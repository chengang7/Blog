package com.cg.blog.lucene;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.blog.util.PathUtil;

import com.cg.blog.entity.Blog;
import com.cg.blog.util.DateUtil;
import com.cg.blog.util.StringUtil;

@Component
public class BlogIndex {

	public Directory directory;

	/**
	 * 瀛樻斁绱㈠紩鐨勭墿鐞嗕綅缃�
	 */
	public String indexDir = PathUtil.getRootPath() + "/src/main/webapp/static/luceneIndex";

	/**
	 * 鑾峰彇鍐欑储寮曞璞�
	 * 
	 * @return
	 * @throws IOException
	 */
	public IndexWriter getIndexWriter() throws IOException {
		// 瀹炰緥鍖栫储寮曠洰褰�
		directory = FSDirectory.open(Paths.get(indexDir));
		// 寰楀埌涓枃瑙ｆ瀽鍣�
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		// 娉ㄥ唽涓枃瑙ｆ瀽鍣ㄥ埌鍐欑储寮曢厤缃�
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		// 瀹炰緥鍖栧啓绱㈠紩瀵硅薄
		IndexWriter indexWriter = new IndexWriter(directory, config);
		return indexWriter;
	}

	/**
	 * 娣诲姞鍗氬绱㈠紩
	 * 
	 * @param blog
	 * @throws IOException
	 */
	public void addIndex(Blog blog) throws IOException {
		// 鑾峰彇鍐欑储寮曞璞�
		IndexWriter indexWriter = getIndexWriter();
		// 瀹炰緥鍖栫储寮曟枃妗�
		Document document = new Document();
		// 璁剧疆绱㈠紩鏂囦欢瀛楁
		document.add(new StringField("id", String.valueOf(blog.getId()), Field.Store.YES));
		document.add(new TextField("title", blog.getTitle(), Field.Store.YES));
		document.add(new StringField("releaseDate", DateUtil.formatDate(new Date(), "yyyy-mm-dd"), Field.Store.YES));
		document.add(new TextField("content", blog.getContentNoTag(), Field.Store.YES));
		// 绱㈠紩鏂囨。鍔犲叆鍒板啓绱㈠紩涓�
		indexWriter.addDocument(document);
		// 鍏抽棴鍐欑储寮�
		indexWriter.close();
	}

	/**
	 * 鍒犻櫎鎸囧畾鍗氬id鐨勭储寮�
	 * 
	 * @param blogId
	 */
	public void deleteIndex(String blogId) throws IOException {
		IndexWriter indexWriter = getIndexWriter();
		indexWriter.deleteDocuments(new Term("id", blogId));
		indexWriter.forceMergeDeletes();// 寮哄埗鍒犻櫎
		indexWriter.commit();
		indexWriter.close();
	}

	/**
	 * 鏇存柊鍗氬绱㈠紩鏂囦欢
	 * 
	 * @param blog
	 * @throws IOException
	 */
	public void updateIndex(Blog blog) throws IOException {
		// 鑾峰彇鍐欑储寮曞璞�
		IndexWriter indexWriter = getIndexWriter();
		// 瀹炰緥鍖栫储寮曟枃妗�
		Document document = new Document();
		// 璁剧疆绱㈠紩鏂囦欢瀛楁
		document.add(new StringField("id", String.valueOf(blog.getId()), Field.Store.YES));
		document.add(new TextField("title", blog.getTitle(), Field.Store.YES));
		document.add(new StringField("releaseDate", DateUtil.formatDate(new Date(), "yyyy-mm-dd"), Field.Store.YES));
		document.add(new TextField("content", blog.getContentNoTag(), Field.Store.YES));
		// 鏇存柊绱㈠紩鏂囨。
		indexWriter.updateDocument(new Term("id", String.valueOf(blog.getId())), document);
		// 鍏抽棴鍐欑储寮�
		indexWriter.close();
	}

