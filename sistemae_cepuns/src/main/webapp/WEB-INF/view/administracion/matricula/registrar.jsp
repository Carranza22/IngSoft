<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 8/09/2020
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:if test="${matriculas_habilitadas == false}">
    <button onclick="div_container_admin('matricula')" type="button" class="btn btn-secondary btn-regresar"><i
            class="fa fa-arrow-left"
            aria-hidden="true"></i>Regresar
    </button>
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong>No existe </strong> ninguna inscripción de matrícula habilitada.
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>

</c:if>
<c:if test="${matriculas_habilitadas == true}">
    <div class="row">
        <div class="col-md-2">
            <button onclick="div_container_admin('matricula')" type="button" class="btn btn-secondary btn-regresar"><i
                    class="fa fa-arrow-left"
                    aria-hidden="true"></i>Regresar
            </button>

        </div>
        <div class="col-md-8 titulo-barra">
            <h2 class="text-dark text-center text-uppercase">Registrar Matricula</h2>
        </div>
    </div>

    <div class="offset-md-1 col-md-10">
        <Spring:form id="form__matricula" modelAttribute="matricula">
            <div class="row">
                <div class="col-md-3 form-group">
                    <Spring:label path="alumno.dni">DNI</Spring:label>
                    <Spring:input path="alumno.dni" class="form-control"
                                  cssErrorClass="form-control alert-danger"
                                  placeholder="DNI del Alumno"
                                  data-toggle="tooltip" data-placement="bottom"
                                  maxlength="8"
                                  oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                                  title="DNI del Alumno"/>
                    <Spring:errors path="alumno.dni" cssClass="text-danger"/>
                </div>
                <div class="col-md-9 form-group" style="margin-top: 32px">
                    <a class="btn btn-outline-secondary" onclick="buscar_alumno()">Buscar</a>
                </div>
                <div class="col-md-6 form-group">
                    <Spring:label path="alumno.nombres">Nombres</Spring:label>
                    <Spring:input path="alumno.nombres" class="form-control"
                                  cssErrorClass="form-control alert-danger" placeholder="Nombres completos"
                                  data-toggle="tooltip" data-placement="bottom" title="Ingrese nombres completos"
                                  disabled="true"/>
                    <Spring:errors path="alumno.nombres" class="text-danger"/>
                </div>
                <div class="col-md-6 form-group">
                    <Spring:label path="alumno.apellidos">Apellidos</Spring:label>
                    <Spring:input path="alumno.apellidos" class="form-control"
                                  cssErrorClass="form-control alert-danger" placeholder="Apellido completos"
                                  data-toggle="tooltip" data-placement="bottom"
                                  title="Ingrese apellido paterno y materno" disabled="true"/>
                    <Spring:errors path="alumno.apellidos" cssClass="text-danger"/>
                </div>
                <div class="col-md-3 form-group">
                    <Spring:label path="alumno.sexo">Sexo</Spring:label>
                    <Spring:select class="form-control" path="alumno.sexo" required="required"
                                   title="Seleccione el sexo" disabled="true">
                        <option hidden selected></option>
                        <Spring:option value="M">Masculino</Spring:option>
                        <Spring:option value="F">Femenino</Spring:option>
                    </Spring:select>
                    <Spring:errors path="alumno.sexo" cssClass="text-danger"/>
                </div>
                <div class="col-md-3 form-group">
                    <Spring:label path="alumno.fecha_nacimiento">Fecha de Nacimiento</Spring:label>
                    <Spring:input type="date" path="alumno.fecha_nacimiento" class="form-control"
                                  cssErrorClass="form-control alert-danger"
                                  placeholder="Fecha de nacimiento"
                                  data-toggle="tooltip" data-placement="bottom"
                                  title="Fecha de nacimiento" disabled="true"/>
                    <Spring:errors path="alumno.fecha_nacimiento" cssClass="text-danger"/>
                </div>
                <div class="col-md-6 form-group">
                    <Spring:label path="alumno.celular">Celular</Spring:label>
                    <Spring:input path="alumno.celular" class="form-control"
                                  cssErrorClass="form-control alert-danger" placeholder="Celular"
                                  data-toggle="tooltip" data-placement="bottom" title="Ingrese celular"
                                  disabled="true"/>
                    <Spring:errors path="alumno.celular" cssClass="text-danger"/>
                </div>
                <div class="col-md-6 form-group">
                    <Spring:label path="alumno.email">Correo Electrónico</Spring:label>
                    <Spring:input type="email" path="alumno.email" class="form-control"
                                  cssErrorClass="form-control alert-danger" placeholder="Correo electronico"
                                  data-toggle="tooltip" data-placement="bottom" title="Ingrese correo electronico"
                                  disabled="true"/>
                    <Spring:errors path="alumno.email" cssClass="text-danger"/>
                </div>
                <div class="col-md-6 form-group">
                    <Spring:label path="alumno.direccion">Direccion</Spring:label>
                    <Spring:input path="alumno.direccion" class="form-control"
                                  cssErrorClass="form-control alert-danger" placeholder="Dirección"
                                  data-toggle="tooltip" data-placement="bottom" title="Ingrese direccion"
                                  disabled="true"/>
                    <Spring:errors path="alumno.direccion" cssClass="text-danger"/>
                </div>
                <div class="col-md-3 form-group">
                    <Spring:label path="codigo_voucher">Código Voucher</Spring:label>
                    <Spring:input type="number" path="codigo_voucher" class="form-control"
                                  cssErrorClass="form-control alert-danger" placeholder="Código voucher"
                                  data-toggle="tooltip" data-placement="bottom"
                                  maxlength="7"
                                  oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                                  title="Ingrese el código del voucher"
                                  disabled="true"/>
                    <Spring:errors path="codigo_voucher" cssClass="text-danger"/>
                </div>
                <div class="col-md-3 form-group">
                    <Spring:label path="ciclo.id">Ciclo de Matricula</Spring:label>
                    <Spring:hidden path="ciclo.id" value="${ciclo_insc.id}"/>
                    <input class="form-control" value="${ciclo_insc.anio}-${ciclo_insc.n_ciclo}"
                           data-toggle="tooltip" data-placement="bottom"
                           disabled="true"/>
                </div>
                <div class="col-md-2 form-group">
                    <label for="lista_facultad">Facultad</label>
                    <select id="lista_facultad" class="form-control" onchange="listar_carreras(this.value)"
                            disabled>
                        <option hidden selected></option>
                        <core:forEach var="facultad" items="${facultades}">
                            <option
                                    value="${facultad.id}">${facultad.nombre_facultad}</option>
                        </core:forEach>
                    </select>
                </div>
                <div class="col-md-4 form-group">
                    <Spring:label path="carrera.id_carrera">Carrera Profesional</Spring:label>
                    <select id="lista_carreras" name="carrera.id_carrera" class="form-control" disabled>
                        <option hidden selected></option>
                    </select>
                </div>
                <div id="btns_registrar_administrador" class="col-md-6 form-group">
                    <Spring:button type="submit" onclick="registrar_matricula()"
                                   title="Seleccione una Carrera Profesional"
                                   class="btn btn-primary">Guardar</Spring:button>
                    <a
                            class="btn btn-secondary" onclick="limpiar_form('form__matricula')">Limpiar</a>
                </div>
            </div>
        </Spring:form>
    </div>
    </div>
</c:if>
