<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Редактирование профиля">
    <!-- Profile single information show -->
    <p><b>Имя пользователя:</b> ${user.username}</p>
    <p><b>Имя:</b> ${user.firstName}</p>
    <p><b>Фамилия:</b> ${user.secondName}</p>
    <p><b>Email:</b> ${user.email}</p>
    <p><b>Телефон:</b> ${user.phoneNumber}</p>
    <form id="profileEditForm" class="form-horizontal" action="<c:url value="/profile/edit"/>" method="POST">
        <label class="form-label" for="username">Имя пользователя</label>
        <input id="username" name="username" class="form-control mb-2" type="text" value="${user.username}" required/>
        <label class="form-label" for="firstName">Имя</label>
        <input id="firstName" name="firstName" class="form-control mb-2" type="text" value="${user.firstName}" required/>
        <label class="form-label" for="secondName">Фамилия</label>
        <input id="secondName" name="secondName" class="form-control mb-2" type="text" value="${user.secondName}" required/>
        <label class="form-label" for="email">Email</label>
        <input id="email" name="email" class="form-control mb-2" type="text" value="${user.email}" required/>
        <label class="form-label" for="phoneNumber">Телефон</label>
        <input id="phoneNumber" name="phoneNumber" class="form-control mb-3" type="text" value="${user.phoneNumber}" required/>
        <button type="submit" class="btn btn-primary">Обновить</button>
    </form>
</t:mainLayout>
