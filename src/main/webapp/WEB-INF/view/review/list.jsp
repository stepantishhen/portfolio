<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Список всех отзывов пользователей">
    <a class="btn btn-outline-success" href="<c:url value="/review/create"/>">Добавить отзыв</a>
    <c:forEach items="${reviews}" var="review">
        <div class="card mt-3 mb-3">
            <div class="card-body">
                <p class="card-text">${review.text}</p>
                <p class="card-text">Оценка - ${review.rating}</p>
                <a href="<c:url value="/review/detail?id=${review.id}"/>" class="card-link">Открыть</a>
                <c:if test="${user.getRole() == \"admin\"}">
                    <a href="<c:url value="/review/delete?id=${review.id}"/>" class="card-link">Удалить</a>
                </c:if>
            </div>
        </div>
    </c:forEach>
</t:mainLayout>