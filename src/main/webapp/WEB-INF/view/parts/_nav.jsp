<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <a class="navbar-brand" href="<c:url value="/"/>">PhotoPortfolio</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <c:if test="${user != null}">
          <li class="nav-item"><a class="nav-link" href="<c:url value="/booking/list"/>">Booking</a></li>
          <li class="nav-item"><a class="nav-link" href="<c:url value="/photostudio/list"/>">Photo Studio</a></li>
          <li class="nav-item"><a class="nav-link" href="<c:url value="/review/list"/>">Review</a></li>
          <c:if test="${user.getRole() == \"admin\"}">
            <li class="nav-item"><a class="nav-link" href="<c:url value="/file/list"/>">Files</a></li>
            <li class="nav-item"><a class="nav-link" href="<c:url value="/user/list"/>">Users</a></li>
          </c:if>
        </c:if>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <c:if test="${user == null}">
          <div class="btn-group">
            <a class="btn btn-success" href="<c:url value="/signin"/>">Sign In</a>
            <a class="btn btn-outline-success ml-3" href="<c:url value="/register"/>">Registration</a>
          </div>
        </c:if>
        <c:if test="${user != null}">
          <li><b><a class="nav-link" href="${pageContext.request.contextPath}/profile/edit">${user.getUsername()}</a></b></li>
          <li><a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>
