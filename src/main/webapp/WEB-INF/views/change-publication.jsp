<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Change Publication</title>
</head>

<body>
<c:choose>
    <c:when test="${edit}">
        <h3>Edit publication</h3>
    </c:when>
    <c:otherwise>
        <h3>Add publication</h3>
    </c:otherwise>
</c:choose>
<div class="generic-container">
    <form:form method="POST" modelAttribute="publication" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <label class="col-md-3 control-lable" for="problem">problem</label>
        <div class="col-md-7">
            <form:select type="text" path="problem" id="problem" class="form-control input-sm">
                <c:forEach items="${problems}" var="problem">
                    <form:option value="${problem.id}">${problem.name}</form:option>
                </c:forEach>
            </form:select>
            <div class="has-error">
                <form:errors path="problem" class="help-inline"/>
            </div>
        </div>

        <label class="col-md-3 control-lable" for="psychologist">psychologist</label>
        <div class="col-md-7">
            <form:select type="text" path="psychologist" id="psychologist" class="form-control input-sm">
                <c:forEach items="${psychologists}" var="psychologist">
                    <form:option value="${psychologist.id}">${psychologist.name}</form:option>
                </c:forEach>
            </form:select>
            <div class="has-error">
                <form:errors path="psychologist" class="help-inline"/>
            </div>
        </div>

        <label class="col-md-3 control-lable" for="title">title</label>
        <div class="col-md-7">
            <form:input type="text" path="title" id="title" class="form-control input-sm"/>
            <div class="has-error">
                <form:errors path="title" class="help-inline"/>
            </div>
        </div>


        <label class="col-md-3 control-lable" for="content">content</label>
        <div class="col-md-7">
            <form:textarea   path="content" id="content" class="form-control input-sm" />
            <div class="has-error">
                <form:errors path="content" class="help-inline"/>
            </div>
        </div>

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