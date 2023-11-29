<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Добавить фотостудию">
    <div>${message}</div>
    <form action="<c:url value="/photostudio/create"/>" method="POST">
        <label for="title">Название</label>
        <input id="title" name="title" class="form-control" type="text" required/>
        <label for="description">Описание</label>
        <input id="description" name="description" class="form-control" type="text" required/>
        <label for="address">Адрес</label>
        <input id="address" name="address" class="form-control" type="text" required/>
        <label for="email">Email</label>
        <input id="email" name="email" class="form-control" type="text" required/>
        <label for="phonenumber">Телефон</label>
        <input id="phonenumber" name="phonenumber" class="form-control" type="text" required/>
        <button type="submit" class="btn btn-primary">Создать</button>
    </form>
</t:mainLayout>