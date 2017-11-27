<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table" style="margin-top: 20px">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Vardas</th>
        <th scope="col">Pavardė</th>
        <th scope="col">Globėjų informacija</th>
        <th scope="col">Klasė</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="student" items="${studentlist}" varStatus="theCount">
        <tr class="my-row" id="student-row-${student.id}">
            <th scope="row_number">${theCount.count}</th>
            <td id="student-name-${student.id}" contenteditable="false">${student.name}</td>
            <td id="student-surname-${student.id}" value="${student.surname}" contenteditable="false">${student.surname}</td>
            <td id="parent_info-address-${student.id}" contenteditable="false">${student.foster.address}</td>
            <td id="class_name-${student.id}" contenteditable="false">${student.class1.name}</td>
            <td id="student_button_edit-${student.id}" ><button class="btn btn-success" onclick="editStudent(${student.id}, ${student.class1.id}, ${student.foster.id})">Redaguoti</button></td>
            <td id="student_button_delete-${student.id}"><button class="btn btn-warning" onclick="deleteStudent(${student.id})">Pašalinti</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>