	public List<Blog> searchBlog(String q) throws Exception {
		// 瀹炰緥鍖栫洰褰曞璞�
		directory = FSDirectory.open(Paths.get(indexDir));
		// 鑾峰彇璇荤储寮曞璞�
		IndexReader indexReader = DirectoryReader.open(directory);
		// 鑾峰彇绱㈠紩鏌ヨ瀵硅薄
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		// 缁勫悎鏌ヨ瀵硅薄
		BooleanQuery.Builder builder = new BooleanQuery.Builder();
		// 涓枃鍒嗘瀽鍣�
		SmartChineseAnalyzer chineseAnalyzer = new SmartChineseAnalyzer();
		// 鏍囬鏌ヨ鍒嗘瀽鍣�
		QueryParser titleParser = new QueryParser("title", chineseAnalyzer);
		// 鏍囬鏌ヨ鍣�
		Query titleQuery = titleParser.parse(q);
		// 鍐呭鏌ヨ鍒嗘瀽鍣�
		QueryParser contentParser = new QueryParser("content", chineseAnalyzer);
		// 鍐呭鏌ヨ鍣�
		Query contentQuery = contentParser.parse(q);
		// 娣诲姞鏍囬鏌ヨ鍣� 閫昏緫鍏崇郴涓烘垨鑰�
		builder.add(titleQuery, BooleanClause.Occur.SHOULD);
		// 娣诲姞鍐呭鏌ヨ鍣� 閫昏緫鍏崇郴涓烘垨鑰�
		builder.add(contentQuery, BooleanClause.Occur.SHOULD);
		// 鏌ヨ鍓�100鏉¤褰曞弽鍦╤is涓�
		TopDocs hits = indexSearcher.search(builder.build(), 100);
		// 灏唗itle寰楀垎楂樼殑鏀惧湪鍓嶉潰
		QueryScorer queryScorer = new QueryScorer(titleQuery);
		// 寰楀垎楂樼殑鐗囨
		Fragmenter fragmenter = new SimpleSpanFragmenter(queryScorer);
		// 鏍煎紡鍖栧緱鍒嗛珮鐗囨
		SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<b><font color='red'>", "</font></b>");
		// 楂樹寒鏄剧ず
		Highlighter highlighter = new Highlighter(formatter, queryScorer);
		// 灏嗗緱鍒嗛珮鐨勭墖娈佃缃繘鍘�
		highlighter.setTextFragmenter(fragmenter);
		// 鐢ㄦ潵灏佽鏌ヨ鍒扮殑鍗氬
		List<Blog> blogIndexList = new LinkedList<Blog>();
		// 閬嶅巻鏌ヨ缁撴灉
		for (ScoreDoc score : hits.scoreDocs) {
			Document doc = indexSearcher.doc(score.doc);
			Blog blog = new Blog();
			blog.setId(Integer.parseInt(doc.get("id")));
			blog.setReleaseDateStr(doc.get("releaseDate"));
			String title = doc.get("title");
			String content = doc.get("content");
			if (title != null) {
				TokenStream tokenStream = chineseAnalyzer.tokenStream("title", new StringReader(title));
				String hTitle = highlighter.getBestFragment(tokenStream, title);
				if (StringUtil.isEmpty(hTitle)) {
					blog.setTitle(title);
				} else {
					blog.setTitle(hTitle);
				}
			}
			if (content != null) {
				TokenStream tokenStream = chineseAnalyzer.tokenStream("content", new StringReader(content));
				String hContent = highlighter.getBestFragment(tokenStream, content);
				if (StringUtil.isEmpty(hContent)) {
					if (content.length() > 100) { // 濡傛灉娌℃煡鍒颁笖content鍐呭鍙堝ぇ浜�100鐨勮瘽
						blog.setContent(content.substring(0, 100)); // 鎴彇100涓瓧绗�
					} else {
						blog.setContent(content);
					}
				} else {
					blog.setContent(hContent);
				}
			}
			blogIndexList.add(blog);
		}

		return blogIndexList;
	}
}
