/**
 * 
 */

$(document).on('ready', function() {
	
	var flag;
	
	var accion;
	
	setTimeout(function() {
		mostrarForm(false);
		mostrarFormCliente(false);
	}, 200);
	
	setTimeout(function() {
		cargarEstadoCliente();
		ocultarBotones();
	}, 6500);
	
	cargarComboSexo();
	
	$.ajax({
		
		type: 'GET',
		url: 'http://localhost:8080/api/v1/persona/personas/listaPersonasNoClientes',
		dataType: 'json',
		success: function(response){
			console.log(response);
			
			if(response == null) {
			}
		}
	});
		
	var tabla = $('#tablaPersonas').dataTable({
		
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
			"url": "http://localhost:8080/api/v1/persona/personas/listaPersonasNoClientes",
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
			{"defaultContent": '<button type="button" class="btn btn-success btn-xs btnAgregarPersonaCliente" idDocumento><i class="fa fa-users"></i> Añadir a Clientes</button>'},
			{"defaultContent": '<div class="btn-group"><button type="button" class="btn btn-info btn-sm btnEditarPersona" idDocumento><i class="fa fa-pencil" title="Editar"></i></button></div>'}
		]		
	}).DataTable();
	
	$('#tablaPersonas tbody').on('click', 'button', function() {
		
		var data = tabla.row($(this).parents('tr')).data();
		$(this).attr('idDocumento', data.documentoPersona);
	});
	
	function limpiar() {
		
		$('#documentoPersona').val('');
		$('#codigoUbigeo').val('');
		$('#nombreUbigeo').val('');
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
	
	function limpiarClientes() {
		
		$('#documentoPersonaCliente').val('');
		$('#clienteNombrePersona').val('');
		$('#clienteApellidosPersona').val('');
		$('#consecutivoCliente').val('');
		$('#codigoCliente').val('');
		$('#nombreComercialCliente').val('');
		$('#correoCliente').val('');
		$('#facebookCliente').val('');
		$('#codigoSexo').val('');
	}
	
	function mostrarForm(flag) {
		
		limpiar();
		if(flag) {
			
			$('#listadoPersonaRegistro').hide();
			$('#formularioPersonaRegistro').show();
		}
		else {
			
			$('#listadoPersonaRegistro').show();
			$('#formularioPersonaRegistro').hide();
		}
	}
	
	function mostrarFormCliente(flag) {
		
		limpiarClientes();
		if(flag) {
			
			$('#listadoPersonaRegistro').hide();
			$('#formularioRegistroClientes').show();
		}
		else {
			$('#listadoPersonaRegistro').show();
			$('#formularioRegistroClientes').hide();
		}
	}
	
	function cancelarForm() {
		limpiar();
		mostrarForm(false);
	}
	
	function cancelarFormCliente() {
		limpiarClientes();
		mostrarFormCliente(false);
	}
	
	$('#btnAgregarPersona').on('click', function() {
		
		mostrarForm(true);
		$('#documentoPersona').attr('disabled', false);
		flag = false;
	});
	
	$('#cancelarAccion').on('click', function() {
		
		cancelarForm();
	});
	
	$('#guardarPersona').on('click', function(e) {
		e.preventDefault();
		
		if($('#documentoPersona').val().match(/^[0-9]{7,11}$/) && $('#nombreUbigeo').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/)
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
				
				console.log(flag);
				
				$.ajax({
					
					type: 'PUT',
					url: 'http://localhost:8080/api/v1/persona/update',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response) {
						
						console.log(response);
						
						swal({
							type: "success",
							title: "Persona Actualizado con exito",
							showConfirmButton: true,
							confirmButtonText: "Cerrar",
							closeOnConfirm: false
						}).then((result) => {

							if(result.value) {
								$(location).attr('href', '/persona/view');
							}
						});
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
					
					type: 'POST',
					url: 'http://localhost:8080/api/v1/persona/save',
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
								title: "Persona: " + response.data.nombrePersona + " Registrado con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/persona/view');
								}
							});
						}
						else if(response.status == 'ERROR') { 
							
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'Ocurrio un Error al Registrar a la Persona: '+ response.data.nombrePersona +', verifique su Numero Documento !'
				            });
							
							limpiar();
						}
					},
					error: function() {
						
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Registrar Persona !'
			            });
					}
				});
			}
		}
		
		if($('#documentoPersona').val() == "" && $('#nombreUbigeo').val() == "" && $('#nombrePersona').val() == "" 
				&& $('#apellidoPaternoPersona').val() == "" && $('#apellidoMaternoPersona').val() == "" && $('#direccionActualPersona').val() == ""
				&& $('#referenciaPersona').val() == "" && $('#telefonoUnoPersona').val() == "")  {
			
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
			
			if($('#nombreUbigeo').val() == "" || $('#nombreUbigeo').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Ubigeo no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#nombreUbigeo').focus();
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
			
			else {
				
				if(!($('#nombreUbigeo').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/))) {
					
					swal({
		                type: 'error',
		                title: 'Ooops',
		                text: 'El campo Ubigeo no permite caracteres especiales ni numeros'
		            });
					
					$('#nombreUbigeo').val('');
					$('#nombreUbigeo').focus();
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
	
	/**
	 *
	 * Editar Persona
	 * 
	 */
	$('#tablaPersonas tbody').on('click', 'button.btnEditarPersona', function() {
		
		var documentoPersona = $(this).attr('idDocumento');
		console.log('documentoPersona: ' + documentoPersona);
		
		mostrarForm(true);
		$('#documentoPersona').attr('disabled', true);
		flag = true;
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/persona/persona/' + documentoPersona,
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#documentoPersona').val(response.documentoPersona);
				$('#codigoUbigeo').val(response.ubigeo.codigoUbigeo);
				$('#nombreUbigeo').val(response.ubigeo.nombreUbigeo);
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
	
	function cargarComboSexo() {
		
		var $codigoSexo = $('#codigoSexo');
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/sexo/sexos',
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$codigoSexo.html('');
				$codigoSexo.append('<option value="">Seleccione una opcion</option>');
				for(var i = 0; i < response.length; i++) {
					$codigoSexo.append('<option id="optionComboSexo" value="' + response[i].codigoSexo +'">' + response[i].descripcionSexo + '</option>');
				}
			}
		});
	}
	
	$('#tablaPersonas tbody').on('click', 'button.btnAgregarPersonaCliente', function() {
		
		var documentoPersona = $(this).attr('idDocumento');
		console.log("documentoPersona: " + documentoPersona);
		mostrarFormCliente(true);
		accion = false;
		$('#documentoPersonaCliente').attr('disabled', true);
		$('#documentoPersonaCliente').val(documentoPersona);
		$('#clienteNombrePersona').attr('disabled', true);
		$('#clienteApellidosPersona').attr('disabled', true);
		$('#inputConsecutivoCliente').hide();
		$('#inputCodigoCliente').hide();
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/persona/persona/' + documentoPersona,
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#clienteNombrePersona').val(response.nombrePersona);
				$('#clienteApellidosPersona').val(response.apellidoPaternoPersona + ' ' + response.apellidoMaternoPersona);
			}
		});
		
		
		
	});
	
	$('#cancelarAccionCliente').on('click', function() {
		
		cancelarFormCliente();
	});
	
	$('#guardarCliente').on('click', function(e) {
		
		e.preventDefault();
		
		if($('#correoCliente').val().match(/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/)
			&& $('#facebookCliente').val().match(/^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ\,.-\s]+$/)
			&& $('#codigoSexo').val().trim() != "") {
				
			var formData = {	
					documentoPersonaCliente: $('#documentoPersonaCliente').val(),
					consecutivoCliente: $('#consecutivoCliente').val(),
					codigoCliente: $('#codigoCliente').val(),
					nombreComercialCliente: $('#nombreComercialCliente').val(),
					correoCliente: $('#correoCliente').val(),
					facebookCliente: $('#facebookCliente').val(),
					sexo: {
						codigoSexo: $('#codigoSexo').val()
					}
			};
			
			if(accion == true) {
				
				$.ajax({
					
					type: 'PUT',
					url: 'http://localhost:8080/api/v1/cliente/update',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response) {
						
						console.log(response);
						
						swal({
							type: "success",
							title: "Cliente Actualizado con exito",
							showConfirmButton: true,
							confirmButtonText: "Cerrar",
							closeOnConfirm: false
						}).then((result) => {

							if(result.value) {
								$(location).attr('href', '/persona/view');
							}
						});
					},
					error: function() {
						
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Actualizar Cliente !'
			            });
					}
				});
			}
			
			else if(accion == false) {
				console.log(formData);
				
				$.ajax({
					
					type:'POST',
					url: 'http://localhost:8080/api/v1/cliente/save',
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
								title: "Cliente Registrado con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/persona/view');
								}
							});
						}
						else if(response.status == 'ERROR') {
							
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'Ocurrio un Error al Registrar al Cliente, verifique si ya existe !'
				            });
							
							limpiarClientes();
						}
					},
					error: function() {
						
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Registrar Cliente !'
			            });
					}
				});
			}
		}
		
		if($('#correoCliente').val() == "" && $('#facebookCliente').val() == "" && $('#codigoSexo').val().trim() == "") {
			
			swal({
                type: 'error',
                title: 'Ooops',
                text: 'Debe llenar todos los Campos !'
            });
		
			return false;
		}
		
		else{
			
			if($('#correoCliente').val() == "" || $('#correoCliente').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Correo Electronico no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#correoCliente').focus();
		    	return false;
			}
			else if($('#facebookCliente').val() == "" || $('#facebookCliente').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Facebook Cliente no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#facebookCliente').focus();
		    	return false;
			}
			else if($('#codigoSexo').val().trim() == "") {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Debe seleccionar un Sexo'
	            });
				
		    	return false;
			}
						
			else if(!($('#correoCliente').val().match(/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Correo Electronico no tiene un formato de Correo valido'
	            });
				
				$('#correoCliente').val('');
				$('#correoCliente').focus();
		    	return false;
			}
			
			else if(!($('#facebookCliente').val().match(/^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ\,.-\s]+$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Ingrese un valor valido para el Facebook Cliente'
	            });
				
				$('#facebookCliente').val('');
				$('#facebookCliente').focus();
		    	return false;
			}
		}
	});
	
	$('#nombreComercialCliente').on('change', function() {
		
		if(!($('#nombreComercialCliente').val().match(/^[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ\,.-\s]+$/))) {
			
			swal({
                type: 'error',
                title: 'Ooops',
                text: 'El campo Nombre Comercial Cliente no permite caracteres especiales'
            });
			
			$('#nombreComercialCliente').val('');
			$('#nombreComercialCliente').focus();
	    	return false;
		}
		
	});
	
	$.ajax({
		
		type: 'GET',
		url: 'http://localhost:8080/api/v1/cliente/clientes/listarClienteVendedor',
		dataType: 'json',
		success: function(response){
			console.log(response);
		}
	});
	
	var tablaClientes = $('#tablaClientes').DataTable({
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
			"url": "http://localhost:8080/api/v1/cliente/clientes/listarClienteVendedor",
			"dataSrc": ""
		},
		"columns": [
			{"data": "documentoPersonaCliente"},
			{"data": "consecutivoCliente"},
			{"data": "codigoCliente"},
			{"data": "nombreComercialCliente"},
			{"data": "correoCliente"},
			{"data": "facebookCliente"},
			{"defaultContent": '<span class="label label-success estadoCliente">Activo</span>'},
			{"defaultContent": '<div class="btn-group"><button type="button" data-toggle="modal" class="btn btn-info btn-sm btnVerCliente" idDocumentoCliente><i class="fa fa-eye" title="Ver"></i></button><button type="button" class="btn btn-primary btn-sm btnEditarCliente" idDocumentoCliente><i class="fa fa-pencil" title="Editar"></i></button><button type="button" class="btn btn-danger btnDeshabilitarCliente btn-sm" idDocumentoCliente><i class="fa fa-times" title="Deshabilitar"></i></button><button type="button" class="btn btn-success btn-sm btnHabilitarCliente" idDocumentoCliente style="display:none;"><i class="fa fa-check" title="Habilitar"></i></button></div>'}
		]
	});
	
	$('#tablaClientes tbody').on('click', 'button', function() {
		
		var data = tablaClientes.row( $(this).parents('tr')).data();
		$(this).attr('idDocumentoCliente', data.documentoPersonaCliente);
	});
	
	function cargarEstadoCliente() {
		
		var estadoCliente = $('.estadoCliente');
		for(var i=0; i < estadoCliente.length; i++) {
			var data = tablaClientes.row( $(estadoCliente[i]).parents("tr")).data();
			if(data.estado == true) {
				$(estadoCliente[i]).attr("class", "label label-success");
				$(estadoCliente[i]).html('Activo');
			}
			else if(data.estado == false) {
				$(estadoCliente[i]).attr("class", "label label-danger");
				$(estadoCliente[i]).html('Inactivo');
			}
		}
	}
	
	function ocultarBotones() {
		
		var btnVerCliente = $('.btnVerCliente');
		for(var i=0; i < btnVerCliente.length; i++) {
			var data = tablaClientes.row( $(btnVerCliente[i]).parents("tr")).data();
			if(data.estado == true) {
				$(btnVerCliente[i]).attr("style", "display:block");
			}
			else if(data.estado == false) {
				$(btnVerCliente[i]).attr("style", "display:none");
			}
		}
		
		var btnEditarCliente = $('.btnEditarCliente');
		for(var i=0; i < btnEditarCliente.length; i++) {
			var data = tablaClientes.row( $(btnEditarCliente[i]).parents("tr")).data();
			if(data.estado == true) {
				$(btnEditarCliente[i]).attr("style", "display:block");
			}
			else if(data.estado == false) {
				$(btnEditarCliente[i]).attr("style", "display:none");
			}
		}
		
		var btnDeshabilitarCliente = $('.btnDeshabilitarCliente');
		for(var i=0; i < btnDeshabilitarCliente.length; i++) {
			var data = tablaClientes.row( $(btnDeshabilitarCliente[i]).parents("tr")).data();
			if(data.estado == true) {
				$(btnDeshabilitarCliente[i]).attr("style", "display:block");
			}
			else if(data.estado == false) {
				$(btnDeshabilitarCliente[i]).attr("style", "display:none");
			}
		}
		
		var btnHabilitarCliente = $('.btnHabilitarCliente');
		for(var i=0; i < btnHabilitarCliente.length; i++) {
			var data = tablaClientes.row( $(btnHabilitarCliente[i]).parents("tr")).data();
			if(data.estado == true) {
				$(btnHabilitarCliente[i]).attr("style", "display:none");
			}
			else if(data.estado == false) {
				$(btnHabilitarCliente[i]).attr("style", "display:block");
			}
		}
	}
	
	/**
	 * 
	 *Funcion para limpiar modal 
	 * 
	 */
	function limpiarModalCliente() {
		
		$('#myModalLabelCliente').html('');
		$('#detalleClienteDocumento').val('');
		$('#detalleClienteNombre').val('');
		$('#detalleClienteDireccionActual').val('');
		$('#detalleClienteTelefonoUno').val('');
		$('#detalleCodigoCliente').val('');
		$('#detalleClienteNombreComercial').val('');
		$('#detalleClienteCorreoElectronico').val('');
		$('#detalleClienteFacebook').val('');
	}
	
	/**
	 * 
	 *Ver detalles del Cliente
	 * 
	 */
	$('#tablaClientes tbody').on('click', 'button.btnVerCliente', function(){
		
		var documentoPersonaCliente = $(this).attr('idDocumentoCliente');
		console.log("documentoPersonaCliente: " + documentoPersonaCliente);
		$('#modalDetalleCliente').modal('show');
		limpiarModalCliente();
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/persona/persona/' + documentoPersonaCliente,
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#myModalLabelCliente').html('Cliente : ' + response.nombrePersona + ' ' + response.apellidoPaternoPersona + ' ' + response.apellidoMaternoPersona);
				$('#detalleClienteDocumento').val(response.documentoPersona);
				$('#detalleClienteNombre').val(response.nombrePersona + ' ' + response.apellidoPaternoPersona + ' ' + response.apellidoMaternoPersona);
				$('#detalleClienteDireccionActual').val(response.direccionActualPersona);
				$('#detalleClienteTelefonoUno').val(response.telefonoUnoPersona);
			}
		});
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/cliente/cliente/' + documentoPersonaCliente,
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#detalleCodigoCliente').val(response.codigoCliente);
				$('#detalleClienteNombreComercial').val(response.nombreComercialCliente);
				$('#detalleClienteCorreoElectronico').val(response.correoCliente);
				$('#detalleClienteFacebook').val(response.facebookCliente);
			}
		});
	});
	
	/**
	 * 
	 * Editar Cliente 
	 * 
	 */
	$('#tablaClientes tbody').on('click', 'button.btnEditarCliente', function() {
		
		var documentoPersonaCliente = $(this).attr('idDocumentoCliente');
		console.log("documentoPersonaCliente: " + documentoPersonaCliente);
		
		mostrarFormCliente(true);
		accion = true;
		$('#documentoPersonaCliente').attr('disabled', true);
		$('#documentoPersonaCliente').val(documentoPersonaCliente);
		$('#clienteNombrePersona').attr('disabled', true);
		$('#clienteApellidosPersona').attr('disabled', true);
		$('#inputConsecutivoCliente').show();
		$('#inputCodigoCliente').show();
		$('#consecutivoCliente').attr('disabled', true);
		$('#codigoCliente').attr('disabled', true);
		
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/persona/persona/' + documentoPersonaCliente,
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#clienteNombrePersona').val(response.nombrePersona);
				$('#clienteApellidosPersona').val(response.apellidoPaternoPersona + ' ' + response.apellidoMaternoPersona);
			}
		});
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/cliente/cliente/' + documentoPersonaCliente,
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#consecutivoCliente').val(response.consecutivoCliente);
				$('#codigoCliente').val(response.codigoCliente);
				$('#nombreComercialCliente').val(response.nombreComercialCliente);
				$('#correoCliente').val(response.correoCliente);
				$('#facebookCliente').val(response.facebookCliente);
				$("#codigoSexo option[value="+ response.sexo.codigoSexo +"]").attr("selected",true);
			}
		});
	});
	
	/**
	 * 
	 * Evento para deshabilitar Cliente
	 * 
	 */
	$('#tablaClientes tbody').on('click', 'button.btnDeshabilitarCliente', function() {
		
		var documentoPersonaCliente = $(this).attr('idDocumentoCliente');
		console.log("documentoPersonaCliente: " + documentoPersonaCliente);
		
		swal({
	        title: '¿Esta Seguro de deshabilitar a este Cliente ?',
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
	                 url: 'http://localhost:8080/api/v1/cliente/cliente/disabled/' + documentoPersonaCliente,
	                 type: 'GET',
	                 success: function(response){
	                	 
	                	 console.log(response);
	                     swal({
	                         type: "success",
	                         title: "El Cliente ha sido deshabilitado correctamente",
	                         showConfirmButton: true,
	                         confirmButtonText: "Cerrar",
	                         closeOnConfirm: false
	                     }).then((result) => {
	                         if(result.value) {
	                             $(location).attr("href", "/persona/view");
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
	 * Evento para habilitar el Cliente
	 * 
	 */
	$('#tablaClientes tbody').on('click', 'button.btnHabilitarCliente', function() {
		
		var documentoPersonaCliente = $(this).attr('idDocumentoCliente');
		console.log("documentoPersonaCliente: " + documentoPersonaCliente);
		
		swal({
	        title: '¿Esta Seguro de habilitar a este Cliente ?',
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
	        		
	        		url: 'http://localhost:8080/api/v1/cliente/cliente/enabled/' + documentoPersonaCliente,
	        		type: 'GET',
	        		success: function(response){
	        			
	        			console.log(response);
	        			
	        			swal({
	        				type: "success",
	                        title: "El Cliente ha sido habilitado correctamente",
	                        showConfirmButton: true,
	                        confirmButtonText: "Cerrar",
	                        closeOnConfirm: false
	                       }).then((result) => {
	                         if(result.value) {
	                            $(location).attr("href", "/persona/view");
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
	
	/**
	 * 
	 * Autocomplete para el Ubigeo
	 * 
	 */
	
	$("#nombreUbigeo").autocomplete({
		
		source: function(request, response) {
			
			$.ajax({
				url : "http://localhost:8080/api/v1/ubigeo/ubigeos/autocomplete/" + request.term,
				dataType : 'json',
				data : {
					term : request.term
				},
				success : function(data) {
					console.log(data);
					response($.map(data, function(item) {
						return {
							value: item.codigoUbigeo,
							label: item.nombreUbigeo,
							
						};
					}));
				},
			});
		},
		
		select: function(event, ui) {
			$("#nombreUbigeo").val(ui.item.label);
			$("#codigoUbigeo").val(ui.item.value);
			return false;
		}
	});
});
