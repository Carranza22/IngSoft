<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 9/09/2020
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="container">
    <div class="div-panel barra-regresar">
        <div class="row">
            <div class="col-md-2">
                <button onclick="div_container_admin('alumno')" type="button" class="btn btn-secondary btn-regresar"><i
                        class="fa fa-arrow-left"
                        aria-hidden="true"></i>Regresar
                </button>
            </div>
            <div class="col-md-8 titulo-barra">
                <h2 class="text-dark text-center text-uppercase">Registrar Alumno(a)</h2>
            </div>
        </div>
    </div>
    <div class="div-panel">
        <div class="offset-md-1 col-md-10">
            <Spring:form id="form__alumno" modelAttribute="alumno">
                <div class="row">
                    <div class="col-md-3 form-group">
                        <Spring:label path="dni">DNI</Spring:label>
                        <Spring:input path="dni" class="form-control"
                                      cssErrorClass="form-control alert-danger"
                                      placeholder="DNI"
                                      data-toggle="tooltip" data-placement="bottom"
                                      maxlength="8"
                                      oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                                      title="DNI del Alumno"/>
                        <Spring:errors path="dni" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-9"></div>
                    <div class="col-md-6 form-group">
                        <Spring:label path="nombres">Nombres</Spring:label>
                        <Spring:input path="nombres" class="form-control"
                                      cssErrorClass="form-control alert-danger" placeholder="Nombres completos"
                                      data-toggle="tooltip" data-placement="bottom"
                                      title="Ingrese nombres completos"
                        />
                        <Spring:errors path="nombres" class="text-danger"/>
                    </div>
                    <div class="col-md-6 form-group">
                        <Spring:label path="apellidos">Apellidos</Spring:label>
                        <Spring:input path="apellidos" class="form-control"
                                      cssErrorClass="form-control alert-danger" placeholder="Apellido completos"
                                      data-toggle="tooltip" data-placement="bottom"
                                      title="Ingrese apellido paterno y materno"/>
                        <Spring:errors path="apellidos" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-3 form-group">
                        <Spring:label path="sexo">Sexo</Spring:label>
                        <Spring:select class="form-control" path="sexo" required="required"
                                       title="Seleccione el sexo">
                            <option hidden selected></option>
                            <Spring:option value="M">Masculino</Spring:option>
                            <Spring:option value="F">Femenino</Spring:option>
                        </Spring:select>
                        <Spring:errors path="sexo" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-3 form-group">
                        <Spring:label path="fecha_nacimiento">Fecha de Nacimiento</Spring:label>
                        <Spring:input type="date" path="fecha_nacimiento" class="form-control"
                                      cssErrorClass="form-control alert-danger"
                                      placeholder="Fecha de nacimiento"
                                      data-toggle="tooltip" data-placement="bottom"
                                      title="Fecha de nacimiento"/>
                        <Spring:errors path="fecha_nacimiento" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-6 form-group">
                        <Spring:label path="celular">Celular</Spring:label>
                        <Spring:input path="celular" class="form-control"
                                      cssErrorClass="form-control alert-danger" placeholder="Celular"
                                      data-toggle="tooltip" data-placement="bottom" title="Ingrese celular"
                        />
                        <Spring:errors path="celular" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-6 form-group">
                        <Spring:label path="email">Correo Electrónico</Spring:label>
                        <Spring:input type="email" path="email" class="form-control"
                                      cssErrorClass="form-control alert-danger" placeholder="Correo electronico"
                                      data-toggle="tooltip" data-placement="bottom"
                                      title="Ingrese correo electronico"
                        />
                        <Spring:errors path="email" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-6 form-group">
                        <Spring:label path="direccion">Direccion</Spring:label>
                        <Spring:input path="direccion" class="form-control"
                                      cssErrorClass="form-control alert-danger" placeholder="Dirección"
                                      data-toggle="tooltip" data-placement="bottom" title="Ingrese direccion"
                        />
                        <Spring:errors path="direccion" cssClass="text-danger"/>
                    </div>
                    <div id="btns_registrar_administrador" class="col-md-6 form-group">
                        <Spring:button type="submit" onclick="registrar_alumno()"
                                       title="Seleccione una Carrera Profesional"
                                       class="btn btn-primary">Guardar</Spring:button>
                        <a
                                class="btn btn-secondary" onclick="limpiar_form('form__alumno')">Limpiar</a>
                    </div>
                </div>
            </Spring:form>
        </div>
    </div>
</div>
