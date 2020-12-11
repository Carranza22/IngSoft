<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 15/09/2020
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="titulo-panel sticky-top">
    <h2 class="text-center text-uppercase">${titulo_container}</h2>
</div>
<div id="inicio_notas" class="container">
    <div class="row">
        <div class="col-md-4 div-panel">
            <fieldset>
                <legend>Registros</legend>
                <div class="seccion_rg">
                    <h5 class="text-dark text-left titulo-subpanel">Ciclo de Estudio</h5>
                    <div class="form-group">
                        <select id="list_ciclo_estudio" class="form-control" name="ciclo_estudio">
                            <option hidden selected></option>
                            <core:forEach var="ciclo" items="${lista_ciclos}">
                                <option
                                        value="${ciclo.id}">${ciclo.anio}-${ciclo.n_ciclo}</option>
                            </core:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-outline-dark btn-sm btn-block" onclick="listar_notas_ciclo()">Mostrar
                            Registro</a>
                    </div>
                </div>
            </fieldset>
        </div>
        <div class="col-md-7 div-panel" style="margin-left: 20px;">
            <input type="hidden" id="ciclo_estudio" value="${id_ciclo}"/>
            <fieldset>
                <legend>Registrar Notas | Alumnos</legend>
                <div class="row">
                    <div class="col-md-6 form-group">
                        <label for="facultades">Tipo Nota</label>
                        <div class="form-group">
                            <select id="tipo_nota" class="form-control" name="ciclo_estudio">
                                <option hidden selected></option>
                                <option value="sumativo1">Sumativo 1</option>
                                <option value="sumativo2">Sumativo 2</option>
                                <option value="sumativo3">Sumativo 3</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6 form-group">
                        <label for="facultades">Facultad</label>
                        <div class="form-group">
                            <select id="facultades" class="form-control" name="ciclo_estudio">
                                <option hidden selected></option>
                                <core:forEach var="facultad" items="${facultades}">
                                    <option
                                            value="${facultad.id}">${facultad.nombre_facultad}</option>
                                </core:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6 form-group">
                        <a class="btn btn-outline-dark btn-sm btn-block" onclick="div_notas_alumnos()">Registrar
                            Notas</a>
                    </div>
                </div>
            </fieldset>
        </div>

    </div>
</div>