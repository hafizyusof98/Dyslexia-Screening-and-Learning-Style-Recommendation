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
<body>
	<jsp:include page="header.jsp"/>
	<!-- MAIN -->
    <div class="col">
        <br/><br/>
        <h3>My Account</h3>
    <br/><br/>
    <form action="teacherController" method="post">
        <div class="row">
    <div class="form-group col-md-7">
            <label for="exampleFormControlInput34">IC Number</label><br/>
            <input type="text" name="teacherIC" class="form-control border" value="<c:out value="${teacherB.teacherICNumber}"/>">
          </div>
          </div>
        <div class="row">
        <div class="form-group col-md-7">
            <label for="exampleFormControlInput34">Name</label><br/>
            <input type="text" name="name" class="form-control border" value="<c:out value="${teacherB.teacherName}"/>">
          </div>
        </div>
        <div class="row">
        <div class="form-group col-md-7">
            <label for="exampleFormControlInput34">Gender</label><br/>
            <input type="text" name="gender" class="form-control border" value="<c:out value="${teacherB.teacherGender}"/>" readonly>
          </div>
        </div>
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
          <br/>
          <input type="submit" class="btn btn-primary" name="action" value="updateOwn">
        </div>
    <br/>
    <br/><br/>
    </form>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="js/script1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
       <script>
            $(document).ready(function() {
               $('#example').DataTable();
            } );
        </script>
</body>
</html>