<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 9/09/2020
  Time: 05:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:if test="${resultado == false}">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>No existe</strong> ningún registro con el DNI ingresado.
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
<c:if test="${resultado == true}">
    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
        <tr class="d-flex">
            <th class="col-md-1">#</th>
            <th class="col-md-3">Ciclo de Matricula</th>
            <th class="col-md-4">Carrera Profesional</th>
            <th class="col-md-4">N° de voucher</th>
        </tr>
        </thead>
        <tbody class="table-sm table-text-small">
        <core:forEach var="matricula" items="${matriculas}">
            <tr class="d-flex">
                <td class="col-md-1">${matricula.id}</td>
                <td class="col-md-3">${matricula.ciclo.anio} ${matricula.ciclo.n_ciclo}</td>
                <td class="col-md-4">${matricula.carrera.nombre_carrera}</td>
                <td class="col-md-4">${matricula.codigo_voucher}</td>
            </tr>
        </core:forEach>
        </tbody>
    </table>
</c:if>