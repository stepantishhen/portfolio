<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Список постов">
    <a class="btn btn-outline-success mb-3" href="<c:url value="/file/create"/>">Добавить пост</a>
    <c:forEach items="${files}" var="file">
        <div class="card mb-3">
            <img src="<c:url value="/uploaded/files?id=${file.id}"/>" class="card-img-top" alt="...">
            <div class="card-body">
                <p class="card-text">${file.description}</p>
                <a href="<c:url value="/file/detail?id=${file.getId()}"/>" class="btn btn-success">Подробнее</a>
                <a href="<c:url value="/file/delete?id=${file.getId()}"/>" class="btn btn-danger">Удалить пост</a>
            </div>
        </div>
    </c:forEach>
</t:mainLayout>