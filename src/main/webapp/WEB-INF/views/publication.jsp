<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List</title>
    <link href="<c:url value='/static/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" />
    <%--<link href="<c:url value='/static/bootstrap/css/bootstrap-theme.min.css' />" rel="stylesheet" />--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<!-- Default panel contents -->
<div class="container" style="margin: 150px auto; font-size: 12px; !important;">


    <ol class="breadcrumb">
        <li><a href="#">Главная</a></li>
        <li><a href="#">${publication.problem.name}</a></li>
        <li class="active">${publication.title}</li>
    </ol>

    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="page-header" style="margin-top: 0; !important;"><h3><strong>${publication.title}</strong></h3></div>
        </div>
        <div class="col-md-3"></div>
    </div>

    <div class="row">

        <div class="col-md-3">


            <%--<ul class="nav  nav-stacked  " id="stacked-menu">--%>
                <%--<c:forEach items="${problems}" var="problem">--%>
                <%--<li>--%>
                    <%--<a  class="list-group-item list-group-item-success" href="#" data-target="#s${problem.id}" data-toggle="collapse" data-parent="#stacked-menu">${problem.name}<span class="caret arrow"></span></a>--%>
                    <%--<ul class="nav nav-stacked collapse  list-group" id="s${problem.id}">--%>
                        <%--<c:forEach items="${problem.publications}" var="publication">--%>
                            <%--<li><a  class="list-group-item" href="/publication-${publication.id}">${publication.title}</a></li>--%>
                        <%--</c:forEach>--%>
                    <%--</ul>--%>
                <%--</li>--%>
                <%--</c:forEach>--%>
            <%--</ul>--%>
                <div class="panel panel-default">
                    <div class="panel-heading"  align="center">Проблемы</div>
                    <div class="panel-body">
                        <ul style="padding-left: 30px">
                            <c:forEach items="${problems}" var="problem">
                             <li>
                                <a href="#">
                                    <span data-toggle="collapse" href="#${problem.id}">${problem.name}</span>
                                </a>
                                <ul class="collapse in" id="${problem.id}" style="padding-left: 30px">
                                    <c:forEach items="${problem.publications}" var="publication">
                                        <li>
                                            <a class=""  href="/publication-${publication.id}">${publication.title}</a>
                                        </li>
                                    </c:forEach>
                                </ul>
                             </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>


        </div>


        <div class="col-md-6">
            <p>${publication.content}</p>

        </div>


        <div class="col-md-3 text-center">

            <div class="panel panel-default">
                <div class="panel-heading" align="center">Контактное лицо</div>
                <div class="panel-body">
                    <%--<img src="/static/image/avatar-temp.svg" class="img-thumbnail">--%>
                    <img height="200" width="200" src="${publication.psychologist.photo}" class="img-thumbnail">
                    <h5>${publication.psychologist.name}</h5>

                    <p>Контакты: ${publication.psychologist.contacts}</p>
                    <a href="<c:url value='/psychologist-${publication.psychologist.id}' />"  class="btn btn-success btn-block">Полная информация</a>
                </div>

            </div>

        </div>


    </div>

</div>

<!-- Bootstrap core JavaScript-->
<script src="/static/js/jquery.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>


</body>
</html>
