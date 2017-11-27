<%--
  Created by IntelliJ IDEA.
  User: CodeAcademy
  Date: 2017.10.03
  Time: 09:20
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
            <form:form method="post" action="/register" modelAttribute="user1Form" cssClass="form-group">
                <form:input type="text" path="username" placeholder="User Name" autofocus="true" cssClass="form-control"/>
                <form:errors path="username"></form:errors>

                <form:input type="password" path="password" placeholder="Password" cssClass="form-control"/>
                <form:errors path="password"></form:errors>

                <form:input type="password" path="passwordconfirm" placeholder="Repeat password" cssClass="form-control"/>
                <form:errors path="passwordconfirm"></form:errors>
                <button type="submit" class="btn btn-dark" value="save">Save</button>
            </form:form>
        </div>
    </div>
</div>
<script type="text/javascript" src="${path}/resources/jQuery/jquery-3.2.1.js"/>
<script type="text/javascript" src="${path}/resources/js/bootstrap.min.js"/>
</body>
</html>
