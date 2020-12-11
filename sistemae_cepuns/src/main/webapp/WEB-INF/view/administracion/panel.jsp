<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 4/09/2020
  Time: 00:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Panel</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <spring:url value="/resources/" var="assets"/>
    <meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
    <meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
    <link rel="stylesheet" href="${assets}css/bootstrap.min.css">
    <link rel="stylesheet" href="${assets}css/alertify.min.css"/>
    <link rel="stylesheet" href="${assets}css/alertify.theme-bootstrap.min.css"/>
    <link rel="stylesheet" href="${assets}css/style.css">
    <link rel="stylesheet" href="${assets}css/font-awesome.min.css">
</head>
<body>
<section id="barra-menu">
    <div id="sidebar-wrapper">
        <div id="sidebar-scroller">
            <div id="sidebar-container">
                <div class="panel-titulo">
                    <h2>PANEL</h2>
                </div>
                <ul>
                    <core:if test="${privilegio == '[ADMINISTRADOR]'}">
                        <li>
                            <a onclick="div_container_admin('general')" title="General"
                               class="nav-item active scrollto">
                                General
                            </a>
                        </li>
                        <li>
                            <a onclick="div_container_admin('docente')" title="Docente"
                               class="nav-item active scrollto">
                                Docente
                            </a>
                        </li>
                    </core:if>
                    <core:if test="${privilegio == '[ADMINISTRADOR]' || privilegio == '[MATRICULA]' }">
                        <li>
                            <a onclick="div_container_admin('matricula')" title="Matricula"
                               class="nav-item active scrollto">
                                Matrícula
                            </a>
                        </li>
                        <li>
                            <a onclick="div_container_admin('alumno')" title="Alumno"
                               class="nav-item active scrollto">
                                Alumno
                            </a>
                        </li>
                    </core:if>
                    <core:if test="${privilegio == '[ADMINISTRADOR]' || privilegio == '[ASISTENCIA]' }">
                    <li>
                        <a onclick="div_container_admin('asistencia')" title="Asistencia"
                           class="nav-item active scrollto">
                            Asistencia
                        </a>
                    </li>
                    </core:if>
                    <core:if test="${privilegio == '[ADMINISTRADOR]' || privilegio == '[NOTAS]' }">
                    <li>
                        <a onclick="div_container_admin('notas')" title="Notas"
                           class="nav-item active scrollto">
                            Notas
                        </a>
                    </li>
                    </core:if>
                </ul>
                <ul>
                    <div class="justify-content-center btn-salir">
                        <form class="form-inline text-center">
                            <a class="btn btn-outline-light btn-block"
                               href="javascript:document.getElementById('logout').submit()"><i class="fa fa-sign-out"
                                                                                               aria-hidden="true"></i>Salir</a>
                        </form>
                    </div>
                </ul>
            </div>
        </div>
        <a class="sidebar-btn" href="#"><i class="fa fa-bars"></i></a>
    </div>
    <div id="sidebar-posicion"></div>
</section>
<div class="container-fluid" id="divPanel" style="display: none;">

</div>
<c:url value="/logout" var="logoutUrl"/>
<form id="logout" action="${logoutUrl}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<script src="${assets}js/jquery-3.4.1.min.js"></script>
<script src="${assets}js/bootstrap.min.js"></script>
<script src="${assets}js/alertify.min.js"></script>
<script src="${assets}js/jquery.validate.min.js"></script>
<script src="${assets}js/additional-methods.min.js"></script>
<script src="${assets}js/app.js"></script>
</body>
</html>