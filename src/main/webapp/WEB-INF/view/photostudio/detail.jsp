<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="${photostudio.title}">
    <p><b>Описание:</b> ${photostudio.description}</p>
    <p><b>Адрес:</b> ${photostudio.address}</p>
    <p><b>Email:</b> ${photostudio.email}</p>
    <p><b>Телефон:</b> ${photostudio.phoneNumber}</p>
</t:mainLayout>