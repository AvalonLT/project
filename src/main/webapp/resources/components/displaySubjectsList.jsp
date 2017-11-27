<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table" style="margin-top: 20px">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Dalyko pavadinimas</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <br>
    <tbody>
    <c:forEach var="subject" items="${subjectList}" varStatus="theCount">
        <tr class="my-row" id="subject-row-${subject.id}">
            <th scope="row_number">${theCount.count}</th>
            <td id="subjectList_name-${subject.id}">${subject.name}</td>
            <td id="button_delete_subject-${subject.id}"><button class="btn btn-warning" onclick="deleteSubjectsList(${subject.id})">Pašalinti</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>