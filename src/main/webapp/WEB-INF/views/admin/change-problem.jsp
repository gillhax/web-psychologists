<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/admin/header.jsp" />
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="/admin"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
            <li><a href="/admin/problems">Проблемы</a></li>
            <li class="active">
                <c:choose>
                <c:when test="${edit}">
                    Редактирование проблемы
                </c:when>
                <c:otherwise>
                    Добавление проблемы
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
                    Редактирование проблемы
                </c:when>
                <c:otherwise>
                    Добавление проблемы
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
                        Редактирование проблемы
                    </c:when>
                    <c:otherwise>
                        Добавление проблемы
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="panel-body"  data-align="center">
                <div class="col-md-6">
                <form:form method="POST" modelAttribute="problem" role="form">
                    <form:input type="hidden" path="id" id="id"/>

                    <div class="form-group">
                        <label for="name">Название проблемы</label>
                        <form:input  type="text" path="name"  id="name"  class="form-control" placeholder="Название проблемы" />
                        <div class="has-warning">
                            <form:errors  path="name" class="form-control"/>
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
