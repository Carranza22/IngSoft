<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 15/09/2020
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="col-md-12">
    <div class="offset-md-1 col-md-10">
        <div class="titulo-asistencia-info">Información Alumno(a)</div>
        <div class="info-alumno">
            <div class="form-group row">
                <label class="col-md-3 col-form-label" >Nombres:</label>
                <div class="col-md">
                    <input type="text" class="form-control form-control-sm"  value="${alumno.nombres}" disabled="disabled" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label">Apellidos:</label>
                <div class="col-md">
                    <input type="text" class="form-control form-control-sm" value="${alumno.apellidos}" disabled="disabled" />
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label">Ciclo de Estudio:</label>
                <div class="col-md-3">
                    <input type="text" class="form-control form-control-sm" value="${ciclo.anio}-${ciclo.n_ciclo}" disabled="disabled" />
                </div>
            </div>
        </div>
        <div class="titulo-asistencia-info">Asistencia Detallada</div>
        <div class="table-responsive">
            <table class="table table-striped table-bordered ">
                <thead class="thead-dark">
                <tr class="d-flex" style="width: 96.3%;">
                    <th class="col-md-1">#</th>
                    <th class="col-md-6">Fecha</th>
                    <th class="col-md-5">Registro</th>
                </tr>
                </thead>
                <tbody>
                <core:forEach var="asistencia" items="${asistencias}" varStatus="i">
                    <tr class="d-flex">
                        <td class="col-md-1">${i.count}</td>
                        <td class="col-md-6"><fmt:formatDate pattern="dd/MM/yyyy"
                                                             value="${asistencia.asistencia.fecha}"/></td>
                        <td class="col-md-5">
                            <core:if test="${asistencia.check_asistencia == true}">
                                <div class="badge badge-success text-wrap" style="width: 6rem;">
                                    Asistió
                                </div>
                            </core:if>
                            <core:if test="${asistencia.check_asistencia == false}">
                                <div class="badge badge-danger text-wrap" style="width: 6rem;">
                                    No Asistió
                                </div>
                            </core:if>
                        </td>
                    </tr>
                </core:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>