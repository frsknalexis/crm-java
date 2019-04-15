
$(document).on('ready', function() {
	
	var flag;
	
	setTimeout(function() {
		 mostrarForm(false);
		 mostrarFormPersona(false);
	}, 100);
	
	setTimeout(function() {
		cargarEstadEmpleado();
		ocultarBotones();
	}, 6500);
	
	cargarComboUbigeo();
	
	cargarComboCargo();
	
	function limpiar() {
		$('#codigoEmpleado').val('');
		$('#documentoPersonaEmpleado').val('');
		$('#empleadoNombrePersona').val('');
		$('#empleadoApellidosPersona').val('');
		$('#codigoCargo').val('');
	}
	
	function limpiarPersona() {
		$('#documentoPersona').val('');
		$('#codigoUbigeo').val('');
		$('#nombrePersona').val('');
		$('#apellidoPaternoPersona').val('');
		$('#apellidoMaternoPersona').val('');
		$('#direccionReniecPersona').val('');
		$('#direccionActualPersona').val('');
		$('#referenciaPersona').val('');
		$('#telefonoUnoPersona').val('');
		$('#telefonoDosPersona').val('');
		$('#telefonoTresPersona').val('');
	}
	
	function mostrarForm(flag) {
		
		limpiar();
		if(flag) {
			$('#listadoPersonasEmpleadosRegistro').hide();
			$('#formularioEmpleadosRegistro').show();
		}
		else {
			$('#listadoPersonasEmpleadosRegistro').show();
			$('#formularioEmpleadosRegistro').hide();
		}
	}
	
	function mostrarFormPersona(flag) {
		
		limpiarPersona();
		if(flag) {
			$('#listadoPersonasEmpleadosRegistro').hide();
			$('#formularioPersonaEmpleadosRegistro').show();
		}
		else {
			$('#listadoPersonasEmpleadosRegistro').show();
			$('#formularioPersonaEmpleadosRegistro').hide();
		}
	}
	
	function cancelarForm() {
		limpiar();
		mostrarForm(false);
	}
	
	function cancelarFormPersona() {
		limpiarPersona();
		mostrarFormPersona(false);
	}
	
	$.ajax({
		
		type: 'GET',
		url: 'http://localhost:8080/api/v1/persona/personas/listaPersonasNoEmpleados',
		dataType: 'json',
		success: function(response){
			console.log(response);
		}
	});
	
	$('#btnAgregarPersonaEmpleado').on('click', function(){
		mostrarFormPersona(true);
		$('#documentoPersona').attr('disabled', false);
		flag = false;
	});
	
	$('#cancelarAccion').on('click', function(){
		cancelarFormPersona();
	});
	
	/**
	 * 
	 * Funcion para cargar el combo ubigeo
	 * 
	 * */
	
	function cargarComboUbigeo() {
		
		var $codigoUbigeo = $('#codigoUbigeo');
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/ubigeo/ubigeos',
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$codigoUbigeo.html('');
				$codigoUbigeo.append('<option value="">Seleccione un Ubigeo</option>');
				for(var i = 0; i < response.length; i++) {
					$codigoUbigeo.append('<option value="'+ response[i].codigoUbigeo+'">'+ response[i].codigoUbigeo + ' - ' + response[i].nombreUbigeo +'</option>');
				}
			}
		});
	}
	
	$('#guardarPersona').on('click', function(e) {
		e.preventDefault();
		
		if($('#documentoPersona').val().match(/^[0-9]{7,11}$/) && $('#codigoUbigeo').val().trim() != ""
			&& $('#nombrePersona').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/) && $('#apellidoPaternoPersona').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/)
			&& $('#apellidoMaternoPersona').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/) && $('#direccionActualPersona').val().match(/^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ\#.-\s]+$/)
			&& $('#referenciaPersona').val().match(/^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ\#.-\s]+$/) && $('#telefonoUnoPersona').val().match(/^[0-9]{7,9}$/)) {
			
			var formData = {
					documentoPersona: $('#documentoPersona').val(),
					ubigeo: {
						codigoUbigeo: $('#codigoUbigeo').val()
					},
					nombrePersona: $('#nombrePersona').val(),
					apellidoPaternoPersona: $('#apellidoPaternoPersona').val(),
					apellidoMaternoPersona: $('#apellidoMaternoPersona').val(),
					direccionReniecPersona: $('#direccionReniecPersona').val(),
					direccionActualPersona: $('#direccionActualPersona').val(),
					referenciaPersona: $('#referenciaPersona').val(),
					telefonoUnoPersona: $('#telefonoUnoPersona').val(),
					telefonoDosPersona: $('#telefonoDosPersona').val(),
					telefonoTresPersona: $('#telefonoTresPersona').val()
			};
			
			if(flag == true) {
				
				$.ajax({
					
					type: 'PUT',
					url: 'http://localhost:8080/api/v1/persona/update',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response){
						console.log(response);
						
						if(response.status == "UPDATED") {
							
							swal({
								type: "success",
								title: "Persona Actualizado con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/empleado/view');
								}
							});
						}
					},
					error: function() {
						
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Actualizar Persona !'
			            });
					}
				});
			}
			
			if(flag == false) {
				
				$.ajax({
					
					type:'POST',
					url: 'http://localhost:8080/api/v1/persona/save',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response){
						console.log(response);
						
						if(response.status == 'CREATED') {
							
							swal({
								type: "success",
								title: "Persona: " + response.data.nombrePersona + " Registrado con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/empleado/view');
								}
							});
						}
						else if(response.status == 'ERROR') { 
							
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'Ocurrio un Error al Registrar a la Persona: '+ response.data.nombrePersona +', verifique si ya existe !'
				            });
							
							limpiarPersona();
						}
					},
					error: function(){
						
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Registrar Persona !'
			            });
					}
				});
			}
		}
		
		if($('#documentoPersona').val() == "" && $('#codigoUbigeo').val().trim() == "" && $('#nombrePersona').val() == ""
			&& $('#apellidoPaternoPersona').val() == "" && $('#apellidoMaternoPersona').val() == "" && $('#direccionActualPersona').val() == ""
				&& $('#referenciaPersona').val() == "" && $('#telefonoUnoPersona').val() == "") {
			
			swal({
                type: 'error',
                title: 'Ooops',
                text: 'Debe llenar todos los Campos !'
            });
			return false;
		}
		else {
			
			if($('#documentoPersona').val() == "" || $('#documentoPersona').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Numero Documento no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#documentoPersona').focus();
		    	return false;
			}
			
			if($('#codigoUbigeo').val().trim() == "") {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Debe seleccionar un Ubigeo'
	            });
				
		    	return false;
			}
			
			if($('#nombrePersona').val() == "" || $('#nombrePersona').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Nombre no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#nombrePersona').focus();
		    	return false;
			}
			
			if($('#apellidoPaternoPersona').val() == "" || $('#apellidoPaternoPersona').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Apellido Paterno no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#apellidoPaternoPersona').focus();
		    	return false;
			}
			
			if($('#apellidoMaternoPersona').val() == "" || $('#apellidoMaternoPersona').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Apellido Materno no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#apellidoMaternoPersona').focus();
		    	return false;
			}
			
			if($('#direccionActualPersona').val() == "" || $('#direccionActualPersona').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Direccion Actual no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#direccionActualPersona').focus();
		    	return false;
			}
			
			if($('#referenciaPersona').val() == "" || $('#referenciaPersona').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Referencia Direccion no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#referenciaPersona').focus();
		    	return false;
			}
			
			if($('#telefonoUnoPersona').val() == "" || $('#telefonoUnoPersona').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Telefono o Celular no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#telefonoUnoPersona').focus();
		    	return false;
			}
			
			if(!($('#documentoPersona').val().match(/^[0-9]{7,11}$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Numero Documento no permite caracteres especiales ni letras'
	            });
				
				$('#documentoPersona').val('');
				$('#documentoPersona').focus();
		    	return false;
			}
			else if(!($('#nombrePersona').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Nombre no permite caracteres especiales ni numeros'
	            });
				
				$('#nombrePersona').val('');
				$('#nombrePersona').focus();
		    	return false;
			}
			else if(!($('#apellidoPaternoPersona').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Apellido Paterno no permite caracteres especiales ni numeros'
	            });
				
				$('#apellidoPaternoPersona').val('');
				$('#apellidoPaternoPersona').focus();
		    	return false;
			}
			else if(!($('#apellidoMaternoPersona').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Apellido Materno no permite caracteres especiales ni numeros'
	            });
				
				$('#apellidoMaternoPersona').val('');
				$('#apellidoMaternoPersona').focus();
		    	return false;
			}
			else if(!($('#direccionActualPersona').val().match(/^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ\#.-\s]+$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Direccion Actual no permite caracteres especiales'
	            });
				
				$('#direccionActualPersona').val('');
				$('#direccionActualPersona').focus();
		    	return false;
			}
			else if(!($('#referenciaPersona').val().match(/^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ\#.-\s]+$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Referencia Direccion no permite caracteres especiales'
	            });
		    	
				$('#referenciaPersona').val('');
		    	$('#referenciaPersona').focus();
		    	return false;
			}
			else if(!($('#telefonoUnoPersona').val().match(/^[0-9]{7,9}$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Telefono o Celular Uno no permite caracteres especiales, ni letras'
	            });
		    	
				$('#telefonoUnoPersona').val('');
		    	$('#telefonoUnoPersona').focus();
		    	return false;
			}
		}
	});
	
	/**
	 * 
	 * Evento change para el input Telefono 2
	 * 
	 * */
	$('#telefonoDosPersona').on('change', function() {
		
		if(!($('#telefonoDosPersona').val().match(/^[0-9]{7,9}$/))) {
			
			swal({
                type: 'error',
                title: 'Ooops',
                text: 'El campo Telefono o Celular Dos no permite caracteres especiales, ni letras'
            });
	    	
			$('#telefonoDosPersona').val('');
	    	$('#telefonoDosPersona').focus();
	    	return false;
		}
	});
	
	/**
	 * 
	 * Evento change para el input Telefono 3
	 * 
	 * */
	$('#telefonoTresPersona').on('change', function() {
		
		if(!($('#telefonoTresPersona').val().match(/^[0-9]{7,9}$/))) {
			
			swal({
                type: 'error',
                title: 'Ooops',
                text: 'El campo Telefono o Celular Tres no permite caracteres especiales, ni letras'
            });
	    	
			$('#telefonoTresPersona').val('');
	    	$('#telefonoTresPersona').focus();
	    	return false;
		}
	});
	
	var tablaPersonas = $('#tablaPersonasEmpleados').dataTable({
		"language": {
			"sProcessing":     "Procesando...",
			"sLengthMenu":     "Mostrar _MENU_ registros",
			"sZeroRecords":    "No se encontraron resultados",
			"sEmptyTable":     "Ningún dato disponible en esta tabla",
			"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
			"sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
			"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix":    "",
			"sSearch":         "Buscar:",
			"sUrl":            "",
			"sInfoThousands":  ",",
			"sLoadingRecords": "Cargando...",
			"oPaginate": {
				"sFirst":    "Primero",
				"sLast":     "Último",
				"sNext":     "Siguiente",
				"sPrevious": "Anterior"
			},
			"oAria": {
				"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
				"sSortDescending": ": Activar para ordenar la columna de manera descendente"
			}
		},
		'bProcessing': true,
		"ajax": {
			"url": "http://localhost:8080/api/v1/persona/personas/listaPersonasNoEmpleados",
			"dataSrc": ""
		},
		"columns": [
			{"data": "documentoPersona"},
			{"data": "nombrePersona"},
			{"data": "apellidoPaternoPersona"},
			{"data": "apellidoMaternoPersona"},
			{"data": "direccionActualPersona"},
			{"data": "referenciaPersona"},
			{"data": "telefonoUnoPersona"},
			{"defaultContent": '<button type="button" class="btn btn-success btn-xs btnAgregarPersonaEmpleado" idDocumentoPersona><i class="fa fa-users"></i> Añadir a Empleados</button>'},
			{"defaultContent": '<div class="btn-group"><button type="button" class="btn btn-info btn-xs btnEditarPersonaEmpleado" idDocumentoPersona><i class="fa fa-pencil" title="Editar"></i></button></div>'}
		]
	}).DataTable();
	
	$('#tablaPersonasEmpleados tbody').on('click', 'button', function() {
		var data = tablaPersonas.row( $(this).parents('tr')).data();
		$(this).attr('idDocumentoPersona', data.documentoPersona);
	});
	
	/**
	 * 
	 *Evento para editar Persona
	 * 
	 */
	$('#tablaPersonasEmpleados tbody').on('click', 'button.btnEditarPersonaEmpleado', function(){
		var documentoPersonaEmpleado = $(this).attr('idDocumentoPersona');
		console.log("documentoPersonaEmpleado: " + documentoPersonaEmpleado);
		mostrarFormPersona(true);
		$('#documentoPersona').attr('disabled', true);
		$('#documentoPersona').val(documentoPersonaEmpleado);
		flag = true;
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/persona/persona/' + documentoPersonaEmpleado,
			dataType: 'json',
			success: function(response){
				console.log(response);
				$("#codigoUbigeo option[value="+ response.ubigeo.codigoUbigeo +"]").attr("selected",true);
				$('#nombrePersona').val(response.nombrePersona);
				$('#apellidoPaternoPersona').val(response.apellidoPaternoPersona);
				$('#apellidoMaternoPersona').val(response.apellidoMaternoPersona);
				$('#direccionReniecPersona').val(response.direccionReniecPersona);
				$('#direccionActualPersona').val(response.direccionActualPersona);
				$('#referenciaPersona').val(response.referenciaPersona);
				$('#telefonoUnoPersona').val(response.telefonoUnoPersona);
				$('#telefonoDosPersona').val(response.telefonoDosPersona);
				$('#telefonoTresPersona').val(response.telefonoTresPersona);
			}
		});
		
	});
	
	/**
	 * 
	 * Evento para agregar empleado
	 * 
	 * */
	
	$('#tablaPersonasEmpleados tbody').on('click', 'button.btnAgregarPersonaEmpleado', function() {
		var documentoPersonaEmpleado = $(this).attr('idDocumentoPersona');
		console.log("documentoPersonaEmpleado: " + documentoPersonaEmpleado);
		mostrarForm(true);
		$('#documentoPersonaEmpleado').attr('disabled', true);
		$('#documentoPersonaEmpleado').val(documentoPersonaEmpleado);
		$('#empleadoNombrePersona').attr('disabled', true);
		$('#empleadoApellidosPersona').attr('disabled', true);
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/persona/persona/' + documentoPersonaEmpleado,
			dataType: 'json',
			success: function(response){
				console.log(response);
				$('#empleadoNombrePersona').val(response.nombrePersona);
				$('#empleadoApellidosPersona').val(response.apellidoPaternoPersona + ' ' + response.apellidoMaternoPersona);
			}
		});
	});
	
	$('#cancelarAccionEmpleado').on('click', function() {
		cancelarForm();
	});
	
	/**
	 * 
	 * Funcion para cargar en el combo el cargo
	 */
	function cargarComboCargo() {
		
		var $codigoCargo = $('#codigoCargo');
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/cargo/cargos',
			dataType: 'json',
			success: function(response){
				console.log(response);
				$codigoCargo.html('');
				$codigoCargo.append('<option value="">Seleccione un Cargo</option>');
				for(var i = 0; i < response.length; i++) {
					$codigoCargo.append('<option value="' + response[i].codigoCargo + '">' + response[i].descripcionCargo + '</option>');
				}
			}
		});
	}
	
	$('#guardarEmpleado').on('click', function(e) {
		e.preventDefault();
		
		if($('#codigoCargo').val().trim() != "") {
			
			var formData = {
				
					codigoEmpleado: $('#codigoEmpleado').val(),
					documentoPersonaEmpleado: $('#documentoPersonaEmpleado').val(),
					cargo: {
						codigoCargo: $('#codigoCargo').val()
					}
			};
			
			if(formData.codigoEmpleado) {
				codigoEmpleado = formData.codigoEmpleado;
				console.log("codigoEmpleado: " + codigoEmpleado);
				
				$.ajax({
					
					type: 'PUT',
					url: 'http://localhost:8080/api/v1/empleado/update',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response){
						console.log(response);
						
						if(response.status == 'UPDATED') {
							
							swal({
								type: "success",
								title: "Empleado Actualizado con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/empleado/view');
								}
							});
						}
					},
					error: function(response){
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Actualizar Empleado !'
			            });
					}
				});
			}
			else {
				
				$.ajax({
					
					type: 'POST',
					url: 'http://localhost:8080/api/v1/empleado/save',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response) {
						
						console.log(response);
						
						if(response.status == 'CREATED') {
							
							swal({
								type: "success",
								title: "Empleado Registrado con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/empleado/view');
								}
							});
						}
						else if(response.status == 'ERROR') {
							
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'Ocurrio un Error al Registrar al Empleado, verifique si ya existe !'
				            });
							limpiarPersona();
						}
					},
					error: function() {
						
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Registrar Empleado !'
			            });
					}
				});
			}
		}
		
		if($('#codigoCargo').val().trim() == "") {
			
			swal({
                type: 'error',
                title: 'Ooops',
                text: 'Debe seleccionar un Cargo'
            });
			
	    	return false;
		}
	});
	
	
	/**
	 * 
	 * Tabla Empleados
	 *
	 */
	var tablaEmpleados = $('#tablaEmpleados').dataTable({
		"language": {
			"sProcessing":     "Procesando...",
			"sLengthMenu":     "Mostrar _MENU_ registros",
			"sZeroRecords":    "No se encontraron resultados",
			"sEmptyTable":     "Ningún dato disponible en esta tabla",
			"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
			"sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
			"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix":    "",
			"sSearch":         "Buscar:",
			"sUrl":            "",
			"sInfoThousands":  ",",
			"sLoadingRecords": "Cargando...",
			"oPaginate": {
				"sFirst":    "Primero",
				"sLast":     "Último",
				"sNext":     "Siguiente",
				"sPrevious": "Anterior"
			},
			"oAria": {
				"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
				"sSortDescending": ": Activar para ordenar la columna de manera descendente"
			}
		},
		"bProcessing": true,
		"ajax": {
			"url": "http://localhost:8080/api/v1/empleado/empleados/listarPersonaEmpleado",
			"dataSrc": ""
		},
		"columns": [
			{"data": "codigoEmpleado"},
			{"data": "documentoPersonaEmpleado"},
			{"data": "cargo.descripcionCargo"},
			{"defaultContent": '<span class="label label-success estadoEmpleado">Activo</span>'},
			{"defaultContent": '<div class="btn-group"><button type="button" data-toggle="modal" class="btn btn-info btn-sm btnVerEmpleado" idDocumentoEmpleado><i class="fa fa-eye" title="Ver"></i></button><button type="button" class="btn btn-primary btn-sm btnEditarEmpleado" idDocumentoEmpleado><i class="fa fa-pencil" title="Editar"></i></button><button type="button" class="btn btn-danger btnDeshabilitarEmpleado btn-sm" idDocumentoEmpleado><i class="fa fa-times" title="Deshabilitar"></i></button><button type="button" class="btn btn-success btn-sm btnHabilitarEmpleado" idDocumentoEmpleado style="display:none;"><i class="fa fa-check" title="Habilitar"></i></button></div>'}
		]
		
	}).DataTable();
	
	/**
	 * 
	 * Asignar valor a los botones
	 * 
	 * */
	
	$('#tablaEmpleados tbody').on('click', 'button', function(){
		
		var data = tablaEmpleados.row( $(this).parents('tr')).data();
		$(this).attr('idDocumentoEmpleado', data.documentoPersonaEmpleado);
		
	});
	
	/**
	 * 
	 *funcion para cargar el estado del empleado
	 *
	 */
	function cargarEstadEmpleado() {
		var estadoEmpleado = $('.estadoEmpleado');
		for(var i = 0; i < estadoEmpleado.length; i++) {
			var data = tablaEmpleados.row( $(estadoEmpleado[i]).parents('tr')).data();
			if(data.estado == true) {
				$(estadoEmpleado[i]).attr('class', 'label label-success');
				$(estadoEmpleado[i]).html('Activo');
			}
			else if(data.estado == false) {
				$(estadoEmpleado[i]).attr('class', 'label label-danger');
				$(estadoEmpleado[i]).html('Inactivo');
			}
		}
	}
	
	/**
	 * 
	 *Funcion para ocultar botones segun el estado del empleado
	 * 
	 */
	function ocultarBotones() {
		
		var btnVerEmpleado = $('.btnVerEmpleado');
		for(var i = 0; i < btnVerEmpleado.length; i++) {
			var data = tablaEmpleados.row( $(btnVerEmpleado[i]).parents('tr')).data();
			if(data.estado == true) {
				$(btnVerEmpleado[i]).attr('style', 'display:block');
			}
			else if(data.estado == false) {
				$(btnVerEmpleado[i]).attr('style', 'display:none');
			}
		}
		
		var btnEditarEmpleado = $('.btnEditarEmpleado');
		for(var i = 0; i < btnEditarEmpleado.length; i++) {
			var data = tablaEmpleados.row( $(btnEditarEmpleado[i]).parents('tr')).data();
			if(data.estado == true) {
				$(btnEditarEmpleado[i]).attr('style', 'display:block');
			}
			else if(data.estado == false) {
				$(btnEditarEmpleado[i]).attr('style', 'display:none');
			}
		}
		
		var btnDeshabilitarEmpleado = $('.btnDeshabilitarEmpleado');
		for(var i = 0; i < btnDeshabilitarEmpleado.length; i++) {
			var data = tablaEmpleados.row( $(btnDeshabilitarEmpleado[i]).parents('tr')).data();
			if(data.estado == true) {
				$(btnDeshabilitarEmpleado[i]).attr('style', 'display:block');
			}
			else if(data.estado == false) {
				$(btnDeshabilitarEmpleado[i]).attr('style', 'display:none');
			}
		}
		
		var btnHabilitarEmpleado = $('.btnHabilitarEmpleado');
		for(var i = 0; i < btnHabilitarEmpleado.length; i++) {
			var data = tablaEmpleados.row( $(btnHabilitarEmpleado[i]).parents('tr')).data();
			if(data.estado == true) {
				$(btnHabilitarEmpleado[i]).attr('style', 'display:none');
			}
			else if(data.estado == false) {
				$(btnHabilitarEmpleado[i]).attr('style', 'display:block');
			}
		}
	}
	
	/**
	 * 
	 * Funcion limpiarModal
	 * 
	 */
	function limpiarModalEmpleado(){
		
		$('#myModalLabelEmpleado').html('');
		$('#detalleEmpleadoDocumento').val('');
		$('#detalleEmpleadoNombre').val('');
		$('#detalleEmpleadoDireccionActual').val('');
		$('#detalleEmpleadoTelefonoUno').val('');
		$('#detalleCodigoEmpleado').val('');
		$('#detalleCargoEmpleado').val('');
	}
	
	/**
	 * 
	 * Verr detalle Empleado
	 * 
	 */
	$('#tablaEmpleados tbody').on('click', 'button.btnVerEmpleado', function() {
		var documentoPersonaEmpleado = $(this).attr('idDocumentoEmpleado');
		$('#modalDetalleEmpleado').modal('show');
		limpiarModalEmpleado();
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/persona/persona/' + documentoPersonaEmpleado,
			dataType: 'json',
			success: function(response){
				console.log(response);
				$('#myModalLabelEmpleado').html('Empleado: ' + response.nombrePersona + ' ' + response.apellidoPaternoPersona + ' ' + response.apellidoMaternoPersona);
				$('#detalleEmpleadoDocumento').val(response.documentoPersona);
				$('#detalleEmpleadoNombre').val(response.nombrePersona + ' ' + response.apellidoPaternoPersona + ' ' + response.apellidoMaternoPersona);
				$('#detalleEmpleadoDireccionActual').val(response.direccionActualPersona);
				$('#detalleEmpleadoTelefonoUno').val(response.telefonoUnoPersona);
			}
		});
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/empleado/empleado/' + documentoPersonaEmpleado,
			dataType: 'json',
			success: function(response){
				console.log(response);
				$('#detalleCodigoEmpleado').val(response.codigoEmpleado);
				$('#detalleCargoEmpleado').val(response.cargo.descripcionCargo);
			}
		});
	});
	
	/**
	 * 
	 *Editar Empleado
	 * 
	 */
	$('#tablaEmpleados tbody').on('click', 'button.btnEditarEmpleado', function() {
		
		var documentoPersonaEmpleado = $(this).attr('idDocumentoEmpleado');
		console.log("documentoPersonaEmpleado: " + documentoPersonaEmpleado);
		
		mostrarForm(true);
		$('#documentoPersonaEmpleado').attr('disabled', true);
		$('#documentoPersonaEmpleado').val(documentoPersonaEmpleado);
		$('#empleadoNombrePersona').attr('disabled', true);
		$('#empleadoApellidosPersona').attr('disabled', true);
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/persona/persona/' + documentoPersonaEmpleado,
			dataType: 'json',
			success: function(response){
				console.log(response);
				$('#empleadoNombrePersona').val(response.nombrePersona);
				$('#empleadoApellidosPersona').val(response.apellidoPaternoPersona + ' ' + response.apellidoMaternoPersona);
			}
		});
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/empleado/empleado/' + documentoPersonaEmpleado,
			dataType: 'json',
			success: function(response){
				console.log(response);
				$('#codigoEmpleado').val(response.codigoEmpleado);
				$("#codigoCargo option[value="+ response.cargo.codigoCargo +"]").attr("selected",true);
			}
		});
	});
	
	/**
	 * 
	 *Evento para deshabilitar Empleado
	 * 
	 */
	 $('#tablaEmpleados tbody').on('click', 'button.btnDeshabilitarEmpleado', function(){
		
		var documentoPersonaEmpleado = $(this).attr('idDocumentoEmpleado');
		console.log("documentoPersonaEmpleado: " + documentoPersonaEmpleado);
		
		swal({
	        title: '¿Esta Seguro de deshabilitar a este Empleado ?',
	        text: '¡Si no lo esta puede Cancelar la accion!',
	        type: 'warning',
	        showCancelButton: true,
	        confirmButtonColor: '#3085d6',
	        cancelButtonColor: '#d33',
	        cancelButtonText: 'Cancelar',
	        confirmButtonText: '¡Si!'
	    }).then((result) => {
	        if(result.value){
	           
	        	 $.ajax({
	                 url: 'http://localhost:8080/api/v1/empleado/empleado/disabled/' + documentoPersonaEmpleado,
	                 type: 'GET',
	                 success: function(response){
	                	 
	                	 console.log(response);
	                     swal({
	                         type: "success",
	                         title: "El Empleado ha sido deshabilitado correctamente",
	                         showConfirmButton: true,
	                         confirmButtonText: "Cerrar",
	                         closeOnConfirm: false
	                     }).then((result) => {
	                         if(result.value) {
	                             $(location).attr("href", "/empleado/view");
	                         }
	                     })
	                 }
	             });
	        }
	        else {
	            swal({
	                type: "error",
	                title: "Cancelado", 
	                text: "Usted ha cancelado la acción de deshabilitar"
	            });
	        }
	    });
	 });
	 
	 /**
	  * 
	  * Evento para habilitar el empleado 
	  * 
	  */
	 $('#tablaEmpleados tbody').on('click', 'button.btnHabilitarEmpleado', function() {
		 var documentoPersonaEmpleado = $(this).attr('idDocumentoEmpleado');
		 console.log("documentoPersonaEmpleado: " + documentoPersonaEmpleado);
		 
		 swal({
		        title: '¿Esta Seguro de habilitar a este Empleado ?',
		        text: '¡Si no lo esta puede Cancelar la accion!',
		        type: 'warning',
		        showCancelButton: true,
		        confirmButtonColor: '#3085d6',
		        cancelButtonColor: '#d33',
		        cancelButtonText: 'Cancelar',
		        confirmButtonText: '¡Si!'
		    }).then((result) => {
		        if(result.value){
		           
		        	$.ajax({
		        		
		        		url: 'http://localhost:8080/api/v1/empleado/empleado/enabled/' + documentoPersonaEmpleado,
		        		type: 'GET',
		        		success: function(response){
		        			console.log(response);
		        			
		        			swal({
		        				type: "success",
		                        title: "El Empleado ha sido habilitado correctamente",
		                        showConfirmButton: true,
		                        confirmButtonText: "Cerrar",
		                        closeOnConfirm: false
		                       }).then((result) => {
		                         if(result.value) {
		                            $(location).attr("href", "/empleado/view");
		                        }
		                     })
		                 }
		        	});
		        }
		        else {
		            swal({
		                type: "error",
		                title: "Cancelado", 
		                text: "Usted ha cancelado la acción de habilitar"
		            });
		        }
		    });
	 });
});
