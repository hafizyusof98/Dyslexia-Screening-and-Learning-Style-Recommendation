<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<link rel="stylesheet" href="css/style2.css">
</head>
<body>
	<div class="wrapper fadeInDown">
    <div id="formContent">
      <!-- Tabs Titles -->
      <h2 class="active"> Sign In </h2>
      <!--<h2 class="inactive underlineHover">Sign Up </h2>-->

      <!-- Icon -->
      <div class="fadeIn first">
        <img src="img/logo.jpg" id="icon" alt="User Icon" />
      </div>

      <!-- Login Form -->
      <form action="teacherController" method="post">
        <input type="text"  class="fadeIn second" name="ic" placeholder="UserID">
        <input type="text"  class="fadeIn third" name="password" placeholder="Password">
        <input type="submit" class="fadeIn fourth" name="action" value="login">
      </form>
    </div>
</div>
</body>
</html>