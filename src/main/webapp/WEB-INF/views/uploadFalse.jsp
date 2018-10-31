
<!DOCTYPE html>
<html
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>업로드 실패</title>

    <!-- Bootstrap core CSS -->
  <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="justified-nav.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      

      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>Upload 실패!</h1>
        <p class="lead">ImageShare에 있는 기존 이미지와 매우 흡사하거나 모방한 이미지로 판명됩니다. 다시 업로드 해주세요</p>
        <p><a class="btn btn-lg btn-success" href="home1" role="button">Home으로 돌아가기</a></p>
      </div>

      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <h2>이미지 둘러보기</h2>           
          <p><a class="btn btn-primary" href="image_view" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-lg-4">
          <h2>이미지로 검색하기</h2>
       
          <p><a class="btn btn-primary" href="image_search" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-lg-4">
          <h2>다시 업로드 하기</h2>          
          <p><a class="btn btn-primary" href="imageUpload" role="button">View details &raquo;</a></p>
        </div>
      </div>

      

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
