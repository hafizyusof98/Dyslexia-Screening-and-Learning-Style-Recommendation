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
        <h3>Student Registration Form</h3>
    <br/><br/>
    <form  action="studentController" method="post">
        <legend>Student's Information</legend>
        <div class="row">
        <div class="form-group col-md-7">
            <label for="exampleFormControlInput34">Name</label><br/>
            <input type="text" name="name" class="form-control border" required>
          </div>
        </div>
        <div class="row">
        <div class="form-group col-md-2">
            <label for="exampleFormControlSelect1">Standard</label>
            <select class="form-control" id="exampleFormControlSelect1" name="standard" required>
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
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
          </select>
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
    <label class=" form-check-label col-md-1">Race:</label>
    <div class="form-check form-check-inline col-md-1">
        <input class="form-check-input" type="radio" name="race" id="inlineRadio3" value="Malay">
        <label class="form-check-label" for="inlineRadio3">Malay</label>
      </div>
      <div class="form-check form-check-inline col-md-1">
        <input class="form-check-input" type="radio" name="race" id="inlineRadio4" value="Chinese">
        <label class="form-check-label" for="inlineRadio4">Chinese</label>
      </div>
      <div class="form-check form-check-inline col-md-1">
        <input class="form-check-input" type="radio" name="race" id="inlineRadio5" value="Indian">
        <label class="form-check-label" for="inlineRadio5">Indian</label>
      </div>
    </div>
    <br/>
    <div class="row">
        <label class=" form-check-label col-md-1">Religion:</label>
        <div class="form-check form-check-inline col-md-1">
            <input class="form-check-input" type="radio" name="religion" id="inlineRadio3" value="Islam">
            <label class="form-check-label" for="inlineRadio3">Islam</label>
          </div>
          <div class="form-check form-check-inline col-md-1">
            <input class="form-check-input" type="radio" name="religion" id="inlineRadio4" value="Christian">
            <label class="form-check-label" for="inlineRadio4">Christian</label>
          </div>
          <div class="form-check form-check-inline col-md-1">
            <input class="form-check-input" type="radio" name="religion" id="inlineRadio5" value="Buddha">
            <label class="form-check-label" for="inlineRadio5">Buddha</label>
          </div>
          <div class="form-check form-check-inline col-md-1">
            <input class="form-check-input" type="radio" name="religion" id="inlineRadio5" value="Hindu">
            <label class="form-check-label" for="inlineRadio5">Hindu</label>
          </div>
        </div>
    <br/><br/>
    <legend>Parent's Information</legend>
    <div class="row">
        <div class="form-group col-md-7">
            <label for="exampleFormControlInput34">Father's Name</label>
            <input name="fatherName" class="form-control" type="text" required>
          </div>
    </div>
    <div class="row">
         <div class="form-group col-md-7">
            <label for="exampleFormControlInput1">Mother's/Guardian's Name</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="motherName" required>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-7">
            <label for="exampleFormControlInput1">Parent's Phone Number</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="parentHP" required>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-10">
          <label for="exampleFormControlInput1">Address</label>
          <input type="text" class="form-control" id="exampleFormControlInput1" name="address" required>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-4">
            <label for="exampleFormControlInput1">City</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="city" required>
          </div>
        <div class="form-group col-md-3">
            <label for="exampleFormControlInput1">State</label>
            <select class="form-control" id="exampleFormControlSelect1" name="state" required>
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
            <input type="text" class="form-control" id="exampleFormControlInput1" name="zipCode" required>
        </div>
    <div class="container">
        <br/>
    <input type="submit" class="btn btn-primary" name="action" value="register">
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