<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Change Psychologist</title>
</head>

<body>
<c:choose>
    <c:when test="${edit}">
        <h3>Edit psychologist</h3>
    </c:when>
    <c:otherwise>
        <h3>Add psychologist</h3>
    </c:otherwise>
</c:choose>
<div class="generic-container">
    <form:form method="POST" commandName="psychologistForm" modelAttribute="psychologistForm" class="form-horizontal" enctype="multipart/form-data" >
        <form:input type="hidden" path="id" id="id"/>
        <form:input type="hidden" path="photo" id="photo"/>

        <label class="col-md-3 control-lable" for="name">name</label>
        <div class="col-md-7">
            <form:input type="text" path="name" id="name" class="form-control input-sm"/>
            <div class="has-error">
                <form:errors path="name" class="help-inline"/>
            </div>
        </div>


        <label class="col-md-3 control-lable" for="contacts">contacts</label>
        <div class="col-md-7">
            <form:textarea  type="text" path="contacts" id="contacts" class="form-control input-sm"/>
            <div class="has-error">
                <form:errors path="contacts" class="help-inline"/>
            </div>
        </div>


        <label class="col-md-3 control-lable" for="about">about</label>
        <div class="col-md-7">
            <form:textarea  type="text" path="about" id="about" class="form-control input-sm"/>
            <div class="has-error">
                <form:errors path="about" class="help-inline"/>
            </div>
        </div>

        <c:choose>
        <c:when test="${edit}"><tr><td  colspan="2"><img style=" margin-left: 70px"  src="${psychologistForm.photo}" width="200" height="200" /><</c:when>
        </c:choose>
        <label for="file" >Путь к фотографии психолога: </label>
        <form:input type="file" accept="image/*" path="file" id="file" />
        <form:errors path="file" cssClass="error"/>


        <br>
        <c:choose>
            <c:when test="${edit}">
                <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
            </c:when>
            <c:otherwise>
                <input type="submit" value="Add" class="btn btn-primary btn-sm"/> or <a  href="<c:url value='/list' />">Cancel</a>
            </c:otherwise>
        </c:choose>

    </form:form>
</div>
</body>
</html>