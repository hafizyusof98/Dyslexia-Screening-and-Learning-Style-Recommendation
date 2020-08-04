<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% if(session.getAttribute("teacherIC") == null){
	   response.sendRedirect("index.jsp");
	   }
%>
<% String teacherIC = (String)session.getAttribute("teacherIC"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
        <h3>List of Teacher</h3><br/>
        <table id="example" class="display" style="width:100%">
            <thead>
                <tr>
                    <th>IC Number</th>
                    <th>Name</th>
                    <th>Update</th>
                    <th>Delete</th>
            </thead>
            <tbody>
            <c:forEach items="${teacherB }" var="teacherB">
            <c:if test="${teacherB.teacherICNumber ne teacherIC }">
                <tr>
                    <td><a href="teacherController?action=viewTeacher&ic=${teacherB.teacherICNumber }"><c:out value="${teacherB.teacherICNumber}"></c:out></a></td>
                    <td><c:out value="${teacherB.teacherName}"></c:out></td>
                    <td><a href="teacherController?action=viewUpdateTeacher&ic=${teacherB.teacherICNumber }"><i class="fa fa-pencil fa-fw"></i></a></td>
                    <td><a href="teacherController?action=deleteTeacher&ic=${teacherB.teacherICNumber }"><i class="fa fa-times" aria-hidden="true"></i></a></td>
                </tr>
                </c:if>
                </c:forEach>
                </tbody>
                </table>
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