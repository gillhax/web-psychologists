<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/admin/header.jsp" />
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="/admin"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
            <li><a href="/admin/publications">Публикации</a></li>
            <li class="active">
                <c:choose>
                    <c:when test="${edit}">
                        Редактирование публикации
                    </c:when>
                    <c:otherwise>
                        Добавление публикации
                    </c:otherwise>
                </c:choose>
            </li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">
                <c:choose>
                    <c:when test="${edit}">
                        Редактирование публикации
                    </c:when>
                    <c:otherwise>
                        Добавление публикации
                    </c:otherwise>
                </c:choose>
            </h1>
        </div>
    </div><!--/.row-->


    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <c:choose>
                        <c:when test="${edit}">
                            Редактирование публикации
                        </c:when>
                        <c:otherwise>
                            Добавление публикации
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="panel-body"  data-align="center">
                    <div class="col-md-6">
                        <form:form method="POST" modelAttribute="publication" role="form">
                            <form:input type="hidden" path="id" id="id"/>

                            <div class="form-group">
                                <label for="problem">Проблема</label>
                                <form:select itemValue="publication.problem.id" type="text" path="problem" id="problem" class="form-control">
                                <c:forEach items="${problems}" var="problem" >
                                       <option value="${problem.id}"  <c:if test="${ problem.id == publication.problem.id}">selected</c:if> > ${problem.name}</option>
                                </c:forEach>
                                </form:select>
                                <div class="has-warning">
                                    <form:errors  path="problem" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="psychologist">Психолог</label>
                                <form:select type="text" path="psychologist" id="psychologist" class="form-control">
                                    <c:forEach items="${psychologists}" var="psychologist">
                                        <form:option value="${psychologist.id}">${psychologist.name}</form:option>
                                    </c:forEach>
                                </form:select>
                                <div class="has-warning">
                                    <form:errors  path="psychologist" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="title">Название публикации</label>
                                <form:input  type="text" path="title"  id="title"  class="form-control" placeholder="Название публикации" />
                                <div class="has-warning">
                                    <form:errors  path="title" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="content">Содержание статьи</label>
                                <form:textarea  type="text" path="content"  id="content"  class="form-control" placeholder="Содержание статьи.." />
                                <div class="has-warning">
                                    <form:errors  path="content" class="form-control"/>
                                </div>
                            </div>

                            <c:choose>
                                <c:when test="${edit}">
                                    <button type="submit" class="btn btn-primary">Обновить</button>
                                </c:when>
                                <c:otherwise>
                                    <button type="submit" class="btn btn-primary">Добавить</button>
                                </c:otherwise>
                            </c:choose>

                        </form:form>

                    </div>

                </div>
            </div>
        </div>
    </div>


</div><!--/.main-->

<jsp:include page="/WEB-INF/views/admin/bottom.jsp" />