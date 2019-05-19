$(document).on('ready', function() {
	
	var tablaClientesPago;
	
	var tablaDeudasCliente;
	
	cargarTotalRegistrosPersonita();
	
	listarClientesPago();
	
	setTimeout(function() {
		mostrarFormRealizarPago(false);
	}, 100);
	
	window.setInterval(
		    function(){
		    // Sección de código para modificar el DIV
		    // $("#miDiv").text(variable);
		    	$('#total').load(cargarTotalRegistrosPersonas());
		    	evaluando();
		    // Ejemplo: Cada dos segundos se imprime la hora
		    /*console.log(Date());*/
		  }
		  // Intervalo de tiempo
		,5000);
	
	mostrarDatosRealizarPago();
	
	 disabledInputDatosCliente(true);
	
	cancelarAccionPago();
	
	cargarComboComprobante();
	
	validarInputsFormRealizarPago(); 
	
	realizarPago();
	
	verDeudaCliente();
	
	/**
	 * function para listar los clientesPago
	 * 
	 * */
	function listarClientesPago() {
		
		tablaClientesPago = $('#tablaClientesPago').dataTable({
			
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
				"url": "/api/v1/pago/clientes/clientesPago",
				"dataSrc": ""
			},
			"columns": [
				{"data": "documentoPersonaCliente"},
				{"data": "cliente"},
				{"data": "nombreComercialCliente"},
				{"data": "direccionActualCliente"},
				{"data": "referencia"},
				{"defaultContent": '<button type="button" class="btn btn-success btn-xs btnRegistrarPagoCliente" idDocumentoPersonaClientePago><i class="fa fa-credit-card"></i> Registrar Pago</button>'}
			]
		}).DataTable();
		
		$('#tablaClientesPago tbody').on('click', 'button', function() {
			var data = tablaClientesPago.row( $(this).parents('tr')).data();
			$(this).attr('idDocumentoPersonaClientePago', data.documentoPersonaCliente);
		});
	}
	
	/**
	 *
	 * function para mostrarFormGenerarPago
	 * 
	 */
	function mostrarFormRealizarPago(flag) {
		
		limpiarInputs();
		disabledInputDatosCliente(true);
		if(flag) {
			$('#mostrarListadoClientesPago').hide();
			$('#mostrarFormGenerarPago').show();
		}
		else {
			$('#mostrarListadoClientesPago').show();
			$('#mostrarFormGenerarPago').hide();
		}
	}
	
	/**
	 * 
	 *funcion para deshabilitar input datos cliente 
	 * 
	 */
	function disabledInputDatosCliente(flag) {
		if(flag) {
			$('#documentoPersonaClientePago').attr('disabled', true);
			$('#clientePago').attr('disabled', true);
			$('#nombreComercialPago').attr('disabled', true);
			$('#direccionClientePago').attr('disabled', true);
			$('#clienteReferenciaDireccionPago').attr('disabled', true);
		}
		else {
			$('#documentoPersonaClientePago').attr('disabled', false);
			$('#clientePago').attr('disabled', false);
			$('#nombreComercialPago').attr('disabled', false);
			$('#direccionClientePago').attr('disabled', false);
			$('#clienteReferenciaDireccionPago').attr('disabled', false);
		}
	}
	
	/**
	 * 
	 * funcion para limpiarInputs
	 * 
	 */
	function limpiarInputs() {
		$('#documentoPersonaClientePago').val('');
		$('#clientePago').val('');
		$('#nombreComercialPago').val('');
		$('#direccionClientePago').val('');
		$('#clienteReferenciaDireccionPago').val('');
		$('#codigoComprobante').val('');
		$('#cantidadPago').val('');
		$('#documentoPersonaPago').val('');
	}
	
	/**
	 * 
	 *funcion para cancelarAccionRealizarPago 
	 *
	 */
	function cancelarAccionPago() {
		
		$('#cancelarAccion').on('click', function() {
			mostrarFormRealizarPago(false);
			limpiarInputs();
			limpiarDatosModal();
		});
	}
	/**
	 * 
	 *function para mostrarDatosRealizarPago 
	 */
	function mostrarDatosRealizarPago() {
		
		$('#tablaClientesPago tbody').on('click', 'button.btnRegistrarPagoCliente', function() {
			
			var documentoPersonaCliente = $(this).attr('idDocumentoPersonaClientePago');
			mostrarFormRealizarPago(true);
			disabledInputDatosCliente(true);
			$.ajax({
				
				type: 'GET',
				url: '/api/v1/cliente/searchClientePago/' + documentoPersonaCliente,
				dataType: 'json',
				success: function(response) {
					console.log(response);
					$('#documentoPersonaClientePago').val(response.documentoPersonaCliente);
					$('#clientePago').val(response.cliente);
					$('#nombreComercialPago').val(response.nombreComercialCliente);
					$('#direccionClientePago').val(response.direccionActualCliente);
					$('#clienteReferenciaDireccionPago').val(response.referencia);
					
					$('#verDeudaCliente').attr('documentoPersonaCliente', response.documentoPersonaCliente);
					
					$('#myModalLabelDeudaCliente').html('Deuda Cliente: ' + response.cliente);
				}
			});
		});
	}
	
	/**
	 *
	 * function para cargar comboComprobante
	 * 
	 */
	function cargarComboComprobante() {
		
		var $codigoComprobante = $('#codigoComprobante');
		
		$.ajax({
			
			type: 'GET',
			url: '/api/v1/comprobante/comprobantes',
			dataType: 'json',
			success: function(response) {
				$codigoComprobante.html('');
				$codigoComprobante.append('<option value="">Seleccione un Comprobante</option>');
				for(var i = 0; i < response.length; i++) {
					$codigoComprobante.append('<option value="' + response[i].codigoComprobante + '">' + response[i].descripcionComprobante + '</option>');
				}
			}
		});
	}
	
	/**
	 * 
	 *function para validar inputs form pago 
	 */
	function validarInputsFormRealizarPago() {
		
		$('#realizarPagoCliente').on('click', function(e) {
			e.preventDefault();
			
			if($('#codigoComprobante').val().trim() == "" && $('#cantidadPago').val() == "") {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Debe llenar algunos los Campos !'
	            });
				return false;
			}
			else {
				
				if($('#codigoComprobante').val().trim() == "") {
					
					swal({
		                type: 'error',
		                title: 'Ooops',
		                text: 'Debe seleccionar un Tipo de Comprobante !'
		            });
					return false
				}
				if($('#cantidadPago').val() <= 0) {
					
					swal({
		                type: 'error',
		                title: 'Ooops',
		                text: 'Ingrese un valor valido para el Monto a Pagar !'
		            });
					
					$('#cantidadPago').val('');
					$('#cantidadPago').focus();
					return false
				}
			}
		});
		
		$('#documentoPersonaPago').on('change', function() {
			if(!($('#documentoPersonaPago').val().match(/^[0-9]{7,11}$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo DNI Pagador no permite caracteres especiales ni letras, ingrese un valor valido'
	            });
				
				$('#documentoPersonaPago').val('');
				$('#documentoPersonaPago').focus();
		    	return false;
			}
		});
		
		$('#cantidadPago').on('keyup', function() {
			
			var valor = $(this).val();
			console.log("valor: " + valor);
			
			if(parseInt(valor) <= 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Ingrese un valor valido para el Monto a Pagar'
	            });
				
				$(this).val('');
				$(this).focus();
			}
		});
	}
	
	/**
	 *
	 * function para realizar Pago
	 * 
	 */
	function realizarPago() {
		
		$('#realizarPagoCliente').on('click', function(e) {
			e.preventDefault();
			
			if($('#codigoComprobante').val().trim() != "" && $('#cantidadPago').val() > 0) {
				
				var formData = {
					documentoPersonaCliente: $('#documentoPersonaClientePago').val(),
					codigoComprobante: $('#codigoComprobante').val(),
					cantidadPago: $('#cantidadPago').val(),
					documentoPersonaPago: $('#documentoPersonaPago').val()
				};
				
				console.log(formData);
				
				$.ajax({
					
					type: 'POST',
					url: '/api/v1/pago/realizarPago',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response) {
						console.log(response);
						
						if(response.message == "HECHO") {
							
							swal({
								type: "success",
								title: "Se Realizo el Pago con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/pago/pagos');
								}
							});
						}
					},
					error: function() {
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Realizar Pago !'
			            });
					}
				});
			}
		})
	}
	
	/**
	 * 
	 *funcion para limpiar inputs del modal 
	 * 
	 */
	function limpiarDatosModal() {
		$('#myModalLabelDeudaCliente').html('');
	}
	
	/**
	 *
	 *function para listar deudas cliente  
	 * 
	 */
	function listarDeudasCliente(documentoPersonaCliente) {
		
		var flag = documentoPersonaCliente;
		
		tablaDeudasCliente = $('#tablaDeudaCliente').dataTable({
			
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
			"bDestroy": true,
			"ajax": {
				"url": "/api/v1/pago/clientes/listaMesesDeudas/" + flag,
				"dataSrc": ""
			},
			"columns": [
				{"data": "mesDeuda"},
				{"data": "anioValido"},
				{"data": "tipoServicio"},
				{"data": "sumaPago"},
				{"data": "descuento"},
				{"defaultContent": '<button type="button" class="btn btn-success btn-xs btnRealizarPagoDeudaCliente" documentoPersonaClientePagoDeuda mesDeuda anioValido tipoServicio sumaPago descuento><i class="fa fa-money"></i> Realizar Pago</button>'}
			]
		}).DataTable();
		
		$('#tablaDeudaCliente tbody').on('click', 'button', function() {
			
			var data = tablaDeudasCliente.row( $(this).parents('tr')).data();
			console.log(data);
			$(this).attr('documentoPersonaClientePagoDeuda', data.documentoPersonaCliente);
			$(this).attr('mesDeuda', data.mesDeuda);
			$(this).attr('anioValido', data.anioValido);
			$(this).attr('tipoServicio', data.tipoServicio);
			$(this).attr('sumaPago', data.sumaPago);
			$(this).attr('descuento', data.descuento);
		});
	}
	
	/**
	 * 
	 *funcion para ver deuda cliente 
	 */
	function verDeudaCliente() {
		
		$('#verDeudaCliente').on('click', function() {
			
			var documentoPersonaCliente = $(this).attr('documentoPersonaCliente');
			console.log("documentoPersonaCliente: " + documentoPersonaCliente);
			
			setTimeout(function() {
				$('#modalVerDeudaCliente').modal('show');
				listarDeudasCliente(documentoPersonaCliente);
				mostrarFormRealizarPagoDeuda();
			}, 2300);
			
			enabledFormPagoDeuda(false);
			
			cargarComboComprobantePagoDeuda();
			
			cancelarAccionPagoDeuda();
			
			validarFormPagoDeuda();
			
			realizarPagoMora();
			
			$.ajax({
				
				type: 'GET',
				url: '/api/v1/pago/clientes/listaMesesDeudas/' + documentoPersonaCliente,
				dataType: 'json',
				success: function(response) {
					
					if(response != null) {
						
					}
					else {
						console.log('No hay Datos');
					}
				}
			});
		});
	}
	
	/**
	 * 
	 * funcion para cargar combo comprobante pago deuda
	 * 
	 */
	function cargarComboComprobantePagoDeuda() {
		
		$codigoComprobantePagoDeuda = $('#codigoComprobantePagoDeuda');
		
		$.ajax({
			
			type: 'GET',
			url: '/api/v1/comprobante/comprobantes',
			dataType: 'json',
			success: function(response) {
				$codigoComprobantePagoDeuda.html('');
				$codigoComprobantePagoDeuda.append('<option value="">Seleccione un Comprobante</option>');
				for(var i = 0; i < response.length; i++) {
					$codigoComprobantePagoDeuda.append('<option value="' + response[i].codigoComprobante + '">' + response[i].descripcionComprobante + '</option>');
				}
			}
		});
	}
	
	/**
	 * 
	 *function para mostrar form pago deuda 
	 */
	function enabledFormPagoDeuda(flag) {
		
		limpiarFormPagoDeuda();
		if(flag) {
			$('#formPagoDeuda').show();
		}
		else {
			$('#formPagoDeuda').hide();
		}
	}
	
	/**
	 * 
	 * function para mostrar form realizar pago deuda
	 * 
	 */
	function mostrarFormRealizarPagoDeuda() {
		
		$('#tablaDeudaCliente tbody').on('click', 'button.btnRealizarPagoDeudaCliente', function() {
			
			var documentoPersonaClienteDeuda = $(this).attr('documentoPersonaClientePagoDeuda');
			var mesDeuda = $(this).attr('mesDeuda');
			var anioValido = $(this).attr('anioValido');
			var tipoServicio = $(this).attr('tipoServicio');
			var sumaPago = $(this).attr('sumaPago');
			var descuento = $(this).attr('descuento');
			
			console.log('documentoPersonaClienteDeuda: ' + documentoPersonaClienteDeuda);
			console.log('mesDeuda: ' +  mesDeuda);
			console.log('anioValido: ' + anioValido);
			console.log('tipoServicio: ' + tipoServicio);
			console.log('sumaPago: ' + sumaPago);
			console.log('descuento: ' + descuento);
			
			enabledFormPagoDeuda(true);
			
			$('#documentoPersonaClientePagoDeuda').val(documentoPersonaClienteDeuda);
			$('#tipoServicioDeudaCliente').val(tipoServicio);
			$('#montoPagoDeuda').val(sumaPago);
			$('#descuentoDeuda').val(descuento);
			$('#mesDeuda').val(mesDeuda);
			$('#anioValidoDeuda').val(anioValido);
		});
	}
	
	/**
	 * 
	 *function para limpiarFormPagoDeuda 
	 * 
	 */
	function limpiarFormPagoDeuda() {
		
		$('#documentoPersonaClientePagoDeuda').val('');
		$('#tipoServicioDeudaCliente').val('');
		$('#montoPagoDeuda').val('');
		$('#descuentoDeuda').val('');
		$('#mesDeuda').val('');
		$('#anioValidoDeuda').val('');
		$('#codigoComprobantePagoDeuda').val('');
		$('#cantidadPagoDeuda').val('');
		$('#documentoPersonaPagoDeuda').val('');
	}
	
	/**
	 *
	 * function para la accion cancelar pago deuda
	 *
	 */
	function cancelarAccionPagoDeuda() {
		
		$('#cancelarAccionPagoDeuda').on('click', function() {
			enabledFormPagoDeuda(false);
			limpiarFormPagoDeuda();
		})
	}
	
	/**
	 * 
	 *function para validar formPagoDeuda 
	 * 
	 */
	function validarFormPagoDeuda() {
		
		$('#realizarPagoDeudaCliente').on('click', function(e) {
			e.preventDefault();
			
			if($('#codigoComprobantePagoDeuda').val().trim() == "" && $('#cantidadPagoDeuda').val() == "") {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Debe llenar algunos los Campos !'
	            });
				return false;
			}
			else {
				
				if($('#codigoComprobantePagoDeuda').val().trim() == "") {
					
					swal({
		                type: 'error',
		                title: 'Ooops',
		                text: 'Debe seleccionar un Tipo de Comprobante !'
		            });
					return false
				}
				
				if($('#cantidadPagoDeuda').val() <= 0) {
					
					swal({
		                type: 'error',
		                title: 'Ooops',
		                text: 'Ingrese un valor valido para el Monto a Pagar !'
		            });
					
					$('#cantidadPagoDeuda').val('');
					$('#cantidadPagoDeuda').focus();
					return false
				}
			}
		});
		
		$('#documentoPersonaPagoDeuda').on('change', function() {
			if(!($('#documentoPersonaPagoDeuda').val().match(/^[0-9]{7,11}$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo DNI Pagador no permite caracteres especiales ni letras, ingrese un valor valido'
	            });
				
				$('#documentoPersonaPagoDeuda').val('');
				$('#documentoPersonaPagoDeuda').focus();
		    	return false;
			}
		});
		
		$('#cantidadPagoDeuda').on('keyup', function() {
			
			var valor = $(this).val();
			console.log("valor: " + valor);
			
			if(parseInt(valor) <= 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Ingrese un valor valido para el Monto a Pagar'
	            });
				
				$(this).val('');
				$(this).focus();
			}
		});
	}
	
	/**
	 *function para realizarPagoMora 
	 * 
	 */
	function realizarPagoMora() {
		
		$('#realizarPagoDeudaCliente').on('click', function(e) {
			e.preventDefault();
			
			if($('#codigoComprobantePagoDeuda').val().trim() != "" && $('#cantidadPagoDeuda').val() > 0) {
				
				var formDataPagoDeuda = {
						documentoPersonaClienteDeuda: $('#documentoPersonaClientePagoDeuda').val(),
						codigoComprobanteDeuda: $('#codigoComprobantePagoDeuda').val(),
						documentoPersonaPagoDeuda: $('#documentoPersonaPagoDeuda').val(),
						cantidadPagoDeuda: $('#cantidadPagoDeuda').val(),
						tipoServicio: $('#tipoServicioDeudaCliente').val(),
						montoPagoDeuda: $('#montoPagoDeuda').val(),
						descuento: $('#descuentoDeuda').val(),
						mes: $('#mesDeuda').val(),
						anioValido:$('#anioValidoDeuda').val()
				};
				
				console.log(formDataPagoDeuda);
				
				$.ajax({
					
					type: 'POST',
					url: '/api/v1/pago/realizarPagoMora',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formDataPagoDeuda),
					dataType: 'json',
					success: function(response) {
						console.log(response);
						
						swal({
							type: "success",
							title: "Se Realizo el Pago con exito",
							showConfirmButton: true,
							confirmButtonText: "Cerrar",
							closeOnConfirm: false
						}).then((result) => {

							if(result.value) {
								$(location).attr('href', '/pago/pagos');
							}
						});
						
					},
					error: function() {
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Realizar Pago !'
			            });
					}
				});
			}
		});
	}
	
	function cargarmensajesnoti(id){
		
		for(var i=1;i<=id;i++){
			if(i <= id){
				
				$.ajax({
					
					type: 'GET',
					url: '/api/v1/atencion/searchMensaje/' + i,
					dataType: 'json',
					success: function(response) {
						console.log(response);
						
						var tag = document.createElement("li");
						tag.innerHTML = '<span class="toggle">Jan</span>';
						
						var mensaje = response.nombrepersona;
						var respuesta = response.descripcionmensaje;
						var listNode = document.getElementById('agregarmensajesnoti');
						var liNode = document.createElement('li');
						var txtNode = document.createTextNode(mensaje);
						
						liNode.innerHTML = '<a href="#" class="clearfix"><figure class="image"><img src="http://clipart-library.com/images/8i6oer5KT.png" wight="40" height="40" alt="Joseph Junior" class="img-circle" /></figure><span class="title">' + String(mensaje) + '</span><span class="mensage">' + String(respuesta) + '</span></a>';
						listNode.appendChild(liNode);
					}
				});
			}
		}
	}
	
	
	function cargarmensajespopus(id){
		
		var i=1;
		
		var title = "Tareas Pendientes!!!";
		
		var position = "Bottom right";
		var duration = "1000";
		var theme = "warning";
		var closeOnClick = true;
		var displayClose =true;
		
		if(id === 0)
		{
			
		}else{
			
			for(i;i <= id;i++)
			{			
				if(i <= id){
					var message = "I am a default message" + i;
					window.createNotification({
						closeOnClick: closeOnClick,
						displayCloseButton: displayClose,
						positionClass: position,
						showDuration: duration,
						theme: theme
					})({
						title: title,
						message: message
					});
				}
			}
			
		}
	}
	
