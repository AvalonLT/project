<%--
  Created by IntelliJ IDEA.
  User: CodeAcademy
  Date: 2017.10.03
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="e" uri="http://www.springframework.org/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${path}/resources/css/style.css">
    <link rel="stylesheet" href="${path}/resources/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-4">
            <form method="post" action="/login" class="form-control ${error!=null ? 'show error' : ''}" >
                <input name="username" value="Jonas1" type="text" placeholder="User name" autofocus="true">
                <input name="password" value="123456" type="password" placeholder="Password">
                <span>${error}</span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <button class="btn" type="submit">Log In</button>

                <h5><a href="${path}/register">create new user1</a> </h5>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="${path}/resources/jQuery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${path}/resources/js/bootstrap.min.js"></script>
</body>
</html>
