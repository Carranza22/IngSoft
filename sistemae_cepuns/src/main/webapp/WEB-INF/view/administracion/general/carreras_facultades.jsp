<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 5/09/2020
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row container-config">
    <div class="col-md-4">
        <fieldset>
            <legend id="legend_facultad">Registrar Facultad</legend>
            <Spring:form id="form__facultad" modelAttribute="facultad">
                <div class="form-group">
                    <Spring:hidden path="id" class="form-control" placeholder="(reservado)"/>
                    <Spring:errors path="id" cssClass="alert-info"/>
                </div>
                <div class="form-group">
                    <Spring:label path="nombre_facultad">Facultad</Spring:label>
                    <Spring:input path="nombre_facultad" class="form-control"
                                  cssErrorClass="form-control alert-danger"
                                  placeholder="Facultad"
                                  data-toggle="tooltip" data-placement="bottom"
                                  title="Ingrese la Facultad"/>
                    <Spring:errors path="nombre_facultad" class="text-danger"/>
                </div>
                <div id="btns_registrar_facultad" class="form-group text-center">
                    <Spring:button type="submit" onclick="registrar_facultad()"
                                   class="btn btn-primary">Guardar</Spring:button>
                    <a onclick="limpiar_form('form__facultad')"
                       class="btn btn-secondary">Limpiar</a>
                </div>
                <div id="btns_editar_facultad" class="form-group text-center" style="display: none;">
                    <Spring:button type="submit" onclick="update_facultad()"
                                   class="btn btn-success">Guardar</Spring:button>
                    <a onclick="cancelar_form('facultades_carreras')"
                       class="btn btn-secondary">Cancelar</a>
                </div>
            </Spring:form>
        </fieldset>
        <fieldset>
            <legend id="legend_carrera">Registrar Carrera Profesional</legend>
            <Spring:form id="form__carrera" modelAttribute="carrera">
                <div class="form-group">
                    <Spring:hidden path="id_carrera" class="form-control" placeholder="(reservado)"/>
                    <Spring:errors path="id_carrera" cssClass="alert-info"/>
                </div>
                <div class="form-group">
                    <Spring:label
                            path="nombre_carrera">Carrera Profesional</Spring:label>
                    <Spring:input path="nombre_carrera" class="form-control"
                                  cssErrorClass="form-control alert-danger"
                                  placeholder="Carrera Profesional"
                                  data-toggle="tooltip" data-placement="bottom"
                                  title="Ingrese la Carrera Profesional"/>
                    <Spring:errors path="nombre_carrera" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label for="facultad">Facultad</label>
                    <select id="facultad" class="form-control" name="facultad">
                        <option hidden selected></option>
                        <core:forEach var="facultad" items="${facultades}">
                            <option
                                    value="${facultad.id}">${facultad.nombre_facultad}</option>
                        </core:forEach>
                    </select>
                </div>

                <div id="btns_registrar_carrera" class="form-group text-center">
                    <Spring:button type="submit" onclick="registrar_carrera()"
                                   class="btn btn-primary">Guardar</Spring:button>
                    <a onclick="limpiar_form('form__carrera')"
                       class="btn btn-secondary">Limpiar</a>
                </div>
                <div id="btns_editar_carrera" class="form-group text-center" style="display: none;">
                    <Spring:button type="submit" onclick="update_carrera()"
                                   class="btn btn-success">Guardar</Spring:button>
                    <a onclick="cancelar_form('facultades_carreras')"
                       class="btn btn-secondary">Cancelar</a>
                </div>
            </Spring:form>
        </fieldset>
    </div>
    <div class="col-md-8">
        <br>
        <ul class="nav nav-tabs" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" data-target="#lista_facultad" data-toggle="tab"
                   role="tab"
                   aria-selected="true" href="#lista_facultad">Facultades</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-target="#lista_carrera" data-toggle="tab" role="tab"
                   aria-selected="false"
                   href="#lista_carrera">Carreras</a>
            </li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" role="tabpanel" id="lista_facultad">
                <div class=" col-md-12">
                    <br>
                    <div id="tabla_lista_facultades" class="table-responsive-md">
                    </div>
                </div>
            </div>
            <div class="tab-pane" role="tabpanel" id="lista_carrera">
                <div class=" col-md-12">
                    <br>
                    <div id="tabla_lista_carreras" class="table-responsive-md">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>