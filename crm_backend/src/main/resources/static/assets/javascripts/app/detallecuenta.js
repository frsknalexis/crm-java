$(document).on('ready', function() {
	
	
	disabledButtonGenerarCuenta(true);
	
	disabledInputs(false);
	
	buscarCliente();
	
	cargarTotalRegistrosPersonita();
	
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
			disabledInputs(true);
			disabledButtonGenerarCuenta(true);
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
					url: '/api/v1/cliente/searchCliente',
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
					url: '/api/v1/detalleCuenta/saveCuentaInternet',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formDataIC),
					dataType: 'json',
					success: function(response) {
						
						console.log(response);
						
						if(response.status == "CREATED" && response.message == "HECHO") {
							
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
						else if(response.status == "ERROR" && response.message == "SERVICIO OPERANDO") {
							
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'Ya se Genero la Cuenta de Internet para el Cliente, verifique el estado del Servicio !'
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
					url: '/api/v1/detalleCuenta/saveCuentaCable',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formDataCC),
					dataType: 'json',
					success: function(response) {
						
						console.log(response);
						
						if(response.status =="CREATED" && response.message == "HECHO") {
							
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
						else if(response.status == "ERROR" && response.message == "SERVICIO OPERANDO") {
							
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'Ya se Genero la Cuenta de Cable para el Cliente, verifique el estado del Servicio !'
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
				
				limpiarForm();
				disabledInputs(true);
				disabledButtonGenerarCuenta(false);
				cancelarAccion();
				verificarCliente();
				generarCuentaInternetColor();
				console.log('Internet Color');
			}
			else if($tipoServicio.val() == 'CC') {
				
				limpiarForm();
				disabledInputs(true);
				disabledButtonGenerarCuenta(false);
				cancelarAccion();
				verificarCliente();
				generarCuentaCableColor();
				console.log('Cable Color');
			}
		});
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
});