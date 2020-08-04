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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DS-LSR System</title>
    <link rel="stylesheet" href="css/style1.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body class="fadeIn">
	<jsp:include page="header.jsp"/>
	<form class="col">
        <br/><h2>Personal Detail</h2><br/>
        <div class="form-group row">
            <label for="staticName" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
              <input type="text" readonly class="form-control-plaintext" id="staticName" value=": ${studentB.name}">
        </div>
        </div>
        <div class="form-group row">
            <label for="staticClass" class="col-sm-2 col-form-label">Class</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticClass" value=": ${studentB.classS}">
        </div>
        </div>
        <div class="form-group row">
            <label for="staticGender" class="col-sm-2 col-form-label">Gender</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticGender" value=" : ${studentB.gender}">
        </div>
        </div>
        <div class="form-group row">
            <label for="staticRace" class="col-sm-2 col-form-label">Race</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticRace" value=" : ${studentB.race}">
        </div>
    </div>
        <div class="form-group row">
            <label for="staticReligion" class="col-sm-2 col-form-label">Religion</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticReligion" value=" : ${studentB.religion}">
        </div>
        </div>
        <div class="form-group row">
            <label for="staticFathername" class="col-sm-2 col-form-label">Father's Name</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticFathername" value=" : ${parentB.fatherName}">
        </div>
        </div>
        <div class="form-group row">
            <label for="staticMothername" class="col-sm-2 col-form-label">Mother's Name</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticMothername" value=" : ${parentB.motherName}">
        </div>
        </div>
        <div class="form-group row">
            <label for="staticPhoneNum" class="col-sm-2 col-form-label">Parent's Phone Number</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticPhoneNum" value=" : ${parentB.parentHp}">
        </div>
        </div>
        <div class="form-group row">
            <label for="staticHomeAddress" class="col-sm-2 col-form-label">Home Address</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticHomeAddress" value=" : ${parentB.address}">
        </div>
        </div>
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