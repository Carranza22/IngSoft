<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 13/09/2020
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="titulo-panel sticky-top">
    <h2 class="text-center text-uppercase">${titulo_container}</h2>
</div>
<div id="inicio_docente" class="container ">
    <div class="div-panel">
        <button id="btn_registrar_docente" onclick="div_registrar('docente')" type="button"
                class="btn btn-primary btn-registrar"><i class="fa fa-plus"
                                                         aria-hidden="true"></i>Registrar
        </button>
        <div class="row">
            <div class="col-md-2 align-self-center">
                <spring:url value="/resources/" var="assets"/>
                <img class="img-fluid" src="${assets}img/docente.svg" alt="">
            </div>
            <div class="col-md-10">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered">
                        <thead class="thead-dark">
                        <tr class="d-flex" style="width: 98.5%;">
                            <th class="col-md-1">#</th>
                            <th class="col-md-2">DNI</th>
                            <th class="col-md-2">Nombres</th>
                            <th class="col-md-3">Apellidos</th>
                            <th class="col-md-3"> Especialidad</th>

                            <th class="col-md-1">Acción</th>
                        </tr>
                        </thead>
                        <tbody>
                        <core:forEach var="docente" items="${docentes}" varStatus="i">
                            <tr class="d-flex">
                                <td class="col-md-1">${i.count}</td>
                                <td class="col-md-2">${docente.dni}</td>
                                <td class="col-md-2">${docente.nombres}</td>
                                <td class="col-md-3">${docente.apellidos}</td>
                                <td class="col-md-3">${docente.especialidad}</td>
                                <td class="col-md-1">
                                    <button class="btn btn-sm btn-primary btn-editar"
                                            onclick="div_editar_entidad('docente',${docente.dni})">
                                        Editar
                                    </button>
                                </td>
                            </tr>
                        </core:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>