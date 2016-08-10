<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Управление сайтом</title>

    <link href="<c:url value='/static/admin/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/static/admin/css/bootstrap-table.css' />" rel="stylesheet">
    <link href="<c:url value='/static/admin/css/styles.css' />" rel="stylesheet">

    <!--Icons-->
    <script src="<c:url value='/static/admin/js/lumino.glyphs.js' />"></script>

    <!--[if lt IE 9]>
    <script src="<c:url value='/static/admin/js/respond.min.js' />"></script>
    <script src="<c:url value='/static/admin/js/html5shiv.min.js' />"></script>
    <![endif]-->

</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
                <span class="sr-only">Навигация</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span>Управление</span> сайтом</a>
            <ul class="user-menu">
                <li class="dropdown pull-right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Admin <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Посмотреть профиль</a></li>
                        <li><a href="#"><svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg> Редактировать профиль</a></li>
                        <li><a href="#"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Выйти</a></li>
                    </ul>
                </li>
            </ul>
        </div>

    </div><!-- /.container-fluid -->
</nav>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">



    <ul class="nav menu">
        <li><a href="/admin/problems"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Проблемы</a></li>
        <li class="active"><a href="/admin/publications"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Публикации</a></li>

        <li role="presentation" class="divider"></li>
        <li><a href="login.html"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Страница входа</a></li>
    </ul>

</div><!--/.sidebar-->

