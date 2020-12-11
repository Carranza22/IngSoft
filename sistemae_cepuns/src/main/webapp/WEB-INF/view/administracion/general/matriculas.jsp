<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 5/09/2020
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row container-config">
    <div id="col_registro_ciclo" class="col-md-3">
        <fieldset <c:out value="${(inscripciones == true)? 'disabled':''}"/>>
            <legend>Registrar Ciclo de Estudio</legend>
            <Spring:form id="form__ciclo" modelAttribute="ciclo">
                <div class="row">
                    <div class="form-group">
                        <Spring:hidden path="id" class="form-control" placeholder="(reservado)"/>
                        <Spring:errors path="id" cssClass="alert-info"/>
                    </div>
                    <div class="col-md-7 form-group">
                        <Spring:label path="anio">Año</Spring:label>
                        <Spring:input type="number" path="anio" class="form-control"
                                      cssErrorClass="form-control alert-danger"
                                      placeholder="Año"
                                      data-toggle="tooltip" data-placement="bottom"
                                      title="Ingrese el Año"/>
                        <Spring:errors path="anio" class="text-danger"/>
                    </div>
                    <div class="col-md-5 form-group">
                        <Spring:label path="n_ciclo">Ciclo</Spring:label>
                        <Spring:select class="form-control" path="n_ciclo" required="required">
                            <option hidden selected></option>
                            <Spring:option value="1">I</Spring:option>
                            <Spring:option value="2">II</Spring:option>
                            <Spring:option value="3">III</Spring:option>
                        </Spring:select>
                        <Spring:errors path="n_ciclo" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-12 form-group">
                        <Spring:label path="estado_matricula">Incripciones</Spring:label>
                        <Spring:select class="form-control" path="estado_matricula" required="required">
                            <Spring:option value="1">Habilitado</Spring:option>
                            <Spring:option value="0">Deshabilitado</Spring:option>
                        </Spring:select>
                        <Spring:errors path="estado_matricula" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-12 form-group">
                        <Spring:label path="fecha_inicio">Inicio de Ciclo</Spring:label>
                        <Spring:input type="date" path="fecha_inicio" class="form-control"
                                      cssErrorClass="form-control alert-danger"
                                      placeholder="Inicio de ciclo"
                                      data-toggle="tooltip" data-placement="bottom"
                                      title="Ingrese fecha de inicio de Ciclo"/>
                        <Spring:errors path="fecha_inicio" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-12 form-group">
                        <Spring:label path="fecha_fin">Fin de Ciclo</Spring:label>
                        <Spring:input type="date" path="fecha_fin" class="form-control"
                                      cssErrorClass="form-control alert-danger"
                                      placeholder="Fin de Ciclo"
                                      data-toggle="tooltip" data-placement="bottom"
                                      title="Ingrese fecha fin de Ciclo"/>
                        <Spring:errors path="fecha_fin" cssClass="text-danger"/>
                    </div>
                    <div id="btns_registrar_ciclo" class="col-md-12 form-group text-center">
                        <Spring:button type="submit" onclick="registrar_ciclo()"
                                       class="btn btn-primary">Guardar</Spring:button>
                        <a onclick="limpiar_form('form__ciclo')"
                           class="btn btn-secondary">Limpiar</a>
                    </div>
                    <div id="btns_editar_ciclo" class="col-md-12 form-group text-center" style="display: none;">
                        <Spring:button type="submit" onclick="update_ciclo()"
                                       class="btn btn-success">Guardar</Spring:button>
                        <a onclick="cancelar_form('matriculas')"
                           class="btn btn-secondary">Cancelar</a>
                    </div>
                </div>
            </Spring:form>
        </fieldset>
    </div>
    <div class="col-md-9">
        <br>
        <div id="tabla_lista_ciclos" class="table-responsive-md">
        </div>
    </div>
</div>