<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Отзыв">
    <p class="card-text">${review.text}</p>
    <p class="card-text">Оценка ${review.rating}</p>
</t:mainLayout>