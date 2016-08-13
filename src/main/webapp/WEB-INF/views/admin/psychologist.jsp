<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/admin/header.jsp" />

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li></li>
        </ol>
    </div><!--/.row-->




    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading" align="center"><strong>${psychologist.name}</strong></div>
                <div class="panel-body">
                    <%--<img src="/static/image/avatar-temp.svg" class="img-thumbnail">--%>
                    <div class="row">


                        <div class="col-md-8">
                            <p>${psychologist.about}</p>
                        </div>
                        <div class="col-md-4">
                            <img height="300" width="300" src="${psychologist.photo}" class="img-thumbnail">
                        </div>
                    </div>
                    <div class="page-header" style="margin: 0 0 15px 0; padding: 0 0 0 5px;"><h5>Контакты:</h5></div>
                    <div style="margin-bottom: 20px">${psychologist.contacts}</div>

                    <div class="page-header" style="margin: 0 0 15px 0; padding: 0 0 0 5px;"><h5>Публикации психолога:</h5></div>
                    <ul>
                        <c:forEach items="${psychologist.publications}" var="publication">
                            <li><a href="<c:url value='/publication-${publication.id}' />" >${publication.title} - ${publication.problem.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>

            </div>
            </div>
        </div>
    </div><!--/.row-->


</div><!--/.main-->

<jsp:include page="/WEB-INF/views/admin/bottom.jsp" />