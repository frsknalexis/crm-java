/**
 * 
 */

$(document).on('ready', function() {
	
	setTimeout(function() {
		mostrarForm(false);
	}, 200);
	
	$.ajax({
		
		type: 'GET',
		url: 'http://localhost:8080/api/v1/persona/personas/listByCreadoPor',
		dataType: 'json',
		success: function(response){
			console.log(response);
		}
	});
	
	var tabla = $('#tablaPersonas').DataTable({
		
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
			"url": "http://localhost:8080/api/v1/persona/personas/listByCreadoPor",
			"dataSrc": ""
		},
		"columns": [
			{"data": "documentoPersona"},
			{"data": "nombrePersona"},
			{"data": "apellidoPaternoPersona"},
			{"data": "apellidoMaternoPersona"}
		]		
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
	
	function cancelarForm() {
		limpiar();
		mostrarForm(false);
	}
	
	$('#btnAgregarPersona').on('click', function() {
		
		mostrarForm(true);
	});
	
	$('#cancelarAccion').on('click', function() {
		
		cancelarForm();
	});
	
	$('#guardarPersona').on('click', function(e) {
		e.preventDefault();
		
		if($('#documentoPersona').val().match(/^[0-9]{8,11}$/) && $('#nombreUbigeo').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/)
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
			
			var flag = true;
			
			if(flag) {
				
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
								title: "Usuario: " + response.data.nombrePersona + " Registrado con exito",
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
			
			if(!($('#documentoPersona').val().match(/^[0-9]{8,11}$/))) {
				
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
				
				else if(!($('#telefonoDosPersona').val().match(/^[0-9]{7,9}$/))) {
					
					swal({
		                type: 'error',
		                title: 'Ooops',
		                text: 'El campo Telefono o Celular Dos no permite caracteres especiales, ni letras'
		            });
			    	
					$('#telefonoDosPersona').val('');
			    	$('#telefonoDosPersona').focus();
			    	return false;
				}
			}
		}
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
