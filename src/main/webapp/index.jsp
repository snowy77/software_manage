<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/index_.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="header">
		<nav class="navbar navbar-expand-lg navbar-light bg-light ">
			<span class="navbar-brand mb-0 h1">软件项目管理</span>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav mr-auto" id="navbarSupportedContent">
					<li class="nav-item">
						<a href="#" class="nav-link disabled">首页</a>
					</li>
					<li class="nav-item">
						<a href="#" class="nav-link">行业信息</a>
					</li>
					<li class="nav-item">
						<a href="#" class="nav-link">下载区</a>
					</li>
<!-- 					<li class="nav-item"> -->
<!-- 						<a href="#" class="nav-link">成绩查询</a> -->
<!-- 					</li> -->
					<li class="nav-item">
						<a href="#" class="nav-link">留言板</a>
					</li>
					<li class="nav-item">
						<a href="#" class="nav-link">网上测试</a>
					</li>
					<li class="nav-item">
						<a href="#" class="nav-link">联系我们</a>
					</li>
				</ul>
			</div>
			<span id="test">
				<button class="btn btn-link" type="button" data-toggle="modal" data-target="#mymodal">登录</button>
				<span>/</span>
				<button class="btn btn-link"  type="button" id="enroll">注册</button>
			</span>
		</nav>
	</div>
	<!-- model -->
				<div class="modal fade" id="mymodal" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop='static'>
					<div class="modal-dialog"  role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h3 class="model-title">登录</h3>
								<button class="close" type="button" data-dismiss="modal">
									<span>&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form >
									<div class="row row1">
										<label for="name" class="col-sm-2">用户名</label>
										<div class="col-sm-10">
											<input type="text" placeholder="用户名" class="form-control
									
											" id="name">
										</div>
										
									</div>
									<div class="row row1">
										<label for="name" class="col-sm-2">学号/职工号</label>
										<div class="col-sm-10">
											<input type="text" placeholder="学号/职工号" class="form-control
									
											" id="no">
										</div>
										
									</div>
									<div class="row">
										<label for="password" class="col-sm-2">密码</label>
										<div class="col-sm-10">
											<input type="password" placeholder="密码" class="form-control" id="password">
										</div>
									</div>
								</form>
								
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-block btn-link-dark" data-dismiss="modal"  id="login">登录</button>
							</div>
						</div>
						
					</div>
				</div>
	
	<div class="banner">
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="images/1.jpg" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="images/3.jpg" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="images/2.jpg" alt="Third slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
	</div>
	<div class="containt">
		<ul class="containt_l">
			<li class="active"><a href="##">课程介绍</a></li>
			<li><a href="##">课程内容</a></li>
			<li><a href="##">课程实践</a></li>
			<li><a href="##">教学团队</a></li>
		</ul>
		<ul class="containt_r">
			<li style="height: auto;">
				
					<table>
					<c:forEach var="row" items="${data1}">
								
									<tr >
										<td style="text-align:left;">${row.id}</td>
										<td style="text-align:right;">${row.date}</td>
									</tr>
									<tr>
										<td><a href="javascript:getContent(${row.id})"><h2>${row.head}</h2></a></td>
									</tr>
									<tr>
										<td>${row.summary}</td>
									</tr>
									<tr>
										<td><img src="${baseUri}/upload/${row.img}"/></td>
									</tr>
									<tr>
										<td>___________________________________________________________________________________________________________________</td>
									</tr>
								
						</c:forEach>
				</table>
				
			</li>
			<li style="height:auto;">
			<table>
					<c:forEach var="row" items="${data2}">
								
									<tr>
										<td style="text-align:left;">${row.id}</td>
										<td style="text-align:right;">${row.date}</td>
									</tr>
									<tr>
										<td><a href="javascript:getContent(${row.id})"><h2>${row.head}</h2></a></td>
									</tr>
									<tr>
										<td>${row.summary}</td>
									</tr>
									
									<tr>
										<td><img src="${baseUri}/upload/${row.img}" /></td>
									</tr>
									<tr>
										<td>___________________________________________________________________________________________________________________</td>
									</tr>
								
						</c:forEach>
				</table>
				
			</li>
			<li style="height:auto;">
				<table>
					<c:forEach var="row" items="${data3}">
								
									<tr>
										<td style="text-align:left;">${row.id}</td>
										<td style="text-align:right;">${row.date}</td>
									</tr>
									<tr>
										<td><a href="javascript:getContent(${row.id})"><h2>${row.head}</h2></a></td>
									</tr>
									<tr>
										<td>${row.summary}</td>
									</tr>
									
									<tr>
										<td><img src="${baseUri}/upload/${row.img}" /></td>
									</tr>
									<tr>
										<td>___________________________________________________________________________________________________________________</td>
									</tr>
								
						</c:forEach>
				</table>
			</li>
			<li style="height: auto;">
				<table >
					<c:forEach var="row" items="${data4}">
								
									<tr>
										<td style="text-align:left;">${row.id}</td>
										<td style="text-align:right;">${row.date}</td>
									</tr>
									<tr>
										<td><a href="javascript:getContent(${row.id})"><h2>${row.head}</h2></a></td>
									</tr>
									<tr>
										<td>${row.summary}</td>
									</tr>
									
									<tr>
										<td><img src="${baseUri}/upload/${row.img}" /></td>
									</tr>
									<tr>
										<td>___________________________________________________________________________________________________________________</td>
									</tr>
								
						</c:forEach>
				</table>
			</li>
		</ul>
		<div style="clear: both;"></div>
	</div>
	<div class="footer">
		<p>适用浏览器：IE8、360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗.</p>
	</div>
	<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/index_.js"></script>
<script type="text/javascript">
	function getContent(id) {
		window.location = "read.action?id=" + id;
	}
</script>
</body>
</html>