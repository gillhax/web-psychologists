<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Вход</title>

    <link href="/static/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/admin/css/styles.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="/static/admin/js/html5shiv.js"></script>
    <script src="/static/admin/js/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">Вход</div>
            <div class="panel-body">
                <c:url var="loginUrl" value="/admin/login" />
                <form role="form" action="${loginUrl}" method="post" >
                    <fieldset>

                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger">
                                <p>Неверное Имя пользователя или Пароль.</p>
                            </div>
                        </c:if>
                        <c:if test="${param.logout != null}">
                            <div class="alert alert-success">
                                <p>Выход произведен успешно.</p>
                            </div>
                        </c:if>

                        <div class="form-group">
                            <input class="form-control" placeholder="Имя пользователя" id="username" name="username" autofocus="">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Пароль" id="password" name="password" type="password" value="">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input id="remember-me" name="remember-me" type="checkbox" >Запомнить меня
                            </label>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                        <input type="submit" class="btn btn-primary" value="Войти">


                    </fieldset>
                </form>
            </div>
        </div>
    </div><!-- /.col-->
</div><!-- /.row -->

<script src="/static/admin/js/jquery-1.11.1.min.js"></script>
<script src="/static/admin/js/bootstrap.min.js"></script>
<script src="/static/admin/js/bootstrap-table.js"></script>
<script>
    !function ($) {
        $(document).on("click","ul.nav li.parent > a > span.icon", function(){
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
</body>

</html>






