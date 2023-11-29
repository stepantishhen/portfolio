<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Занятые даты">
    <a href="<c:url value="/booking/create"/>" class="btn btn-outline-success">Записаться на фотосессию</a>
    <c:forEach items="${bookings}" var="booking">
        <div class="card mt-3 mb-3">
            <div class="card-body">
                <p class="card-text">ID Фотостудии: ${booking.photoStudioId}</p>
                <p class="card-text">Дата: ${booking.date}</p>
                <c:if test="${user.getRole() == \"admin\"}">
                    <p class="card-text">ID Пользователя: ${booking.userId}</p>
                </c:if>
            </div>
        </div>
    </c:forEach>
</t:mainLayout>