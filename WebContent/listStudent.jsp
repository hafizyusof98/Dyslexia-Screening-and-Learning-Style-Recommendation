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
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body class="fadeIn">
	<jsp:include page="header.jsp"/>
	<!-- MAIN -->
    <div class="col">
        <br/><br/>
        <h3>List of Student</h3><br/>
    <br/>
    <table id="example" class="display" style="width:100%">
        <thead>
            <tr>
            	<th>Student ID</th>
                <th>Name</th>
                <th>Class</th>
                <th>Gender</th>
                <th>ISD Result</th>
                <th>LS Result</th>
                <th>View Result</th>
                <th>Update</th>
                <th>Delete</th>
        </thead>
        <tbody>
        <c:forEach items="${studentB }" var="studentB">
            <tr>
                <td><a href="studentController?action=viewStudent&studentID=${studentB.studentId }&parentID=${studentB.studentId }"><c:out value="${studentB.studentId}"></c:out></a></td>
                <td><c:out value="${studentB.name}"></c:out></td>
                <td><c:out value="${studentB.classS}"></c:out></td>
                <td><c:out value="${studentB.gender}"></c:out></td>
                <c:choose>
                <c:when test="${ empty studentB.isd }">
                <td> - </td>
                </c:when>
                <c:otherwise>
                <td><c:out value="${studentB.isd}"></c:out></td>
                </c:otherwise>
                </c:choose>
                <c:choose>
                <c:when test="${ empty studentB.isd }">
                <td> - </td>
                </c:when>
                <c:otherwise>
                <td><c:out value="${studentB.ls}"></c:out></td>
                </c:otherwise>
                </c:choose>
                <td><a href="testController?action=viewResult&studentID=${studentB.studentId }"><i class="fa fa-bar-chart"></i></a></td>
                <td><a href="studentController?action=updateStudentRead&studentID=${studentB.studentId }&parentID=${studentB.studentId }"><i class="fa fa-pencil fa-fw"></i></a></td>
                <td><a href="studentController?action=deleteStudent&studentID=${studentB.studentId }&parentID=${studentB.studentId }"><i class="fa fa-times" aria-hidden="true"></i></a></td>
            </tr>
        </c:forEach>
            </tbody>
            </table>
        </div>	
    <!-- Main Col END -->
</div><!-- body-row END -->
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