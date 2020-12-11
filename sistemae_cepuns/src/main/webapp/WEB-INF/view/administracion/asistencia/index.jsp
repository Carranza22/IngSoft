<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
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
<div id="inicio_asistencia" class="container">
    <div class="row">
        <div class="col-md-4 div-panel">
            <fieldset>
                <legend>Registros</legend>
                <div class="seccion_rg">
                    <h5 class="text-dark text-left titulo-subpanel">Ciclo de Estudio</h5>
                    <div class="form-group">
                        <select id="list_ciclo_estudio" class="form-control" name="ciclo_estudio">
                            <option hidden selected></option>
                            <core:forEach var="ciclo" items="${lista_ciclos}">
                                <option
                                        value="${ciclo.id}">${ciclo.anio}-${ciclo.n_ciclo}</option>
                            </core:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-outline-dark btn-sm btn-block" onclick="listar_asistencia_ciclo()">Mostrar
                            Registro</a>
                    </div>
                </div>
            </fieldset>
        </div>
        <div class="col-md-7 div-panel" style="margin-left: 20px;">
            <input type="hidden" id="ciclo_estudio" value="${id_ciclo}"/>
            <fieldset>
                <legend>Asistencia del Dia | Alumnos</legend>
                <div class="row">
                    <div class="col-md-6 form-group">
                        <label for="fecha_asistencia_alumno">Fecha</label>
                        <input type="date" id="fecha_asistencia_alumno" name="fecha_asistencia_alumno"
                               class="form-control"
                               data-toggle="tooltip" data-placement="bottom"
                               title="Fecha de Hoy"/>
                    </div>
                    <div class="col-md-6 form-group">
                        <label for="facultades">Facultad</label>
                        <div class="form-group">
                            <select id="facultades" class="form-control" name="ciclo_estudio">
                                <option hidden selected></option>
                                <core:forEach var="facultad" items="${facultades}">
                                    <option
                                            value="${facultad.id}">${facultad.nombre_facultad}</option>
                                </core:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6 form-group">
                        <a class="btn btn-outline-dark btn-sm btn-block" onclick="div_asistencia_alumnos()">Registrar
                            Asistencia</a>
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <legend>Asistencia del Dia | Docentes</legend>
                <div class="row">
                    <div class="col-md-6 form-group">
                        <label for="fecha_asistencia_docente">Fecha</label>
                        <input type="date" id="fecha_asistencia_docente" name="fecha_asistencia_docente"
                               class="form-control"
                               data-toggle="tooltip" data-placement="bottom"
                               title="Fecha de Hoy"/>
                    </div>
                    <div class="col-md-6 form-group">
                        <label for="facultades">DNI del Docente</label>
                        <input id="dni_docente" class="form-control"
                               placeholder="DNI"
                               data-toggle="tooltip" data-placement="bottom"
                               maxlength="8"
                               oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                               title="DNI del Docente"/>
                    </div>
                    <div class="col-md-6 form-group">
                        <a class="btn btn-outline-dark btn-sm btn-block" onclick="registrar_asistencia_docente()">Registrar
                            Asistencia</a>
                    </div>
                </div>
            </fieldset>
        </div>
    </div>
</div>
