<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 14/09/2020
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row div-panel">
    <div class="col-md-2">
        <button onclick="div_container_admin('asistencia')" type="button" class="btn btn-secondary btn-regresar"><i
                class="fa fa-arrow-left"
                aria-hidden="true"></i>Regresar
        </button>
    </div>
    <div class="col-md-10 ">
        <core:if test="${lista_activa == false}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>Existe un registro!</strong> de asistencia con lo seleccionado.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </core:if>
        <core:if test="${lista_activa == true}">
            <div class="table-responsive">
                <Spring:form id="form__asistencia_alumno" modelAttribute="list_alumnos">
                    <table class="table table-striped table-bordered">
                        <thead class="thead-dark">
                        <tr class="d-flex" style="width: 98.5%;">
                            <th class="col-md-2">DNI</th>
                            <th class="col-md-4">Nombres</th>
                            <th class="col-md-4">Apellidos</th>
                            <th class="col-md-2"> Asistencia</th>
                        </tr>
                        </thead>
                        <tbody>
                        <core:forEach items="${list_alumnos.asistenciaAlumnoList}" var="asistencia" varStatus="i">
                            <tr class="d-flex">
                                <td class="col-md-2">${asistencia.matricula.alumno.dni}</td>
                                <td class="col-md-4">${asistencia.matricula.alumno.nombres}</td>
                                <td class="col-md-4">${asistencia.matricula.alumno.apellidos}</td>
                                <td hidden><form:input path="asistenciaAlumnoList[${i.index}].asistencia.id"
                                                         value="${asistencia.id}"/></td>
                                <td hidden><form:input path="asistenciaAlumnoList[${i.index}].matricula.id"
                                                         value="${asistencia.matricula.id}"/></td>
                                <td class="col-md-2"><form:checkbox
                                        path="asistenciaAlumnoList[${i.index}].check_asistencia"
                                        value="${asistencia.check_asistencia}"/></td>
                            </tr>
                        </core:forEach>
                        </tbody>
                    </table>
                    <div id="btns_registrar_administrador" class="col-md-6 form-group">
                        <Spring:button type="submit" onclick="registrar_asistencia_alumno()"
                                       class="btn btn-primary">Guardar</Spring:button>
                        <a
                                class="btn btn-secondary" onclick="limpiar_form('form__asistencia_alumno')">Limpiar</a>
                    </div>
                </Spring:form>
            </div>
        </core:if>
    </div>
</div>