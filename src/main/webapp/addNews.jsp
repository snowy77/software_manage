<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }" scope="request"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/manageNews.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="masthead">
			<h3 class="text-muted page-header">欢迎你，管理员</h3>
			<nav class="nav nav-pills nav-fill">
			<li class="nav-item ">
				<a class=" nav-link active">发布新闻</a>
			</li>
			<li class="nav-item ">
				<a class=" nav-link" href="updateNews.jsp">更改新闻</a>
			</li>
			<li class="nav-item ">
				 <a class=" nav-link" href="deleteNews.jsp">删除新闻</a>
			</li>
			<li class="nav-item dropdown">
				 <a class=" nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">浏览新闻</a>
				 <div class="dropdown-menu">
			       <a class="dropdown-item" href="news1">课程介绍</a>
			      <a class="dropdown-item" href="news2">课程内容</a>
			      <a class="dropdown-item" href="news3">课程实践</a>
			      <a class="dropdown-item" href="news4">教学团队</a>
			    </div>
			</li>
		
</nav>
		</div>
	
		<!-- background image -->
	
		<!-- 添加新闻界面 -->
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-9">
			<h3 class="text-muted page-header">发布新闻</h3>
					<form  action="addNews" method="post"  class="form-horizontal" enctype="multipart/form-data">
					<div class="form-group">
						<label for="news_title" class="col-md-4 control-label">所属板块</label>
						<div class="col-md-6">
							<input type="text" name="type" class="form-control"
								id="news_title" placeholder="所属板块">
						</div>
						<div class="col-md-4"></div>
					</div>
				    <div class="form-group">
						<label for="news_id" class="col-md-2 control-label">标题</label>
						<div class="col-md-6">
							<input type="text" name="head" class="form-control"
								id="news_id" placeholder="标题">
						</div>
						<div class="col-md-4"></div>
					</div>
					<div class="form-group">
						<label for="news_title" class="col-md-2 control-label">摘要</label>
						<div class="col-md-6">
							<input type="text" name="summary" class="form-control"
								id="news_title" placeholder="摘要">
						</div>
						<div class="col-md-4"></div>
					</div>
					
					<div class="form-group">
						<label for="news_content" class="col-md-4 control-label">正文内容</label>
						<div class="col-md-10">
							<textarea type="text" style="height: 100px; width: 400px"
								name="body" class="form-control" id="body"
								placeholder="正文内容">
					</textarea>
						</div>
					</div>
					
					<div class="form-group">
						<label for="news_date" class="col-md-4 control-label">发表日期</label>
						<div class="col-md-3">
							<input type="text" class="form-control" id="news_date"
								name="date" placeholder="格式yyyy-mm-xx" >
						</div>
						<div class="col-md-7"></div>
					</div>
					<div class="form-group">
						<label for="author_id" class="col-md-4 control-label">选择图片</label>
						<div class="col-md-2">
							<input type="file" name="file" onchange="showPreview(this)" /><br/><br/>
    	<img id="portrait" src="" style="display:none;width: 100px;height:100px;" />
						</div>
						<div class="col-md-8"></div>
					</div>
			
					<div class="form-group">
						<div class="col-md-offset-2 col-md-12 ">
							<button type="submit" class="btn btn-default" id="submit1">提交</button>
						</div>
					</div>
				</form>
		</div>
	</div>
	 </div>
	 <script type="text/javascript" src="js/jquery.min.js"></script>
	 <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	 <script type="text/javascript">
    function showPreview(source) {
      var file = source.files[0];
      if(window.FileReader) {
          var fr = new FileReader();
          console.log(fr);
          var portrait = document.getElementById('portrait');
          fr.onloadend = function(e) {
            portrait.src = e.target.result;
          };
          fr.readAsDataURL(file);
          portrait.style.display = 'block';
      }
    }
</script> 
</body>
</html>