<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String teacherRole = (String)session.getAttribute("teacherRole"); %>
<%String teacherName = (String)session.getAttribute("teacherName"); %>
<!-- Bootstrap NavBar -->
<nav class="navbar navbar-expand-md navbar-light" style="background-color:lightslategrey">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">
        <span class="menu-collapsed">DS-LSR</span>
    </a>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="teacherController?action=logout" style="background-color: gray; border-radius: 9%;" ><b>Logout</b></a>
            </li>
            <!-- This menu is hidden in bigger devices with d-sm-none. 
           The sidebar isn't proper for smaller screens imo, so this dropdown menu can keep all the useful sidebar itens exclusively for smaller screens  -->
            <li class="nav-item dropdown d-sm-block d-md-none">
                <a class="nav-link dropdown-toggle" href="#" id="smallerscreenmenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Menu </a>
                <div class="dropdown-menu" aria-labelledby="smallerscreenmenu">
                    <a class="dropdown-item" href="#top">hjsahgjsa</a>
                    <a class="dropdown-item" href="#top">Profile</a>
                    <a class="dropdown-item" href="#top">Tasks</a>
                    <a class="dropdown-item" href="#top">Etc ...</a>
                </div>
            </li><!-- Smaller devices menu END -->
        </ul>
    </div>
</nav><!-- NavBar END -->
<!-- Bootstrap row -->
<div class="row" id="body-row">
    <!-- Sidebar -->
    <div id="sidebar-container" class="sidebar-expanded d-none d-md-block">
        <!-- d-* hiddens the Sidebar in smaller devices. Its itens can be kept on the Navbar 'Menu' -->
        <!-- Bootstrap List Group -->
        <ul class="list-group">
            <!-- Separator with title -->
            <!--<li class="list-group-item sidebar-separator-title text-muted d-flex align-items-center menu-collapsed">
                <small>MAIN MENU</small>
            </li>-->
            <!-- /END Separator -->
            <!-- Menu with submenu -->
            <br/>
            <img src="img/logo.jpg" alt="user" width=50 class="col-md-auto" style="border-radius: 100%;"><br/>
            <h6 class="col-md-auto" style="color: white;"><c:out value = "<%=teacherName%>"/> </h6>
            <a href="home.jsp" class="bg-dark list-group-item list-group-item-action">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-home fa-fw mr-3"></span>
                    <span class="menu-collapsed">Home</span>
                </div>
            </a>
            <a href="teacherController?action=viewOwnAccount" class="bg-dark list-group-item list-group-item-action">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-address-card fa-fw mr-3"></span>
                    <span class="menu-collapsed">My Account</span>
                </div>
            </a>
           <a href="#submenu1" data-toggle="collapse" aria-expanded="false" class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-user fa-fw mr-3"></span>
                    <span class="menu-collapsed">Student</span>
                    <span class="submenu-icon ml-auto"></span>
                </div>
            </a>
            <!-- Submenu content -->
            <div id='submenu1' class="collapse sidebar-submenu">
                <a href="registerStudent.jsp" class="list-group-item list-group-item-action bg-dark text-white">
                    <span class="menu-collapsed">Register Student</span>
                </a>
                <a href="studentController?action=viewListStudent" class="list-group-item list-group-item-action bg-dark text-white">
                    <span class="menu-collapsed">List of Student</span>
                </a>
            </div>
            <%if(String.valueOf(session.getAttribute("teacherRole")).equalsIgnoreCase("GPK Teacher")) {%>
            <a href="#submenu2" data-toggle="collapse" aria-expanded="false" class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-user fa-fw mr-3"></span>
                    <span class="menu-collapsed">Teacher</span>
                    <span class="submenu-icon ml-auto"></span>
                </div>
            </a>
            <!-- Submenu content -->
            <div id='submenu2' class="collapse sidebar-submenu">
                <a href="registerTeacher.jsp" class="list-group-item list-group-item-action bg-dark text-white">
                    <span class="menu-collapsed">Register Teacher</span>
                </a>
                <a href="teacherController?action=listViewTeacher" class="list-group-item list-group-item-action bg-dark text-white">
                    <span class="menu-collapsed">List of Teacher</span>
                </a>
            </div>
            <%} %>
            <a href="#submenu3" data-toggle="collapse" aria-expanded="false" class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-list-ul fa-fw mr-3"></span>
                    <span class="menu-collapsed">Take Test</span>
                    <span class="submenu-icon ml-auto"></span>
                </div>
            </a>
            <!-- Submenu content -->
            <div id='submenu3' class="collapse sidebar-submenu">
                <a href="testController?action=viewISDStudent" class="list-group-item list-group-item-action bg-dark text-white">
                    <span class="menu-collapsed">ISD (Dyslexia)</span>
                </a>
                <a href="testController?action=viewLearningStyleStudent" class="list-group-item list-group-item-action bg-dark text-white">
                    <span class="menu-collapsed">Learning Style Screener</span>
                </a>
            </div>
            <!--<a href="login.html" class="bg-dark list-group-item list-group-item-action">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-tasks fa-fw mr-3"></span>
                    <span class="menu-collapsed">Logout</span>
                </div>
            </a>-->
            <a href="#top" data-toggle="sidebar-colapse" class="bg-dark list-group-item list-group-item-action d-flex align-items-center">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span id="collapse-icon" class="fa fa-2x mr-3"></span>
                    <span id="collapse-text" class="menu-collapsed">Collapse</span>
                </div>
            </a>
        </ul><!-- List Group END-->
    </div><!-- sidebar-container END -->