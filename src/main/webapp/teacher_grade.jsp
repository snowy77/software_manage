<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/choose_.css">
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
						<a href="#" class="nav-link ">首页</a>
					</li>
					<li class="nav-item">
						<a href="#" class="nav-link disabled">行业信息</a>
					</li>
					<li class="nav-item">
						<a href="#" class="nav-link">下载区</a>
					</li>
					<li class="nav-item">
						<a href="#" class="nav-link">成绩查询</a>
					</li>
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
				<span>
					<form action="index.action">
						<button type="submit" class="btn btn-default" id="submit0">返回首页</button>
					</form>
				</span>
			</div>
		</nav>
	</div>
	<div class="containt">
		<table class="table table-hover">
		<thead class="thead-dark">
		<tr>
			<th scope="col">学生编号</th>
			<th scope="col">学生姓名</th>
			<th scope="col">学生学校</th>
			<th scope="col">成绩</th>
			<th scope="col">成绩输入</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="row" items="${data}">
			<
				<tr scope="row" class="main">
					<td class="no">${row.no}</td>
					<td>${row.user.name}</td>
					<td>${row.user.shool}</td>
					<td class="result">${row.grade}</td>
					<td>
						<input type="text" class="grade" name="grade"></input>
<%-- 					<a href="${baseUri}/toUpdateUser?id=${userList.id}"></a> --%>
				</td>
				</tr>
			
		</c:forEach>
		<th colspan="5" style="text-align:right;"><button type="button" class=" btn btn-secondary" id="sure">确认</button></th>
		
		</tbody>
	</table>
	</div>
	<div class="footer" >
		<p>适用浏览器：IE8、360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗.</p>
	</div>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script src="js/teacher_grade.js"></script>
</body>
</html>