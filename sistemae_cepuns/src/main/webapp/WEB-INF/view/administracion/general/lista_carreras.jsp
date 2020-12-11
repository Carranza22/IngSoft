<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 5/09/2020
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table table-striped table-bordered">
    <thead class="thead-dark">
    <tr class="d-flex">
        <th class="col-md-1" scope="col">#</th>
        <th class="col-md-4" scope="col">Carrera</th>
        <th class="col-md-4" scope="col">Facultad</th>
        <th class="col-md-3" scope="col">Acción</th>
    </tr>
    </thead>
    <tbody>
    <core:forEach var="carrera" items="${carreras}">
        <tr class="d-flex">
            <th class="col-md-1" scope="row">${carrera.id_carrera}</th>
            <td class="col-md-4">${carrera.nombre_carrera}</td>
            <td class="col-md-4">${carrera.facultad.nombre_facultad}</td>
            <td class="col-md-3">
                <button class="btn btn-sm btn-primary btn-editar"
                        onclick="editar_entidad('carrera',${carrera.id_carrera})">
                    Editar
                </button>
                <button class="btn btn-sm btn-info btn-eliminar"
                        onclick="eliminar_entidad('carrera',${carrera.id_carrera})">Eliminar
                </button>
            </td>
        </tr>
    </core:forEach>
    </tbody>
</table>
