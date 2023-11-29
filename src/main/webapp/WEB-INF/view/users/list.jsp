<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Список пользователей">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Имя пользователя</th>
            <th scope="col">Email</th>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Номер</th>
            <th scope="col">Роль</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <th scope="row">${user.username}</th>
                <td>${user.email}</td>
                <td>${user.firstName}</td>
                <td>${user.secondName}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</t:mainLayout>