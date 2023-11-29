<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Добавить пост">
    <div>${message}</div>
    <form enctype="multipart/form-data" id="fileCreateForm" class="form-horizontal" action="<c:url value="/file/create"/>" method="post">
        <label for="file" class="form-label">Изображение</label>
        <input class="form-control" type="file" id="file" name="file">
        <label for="description" class="form-label mb-2">Описание</label>
        <textarea class="form-control mb-2" id="description" name="description" placeholder="Описание"></textarea>
        <input type="submit" class="btn btn-success" value="Создать"/>
    </form>
    <a class="btn btn-outline-success mt-2" href="<c:url value="/file/list" />">Назад</a>
</t:mainLayout>