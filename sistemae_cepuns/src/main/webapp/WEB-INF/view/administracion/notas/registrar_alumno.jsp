<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 16/09/2020
  Time: 05:48
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
                <h2 class="text-dark text-center text-uppercase">Registrar Notas | Alumnos</h2>
            </div>
        </div>
    </div>
    <div class="div-panel">
        <div class="offset-md-1 col-md-10">
            <core:if test="${lista_activa == false}">
                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                    <strong>Existe un registro!</strong> de notas con lo seleccionado.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </core:if>
            <core:if test="${lista_activa == true}">
                <div class="table-responsive">
                    <Spring:form id="form__nota_alumno" modelAttribute="list_alumnos">
                        <table class="table table-striped table-bordered">
                            <thead class="thead-dark">
                            <tr class="d-flex" style="width: 97.6%;">
                                <th class="col-md-1">#</th>
                                <th class="col-md-2">DNI</th>
                                <th class="col-md-3">Nombres</th>
                                <th class="col-md-4">Apellidos</th>
                                <th class="col-md-2"> Puntaje</th>
                            </tr>
                            </thead>
                            <tbody>
                            <core:forEach items="${list_alumnos.notaList}" var="nota" varStatus="i">
                                <tr class="d-flex">
                                    <td class="col-md-1">${i.count}</td>
                                    <td class="col-md-2">${nota.matricula.alumno.dni}</td>
                                    <td class="col-md-3">${nota.matricula.alumno.nombres}</td>
                                    <td class="col-md-4">${nota.matricula.alumno.apellidos}</td>
                                    <td hidden><Spring:input path="notaList[${i.index}].matricula.id"
                                                             value="${nota.matricula.id}"/></td>
                                    <td hidden><Spring:input path="notaList[${i.index}].tipo"
                                                             value="${nota.tipo}"/></td>
                                    <td class="col-md-2"><Spring:input cssClass="form-control form-control-sm col-md"
                                                                       type="number"
                                                                       path="notaList[${i.index}].nota"
                                                                       value="${nota.nota}"/></td>
                                </tr>
                            </core:forEach>
                            </tbody>
                        </table>
                        <div id="btns_registrar_administrador" class="col-md-6 form-group">
                            <Spring:button type="submit" onclick="registrar_nota_alumno()"
                                           class="btn btn-primary">Guardar</Spring:button>
                            <a
                                    class="btn btn-secondary" onclick="limpiar_form('form__nota_alumno')">Limpiar</a>
                        </div>
                    </Spring:form>
                </div>
            </core:if>
        </div>
    </div>
</div>