function estado(id){
		
		
		if(id !== 0){
			
			
			for(var i=1;i<=id;i++){
			if(i <= id){
				
				$.ajax({
					
					type: 'GET',
					url: '/api/v1/atencion/searchMensaje/' + i,
					dataType: 'json',
					success: function(response) {
						
						
						var tag = document.createElement("li");
						tag.innerHTML = '<span class="toggle">Jan</span>';
						
						var mensaje = response.nombrepersona;
						var respuesta = response.descripcionmensaje;
						var listNode = document.getElementById('agregarmensajesnoti');
						var liNode = document.createElement('li');
						var txtNode = document.createTextNode(mensaje);
						
						liNode.innerHTML = '<a href="#" class="clearfix"><figure class="image"><img src="http://clipart-library.com/images/8i6oer5KT.png" wight="40" height="40" alt="Joseph Junior" class="img-circle" /></figure><span class="title">' + String(mensaje) + '</span><span class="mensage">' + String(respuesta) + '</span></a>';
						listNode.appendChild(liNode);
					}
				});
			}
		}
	}
}
	
	function evaluando(){
		
		var estatico = null;
		var dinamico = null;
		var valuee = null;
		
		estatico = document.getElementsByName("canje")[0].value;
		dinamico = document.getElementsByName("canjes")[0].value;
		valuee = document.getElementsByName("canjess")[0].value;
		
		
		var verificando = valuee - dinamico;
		
		if(estatico === valuee && valuee === dinamico){
			console.log("inicio");
			estado(valuee);
			cargarmensajespopus(valuee);
			$('#canje').val("0");
		}
		if(verificando === 0){
			console.log("igual");
			estado(verificando);
			cargarmensajespopus(verificando);
			$('#canje').val("0");
		}
		if(verificando !== 0){
			console.log("nuevo");
			estado(verificando);
			cargarmensajespopus(verificando);
			$('#canje').val("0");
			$('#canjes').val(valuee);
		}
	}
function cargarTotalRegistrosPersonita() {
		
		
		var formData = {
				
		};
		
		$.ajax({
			
			type: 'POST',
			url: '/api/v1/atencion/obtenercantidad',
			headers: {
				"Content-Type": "application/json",
				"Accept": "application/json"
			},
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(response) {
				
				$('#total').html(response.message);
				$('#totalidad').html(response.message);
				$('#canje').val(response.message);
				$('#canjes').val(response.message);
				$('#canjess').val(response.message);
			}
			
		});	
		
	}

function cargarTotalRegistrosPersonas() {
	
	
	var formData = {
			
	};
	
	$.ajax({
		
		type: 'POST',
		url: '/api/v1/atencion/obtenercantidad',
		headers: {
			"Content-Type": "application/json",
			"Accept": "application/json"
		},
		data: JSON.stringify(formData),
		dataType: 'json',
		success: function(response) {
			
			$('#total').html(response.message);
			$('#totalidad').html(response.message);
			$('#canjess').val(response.message);
		}
		
	});	
	
}
});