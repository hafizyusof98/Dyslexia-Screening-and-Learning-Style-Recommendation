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
<body onload = "window.print()">
	<form class="col">
        <br/><h2>Student Result</h2><br/>
        <div class="form-group row">
            <label for="staticName" class="col-sm-2 col-form-label">Student Name</label>
            <div class="col-sm-10">
              <input type="text" readonly class="form-control-plaintext" id="staticName" value=": ${studentB.name}">
        </div>
        </div>
        <div class="form-group row">
            <label for="staticName" class="col-sm-2 col-form-label">Student Class</label>
            <div class="col-sm-10">
              <input type="text" readonly class="form-control-plaintext" id="staticName" value=": ${studentB.classS}">
        </div>
        </div>
        <legend>Dyslexia Information</legend>
        <hr/>
        <c:choose>
        	<c:when test="${empty testISDBean.resultTest }">
        		<div class="form-group row">
            		<label for="staticClass" class="col-sm-2 col-form-label">Dyslexia Result</label>
           			 <div class="col-sm-10">
                	<input type="text" readonly class="form-control-plaintext" id="staticClass" value=": Test has not been taken">
        		</div></div>
        	</c:when>
        	<c:otherwise>
        			<div class="form-group row">
            <label for="staticClass" class="col-sm-2 col-form-label">Element 1 Score</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticClass" value=": ${element1}">
        </div></div>
        <div class="form-group row">
            <label for="staticClass" class="col-sm-2 col-form-label">Element 2 Score</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticClass" value=": ${element2}">
        </div></div>
        <div class="form-group row">
            <label for="staticClass" class="col-sm-2 col-form-label">Element 3 Score</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticClass" value=": ${element3}">
        </div></div>
        <div class="form-group row">
            <label for="staticClass" class="col-sm-2 col-form-label">Dyslexia Screening Result</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticClass" value=": ${dyslexia}">
        </div></div>
		<c:if test="${dyslexia == 'High' }">
        <div class="form-group row">
            <label for="staticClass" class="col-sm-2 col-form-label">Note</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticClass" value=": The student need to seek further medical attention by psychologyst.">
        </div></div>
        </c:if>
        	<div class="form-group row">
            <label for="staticClass" class="col-sm-2 col-form-label">Date Taken</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticClass" value=" : ${testISDBean.resultDate } ">
        </div></div>
        <div class="form-group row">
            		<label for="staticClass" class="col-sm-2 col-form-label">Taken By</label>
           			 <div class="col-sm-10">
                	<input type="text" readonly class="form-control-plaintext" id="staticClass" value=": ${testISDBean.teacherName }">
        		</div></div>
        	</c:otherwise>
        </c:choose>
        <br/><br/>
        <legend>Learning Style</legend>
        <hr/>
        <c:choose>
        	<c:when test="${empty testLSBean.resultTest }">
	        	<div class="form-group row">
	            		<label for="staticClass" class="col-sm-2 col-form-label">Preferred Learning Style</label>
	           			 <div class="col-sm-10">
	                	<input type="text" readonly class="form-control-plaintext" id="staticClass" value=": Test has not been taken">
	        		</div></div>
        	</c:when>
        	<c:otherwise>
        		<div class="form-group row">
            		<label for="staticClass" class="col-sm-2 col-form-label">Preferred Learning Style</label>
           			 <div class="col-sm-10">
                	<input type="text" readonly class="form-control-plaintext" id="staticClass" value=": ${testLSBean.resultTest }">
        		</div></div>
        		<div class="form-group row">
            		<label for="staticClass" class="col-sm-2 col-form-label">Taken By</label>
           			 <div class="col-sm-10">
                	<input type="text" readonly class="form-control-plaintext" id="staticClass" value=": ${testLSBean.teacherName }">
        		</div></div>
        		<div class="form-group row">
            <label for="staticClass" class="col-sm-2 col-form-label">Date Taken</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticClass" value=" : ${testLSBean.resultDate } ">
        </div></div>
        	</c:otherwise>
        </c:choose>
        <button type="submit" class="btn btn-primary"><a href="home.jsp">Print</a></button>
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
</body>
</html>