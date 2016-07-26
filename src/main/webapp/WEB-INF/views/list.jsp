<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List</title>
</head>

<body>
<!-- Default panel contents -->
<div class="panel-heading"><span class="lead">List</span></div>

<br>

<table class="table table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Problem Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${problems}" var="problem">
        <tr>
            <td>${problem.id}</td>
            <td>${problem.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>

<table class="table table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Psychologist Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${psychologists}" var="psychologist">
        <tr>
            <td>${psychologist.id}</td>
            <td>${psychologist.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>

<table class="table table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Publication Title</th>
        <th>Problem ID</th>
        <th>Problem Name</th>
        <th>Psychologist ID</th>
        <th>Psychologist Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${publications}" var="publication">
        <tr>
            <td>${publication.id}</td>
            <td>${publication.title}</td>
            <td>${publication.problem.id}</td>
            <td>${publication.problem.name}</td>
            <td>${publication.psychologist.id}</td>
            <td>${publication.psychologist.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>



</body>
</html>
