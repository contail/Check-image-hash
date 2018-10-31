<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Join_member</title>

    
      <!-- 부트스트랩 -->
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
     
    <!-- font awesome -->
    <link rel="stylesheet" href="css/font-awesome.min.css" media="screen" title="no title" charset="utf-8">
    <!-- Custom style -->
    <link rel="stylesheet" href="css/style.css" media="screen" title="no title" charset="utf-8">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

 <form action ="join" method="post">
      <article class="container">
        <div class="page-header">
          <h1>회원가입 </h1>
        </div>
        <div class="col-md-6 col-md-offset-3">
          <form role="form">
            <div class="form-group">
              <label for="InputEmail">이메일 주소</label>
              <input type="email" class="form-control" name ="mEmail" id="InputEmail" placeholder="이메일 주소">
            </div>
            <div class="form-group">
              <label for="InputPassword1">비밀번호</label>
              <input type="password" class="form-control" name="mPassword" id="InputPassword1" placeholder="비밀번호">
            </div>
            <div class="form-group">
              <label for="InputPassword2">비밀번호 확인</label>
              <input type="password" class="form-control" id="InputPassword2" placeholder="비밀번호 확인">
              <p class="help-block">비밀번호 확인을 위해 다시한번 입력 해 주세요</p>
            </div>
            <div class="form-group">
              <label for="username">이름</label>
              <input type="text" class="form-control" name="mName" id="username" placeholder="이름을 입력해 주세요">
            </div>
                       
             
            <div class="form-group text-center">
          
            <button type="submit" class="btn btn-info"  >회원가입<i class="fa fa-check spaceLeft"></i></button>
            <button type="button" class="btn btn-warning" onclick="location.href='home'" >가입취소<i class="fa fa-times spaceLeft"></i></button>
          
          
            
               </form>
             
               
            </div>
            
             
        
              
           	</form>
        </div>

         
      </article>
 
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="webjars/jquery/2.1.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
     <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </body>
</html>
