 
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>Image Share</title>

    <!-- 부트스트랩 -->
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
   <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Image Share</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
         			<ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> ${name}님 환영합니다</a></li>
      </ul>	
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Welcome to Image Share!</h1>
        <p> Image Share에 오신걸 환영합니다. 당신이 가지고 있는 PNG, JPEG 파일들을 공유하세요. Image Share는 당신이 소유한 이미지파일들을 존중합니다. Image Share만의 기법으로 당신의 이미지 저작권을 보호해드립니다. 
        또한 이미지 검색을 통해 당신이 찾고자 하는 이미지를 빠르게 추천해드립니다.</p>
        
      
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Image Search</h2>
          <p>당신이 가지고 있는 이미지를 업로드 통해 비슷한 이미지를 추천해드립니다! </p>
          <p><a class="btn btn-default" href="image_search" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>Image Upload</h2>
          <p> 당신이 가지고 있는 이미지를 업로드하세요. 저희 이미지 업로드 알고리즘은 당신의 저작권을 보호해드립니다!</p>
          <p><a class="btn btn-default" href="imageUpload" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Image View</h2>
          <p> 당신이 원하는 이미지들을 둘러보세요!</p>
          <p><a class="btn btn-default" href="image_view" role="button">View details &raquo;</a></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; Company 2016</p>
      </footer>
    </div> <!-- /container -->
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/2.1.4/jquery.min.js"></script>
  </body>
</html>