<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 16/09/2020
  Time: 08:57
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <spring:url value="/resources/" var="assets"/>
    <link rel="stylesheet" href="${assets}css/bootstrap.min.css">
    <link rel="stylesheet" href="${assets}css/style.css">
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="login-form">
                <form action="<c:url value='/' />" method="post">
                    <img src="${assets}img/login.svg" class="rounded mx-auto d-block img" alt="logo login">
                    <h2 class="text-black-50">Login</h2>
                    <c:if test="${not empty error}">
                        <div class="alert-danger text-center mensaje">${error}</div>
                    </c:if>
                    <c:if test="${not empty logout}">
                        <div class="alert-info text-center mensaje">${logout}</div>
                    </c:if>
                    <div class="form-group">
                        <label for="usuario">Usuario</label>
                        <input type="text" class="form-control" id="usuario"
                               name="usuario" placeholder="Ingrese usuario" required="required">
                    </div>
                    <div class="form-group">
                        <label for="contrasena">Contraseña</label>
                        <input type="password" class="form-control" id="contrasena"
                               name="contrasena" placeholder="Ingrese Contraseña" required="required">
                    </div>
                    <button class="btn btn-primary btn-block">Ingresar</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="${assets}js/jquery-3.4.1.min.js"></script>
<script src="${assets}js/bootstrap.min.js"></script>
<script src="${assets}js/app.js"></script>
</body>
</html>
