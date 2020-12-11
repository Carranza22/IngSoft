/** Abrir y cerrar Menu **/
function abrir_menu() {
    $('#sidebar-wrapper').toggleClass('openclose');
    $('#sidebar-posicion').toggleClass('openclose');
}

function cerrar_menu() {
    $('#sidebar-wrapper').removeClass('openclose');
    $('#sidebar-posicion').toggleClass('openclose');
}

$(document).ready(function () {
    abrir_menu();
    $('a.sidebar-btn').on('click', function (e) {
        e.preventDefault();
        abrir_menu();
    });
    $('#sidebar-posicion').on('click', function (e) {
        e.preventDefault();
        cerrar_menu();
    });
});

function request_html(id, url) {
    $(id).empty();
    $.get(url,
        function (Resultado) {
            $(id).html(Resultado);
        }
    );
}

/** Sección General **/
function section_general(Entidad) {
    let datos = {
        administradores: {
            id: '#section_administradores',
            url: './general/administradores'
        },
        facultades_carreras: {
            id: '#section_carreras_facultades',
            url: './general/carreras_facultades'
        },
        matriculas: {
            id: '#section_matriculas',
            url: './general/matriculas'
        }
    }
    let id_section = datos[Entidad]['id'];
    let url_section = datos[Entidad]['url'];
    $(id_section).empty();
    $.get(url_section,
        function (Resultado) {
            $(id_section).html(Resultado);
            if (Entidad === 'facultades_carreras') {
                lista_tablas_general('facultades');
                lista_tablas_general('carreras');
            } else {
                lista_tablas_general(Entidad);
            }
        }
    );
}


/** Lista de Tablas **/
function lista_tablas_general(Entidad) {
    let datos = {
        administradores: {
            id: '#tabla_lista_administradores',
            url: './lista/usuarios'
        },
        facultades: {
            id: '#tabla_lista_facultades',
            url: './lista/facultades'
        },
        carreras: {
            id: '#tabla_lista_carreras',
            url: './lista/carreras'
        },
        matriculas: {
            id: '#tabla_lista_ciclos',
            url: './lista/ciclos'
        }
    }
    let id_tabla = datos[Entidad]['id'];
    let url_tabla = datos[Entidad]['url'];
    request_html(id_tabla, url_tabla);
}

/** Fin lista de Tablas **/
/** Fin Sección General **/

function div_container_admin(entidad) {
    $('#divPanel').css("display", "");
    cerrar_menu();
    div_admin_index(entidad);
}

function div_admin_index(entidad) {
    $('#divPanel').show();
    $.get("./" + entidad,
        function (Resultado) {
            $('#divPanel').html(Resultado);
            if (entidad === 'general') {
                section_general('administradores');
            }
        }
    );
}


