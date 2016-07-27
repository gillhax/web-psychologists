<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Change Problem</title>
</head>

<body>
<c:choose>
    <c:when test="${edit}">
        <h3>Edit problem</h3>
    </c:when>
    <c:otherwise>
        <h3>Add problem</h3>
    </c:otherwise>
</c:choose>
<div class="generic-container">
    <form:form method="POST" modelAttribute="problem" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>


        <label class="col-md-3 control-lable" for="name">name</label>
        <div class="col-md-7">
            <form:input type="text" path="name" id="name" class="form-control input-sm"/>
            <div class="has-error">
                <form:errors path="name" class="help-inline"/>
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