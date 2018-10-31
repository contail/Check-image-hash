<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/lightbox/dist/css/lightbox.css" rel="stylesheet">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/lightbox/dist/css/lightbox.min.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>현재 사이트에 있는 모든 이미지 입니다!</h1>
		<div class="gallery">
			<div class="row">
				<c:forEach items="${image_view}" var="dto">
					<div class="col-lg-3">
						<a href="resources/image/${dto.new_name}"
							data-title="${dto.image_name}" data-lightbox="Vacation"> <img
							src="resources/image/${dto.new_name}" width="200px"
							height="200px" class="img-thumbnail" />
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<script src="resources/lightbox/dist/js/lightbox.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/2.1.4/jquery.min.js"></script>
	<script src="resources/lightbox/dist/js/lightbox.min.js"></script>
</body>
</html>