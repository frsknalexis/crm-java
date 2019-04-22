$(document).on('ready', function() {
	
	disabledButtonGenerarCuenta(true);
	
	disabledInputs(false);
	
	buscarCliente();
	
	comboServicio(); 
	
	/**
	 * 
	 *Funcion para deshabilitar inicialmente el boton guardar cuenta 
	 */
	
	function disabledButtonGenerarCuenta(flag) {
		
		if(flag) {
			$('#generarCuenta').attr('disabled', true);
			$('#cancelarAccion').attr('disabled', true);
		}
		else {
			$('#generarCuenta').attr('disabled', false);
			$('#cancelarAccion').attr('disabled', false);
		}
	}
	
	/**
	 * 
	 *Limpiar formulario 
	 * 
	 */
	function limpiarForm() {
		
		$('#documentoPersonaCliente').val('');
		$('#detalleCuentaCliente').val('');
		$('#detalleCuentaDireccion').val('');
		$('#detalleCuentaReferenciaDireccion').val('');
		$('#detalleCuentaAnio').val('');
		$('#detalleCuentaObservacion').val('');
	}
	
	/**
	 * 
	 *funcion para deshabilitar los inputs 
	 * 
	 */
	function disabledInputs(flag) {
		
		if(flag) {
			$('#documentoPersonaCliente').attr('disabled', true);
			$('#detalleCuentaCliente').attr('disabled', true);
			$('#detalleCuentaDireccion').attr('disabled', true);
			$('#detalleCuentaReferenciaDireccion').attr('disabled', true);
			$('#detalleCuentaAnio').attr('disabled', true);
		}
		else {
			$('#documentoPersonaCliente').attr('disabled', false);
			$('#detalleCuentaCliente').attr('disabled', false);
			$('#detalleCuentaDireccion').attr('disabled', false);
			$('#detalleCuentaReferenciaDireccion').attr('disabled', false);
			$('#detalleCuentaAnio').attr('disabled', false);
		}
	}
	
	/**
	 * 
	 *funcion para cancelar acciones 
	 * 
	 */
	function cancelarAccion() {
		
		$('#cancelarAccion').on('click', function() {
			
			limpiarForm();
			disabledInputs(false);
		});
	}
	
	/**
	 *
	 * Funcion para buscar cliente por
	 * 
	 */
	function buscarCliente() {
		
		$('#buscarCliente').on('click', function(e) {
			e.preventDefault();
			
			if($('#busqueda').val().match(/^[0-9]{7,11}$/)) {
				
				var formData = {
						documentoPersona: $('#busqueda').val()
				};
				
				console.log(formData);
				
				$.ajax({
					
					type: 'POST',
					url: 'http://localhost:8080/api/v1/cliente/searchCliente',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response) {
						
						if(response != null) {
							console.log(response);
							$('#documentoPersonaCliente').val(response.documentoPersona);
							$('#detalleCuentaCliente').val(response.cliente);
							$('#detalleCuentaDireccion').val(response.direccionPersona);
							$('#detalleCuentaReferenciaDireccion').val(response.referenciaPersona);
							$('#detalleCuentaAnio').val(response.anio);
							disabledInputs(true);
						}
						else if(response == null) {
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'No se encontro al Cliente, verifique si existe!'
				            });
							
							disabledInputs(false);
							limpiarForm();
						}
						
						$('#busqueda').val('');
					},
					error: function() {
						
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Buscar Cliente !'
			            });
					}
				});
			}
			
			if(!($('#busqueda').val().match(/^[0-9]{7,11}$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Debe ingresar un valor valido de DNI/RUC para realizar la busqueda'
	            });
				
				$('#busqueda').val('');
				$('#busqueda').focus();
		    	return false;
			}
		});
	}
	
	/***
	 * 
	 *function para verificar que el cliente se registro  
	 * 
	 */
	function verificarCliente() {
		
		$('#generarCuenta').on('click', function(e) {
			
			e.preventDefault();
			if($('#documentoPersonaCliente').val() == "" && $('#detalleCuentaCliente').val() == ""
				&& $('#detalleCuentaDireccion').val() == "" && $('#detalleCuentaReferenciaDireccion').val() == "") {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Debe Ingresar un  Cliente !'
	            });
			}
		});
	}
	
	/**
	 * 
	 *funcion para generarCuentaInternetColor 
	 * 
	 */
	function generarCuentaInternetColor() {
		
		$('#generarCuenta').on('click', function(e) {
			
			e.preventDefault();
			if($('#documentoPersonaCliente').val().match(/^[0-9]{7,11}$/)) {
				
				var formDataIC = {
						documentoPersonaCliente: $('#documentoPersonaCliente').val(),
						observacionDetalleCuenta: $('#detalleCuentaObservacion').val()
				};
				console.log(formDataIC);
				
				$.ajax({
					
					type: 'POST',
					url: 'http://localhost:8080/api/v1/detalleCuenta/saveCuentaInternet',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formDataIC),
					dataType: 'json',
					success: function(response) {
						
						console.log(response);
						
						if(response.status =="CREATED") {
							
							swal({
								type: "success",
								title: "Se Genero la Cuenta de Internet con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/detalleCuenta/generarCuenta/view');
								}
							});
						}
					},
					error: function() {
						
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Generar Cuenta de Internet !'
			            });
					}
				});
			}
		});
	}
	
	/**
	 * 
	 *funcion para generarCuentaCableColor 
	 * 
	 */
	function generarCuentaCableColor() {
		
		$('#generarCuenta').on('click', function(e) {
			
			e.preventDefault();
			if($('#documentoPersonaCliente').val().match(/^[0-9]{7,11}$/)) {
				
				var formDataCC = {
					documentoPersonaCliente: $('#documentoPersonaCliente').val(),
					observacionDetalleCuenta: $('#detalleCuentaObservacion').val()
				};
				
				console.log(formDataCC);
				
				$.ajax({
					
					type: 'POST',
					url: 'http://localhost:8080/api/v1/detalleCuenta/saveCuentaCable',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formDataCC),
					dataType: 'json',
					success: function(response) {
						
						console.log(response);
						
						if(response.status =="CREATED") {
							
							swal({
								type: "success",
								title: "Se Genero la Cuenta de Cable con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/detalleCuenta/generarCuenta/view');
								}
							});
						}
					},
					error: function() {
						
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Generar Cuenta de Cable !'
			            });
					}
				});
			}
		});
	}
	
	/**
	 * 
	 *funcion para el combo de servicios 
	 * 
	 */
	function comboServicio() {
		
		var $tipoServicio = $('#tipoServicio');
		
		$tipoServicio.on('change', function() {
			
			if($tipoServicio.val() == "") {
				limpiarForm();
				disabledInputs(false);
				disabledButtonGenerarCuenta(true);
				console.log('vacio');
			}
			else if($tipoServicio.val() == "IC") {
				
				disabledButtonGenerarCuenta(false);
				cancelarAccion();
				verificarCliente();
				generarCuentaInternetColor();
				console.log('Internet Color');
			}
			else if($tipoServicio.val() == 'CC') {
				disabledButtonGenerarCuenta(false);
				cancelarAccion();
				verificarCliente();
				generarCuentaCableColor();
				console.log('Cable Color');
			}
		});
	}
});