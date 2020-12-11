<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 7/09/2020
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="titulo-panel sticky-top">
    <h2 class="text-center text-uppercase">${titulo_container}</h2>
</div>
<div id="inicio_alumno" class="container">
    <div class="div-panel">
        <button id="btn_registrar_alumno" onclick="div_registrar('alumno')" type="button"
                class="btn btn-primary btn-registrar"><i class="fa fa-plus"
                                                         aria-hidden="true"></i>Registrar
        </button>
        <div class="row">
            <div class="col-md-2  align-self-center">
                <core:url value="/resources/" var="assets"/>
                <img class="img-fluid" src="${assets}img/alumno.svg" width="80%" alt="">
            </div>
            <div class="col-md-10">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered ">
                        <thead class="thead-dark">
                        <tr class="d-flex" style="width: 98.5%;">
                            <th class="col-md-2">DNI</th>
                            <th class="col-md-2">Nombres</th>
                            <th class="col-md-2">Apellidos</th>
                            <th class="col-md-2">F. Nacimiento</th>
                            <th class="col-md-2">Celular</th>
                            <th class="col-md-2">Acción</th>
                        </tr>
                        </thead>
                        <tbody>
                        <core:forEach var="alumno" items="${alumnos}">
                            <tr class="d-flex">
                                <td class="col-md-2">${alumno.dni}</td>
                                <td class="col-md-2">${alumno.nombres}</td>
                                <td class="col-md-2">${alumno.apellidos}</td>
                                <td class="col-md-2"><fmt:formatDate pattern="dd/MM/yyyy"
                                                                     value="${alumno.fecha_nacimiento}"/></td>
                                <td class="col-md-2">${alumno.celular}</td>
                                <td class="col-md-2">
                                    <button class="btn btn-sm btn-primary btn-editar"
                                            onclick="div_editar_entidad('alumno',${alumno.dni})">
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