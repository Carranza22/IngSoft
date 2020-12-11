<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 16/09/2020
  Time: 07:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="container">
    <div class="div-panel barra-regresar">
        <div class="row">
            <div class="col-md-2">
                <button onclick="div_container_admin('notas')" type="button" class="btn btn-secondary btn-regresar"><i
                        class="fa fa-arrow-left"
                        aria-hidden="true"></i>Regresar
                </button>
            </div>
            <div class="col-md-8 titulo-barra">
                <h2 class="text-dark text-center text-uppercase">Registro Notas | Alumnos</h2>
            </div>
        </div>
    </div>
    <div class=" div-panel">
        <div class=" col-md-12 table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="thead-dark">
                <tr class="d-flex" style="width: 97.9%;">
                    <th class="col-md-2">DNI</th>
                    <th class="col-md-2">Nombres</th>
                    <th class="col-md-2">Apellidos</th>
                    <th class="col-md-2">Sumativo 1</th>
                    <th class="col-md-2">Sumativo 2</th>
                    <th class="col-md-2">Sumativo 3</th>
                </tr>
                </thead>
                <tbody style="max-height: 300px;">
                <core:forEach var="nota" items="${registro_notas}" varStatus="i">
                    <tr class="d-flex">
                        <td class="col-md-2">${nota.alumno.dni}</td>
                        <td class="col-md-2">${nota.alumno.nombres}</td>
                        <td class="col-md-2">${nota.alumno.apellidos}</td>
                        <td class="col-md-2">
                            <core:if test="${nota.nota1 == null}">
                                <div class="badge badge-secondary text-wrap" style="width: 6rem;">
                                    No registrado
                                </div>
                            </core:if>
                            <core:if test="${nota.nota1 != null}">
                                ${nota.nota1}
                            </core:if>
                        </td>
                        <td class="col-md-2">
                            <core:if test="${nota.nota2 == null}">
                                <div class="badge badge-secondary text-wrap" style="width: 6rem;">
                                    No registrado
                                </div>
                            </core:if>
                            <core:if test="${nota.nota2 != null}">
                                ${nota.nota2}
                            </core:if>
                        </td>
                        <td class="col-md-2">
                            <core:if test="${nota.nota3 == null}">
                                <div class="badge badge-secondary text-wrap" style="width: 6rem;">
                                    No registrado
                                </div>
                            </core:if>
                            <core:if test="${nota.nota3 != null}">
                                ${nota.nota3}
                            </core:if>
                        </td>
                    </tr>
                </core:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>