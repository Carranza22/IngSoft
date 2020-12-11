<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 15/09/2020
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="container">
    <div class="div-panel barra-regresar">
        <button onclick="div_container_admin('asistencia')" type="button" class="btn btn-secondary btn-regresar"><i
                class="fa fa-arrow-left"
                aria-hidden="true"></i>Regresar
        </button>
    </div>
    <div id="div_asistencia_alumno" class=" div-panel">
        <div class="subtitulo">
            <h2 class="text-dark text-center text-uppercase">Alumnos</h2>
        </div>

        <div class="row content-tabla">
            <div class="col-md-2 align-self-center">
                <spring:url value="/resources/" var="assets"/>
                <img class="img-fluid" src="${assets}img/notas.svg">
            </div>
            <div class=" col-md-10 table-responsive">
                <table class="table table-striped table-bordered">
                    <thead class="thead-dark">
                    <tr class="d-flex" style="width: 97.9%;">
                        <th class="col-md-1">#</th>
                        <th class="col-md-2">DNI</th>
                        <th class="col-md-3">Nombres</th>
                        <th class="col-md-4">Apellidos</th>
                        <th class="col-md-2">Acción</th>
                    </tr>
                    </thead>
                    <tbody style="max-height: 300px;">
                    <core:forEach var="alumno" items="${lista_alumnos}" varStatus="i">
                        <tr class="d-flex">
                            <td class="col-md-1">${i.count}</td>
                            <td class="col-md-2">${alumno.dni}</td>
                            <td class="col-md-3">${alumno.nombres}</td>
                            <td class="col-md-4">${alumno.apellidos}</td>
                            <td class="col-md-2">
                                <button class="btn btn-sm btn-primary btn-editar"
                                        onclick="modal_asistencia_alumno(${id_ciclo},${alumno.dni})">
                                    Asistencias
                                </button>
                            </td>
                        </tr>
                    </core:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div id="div_asistencia_docente" class=" div-panel">
        <div class="subtitulo">
            <h2 class="text-dark text-center text-uppercase">Docentes</h2>
        </div>

        <div class="row content-tabla">
            <div class="col-md-2 align-self-center">
                <spring:url value="/resources/" var="assets"/>
                <img class="img-fluid" src="${assets}img/notas.svg">
            </div>
            <div class=" col-md-10 table-responsive">

                <table class="table table-striped table-bordered">
                    <thead class="thead-dark">
                    <tr class="d-flex" style="width: 97.9%;">
                        <th class="col-md-1">#</th>
                        <th class="col-md-2">DNI</th>
                        <th class="col-md-3">Nombres</th>
                        <th class="col-md-4">Apellidos</th>
                        <th class="col-md-2">Acción</th>
                    </tr>
                    </thead>
                    <tbody style="max-height: 300px;">
                    <core:forEach var="docente" items="${lista_docentes}" varStatus="i">
                        <tr class="d-flex">
                            <td class="col-md-1">${i.count}</td>
                            <td class="col-md-2">${docente.dni}</td>
                            <td class="col-md-3">${docente.nombres}</td>
                            <td class="col-md-4">${docente.apellidos}</td>
                            <td class="col-md-2">
                                <button class="btn btn-sm btn-primary btn-editar"
                                        onclick="modal_asistencia_docente(${id_ciclo},${docente.dni})">
                                    Asistencias
                                </button>
                            </td>
                        </tr>
                    </core:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="modal fade" id="modalAsistencia" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content" style="border-radius: 25px;">
                <div class="modal-header" style="padding: 0.5em 1em;">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div id="bodyModalAsistencia" class="modal-body">
                </div>
            </div>
        </div>
    </div>
</div>