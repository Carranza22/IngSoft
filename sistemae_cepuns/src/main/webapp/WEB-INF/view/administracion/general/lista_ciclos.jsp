<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 5/09/2020
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table table-striped table-bordered">
    <thead class="thead-dark">
    <tr class="d-flex">
        <th class="col-md-1">#</th>
        <th class="col-md-2">Ciclo</th>
        <th class="col-md-2">F. de Inicio</th>
        <th class="col-md-2">F. de Termino</th>
        <th class="col-md-2">Inscripciones</th>
        <th class="col-md-3">Acción</th>
    </tr>
    </thead>
    <tbody>
    <core:forEach var="ciclo" items="${ciclos}">
        <tr class="d-flex">
            <td class="col-md-1">${ciclo.id}</td>
            <td class="col-md-2">${ciclo.anio} - ${ciclo.n_ciclo}</td>
            <td class="col-md-2"><fmt:formatDate pattern="dd/MM/yyyy" value="${ciclo.fecha_inicio}"/></td>
            <td class="col-md-2"><fmt:formatDate pattern="dd/MM/yyyy" value="${ciclo.fecha_fin}"/></td>
            <th class="col-md-2">
                <c:choose>
                    <c:when test="${ciclo.estado_matricula == 1}">
                        <button class="btn btn-sm btn-warning btn-editar" disabled>Abierta</button>
                    </c:when>
                    <c:when test="${ciclo.estado_matricula == 0}">
                        <button class="btn btn-sm btn-secondary btn-editar" disabled>Cerrada</button>
                    </c:when>
                </c:choose>
            </th>
            <td class="col-md-3">
                <button class="btn btn-sm btn-primary btn-editar" onclick="editar_entidad('ciclo',${ciclo.id})">Editar</button>
                <button class="btn btn-sm btn-info btn-eliminar" onclick="eliminar_entidad('ciclo',${ciclo.id})">
                    Eliminar
                </button>
            </td>
        </tr>
    </core:forEach>
    </tbody>
</table>