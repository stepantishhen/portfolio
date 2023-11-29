<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Регистрация">
  <div>${error}</div>
  <form id="registerForm" class="form-horizontal" action="<c:url value="/register"/>" method="POST">
    <label class="form-label mt-2" for="username">Имя пользователя</label>
    <input id="username" name="username" class="form-control mt-1" type="text" value=""/>
    <label class="form-label mt-2" for="password">Пароль</label>
    <input id="password" name="password" class="form-control mt-1" type="password"/>
    <button type="submit" class="btn btn-success mt-3">Зарегистрироваться</button>
  </form>
</t:mainLayout>
