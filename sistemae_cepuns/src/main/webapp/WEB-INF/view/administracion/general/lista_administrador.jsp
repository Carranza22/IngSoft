<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 4/09/2020
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table table-striped table-bordered">
    <thead class="thead-dark">
    <tr class="d-flex">
        <th class="col-md-1">#</th>
        <th class="col-md-5">Nombres y Apellidos</th>
        <th class="col-md-3">Rol</th>
        <th class="col-md-3">Acción</th>
    </tr>
    </thead>
    <tbody>
    <core:forEach var="usuario" items="${usuarios}">
        <tr class="d-flex">
            <td class="col-md-1">${usuario.id}</td>
            <td class="col-md-5">${usuario.nombres} ${usuario.apellidos}</td>
            <td class="col-md-3">${usuario.rol}</td>
            <td class="col-md-3">
                <button class="btn btn-sm btn-primary btn-editar" onclick="editar_entidad('administrador',${usuario.id})">Editar</button>
                <button class="btn btn-sm btn-info btn-eliminar" onclick="eliminar_entidad('administrador',${usuario.id})">Eliminar</button>
            </td>
        </tr>
    </core:forEach>
    </tbody>
</table>