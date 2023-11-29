<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Запись на фотосессию">
    <div>${message}</div>
    <form id="bookingCreateForm" action="<c:url value="/booking/create"/>" method="post">
        <!-- photostudios list select -->
        <label class="form-label">Фотостудия</label>
        <select name="photostudioId" class="form-control" required>
            <c:forEach items="${photostudios}" var="photostudio">
                <option value="${photostudio.id}">${photostudio.title}</option>
            </c:forEach>
        </select>
        <label class="form-label">Дата</label>
        <input type="date" name="date" class="form-control" placeholder="Дата" required>
        <button type="submit" class="btn btn-primary">Забронировать</button>
    </form>
</t:mainLayout>