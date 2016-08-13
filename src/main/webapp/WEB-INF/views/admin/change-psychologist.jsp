<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/admin/header.jsp" />
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="/admin"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
            <li class="active">Редактирование профиля</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Редактирование профиля</h1>
        </div>
    </div><!--/.row-->


    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">Редактирование профиля</div>
                <div class="panel-body"  data-align="center">
                    <div class="col-md-6">
                        <form:form method="POST" modelAttribute="psychologistForm" role="form" enctype="multipart/form-data">
                            <form:input type="hidden" path="id" id="id"/>
                            <form:input type="hidden" path="photo" id="photo"/>
                            <%--<form:input type="hidden" path="username" id="photo"/>--%>
                            <%--<form:input type="hidden" path="password" id="photo"/>--%>



                            <div class="form-group">
                                <label for="username">Уникальное имя входа</label>
                                <form:input  type="text" path="username"  id="username"  class="form-control" placeholder="Имя" />
                                <div class="has-warning">
                                    <form:errors  path="username" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password">Пароль</label>
                                <form:input  type="text" path="password"  id="password"  class="form-control" placeholder="Имя" />
                                <div class="has-warning">
                                    <form:errors  path="password" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="name">Имя</label>
                                <form:input  type="text" path="name"  id="name"  class="form-control" placeholder="Имя" />
                                <div class="has-warning">
                                    <form:errors  path="name" class="form-control"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <label for="contacts">Контакты</label>
                                <form:textarea  type="text" path="contacts"  id="contacts"  class="form-control" placeholder="Контакты..." />
                                <div class="has-warning">
                                    <form:errors  path="contacts" class="form-control"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <label for="about">Об психологе</label>
                                <form:textarea  type="text" path="about"  id="about"  class="form-control" placeholder="Об психологе..." />
                                <div class="has-warning">
                                    <form:errors  path="about" class="form-control"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <label for="file">Фотография</label>
                                <img style=" margin-left: 70px"  src="${psychologistForm.photo}" width="200" height="200" />
                                <form:input type="file" accept="image/*" path="file" id="file" />
                                <div class="has-warning">
                                    <form:errors  path="file" class="form-control"/>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary">Обновить</button>

                        </form:form>

                    </div>

                </div>
            </div>
        </div>
    </div>


</div><!--/.main-->

<jsp:include page="/WEB-INF/views/admin/bottom.jsp" />

