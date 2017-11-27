<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table" style="margin-top: 20px">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Klasė</th>
        <th scope="col">Mokiniai</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <br>
    <tbody>
    <c:forEach var="student" items="${studentlist}" varStatus="theCount">
        <tr class="my-row" id="subject-row-${student.id}">
            <th scope="row_number">${theCount.count}</th>
            <td id="subjectList_name-${student.id}">${student.name}</td>
            <td id="button_delete_subject-${student.id}"><button class="btn btn-warning" onclick="">Pašalinti</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>