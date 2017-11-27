<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="e" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/welcomepage.css"/>
    <script type="text/javascript" src="../../resources/js/student.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>
<footer class="container-fluid">
    <c:if test="${pageContext.request.userPrincipal.name!=null}">
        <form id="logoutForm" method="post" action="${path}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>
        <h2>
            Labas vartotojau vardu: ${pageContext.request.userPrincipal.name} |-> <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>
    </c:if>
</footer>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <div class="w3-sidebar w3-bar-block"  style="width:25%">
                <a href="main" class="w3-bar-item w3-button">Mokytojų sąrašas</a>
                <a href="subjectList" class="w3-bar-item w3-button">Mokomųjų dalykų sąrašas</a>
                <a href="studentList" class="w3-bar-item w3-button">Studentų sąrašas</a>
                <a href="class1List" class="w3-bar-item w3-button">Klasių sąrašas</a>
            </div>
        </div>

        <div class="col-sm-10 right-side-content">
            <p><h4>Studentų sąrašas (studentų skaičius: )</h4></p>
            <div>
                <jsp:include page="../../resources/components/addStudentModal.jsp"/>
            </div>
            <jsp:include page="../../resources/components/displayStudentList.jsp"/>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>