<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 4/09/2020
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="titulo-panel sticky-top">
    <h2 class="text-center text-uppercase">${titulo_container}</h2>
</div>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="container-subnav fixed-top">
                <nav class="navbar navbar-expand-md navbar-dark bg-dark titulo-navbar">
                    <div class="navbar-collapse collapse w-100 ">
                        <ul class="nav navbar-nav mx-auto nav-general" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" role="tab" aria-selected="true"
                                   data-target="#section_administradores" href="#section_administradores"
                                   onclick="section_general('administradores')">ADMINISTRADORES</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" role="tab" aria-selected="false"
                                   data-target="#section_carreras_facultades" href="#section_carreras_facultades"
                                   onclick="section_general('facultades_carreras')">CARRERAS
                                    & FACULTADES</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" role="tab" aria-selected="false"
                                   data-target="#section_matriculas" href="#section_matriculas"
                                   onclick="section_general('matriculas')">CICLO DE INSCRIPCIÓN</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
            <div style="background-color:#ebedef; padding: 25px; "></div>
            <div class="tab-content div-panel">
                <div class="tab-pane active" role="tabpanel" id="section_administradores"></div>
                <div class="tab-pane" role="tabpanel" id="section_carreras_facultades"></div>
                <div class="tab-pane" role="tabpanel" id="section_matriculas"></div>
            </div>
        </div>
    </div>
</div>
