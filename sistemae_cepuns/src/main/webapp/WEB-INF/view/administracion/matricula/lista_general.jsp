<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 9/09/2020
  Time: 05:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<h3 class="text-center text-dark text-uppercase" style="font-weight: 600;">Registros Generales</h3>
<br>
<table class="table table-striped table-bordered">
    <thead class="thead-dark">
    <tr class="d-flex">
        <th class="col-md-1">#</th>
        <th class="col-md-2">DNI</th>
        <th class="col-md-3">Alumno(a)</th>
        <th class="col-md-2">Carrera Profesional</th>
        <th class="col-md-2">Ciclo de Matricula</th>
        <th class="col-md-2">N° de voucher</th>
    </tr>
    </thead>
    <tbody class="table-sm table-text-small">
    <core:forEach var="matricula" items="${matriculas}">
        <tr class="d-flex">
            <td class="col-md-1">${matricula.id}</td>
            <td class="col-md-2">${matricula.alumno.dni}</td>
            <td class="col-md-3">${matricula.alumno.nombres} ${matricula.alumno.apellidos}</td>
            <td class="col-md-2">${matricula.carrera.nombre_carrera}</td>
            <td class="col-md-2">${matricula.ciclo.anio}-${matricula.ciclo.n_ciclo}</td>
            <td class="col-md-2">${matricula.codigo_voucher}</td>
        </tr>
    </core:forEach>
    </tbody>
</table>