<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 5/09/2020
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table table-striped table-bordered">
    <thead class="thead-dark">
    <tr class="d-flex">
        <th class="col-md-2" scope="col">#</th>
        <th class="col-md-6" scope="col">Facultad</th>
        <th class="col-md-4" scope="col">Acción</th>
    </tr>
    </thead>
    <tbody>
    <core:forEach var="facultad" items="${facultades}">
        <tr class="d-flex">
            <th class="col-md-2" scope="row">${facultad.id}</th>
            <td class="col-md-6">${facultad.nombre_facultad}</td>
            <td class="col-md-4">
                <button class="btn btn-sm btn-primary btn-editar" onclick="editar_entidad('facultad',${facultad.id})">
                    Editar
                </button>
                <button class="btn btn-sm btn-info btn-eliminar" onclick="eliminar_entidad('facultad',${facultad.id})">Eliminar
                </button>
            </td>
        </tr>
    </core:forEach>
    </tbody>
</table>