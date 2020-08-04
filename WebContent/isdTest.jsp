<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% if(session.getAttribute("teacherIC") == null){
	   response.sendRedirect("index.jsp");
	   }
%>
<% String teacherName = (String)session.getAttribute("teacherName"); %>
<% String teacherIC = (String)session.getAttribute("teacherIC"); %>
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
<!-- MAIN -->
<jsp:include page="header.jsp"/>
    <form action="testController" method="post">
        <div class="col">
            <br/>
            <h2 class="col-md-auto">Dyslexia Checklist Instrument (ISD)</h2><br/>
            <h5 class="col-md-auto">Student's Name :  ${studentName }</h5>
            <h5 class="col-md-auto">Teacher's Name : <%=teacherName %></h5>
            <h5 class="col-md-auto">Test Date : ${dateToday}</h5></h5><br/>
            <!-- <h5 class="col-md-auto"><u>Elemen 1 : Tahap penguasaan mengeja , membaca dan menulis</u></h5><br/>-->
            <ol>
            	<c:forEach items="${questionB }" var="questionB">
                <li>
                    <b><c:out value="${questionB.questionDescription }"></c:out></b>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="q${questionB.questionNumber }" id="exampleRadios" value="${questionB.questionChoice1 }" >
                <label class="form-check-label" for="exampleRadios">
                  ${questionB.questionChoice1 }
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="q${questionB.questionNumber }" id="exampleRadios" value="${questionB.questionChoice2 }" >
                <label class="form-check-label" for="exampleRadios">
                  ${questionB.questionChoice2 }
                </label>
              </div>
              <br/>
                </li>
                </c:forEach>
              </ol>
              <input type="hidden" name="studentID" value="${studentID }"/>
              <input type="hidden" name="teacherIC" value="<%=teacherIC%>"/>
              <input type="hidden" name="testID" value="T01"/>
              <button type="submit" class="btn btn-primary" name="action" value="resultISD">Submit</button><br/><br/><br/>
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