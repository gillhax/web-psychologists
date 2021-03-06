<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List</title>
</head>

<body>
<!-- Default panel contents -->

<table class="table table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Problem Name</th>
        <th width="30"></th>
        <th>Publications about problem</th>
        <th width="40"></th>
        <th width="40"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${problems}" var="problem">
        <tr>
            <td>${problem.id}</td>
            <td>${problem.name}</td>
            <td></td><td><c:forEach items="${problem.publications}" var="publication">
                ${publication.title}, </c:forEach></td>
            <td><a href="<c:url value='/edit-problem-${problem.id}' />" class="btn btn-success custom-width">edit</a></td>
            <td><a href="<c:url value='/delete-problem-${problem.id}' />" class="btn btn-danger custom-width">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="well">
    <a href="<c:url value='/new-problem' />">Add problem</a>
</div>
<br>

<table class="table table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Psychologist Name</th>
        <th>Psychologist Contacts</th>
        <th>Psychologist Photo</th>
        <th>AboutPsychologist</th>
        <th width="30"></th>
        <th>Publications by psychologist</th>
        <th width="40"></th>
        <th width="40"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${psychologists}" var="psychologist">
        <tr>
            <td>${psychologist.id}</td>
            <td>${psychologist.name}</td>
            <td>${psychologist.contacts}</td>
            <td><img src="${psychologist.photo}" height="200" width="200" /></td>
            <td>${psychologist.about}</td>
            <td></td><td><c:forEach items="${psychologist.publications}" var="publication">
                ${publication.title}, </c:forEach></td>
            <td><a href="<c:url value='/edit-psychologist-${psychologist.id}' />" class="btn btn-success custom-width">edit</a></td>
            <td><a href="<c:url value='/delete-psychologist-${psychologist.id}' />" class="btn btn-danger custom-width">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="well">
    <a href="<c:url value='/new-psychologist' />">Add psychologist</a>
</div>
<br>

<table class="table table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Publication Title</th>
        <th>Publication Content</th>
        <th>Problem ID</th>
        <th>Problem Name</th>
        <th>Psychologist ID</th>
        <th>Psychologist Name</th>
        <th>Psychologist Contacts</th>
        <th>About Psychologist</th>
        <th width="40"></th>
        <th width="40"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${publications}" var="publication">
        <tr>
            <td>${publication.id}</td>
            <td>${publication.title}</td>
            <td>${publication.content}</td>
            <td>${publication.problem.id}</td>
            <td>${publication.problem.name}</td>
            <td>${publication.psychologist.id}</td>
            <td>${publication.psychologist.name}</td>
            <td>${publication.psychologist.contacts}</td>
            <td>${publication.psychologist.about}</td>
            <td><a href="<c:url value='/edit-publication-${publication.id}' />" class="btn btn-success custom-width">edit</a></td>
            <td><a href="<c:url value='/delete-publication-${publication.id}' />" class="btn btn-danger custom-width">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="well">
    <a href="<c:url value='/new-publication' />">Add publication</a>
</div>
<br>



</body>
</html>
