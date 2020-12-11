<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 7/09/2020
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="titulo-panel sticky-top">
    <h2 class="text-center text-uppercase">${titulo_container}</h2>
</div>
<div id="inicio_matricula" class="container div-panel">
    <div class="row">
        <div class="col-md-3">
            <fieldset>
                <legend>Matricula</legend>
                <div class="form-group">
                    <a class="btn btn-outline-dark btn-sm btn-block" onclick="div_registrar('matricula')">Registrar
                        ahora</a>
                </div>
            </fieldset>
            <fieldset>
                <legend>Registros</legend>
                <div class="seccion_rg">
                    <h5 class="text-dark text-left" style="padding-bottom:15px;">Generales</h5>
                    <div class="form-group">
                        <a class="btn btn-outline-dark btn-sm btn-block"
                           onclick="listar_matricula_general()">Listar</a>
                    </div>
                </div>
                <div class="seccion_rg">
                    <h5 class="text-dark text-left titulo-subpanel">Ciclo de Estudio</h5>
                    <div class="form-group">
                        <select id="ciclo_estudio" class="form-control" name="ciclo_estudio">
                            <option hidden selected></option>
                            <core:forEach var="ciclo" items="${lista_ciclos}">
                                <option
                                        value="${ciclo.id}">${ciclo.anio}-${ciclo.n_ciclo}</option>
                            </core:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-outline-dark btn-sm btn-block" onclick="listar_matricula_ciclo()">Mostrar
                            Registro</a>
                    </div>
                </div>
                <div class="seccion_rg">
                    <h5 class="text-dark text-left titulo-subpanel">Alumno</h5>
                    <div class="form-group">
                        <input id="dni_matricula" minlength="8" maxlength="8" oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" class="form-control" type="text" placeholder="DNI"/>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-outline-dark btn-sm btn-block" onclick="listar_matricula_alumno()">Buscar</a>
                    </div>
                </div>
            </fieldset>
        </div>
        <div id="tabla_matricula_registro" class="col-md-9">

        </div>
    </div>
</div>

<div id="registro_matricula" class="container div-panel" style="display:none;">
</div>