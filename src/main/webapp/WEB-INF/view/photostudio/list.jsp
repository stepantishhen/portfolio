<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Список фотостудий">
    <c:if test="${user.getRole() == \"admin\"}">
        <a href="<c:url value="/photostudio/create"/>" class="btn btn-outline-success">Добавить фотостудию</a>
    </c:if>
    <c:forEach items="${photostudios}" var="photostudio">
        <div class="card mt-3 mb-3">
            <div class="card-body">
                <h5 class="card-title">${photostudio.title}</h5>
                <p class="card-text">${photostudio.description}</p>
                <a href="<c:url value="/photostudio/detail?id=${photostudio.id}"/>" class="btn btn-success">Подробнее</a>
                <c:if test="${user.getRole() == \"admin\"}">
                    <a href="<c:url value="/photostudio/delete?id=${photostudio.id}"/>" class="btn btn-outline-danger">Удалить</a>
                </c:if>
            </div>
        </div>
    </c:forEach>
</t:mainLayout>