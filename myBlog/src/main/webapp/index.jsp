
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/nprogress.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/style.css">
<link
	href="${pageContext.request.contextPath}/static/css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath}/static/images/icon.png">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/static/images/favicon.ico">
<script
	src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/jquery.lazyload.min.js"></script>
<!--[if gte IE 9]>
      <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/static/js/html5shiv.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/static/js/respond.min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/static/js/selectivizr-min.js" type="text/javascript"></script>
    <![endif]-->
<!--[if lt IE 9]>
	/*
	未改完,后面可以修改
	*/
      <script>window.location.href='upgrade-browser.html';</script>
    <![endif]-->
<title>我的个人博客主页</title>
</head>

<body class="user-select">
	<header class="header"> <nav class="navbar navbar-default"
		id="navbar">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#header-navbar"
				aria-expanded="false">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<h1 class="logo hvr-bounce-in">
				<a href="#" title="我的个人博客"><img
					src="${pageContext.request.contextPath}/static/images/tubiao.png"
					alt="我的个人博客"></a>
			</h1>
		</div>
		
		<div class="collapse navbar-collapse" id="header-navbar">
			<form class="navbar-form visible-xs" action="/Search" method="post">
				<div class="input-group">
					<input type="text" name="keyword" class="form-control"
						placeholder="请输入关键字" maxlength="20" autocomplete="off"> <span
						class="input-group-btn">
						<button class="btn btn-default btn-search" name="search"
							type="submit">搜索</button>
					</span>
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a data-cont="我的个人博客" title="我的个人博客" href="index.jsp">首页</a></li>
				<li><a data-cont="生活百态" title="生活百态" href="#">生活百态</a></li>
				<li><a data-cont="前端技术" title="前端技术" href="#">前端技术</a></li>
				<li><a data-cont="后端技术" title="后端技术" href="#">后端技术</a></li>
				<li><a data-cont="资讯分享" title="资讯分享" href="#">资讯分享</a></li>
				<li><a data-cont="关于本站" title="关于本站"
					href="#">关于本站</a></li>
			</ul>
		</div>
	</div>
	</nav> </header>
	<section class="container">
	<div class="content-wrap">
		<div class="content">
			<div id="focusslide" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#focusslide" data-slide-to="0" class="active"></li>
					<li data-target="#focusslide" data-slide-to="1"></li>
				</ol>
				<!-- 动态轮播 -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<a href="#" target="_blank"
							title="图片轮播01"> <img
							src="${pageContext.request.contextPath}/static/images/1.jpg"
							alt="图片轮播01" class="img-responsive"></a>
					</div>
					<div class="item">
						<a href="#" target="_blank"
							title="图片轮播02"> <img
							src="${pageContext.request.contextPath}/static/images/2.jpg"
							alt="图片轮播02" class="img-responsive"></a>
					</div>
					<div class="item">
						<a href="#" target="_blank"
							title="图片轮播03"> <img
							src="${pageContext.request.contextPath}/static/images/3.jpg"
							alt="图片轮播03" class="img-responsive"></a>
					</div>
					<div class="item">
						<a href="#" target="_blank"
							title="图片轮播04"> <img
							src="${pageContext.request.contextPath}/static/images/4.jpg"
							alt="图片轮播04" class="img-responsive"></a>
					</div>
					<div class="item">
						<a href="#" target="_blank"
							title="图片轮播05"> <img
							src="${pageContext.request.contextPath}/static/images/5.jpg"
							alt="图片轮播05" class="img-responsive"></a>
					</div>
					<div class="item">
						<a href="#" target="_blank"
							title="图片轮播06"> <img
							src="${pageContext.request.contextPath}/static/images/6.jpg"
							alt="图片轮播06" class="img-responsive"></a>
					</div>
				</div>
				<a class="left carousel-control" href="#focusslide" role="button"
					data-slide="prev" rel="nofollow"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">上一个</span>
				</a> <a class="right carousel-control" href="#focusslide" role="button"
					data-slide="next" rel="nofollow"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">下一个</span>
				</a>
			</div>
			<article class="excerpt-minic excerpt-minic-index">
			<h2>
				<span class="red">【每日一荐】</span><a target="_blank"
					href="#"
					title="#">暂时没有啊</a>
			</h2>
			<p class="note">这里是内容哦，暂时想不起来写什么，后期再改吧！！！</p>
			</article>
			<div class="title">
				<h3>最新发布</h3>
				<div class="more">
					<a href="#" title="前端技术">前端技术</a> 
					<a href="#" title="后端技术">后端技术</a>
					<a href="#" title="资源分享">资源分享</a>
				</div>
			</div>
			<article class="excerpt excerpt-1" style=""> <a
				class="focus" href="http://www.muzhuangnet.com/show/269.html"
				title="用DTcms做一个独立博客网站（响应式模板）" target="_blank"><img
				class="thumb"
				data-original="http://www.muzhuangnet.com/upload/201610/18/201610181739277776.jpg"
				src="http://www.muzhuangnet.com/upload/201610/18/201610181739277776.jpg"
				alt="用DTcms做一个独立博客网站（响应式模板）" style="display: inline;"></a> <header>
			<a class="cat" href="http://www.muzhuangnet.com/list/mznetblog/"
				title="MZ-NetBlog主题">MZ-NetBlog主题<i></i></a>
			<h2>
				<a href="http://www.muzhuangnet.com/show/269.html"
					title="用DTcms做一个独立博客网站（响应式模板）" target="_blank">用DTcms做一个独立博客网站（响应式模板）</a>
			</h2>
			</header>
			<p class="meta">
				<time class="time">
				<i class="glyphicon glyphicon-time"></i> 2016-10-14</time>
				<span class="views"><i class="glyphicon glyphicon-eye-open"></i>
					216</span> <a class="comment"
					href="http://www.muzhuangnet.com/show/269.html#comment" title="评论"
					target="_blank"><i class="glyphicon glyphicon-comment"></i> 4</a>
			</p>
	
			</article>
			<nav class="pagination" style="display: none;">
			<ul>
				<li class="prev-page"></li>
				<li class="active"><span>1</span></li>
				<li><a href="?page=2">2</a></li>
				<li class="next-page"><a href="?page=2">下一页</a></li>
				<li><span>共 2 页</span></li>
			</ul>
			</nav>
		</div>
	</div>
	<aside class="sidebar">
	<div class="fixed">
		<div class="widget widget-tabs">
			<ul class="nav nav-tabs" role="tablist">
				
				<li role="presentation" class="active"><a href="#notice"
					aria-controls="notice" role="tab" data-toggle="tab">网站公告</a></li>
				<li role="presentation" ><a href="#centre"
					aria-controls="centre" role="tab" data-toggle="tab">统计信息</a></li>
				<li role="presentation"><a href="#contact"
					aria-controls="contact" role="tab" data-toggle="tab">联系站长</a></li>
			</ul>
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane contact active" id="notice">
					<p id="notices" style="text-indent: 2em;padding: 5px;color: #666">
						各位博友，由于本网站刚开始建，功能和内容不是很完善，网站的一部分内容是来源于网络，如果侵犯到您的利益，请联系站长删除，谢谢您的配合！！！
					</p>
				</div>
				<div role="tabpanel" class="tab-pane contact" id="centre">
					<h2>日志总数: 0篇</h2>
					<h2>
						网站运行: <span id="sitetime">10天 </span>
					</h2>
				</div>
				<div role="tabpanel" class="tab-pane contact" id="contact">
					<h2>
						Email: <a href="mailto:819240821@qq.com" target="_blank"
							data-toggle="tooltip" rel="nofollow" data-placement="bottom"
							 data-original-title="Email:819240821@qq.com">819240821@qq.com</a>
					</h2>
				</div>
			</div>
		</div>
		<div class="widget widget_search">
			<form class="navbar-form" action="/Search" method="post">
				<div class="input-group">
					<input type="text" name="keyword" class="form-control" size="35"
						placeholder="请输入关键字" maxlength="15" autocomplete="off"> <span
						class="input-group-btn">
						<button class="btn btn-default btn-search" name="search"
							type="submit">搜索</button>
					</span>
				</div>
			</form>
		</div>
	</div>
	<div class="widget widget_hot">
		<h3>最新评论文章</h3>
		<ul>
			<li><a title="用DTcms做一个独立博客网站（响应式模板）"
				href="http://www.muzhuangnet.com/show/269.html"><span
					class="thumbnail"> <img class="thumb"
						data-original="http://www.muzhuangnet.com/upload/201610/18/201610181739277776.jpg"
						src="http://www.muzhuangnet.com/upload/201610/18/201610181739277776.jpg"
						alt="用DTcms做一个独立博客网站（响应式模板）" style="display: block;">
				</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i
						class="glyphicon glyphicon-time"></i> 2016-11-01 </span><span
					class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
			<li><a title="用DTcms做一个独立博客网站（响应式模板）"
				href="http://www.muzhuangnet.com/show/269.html"><span
					class="thumbnail"> <img class="thumb"
						data-original="http://www.muzhuangnet.com/upload/201610/18/201610181739277776.jpg"
						src="http://www.muzhuangnet.com/upload/201610/18/201610181739277776.jpg"
						alt="用DTcms做一个独立博客网站（响应式模板）" style="display: block;">
				</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i
						class="glyphicon glyphicon-time"></i> 2016-11-01 </span><span
					class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
		</ul>
	</div>
		<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byType_icon.png"/>
					文章分类
				</div>
				<div class="datas">
					<ul>						
							<c:forEach items="${blogTypeList }" var="blogType">
								<li><span><a href="#">${blogType.typeName }（${blogType.blogCount }）</a></span></li>		
							</c:forEach>					
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byDate_icon.png"/>
					文章存档
				</div>
				<div class="datas">
					<ul>						
							<c:forEach items="${blogList }" var="blog">							
								<li><span><a href="#">${blog.releaseDateStr }（${blog.blogCount }）</a></span></li>						
							</c:forEach>						
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/link_icon.png"/>
					友情链接
				</div>
				<div class="datas">
					<ul>						
						<c:forEach items="${linkList }" var="link">
							<li><span><a href="${link.linkUrl }" target="_blank">${link.linkName }</a></span></li>
						</c:forEach>											
					</ul>
				</div>
			</div>
	<!--  广告位置，后期可以改成相册展示 
	<div class="widget widget_sentence">
		<a href="#" target="_blank" rel="nofollow"
			title="广告位置"> <img style="width: 100%"
			src="#"
			alt="广告位置"></a>
	</div> -->
	<div class="widget widget_sentence">
		<h3>友情链接</h3>
		<div class="widget-sentence-link">
			<a href="https://www.baidu.com" title="百度" target="_blank">百度</a>&nbsp;&nbsp;&nbsp;
			<a href="https://www.sina.com" title="新浪" target="_blank">新浪</a>&nbsp;&nbsp;&nbsp;
		</div>
	</div>
	</aside> </section>
	<footer class="footer">
	<div class="container">
		<p>
		<a href="#" rel="nofollow" >关于博主</a>
		|
		<a href="#" rel="nofollow" >关于本站</a>
		|
		<a href="#" rel="nofollow">友情链接</a>
		|
		<a href="#" rel="nofollow" >后台管理</a>
		</p>
		<p style="margin-top: 15px;">
			Copyright © 个人版权所有 最终解释权归个人所有
		</p>
	</div>
	<div id="gotop">
		<a class="gotop"></a>
	</div>
	</footer>
	<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.ias.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/scripts.js"></script>
	<%-- <div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="blog">
					<strong>熊平的博客</strong>
				</div>
			</div>
			<div class="col-md-8">
				<iframe style="float: right" width="420" scrolling="no" height="60"
					frameborder="0" allowtransparency="true"
					src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
			</div>
		</div>

		<div class="row" style="padding-top: 10px">
			<div class="col-md-12">
				<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a class="navbar-brand" href="#">博客首页</a></li>
							<li><a class="navbar-brand" href="#">关于博主</a></li>
							<li><a class="navbar-brand" href="#">我的相册</a></li>
							<li><a class="navbar-brand" href="#">资源小站</a></li>
							<li><a class="navbar-brand" href="#">程序人生</a></li>
							<li><a class="navbar-brand" href="#">CSDN</a></li>
						</ul>
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="请输入要查询的关键字">
							</div>
							<button type="submit" class="btn btn-default">搜索</button>
						</form>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid --> </nav>
			</div>
		</div>
		<script type="application/javascript">
			
			
			
			alert(${blogger.imageName})
		
		
		
		</script>
		<div class="row">
			<div class="col-md-3">
				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/user_icon.png" />
						博主信息
					</div>
					<div class="user_image">
						<img
							src="${pageContext.request.contextPath}/static/userImages/${blogger.imageName}" />
					</div>
					<div class="nickName">${blogger.nickName }</div>
					<div class="userSign">${blogger.sign }</div>
				</div>

				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/byType_icon.png" />
						文章分类
					</div>
					<div class="datas">
						<ul>
							<c:forEach items="${blogTypeList }" var="blogType">
								<li><span><a href="#">${blogType.typeName }（${blogType.blogCount }）</a></span></li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/byDate_icon.png" />
						文章存档
					</div>
					<div class="datas">
						<ul>
							<c:forEach items="${blogList }" var="blog">
								<li><span><a href="#">${blog.releaseDateStr }（${blog.blogCount }）</a></span></li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/link_icon.png" />
						友情链接
					</div>
					<div class="datas">
						<ul>
							<c:forEach items="${linkList }" var="link">
								<li><span><a href="${link.linkUrl }" target="_blank">${link.linkName }</a></span></li>
							</c:forEach>
						</ul>
					</div>
				</div>


			</div>

			<div class="col-md-9">
				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath}/static/images/list_icon.png" />&nbsp;最新博客
					</div>
					<div class="datas">
						<ul>

							<li style="margin-bottom: 30px"><span class="title">
									<img alt="文章类型"
									src="${pageContext.request.contextPath}/static/userImages/yuan.jpg">
									<a href="#">这是一篇测试博客</a>
							</span> <span class="summary">摘要:
									这是用来测试的静态数据，为了多搞一点数据，于是我开始喋喋不休的说一些废话，包括我很帅之类的，虽然我一直强调自己要低调，但不知为何，自己的容颜非得和内心背道而驰....</span>
								<span class="img"> <a href="#"><img
										src="${pageContext.request.contextPath}/static/userImages/dog.jpg"
										title="dog" alt="dog.jpg" width="823" height="489"
										style="width: 823px; height: 489px;"></a> <a href="#"><img
										src="${pageContext.request.contextPath}/static/userImages/dog.jpg"
										title="dog" alt="dog.jpg" width="823" height="489"
										style="width: 823px; height: 489px;"></a> <a href="#"><img
										src="${pageContext.request.contextPath}/static/userImages/dog.jpg"
										title="dog" alt="dog.jpg" width="823" height="489"
										style="width: 823px; height: 489px;"></a> &nbsp;&nbsp;

							</span> <span class="info"> <font color="#999">2016-07-03
										10:39</font> &nbsp;&nbsp; <font color="#33a5ba"><a href="#">阅读</a><font
										color="#999">(404)</font>&nbsp;&nbsp;</font> <font color="#33a5ba"><a
										href="#">评论</a><font color="#999">(8)</font>&nbsp;&nbsp;</font>
							</span></li>
							<hr
								style="height: 5px; border: none; border-top: 1px dashed gray; padding-bottom: 10px;" />

							<li style="margin-bottom: 30px"><span class="title">
									<img alt="文章类型"
									src="${pageContext.request.contextPath}/static/userImages/yuan.jpg">
									<a href="#">这是一篇测试博客</a>
							</span> <span class="summary">摘要:
									这是用来测试的静态数据，为了多搞一点数据，于是我开始喋喋不休的说一些废话，包括我很帅之类的，虽然我一直强调自己要低调，但不知为何，自己的容颜非得和内心背道而驰....</span>
								<span class="img"> <a href="#"><img
										src="${pageContext.request.contextPath}/static/userImages/dog.jpg"
										title="dog.jpg" alt="dog.jpg" width="823" height="489"
										style="width: 823px; height: 489px;"></a> <a href="#"><img
										src="${pageContext.request.contextPath}/static/userImages/dog.jpg"
										title="dog.jpg" alt="dog.jpg" width="823" height="489"
										style="width: 823px; height: 489px;"></a> <a href="#"><img
										src="${pageContext.request.contextPath}/static/userImages/dog.jpg"
										title="dog.jpg" alt="dog.jpg" width="823" height="489"
										style="width: 823px; height: 489px;"></a> &nbsp;&nbsp;

							</span> <span class="info"> <font color="#999">2016-07-03
										10:39</font> &nbsp;&nbsp; <font color="#33a5ba"><a href="#">阅读</a><font
										color="#999">(404)</font>&nbsp;&nbsp;</font> <font color="#33a5ba"><a
										href="#">评论</a><font color="#999">(8)</font>&nbsp;&nbsp;</font>
							</span></li>
							<hr
								style="height: 5px; border: none; border-top: 1px dashed gray; padding-bottom: 10px;" />

							<li style="margin-bottom: 30px"><span class="title">
									<img alt="文章类型"
									src="${pageContext.request.contextPath}/static/userImages/yuan.jpg">
									<a href="#">这是一篇测试博客</a>
							</span> <span class="summary">摘要:
									这是用来测试的静态数据，为了多搞一点数据，于是我开始喋喋不休的说一些废话，包括我很帅之类的，虽然我一直强调自己要低调，但不知为何，自己的容颜非得和内心背道而驰....</span>
								<span class="img"> <a href="#"><img
										src="${pageContext.request.contextPath}/static/userImages/dog.jpg"
										title="dog.jpg" alt="dog.jpg" width="823" height="489"
										style="width: 823px; height: 489px;"></a> <a href="#"><img
										src="${pageContext.request.contextPath}/static/userImages/dog.jpg"
										title="dog.jpg" alt="dog.jpg" width="823" height="489"
										style="width: 823px; height: 489px;"></a> <a href="#"><img
										src="${pageContext.request.contextPath}/static/userImages/dog.jpg"
										title="dog.jpg" alt="dog.jpg" width="823" height="489"
										style="width: 823px; height: 489px;"></a> &nbsp;&nbsp;

							</span> <span class="info"> <font color="#999">2016-07-03
										10:39</font> &nbsp;&nbsp; <font color="#33a5ba"><a href="#">阅读</a><font
										color="#999">(404)</font>&nbsp;&nbsp;</font> <font color="#33a5ba"><a
										href="#">评论</a><font color="#999">(8)</font>&nbsp;&nbsp;</font>
							</span></li>
							<hr
								style="height: 5px; border: none; border-top: 1px dashed gray; padding-bottom: 10px;" />
						</ul>
					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="footer" align="center" style="padding-top: 120px">
					<font>Copyright © 2012-2017 熊平SSM个人博客系统 版权所有</font>

				</div>
			</div>
		</div>
	</div> --%>
</body>
</html>
