$(document).on('ready', function() {
	
	var tablaClientesPago;
	
	listarClientesPago();
	
	setTimeout(function() {
		mostrarFormRealizarPago(false);
	}, 100);
	
	mostrarDatosRealizarPago();
	
	 disabledInputDatosCliente(true);
	
	cancelarAccionPago();
	
	cargarComboComprobante();
	
	validarInputsFormRealizarPago(); 
	
	realizarPago();
	
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
				"url": "http://localhost:8080/api/v1/pago/clientes/clientesPago",
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
				url: 'http://localhost:8080/api/v1/cliente/searchClientePago/' + documentoPersonaCliente,
				dataType: 'json',
				success: function(response) {
					console.log(response);
					$('#documentoPersonaClientePago').val(response.documentoPersonaCliente);
					$('#clientePago').val(response.cliente);
					$('#nombreComercialPago').val(response.nombreComercialCliente);
					$('#direccionClientePago').val(response.direccionActualCliente);
					$('#clienteReferenciaDireccionPago').val(response.referencia);
					$('#verDeudaCliente').attr('documentoPersonaCliente', response.documentoPersonaCliente);
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
			url: 'http://localhost:8080/api/v1/comprobante/comprobantes',
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
		})
	}
});