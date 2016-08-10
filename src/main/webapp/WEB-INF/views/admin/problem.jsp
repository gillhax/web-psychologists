<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/admin/header.jsp" />

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="/admin"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
            <li class="active">Проблемы</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Проблемы</h1>
        </div>
    </div><!--/.row-->


    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading" >
                      Таблица проблем
                            <a style="text-align: left;" href="<c:url value='/admin/new-problem' />" class="btn btn-success custom-width">Добавить проблему</a>

                </div>
                <div class="panel-body">
                    <table data-toggle="table" data-show-columns="true" data-show-toggle="true"  data-search="true" data-pagination="true" data-sort-name="name" data-sort-order="desc">
                        <thead>
                        <tr>
                            <th data-field="id" data-align="right"   data-sortable="true">Номер</th>
                            <th data-field="name" data-sortable="true">Название </th>
                            <th data-field="edit" data-align="center" >Редактировать</th>
                            <th data-field="delete" data-align="center" >Удалить</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${problems}" var="problem">
                        <tr>
                            <td>${problem.id}</td>
                            <td>${problem.name}</td>
                            <td><a href="<c:url value='/admin/edit-problem-${problem.id}' />" class="btn btn-success custom-width">Редактировать</a></td>
                            <td><a href="<c:url value='/admin/delete-problem-${problem.id}' />" class="btn btn-danger custom-width">Удалить</a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div><!--/.row-->


</div><!--/.main-->

<jsp:include page="/WEB-INF/views/admin/bottom.jsp" />
