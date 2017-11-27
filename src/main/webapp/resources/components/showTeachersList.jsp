<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table" style="margin-top: 20px">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Pavardė, Vardas</th>
        <th scope="col">Kontaktiniai duomenys</th>
        <th scope="col">Dalykai</th>
        <th scope="col">Registracijos duomenys</th>
        <th scope="col">Auklėjamos klasės</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>

    <tbody>
        <c:forEach var="teacher" items="${teachersList}" varStatus="theCount">
            <tr class="my-row" id="row-${teacher.id}">
                <th scope="row_number">${theCount.count}</th>
                <td id="name&surname-${teacher.id}" contenteditable="false">${teacher.surname} ${teacher.name}</td>
                <td id="phone-${teacher.id}" value="${teacher.telephone}" contenteditable="false">${teacher.telephone}</td>
                <td id="subject-${teacher.id}"><c:forEach var="subject" items="${teacher.subjectList}"> ${subject.name} </c:forEach></td>
                <td id="email-${teacher.id}" contenteditable="false">${teacher.email}</td>
                <td id="class_name-${teacher.id}" contenteditable="false">${teacher.class_name}</td>
                <td id="button_edit-${teacher.id}" ><button class="btn btn-success" onclick="editTeacher(${teacher.id})">Redaguoti</button></td>
                <td id="button_delete-${teacher.id}"><button class="btn btn-warning" onclick="deleteTeacher(${teacher.id})">Pašalinti</button></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