function registrar_administrador() {
    $("form[id='form__administrador']").validate({
        rules: {
            nombres: "required",
            apellidos: "required",
            usuario: "required",
            clave: "required",
            rol: "required"
        },
        messages: {
            nombres: "Ingrese los nombres",
            apellidos: "Ingrese los apellidos",
            usuario: "Ingrese el usuario",
            clave: "Ingrese la contraseña",
            rol: "Seleccione un rol"
        },
        submitHandler: function () {
            const form = $("form[id='form__administrador']");
            console.log(form.serialize())
            $.ajax({
                type: 'POST',
                url: "../usuario/admin/registrar",
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        div_container_admin('general');
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function registrar_facultad() {
    $("form[id='form__facultad']").validate({
        rules: {
            nombre_facultad: "required",
        },
        messages: {
            nombre_facultad: "Ingrese la facultad",
        },
        submitHandler: function () {
            const form = $("form[id='form__facultad']");
            $.ajax({
                type: 'POST',
                url: "../facultad/registrar",
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        section_general('facultades_carreras');
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function registrar_carrera() {
    $("form[id='form__carrera']").validate({
        rules: {
            nombre_carrera: "required",
            facultad_id: "required"
        },
        messages: {
            nombre_facultad: "Ingrese la facultad",
            facultad_id: "Seleccione la facultad"
        },
        submitHandler: function () {
            const form = $("form[id='form__carrera']");
            $.ajax({
                type: 'POST',
                url: "../carrera/registrar",
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        lista_tablas_general('carreras');
                        lista_tablas_general('facultades');
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function registrar_ciclo() {
    $("form[id='form__ciclo']").validate({
        rules: {
            anio: "required",
            n_ciclo: "required",
            fecha_inicio: "required",
            fecha_fin: "required"
        },
        messages: {
            anio: "Ingrese el año del ciclo",
            n_ciclo: "Seleccione un ciclo",
            fecha_inicio: "Ingrese la fecha de inicio",
            fecha_fin: "Ingrese la fecha de fin"
        },
        submitHandler: function () {
            const form = $("form[id='form__ciclo']");
            console.log(form.serialize());
            $.ajax({
                type: 'POST',
                url: "../ciclo/registrar",
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        section_general('matriculas');
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function registrar_matricula() {
    $("form[id='form__matricula']").validate({
        rules: {
            'alumno.dni': "required",
            'alumno.nombres': "required",
            'alumno.apellidos': "required",
            'alumno.sexo': "required",
            'alumno.fecha_nacimiento': "required",
            'alumno.celular': "required",
            'alumno.email': "required",
            'alumno.direccion': "required",
            'codigo_voucher': "required",
            'ciclo.id': "required",
            'carrera.id_carrera': "required"
        },
        submitHandler: function () {
            const form = $("form[id='form__matricula']");
            $.ajax({
                type: 'POST',
                url: "../matricula/registrar",
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        section_general('matriculas');
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function registrar_alumno() {
    $("form[id='form__alumno']").validate({
        rules: {
            dni: "required",
            nombres: "required",
            apellidos: "required",
            sexo: "required",
            fecha_nacimiento: "required",
            celular: "required",
            email: {
                required: true,
                email: true
            },
            direccion: "required"
        },
        messages: {
            dni: "Ingrese el DNI",
            nombres: "Ingrese los nombres del alumno",
            apellidos: "Ingrese los apellidos del alumno",
            sexo: "Seleccione el sexo del alumno",
            celular: "Ingrese el celular del alumno",
            fecha_nacimiento: "Ingrese la fecha de nacimiento del alumno",
            email: "Ingrese un email válido",
            direccion: "Ingrese la direccion del alumno"
        },
        submitHandler: function () {
            const form = $("form[id='form__alumno']");
            $.ajax({
                type: 'POST',
                url: "../alumno/registrar",
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        div_container_admin('alumno')
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function registrar_docente() {
    $("form[id='form__docente']").validate({
        rules: {
            dni: "required",
            nombres: "required",
            apellidos: "required",
            celular: "required",
            email: {
                required: true,
                email: true
            },
            direccion: "required",
            especialidad: "required"
        },
        messages: {
            dni: "Ingrese el dni del docente",
            nombres: "Ingrese los nombres del docente",
            apellidos: "Ingrese los apellidos del docente",
            celular: "Ingrese el celular del docente",
            email: "Ingrese un email válido",
            direccion: "Ingrese la direccion del docente",
            especialidad: "Ingrese la especialidad del docente"
        },
        submitHandler: function () {
            const form = $("form[id='form__docente']");
            $.ajax({
                type: 'POST',
                url: "../docente/registrar",
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        div_container_admin('docente')
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function formatDate(date) {
    let d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;
    return [year, month, day].join('-');
}

function eliminar_entidad(entidad, id) {
    let token = $('#_csrf').attr('content');
    let header = $('#_csrf_header').attr('content');
    let url_path;
    if (entidad === 'administrador') {
        url_path = "../usuario/admin/eliminar";
    } else {
        url_path = "../" + entidad + "/eliminar";
    }
    alertify.confirm('Confirmar', 'Desea eliminar el registro?', function () {
            $.ajax({
                type: 'POST',
                url: url_path,
                data: {
                    id: id
                },
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(header, token);
                },
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        switch (entidad) {
                            case 'facultad':
                                section_general('facultades_carreras');
                                break;
                            case 'carrera':
                                section_general('facultades_carreras');
                                break;
                            case 'ciclo':
                                section_general('matriculas');
                                break;
                            case 'administrador':
                                section_general('administradores');
                                break;
                            default:
                                section_general(entidad);
                                break;
                        }
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
        , function () {
            alertify.notify('Se canceló');
        });

}

function editar_entidad(entidad, id) {
    let url_path;
    if (entidad === 'administrador') {
        url_path = "../usuario/admin/registro/" + id;
    } else {
        url_path = "../" + entidad + "/registro/" + id;
    }
    $.ajax({
        type: 'GET',
        url: url_path,
        success: function (data) {
            let form;
            switch (entidad) {
                case 'ciclo':
                    form = $('#form__ciclo');
                    $('fieldset').removeAttr('disabled');
                    $('legend').text("Editar Ciclo de Estudio");
                    form.find("input[name='id']").val(data["id"]);
                    form.find("input[name='anio']").val(data["anio"]);
                    form.find("select[name='n_ciclo']").val(data["n_ciclo"]);
                    form.find("select[name='estado_matricula']").val(data["estado_matricula"]);
                    form.find("input[name='fecha_inicio']").val(formatDate(data["fecha_inicio"]));
                    form.find("input[name='fecha_fin']").val(formatDate(data["fecha_fin"]));
                    $('#btns_registrar_ciclo').css('display', 'none');
                    $('#btns_editar_ciclo').css('display', '');
                    break;
                case 'facultad':
                    form = $('#form__facultad');
                    $('#legend_facultad').text("Editar Facultad");
                    form.find("input[name='id']").val(data["id"]);
                    form.find("input[name='nombre_facultad']").val(data["nombre_facultad"]);
                    $('#btns_registrar_facultad').css('display', 'none');
                    $('#btns_editar_facultad').css('display', '');
                    break;
                case 'carrera':
                    form = $('#form__carrera');
                    $('#legend_carrera').text("Editar Carrera Profesional");
                    form.find("input[name='id_carrera']").val(data["id_carrera"]);
                    form.find("input[name='nombre_carrera']").val(data["nombre_carrera"]);
                    form.find("select[name='facultad']").val(data["facultad"]["id"]);
                    $('#btns_registrar_carrera').css('display', 'none');
                    $('#btns_editar_carrera').css('display', '');
                    break;
                case 'administrador':
                    form = $('#form__administrador');
                    $('#legend_administrador').text("Editar Administrador");
                    form.find("input[name='id']").val(data["id"]);
                    form.find("input[name='nombres']").val(data["nombres"]);
                    form.find("input[name='apellidos']").val(data["apellidos"]);
                    form.find("input[name='usuario']").val(data["usuario"]);
                    form.find("input[name='clave']").val("none");
                    $('#input_clave_admin').css('display', 'none');
                    form.find("select[name='rol']").val(data["rol"]);
                    $('#btns_registrar_administrador').css('display', 'none');
                    $('#btns_editar_administrador').css('display', '');
                    break;
            }

        }
    });
}

function update_ciclo() {
    $("form[id='form__ciclo']").validate({
        rules: {
            anio: "required",
            n_ciclo: "required",
            fecha_inicio: "required",
            fecha_fin: "required"
        },
        messages: {
            anio: "Ingrese el año del ciclo",
            n_ciclo: "Seleccione un ciclo",
            fecha_inicio: "Ingrese la fecha de inicio",
            fecha_fin: "Ingrese la fecha de fin"
        },
        submitHandler: function () {
            const form = $("form[id='form__ciclo']");
            $.ajax({
                type: 'POST',
                url: "../ciclo/editar",
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        section_general('matriculas');
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function update_facultad() {
    $("form[id='form__facultad']").validate({
        rules: {
            nombre_facultad: "required",
        },
        messages: {
            nombre_facultad: "Ingrese la facultad",
        },
        submitHandler: function () {
            const form = $("form[id='form__facultad']");
            $.ajax({
                type: 'POST',
                url: "../facultad/editar",
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        section_general('facultades_carreras');
                        $('#btns_registrar_facultad').css('display', '');
                        $('#btns_editar_facultad').css('display', 'none');
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function update_carrera() {
    $("form[id='form__carrera']").validate({
        rules: {
            nombre_carrera: "required",
            facultad_id: "required"
        },
        messages: {
            nombre_facultad: "Ingrese la facultad",
            facultad_id: "Seleccione la facultad"
        },
        submitHandler: function () {
            const form = $("form[id='form__carrera']");
            $.ajax({
                type: 'POST',
                url: "../carrera/editar",
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        section_general('facultades_carreras');
                        $('#btns_registrar_carrera').css('display', '');
                        $('#btns_editar_carrera').css('display', 'none');
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function update_administrador() {
    $("form[id='form__administrador']").validate({
        rules: {
            nombres: "required",
            apellidos: "required",
            usuario: "required",
            rol: "required"
        },
        messages: {
            nombres: "Ingrese los nombres",
            apellidos: "Ingrese los apellidos",
            usuario: "Ingrese el usuario",
            rol: "Seleccione un rol"
        },
        submitHandler: function () {
            const form = $("form[id='form__administrador']");
            console.log(form.serialize())
            $.ajax({
                type: 'POST',
                url: "../usuario/admin/editar",
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        section_general('administradores');
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function limpiar_form(id) {
    const form = $("form[id='" + id + "']");
    form.trigger("reset");
    form.validate().resetForm();
    if (id === 'form__matricula') {
        disable_form_matricula();
    }
}

function cancelar_form(entidad) {
    section_general(entidad);
}

function div_registrar(entidad) {
    $.get("./" + entidad + "/registrar",
        function (Resultado) {
            let div;
            switch (entidad) {
                case 'matricula':
                    $('#inicio_matricula').css("display", "none");
                    div = $('#registro_matricula');
                    div.css("display", "");
                    div.html(Resultado);
                    break;
                case 'alumno':
                    $('#btn_registrar_alumno').remove();
                    div = $('#inicio_alumno');
                    div.html(Resultado);
                    break;
                case'docente':
                    $('#btn_registrar_docente').remove();
                    div = $('#inicio_docente');
                    div.html(Resultado);
                    break;
            }

        }
    );
}

function buscar_alumno() {
    let token = $('#_csrf').attr('content');
    let header = $('#_csrf_header').attr('content');
    let form_matricula = $('#form__matricula');
    let dni_alumno = form_matricula.find("input[name='alumno.dni']").val();
    $.ajax({
        type: 'GET',
        url: '../alumno/registro/' + dni_alumno,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            form_matricula.trigger("reset");
            if (data) {
                form_matricula.find("input[name='alumno.dni']").val(data["dni"])
                form_matricula.find("input[name='alumno.nombres']").val(data["nombres"]).prop('disabled', true);
                form_matricula.find("input[name='alumno.apellidos']").val(data["apellidos"]).prop('disabled', true);
                form_matricula.find("select[name='alumno.sexo']").val(data["sexo"]).prop('disabled', true);
                form_matricula.find("input[name='alumno.fecha_nacimiento']").val(formatDate(data["fecha_nacimiento"])).prop('disabled', true);
                form_matricula.find("input[name='alumno.email']").val(data["email"]).prop('disabled', true);
                form_matricula.find("input[name='alumno.celular']").val(data["celular"]).prop('disabled', true);
                form_matricula.find("input[name='alumno.direccion']").val(data["direccion"]).prop('disabled', true);
                form_matricula.find("input[name='codigo_voucher']").prop('disabled', false);
                form_matricula.find("select[id='lista_facultad']").prop('disabled', false);
                form_matricula.find("select[name='carrera.id_carrera']").prop('disabled', false);
            } else {
                form_matricula.find("input[name='alumno.dni']").val(dni_alumno);
                form_matricula.find("input[name='alumno.nombres']").prop('disabled', false);
                form_matricula.find("input[name='alumno.apellidos']").prop('disabled', false);
                form_matricula.find("select[name='alumno.sexo']").prop('disabled', false);
                form_matricula.find("input[name='alumno.fecha_nacimiento']").prop('disabled', false);
                form_matricula.find("input[name='alumno.email']").prop('disabled', false);
                form_matricula.find("input[name='alumno.celular']").prop('disabled', false);
                form_matricula.find("input[name='alumno.direccion']").prop('disabled', false);
                form_matricula.find("input[name='codigo_voucher']").prop('disabled', false);
                form_matricula.find("select[id='lista_facultad']").prop('disabled', false);
                form_matricula.find("select[name='carrera.id_carrera']").prop('disabled', false);
            }
        }
    });
}

function disable_form_matricula() {
    let form_matricula = $('#form__matricula');
    form_matricula.find("input[name='alumno.nombres']").prop('disabled', true);
    form_matricula.find("input[name='alumno.apellidos']").prop('disabled', true);
    form_matricula.find("select[name='alumno.sexo']").prop('disabled', true);
    form_matricula.find("input[name='alumno.fecha_nacimiento']").prop('disabled', true);
    form_matricula.find("input[name='alumno.email']").prop('disabled', true);
    form_matricula.find("input[name='alumno.celular']").prop('disabled', true);
    form_matricula.find("input[name='alumno.direccion']").prop('disabled', true);
    form_matricula.find("input[name='codigo_voucher']").prop('disabled', true);
    form_matricula.find("select[id='lista_facultad']").prop('disabled', true);
    form_matricula.find("select[name='carrera.id_carrera']").prop('disabled', true);
}

function listar_carreras(id_facultad) {
    let token = $('#_csrf').attr('content');
    let header = $('#_csrf_header').attr('content');
    $.ajax({
        type: 'GET',
        url: '../facultad/registro/' + id_facultad + '/carreras',
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data) {
                $('#lista_carreras').find('option:not(:first)').remove();
                data.map(function (carrera) {
                    $("#lista_carreras").append("<option value=" + carrera.id_carrera + ">" + carrera.nombre_carrera + "</option>");
                });
            }
        }
    });
}

function listar_matricula_general() {
    $('#tabla_matricula_registro').show();
    $.get("./matricula/lista/general",
        function (Resultado) {
            $('#tabla_matricula_registro').html(Resultado);
        }
    );
}

function listar_matricula_ciclo() {
    let dato = $('#ciclo_estudio').val();
    if (dato) {
        $('#tabla_matricula_registro').show();
        $.get("./matricula/lista/ciclo/" + dato,
            function (Resultado) {
                $('#tabla_matricula_registro').html(Resultado);
            }
        );
    }
}

function listar_matricula_alumno() {
    let dni = $('#dni_matricula').val();
    if (dni.length === 8) {
        $('#tabla_matricula_registro').show();
        $.get("./matricula/lista/alumno/" + dni,
            function (Resultado) {
                $('#tabla_matricula_registro').html(Resultado);
            }
        );
    }
}

function registrar_asistencia_docente() {
    let token = $('#_csrf').attr('content');
    let header = $('#_csrf_header').attr('content');
    let dni = $('#dni_docente');
    let fecha = $('#fecha_asistencia_docente');
    let id_ciclo = $('#ciclo_estudio');
    $.ajax({
        type: 'POST',
        url: '../asistencia/registrar/docente',
        dataType: 'json',
        data: $.param({
            "asistencia.ciclo.id": id_ciclo.val(),
            "asistencia.fecha": fecha.val(),
            "docente.dni": dni.val(),
            "check_asistencia": 1,
        }),
        //data: JSON.stringify(asistenciaDocente),
        //contentType: 'application/""json; charset=utf-8',
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (result) {
            if (result["success"]) {
                dni.val("");
                fecha.val("");
                alertify.success(result["message"]);
            } else {
                alertify.error(result["message"]);
            }
        }
    });
}

function div_asistencia_alumnos() {
    let id_ciclo = $('#ciclo_estudio');
    let fecha = $('#fecha_asistencia_alumno');
    let id_facultad = $('#facultades');
    $.get('./asistencia/registrar/alumnos/' + id_ciclo.val() + '/' + fecha.val() + '/' + id_facultad.val(),
        function (Resultado) {
            $('#inicio_asistencia').html(Resultado);
        }
    );
}

function registrar_asistencia_alumno() {
    $("form[id='form__asistencia_alumno']").validate({
        submitHandler: function () {
            const form = $("form[id='form__asistencia_alumno']");
            $.ajax({
                type: 'POST',
                url: '../asistencia/registrar/alumnos',
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        div_container_admin('asistencia')
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function listar_asistencia_ciclo() {
    let id_ciclo = $('#list_ciclo_estudio');
    $.get('./asistencia/registro/ciclo/' + id_ciclo.val(),
        function (Resultado) {
            $('#inicio_asistencia').html(Resultado);
        }
    );
}

function modal_asistencia_alumno(id_ciclo, alumno_dni) {
    $.get('./asistencia/registro/alumno/' + alumno_dni + '/ciclo/' + id_ciclo,
        function (Resultado) {
            $('#bodyModalAsistencia').html(Resultado);
            $('#modalAsistencia').modal('show')
        }
    );
}

function modal_asistencia_docente(id_ciclo, docente_dni) {
    $.get('./asistencia/registro/docente/' + docente_dni + '/ciclo/' + id_ciclo,
        function (Resultado) {
            $('#bodyModalAsistencia').html(Resultado);
            $('#modalAsistencia').modal('show')
        }
    );
}

function div_notas_alumnos() {
    let id_ciclo = $('#ciclo_estudio');
    let tipo_nota = $('#tipo_nota');
    let id_facultad = $('#facultades');
    $.get('./notas/registrar/alumnos/' + tipo_nota.val() + '/' + id_ciclo.val() + '/' + id_facultad.val(),
        function (Resultado) {
            $('#inicio_notas').html(Resultado);
        }
    );
}

function registrar_nota_alumno(){
    $("form[id='form__nota_alumno']").validate({
        submitHandler: function () {
            const form = $("form[id='form__nota_alumno']");
            $.ajax({
                type: 'POST',
                url: '../notas/registrar/',
                data: form.serialize(),
                success: function (data) {
                    const result = JSON.parse(data);
                    if (result["success"]) {
                        form.trigger("reset");
                        div_container_admin('notas')
                        alertify.success(result["message"]);
                    } else {
                        alertify.error(result["message"]);
                    }
                }
            });
        }
    });
}

function listar_notas_ciclo() {
    let id_ciclo = $('#list_ciclo_estudio');
    $.get('./notas/registro/ciclo/' + id_ciclo.val(),
        function (Resultado) {
            $('#inicio_notas').html(Resultado);
        }
    );
}