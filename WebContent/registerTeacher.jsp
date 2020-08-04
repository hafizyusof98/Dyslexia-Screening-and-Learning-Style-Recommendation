<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% if(session.getAttribute("teacherIC") == null){
	   response.sendRedirect("index.jsp");
	   }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DS-LSR System</title>
    <link rel="stylesheet" href="css/style1.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body class="fadeIn">
	<jsp:include page="header.jsp"/>
	<!-- MAIN -->
    <div class="col">
        <br/><br/>
        <h3>Teacher Registration Form</h3><br/>
    <form action="teacherController" method="post">
    <div class="row">
        <div class="form-group col-md-7">
            <label for="exampleFormControlInput34">Name</label>
            <input name="name" class="form-control" type="text" required>
          </div>
    </div>
    <div class="row">
         <div class="form-group col-md-7">
            <label for="exampleFormControlInput1">IC Number</label>
            <input type="text" class="form-control" name="icNum" required>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-7">
           <label for="exampleFormControlInput1">Password</label>
           <input type="text" class="form-control" id="exampleFormControlInput1" name="password" required>
       </div>
    </div>
    <br/>
    <div class="row">
        <label class=" form-check-label col-md-1">Gender:</label>
        <div class="form-check form-check-inline col-md-1">
            <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="Male">
            <label class="form-check-label" for="inlineRadio1">Male</label>
          </div>
          <div class="form-check form-check-inline col-md-1">
            <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="Female">
            <label class="form-check-label" for="inlineRadio2">Female</label>
          </div>
        </div>
        <br/>
        <div class="row">
            <div class="form-group col-md-4">
                <label for="exampleFormControlSelect1">Specialization</label>
                <select class="form-control" id="exampleFormControlSelect1" name="specialization" required>
                  <option selected> </option>
                  <option value="Bahasa Melayu">Bahasa Melayu</option>
                  <option value="English">English</option>
                  <option value="Mathematics">Mathematics</option>
                  <option value="Science">Science</option>
                </select>
              </div>
              </div>
              <div class="row">
                <div class="form-group col-md-4">
                    <label for="exampleFormControlSelect">Teacher Role</label>
                    <select class="form-control" id="exampleFormControlSelect" name="role" required>
                      <option selected> </option>
                      <option value="Teacher">Teacher</option>
                      <option value="GPK Teacher">GPK Teacher</option>
                    </select>
                  </div>
              <div class="container">
                <br/>
            <input type="submit" class="btn btn-primary" name="action" value="register">
            <br/><br/>
            </div>
    </div>
    </form>
    <!-- Main Col END -->
</div><!-- body-row END -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="js/script1.js"></script>
</body>
</html>