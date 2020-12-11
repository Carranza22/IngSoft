<%@ taglib prefix="Spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: CyanCJ
  Date: 5/09/2020
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<div class="row container-config">
    <div class="col-md-4">
        <fieldset>
            <legend id="legend_administrador">Registrar Administrador</legend>
            <Spring:form id="form__administrador" modelAttribute="administrador">
                <div class="form-group">
                    <Spring:hidden path="id" class="form-control" placeholder="(reservado)"/>
                    <Spring:errors path="id" cssClass="alert-info"/>
                </div>
                <div class="form-group">
                    <Spring:label path="nombres">Nombres</Spring:label>
                    <Spring:input path="nombres" class="form-control"
                                  cssErrorClass="form-control alert-danger"
                                  placeholder="Nombres"
                                  data-toggle="tooltip" data-placement="bottom"
                                  title="Ingrese los Nombres"/>
                    <Spring:errors path="nombres" class="text-danger"/>
                </div>
                <div class="form-group">
                    <Spring:label path="apellidos">Apellidos</Spring:label>
                    <Spring:input path="apellidos" class="form-control"
                                  cssErrorClass="form-control alert-danger"
                                  placeholder="Apellidos"
                                  data-toggle="tooltip" data-placement="bottom"
                                  title="Ingrese los Apellidos"/>
                    <Spring:errors path="apellidos" class="text-danger"/>
                </div>
                <div class="form-group">
                    <Spring:label type="text" path="usuario">Usuario</Spring:label>
                    <Spring:input path="usuario" class="form-control"
                                  cssErrorClass="form-control alert-danger"
                                  placeholder="Usuario"
                                  data-toggle="tooltip" data-placement="bottom"
                                  title="Ingrese el Usuario"/>
                    <Spring:errors path="usuario" class="text-danger"/>
                </div>
                <div id="input_clave_admin" class="form-group">
                    <Spring:label path="clave">Contraseña</Spring:label>
                    <Spring:input path="clave" class="form-control"
                                  cssErrorClass="form-control alert-danger"
                                  placeholder="Contraseña"
                                  data-toggle="tooltip" data-placement="bottom"
                                  title="Ingrese la Contraseña"/>
                    <Spring:errors path="clave" class="text-danger"/>
                </div>
                <div class="form-group">
                    <Spring:label path="rol">Rol</Spring:label>
                    <Spring:select class="form-control" path="rol" itemValue="${administrador.rol}">
                        <option hidden selected></option>
                        <Spring:option value="ADMINISTRADOR">Administrador</Spring:option>
                        <Spring:option value="ASISTENCIA">Asistencia</Spring:option>
                        <Spring:option value="MATRICULA">Matricula</Spring:option>
                        <Spring:option value="NOTAS">Notas</Spring:option>
                    </Spring:select>
                    <Spring:errors path="rol" cssClass="text-danger"/>
                </div>
                <div id="btns_registrar_administrador" class="form-group text-center">
                    <Spring:button type="submit" onclick="registrar_administrador()"
                                   class="btn btn-primary">Guardar</Spring:button>
                    <a onclick="limpiar_form('form__administrador')"
                       class="btn btn-secondary">Limpiar</a>
                </div>
                <div id="btns_editar_administrador" class="col-md-12 form-group text-center" style="display: none;">
                    <Spring:button type="submit" onclick="update_administrador()"
                                   class="btn btn-success">Guardar</Spring:button>
                    <a onclick="cancelar_form('administradores')"
                       class="btn btn-secondary">Cancelar</a>
                </div>
            </Spring:form>
        </fieldset>
    </div>
    <div class="col-md-8">
        <br>
        <div id="tabla_lista_administradores" class="table-responsive-md">
        </div>
    </div>
</div>