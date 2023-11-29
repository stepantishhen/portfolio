<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Пост">
    <img src="<c:url value="/uploaded/files?id=${file.id}"/>" class="card-img-top" alt="...">
    <p class="card-text">${file.description}</p>
    <a class="btn btn-success" href="<c:url value="/file/list"/>">Назад</a>
</t:mainLayout>