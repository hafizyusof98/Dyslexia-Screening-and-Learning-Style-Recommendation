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
        <h3>Update Student Information</h3>
    <br/><br/>
    <form action="studentController" method="post">
        <legend>Student's Information</legend>
        <div class="row">
    <div class="form-group col-md-2">
            <label for="exampleFormControlInput34">Student ID</label><br/>
            <input type="text" name="studentID" class="form-control border" value="<c:out value="${studentB.studentId}"/>" readonly>
          </div>
          </div>
    <br/>
        <div class="row">
        <div class="form-group col-md-7">
            <label for="exampleFormControlInput34">Name</label><br/>
            <input type="text" name="name" class="form-control border" value="<c:out value="${ studentB.name}"/>" readonly>
          </div>
        </div>
        <div class="row">
        <div class="form-group col-md-2">
            <label for="exampleFormControlSelect1">Standard</label>
            <select class="form-control" id="exampleFormControlSelect1" name="standard" required>
              <option selected> </option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
            </select>
          </div>
        <div class="form-group col-md-2">
          <label for="exampleFormControlSelect1">Class</label>
          <select class="form-control" id="exampleFormControlSelect1" name="class" required>
          	<option selected> </option>
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
          </select>
        </div>
    </div>
    <br/>
    <div class="row">
   <div class="form-group col-md-2">
            <label for="exampleFormControlInput34">Gender</label><br/>
            <input type="text" name="gender" class="form-control border" value="<c:out value="${studentB.gender}"/>" readonly>
          </div>
    </div>
    <br/>
    <div class="row">
    <div class="form-group col-md-2">
            <label for="exampleFormControlInput34">Race</label><br/>
            <input type="text" name="race" class="form-control border" value="<c:out value="${studentB.race}"/>" readonly>
          </div>
          </div>
    <br/>
    <div class="row">
        <div class="form-group col-md-2">
            <label for="exampleFormControlInput34">Religion</label><br/>
            <input type="text" name="religion" class="form-control border" value="<c:out value="${studentB.religion}"/>" readonly>
          </div>
        </div>
    <br/><br/>
    <legend>Parent's Information</legend>
    <div class="row">
    <div class="form-group col-md-2">
            <label for="exampleFormControlInput34">Parent ID</label><br/>
            <input type="text" name="parentID" class="form-control border" value="<c:out value="${parentB.parentId}"/>" readonly>
          </div>
          </div>
    <br/>
    <div class="row">
        <div class="form-group col-md-7">
            <label for="exampleFormControlInput34">Father's Name</label>
            <input name="fatherName" class="form-control" type="text" value="<c:out value="${parentB.fatherName}"/>" readonly>
          </div>
    </div>
    <br/>
    <div class="row">
         <div class="form-group col-md-7">
            <label for="exampleFormControlInput1">Mother's/Guardian's Name</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="motherName" value="<c:out value="${parentB.motherName}"/>" readonly>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-7">
            <label for="exampleFormControlInput1">Parent's Phone Number</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="parentHP" value="<c:out value="${parentB.parentHp}"/>">
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-10">
          <label for="exampleFormControlInput1">Address</label>
          <input type="text" class="form-control" id="exampleFormControlInput1" name="address" value="<c:out value="${parentB.address}"/>">
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-4">
            <label for="exampleFormControlInput1">City</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="city" value="<c:out value="${parentB.city}"/>">
          </div>
        <div class="form-group col-md-3">
            <label for="exampleFormControlInput1">State</label>
            <select class="form-control" id="exampleFormControlSelect1" name="state" required>
                <option selected> </option>
                <option value="Perlis">Perlis</option>
                <option value="Kedah">Kedah</option>
                <option value="Pulau Pinang">Pulau Pinang</option>
                <option value="Perak">Perak</option>
                <option value="Selangor">Selangor</option>
                <option value="W.P. Kuala Lumpur">W.P. Kuala Lumpur</option>
                <option value="W.P. Putrajaya">W.P. Putrajaya</option>
                <option value="Negeri Sembilan">Negeri Sembilan</option>
                <option value="Melaka">Melaka</option>
                <option value="Johor">Johor</option>
                <option value="Pahang">Pahang</option>
                <option value="Terengganu">Terengganu</option>
                <option value="Kelantan">Kelantan</option>
                <option value="Sarawak">Sarawak</option>
                <option value="Sabah">Sabah</option>
                <option value="W.P. Labuan">W.P. Labuan</option>
              </select>
        </div>
        <div class="form-group col-md-3">
            <label for="exampleFormControlInput1">Zip Code</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="zipCode" value="<c:out value="${parentB.zipCode}"/>">
        </div>
    <div class="container">
        <br/>
    <input type="submit" class="btn btn-primary" name="action" value="update">
    </div>
    </div>
    <br/><br/><br/>
    </form>
    <!-- Main Col END -->
</div><!-- body-row END -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="js/script1.js"></script>
</body>
</html>