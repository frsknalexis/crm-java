$(document).on('ready', function() {
	
	 comboServicio();
	 disabledAllButtons();
	 disabledInputContador(true);
	 
	 /**
	  * 
	  *function para deshabilitar todos los botones 
	  * 
	  */
	 function disabledAllButtons() {
		 
		 disabledButtonReprogramacionDelDia(true);
		 disabledButtonReprogramacionPendientes(true);
	 }
	
	/**
	 * 
	 *function para deshabilitar boton de reprogramacion de dia 
	 */
	function disabledButtonReprogramacionDelDia(flag) {
		
		if(flag) {
			$('#reprogramacionDelDia').attr('disabled', true);
		}
		else {
			$('#reprogramacionDelDia').attr('disabled', false);
		}
	}
	
	/**
	 * 
	 * function para deshabilitar boton de reprogramacion pendientes
	 * 
	 */
	function disabledButtonReprogramacionPendientes(flag) {
		
		if(flag) {
			$('#reprogramacionPendientes').attr('disabled', true);
		}
		else {
			$('#reprogramacionPendientes').attr('disabled', false);
		}
	}
	
	/**
	 * 
	 *funcion para limpiar el contador 
	 * 
	 */
	function limpiarContador() {
		
		$('#contador').val('');
	}
	
	/**
	 * 
	 *function para deshabilitar el input contador 
	 * 
	 */
	function disabledInputContador(flag) {
		
		if(flag) {
			$('#contador').attr('disabled', true);
		}
		else {
			$('#contador').attr('disabled', false);
		}
	}
	
	/**
	 * 
	 *function activar desactivar botones segun contador 
	 * 
	 */
	function activarDesactivarBotonesSegunContador(contador) {
			
		if(contador > 0) {
			disabledButtonReprogramacionPendientes(false);
			disabledButtonReprogramacionDelDia(true);
		}
		else if(contador == 0) {
			disabledButtonReprogramacionPendientes(true);
			disabledButtonReprogramacionDelDia(false);
		}
	}
	
	/**
	 * 
	 *function para llamar al contadorPendientesCable 
	 * 
	 */
	function contadorPendientesCable() {
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/detalleCuenta/contadorPendientesCable',
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#contador').val(response.data);
				var contador = $('#contador').val(response.data);
				contador = contador.val();
				console.log(contador);
				activarDesactivarBotonesSegunContador(contador);
			}
		});
	}
	
	/**
	 * 
	 *function para llamar al contadorPendientesInternet 
	 */
	function contadorPendientesInternet() {
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/detalleCuenta/contadorPendientesInternet',
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#contador').val(response.data);
				var contador = $('#contador').val(response.data);
				contador = contador.val();
				console.log(contador);
				activarDesactivarBotonesSegunContador(contador);
			}
		});
	}
	
	/**
	 *
	 * reprogramacion del dia internet
	 * 
	 */
	function reprogramacionDelDiaInternet() {
		
		$('#reprogramacionDelDia').on('click', function() {
			
			$.ajax({
				
				type: 'GET',
				url: 'http://localhost:8080/api/v1/detalleCuenta/reprogramacionInstalacionInternet',
				dataType: 'json',
				success: function(response) {
					console.log(response);
					
					if(response.status == "SUCCESS" && response.data == "HECHO") {
						
						swal({
							type: "success",
							title: "La Reprogramacion de Instalacion de Internet del Dia se realizo con exito",
							showConfirmButton: true,
							confirmButtonText: "Cerrar",
							closeOnConfirm: false
						}).then((result) => {

							if(result.value) {
								$(location).attr('href', '/detalleCuenta/reprogramacion/view');
							}
						});
					}
				}
			});
		});
	}
	
	/**
	 * 
	 * reprogramacion del dia cable
	 * 
	 */
	function reprogramacionDelDiaCable() {
		
		$('#reprogramacionDelDia').on('click', function() {
			
			$.ajax({
				
				type: 'GET',
				url: 'http://localhost:8080/api/v1/detalleCuenta/reprogramacionInstalacionCable',
				dataType: 'json',
				success: function(response) {
					console.log(response);
					
					if(response.status == "SUCCESS" && response.data == "HECHO") {
						
						swal({
							type: "success",
							title: "La Reprogramacion de Instalacion de Cable del Dia se realizo con exito",
							showConfirmButton: true,
							confirmButtonText: "Cerrar",
							closeOnConfirm: false
						}).then((result) => {

							if(result.value) {
								$(location).attr('href', '/detalleCuenta/reprogramacion/view');
							}
						});
					}
				}
			});
		});
	}
	
	/**
	 * 
	 *function para revalidar instalacion de cable 
	 *
	 */
	function revalidarInstalacionCable() {
		
		$('#reprogramacionPendientes').on('click', function() {
			
			$.ajax({
				
				type: 'GET',
				url : 'http://localhost:8080/api/v1/detalleCuenta/revalidandoInstalacionCable',
				dataType: 'json',
				success: function(response) {
					
					console.log(response);
					
					if(response.status == "SUCCESS" && response.data == "HECHO") {
						
						swal({
							type: "success",
							title: "Se Reprogramaron las Instalaciones de Cable Pendientes con Exito",
							showConfirmButton: true,
							confirmButtonText: "Cerrar",
							closeOnConfirm: false
						}).then((result) => {

							if(result.value) {
								$(location).attr('href', '/detalleCuenta/reprogramacion/view');
							}
						});
					}
				}
			});
		});
	}
	
	/**
	 * 
	 *function para revalidar instalaciones de internet
	 * 
	 */
	function revalidarInstalacionInternet() {
		
		$('#reprogramacionPendientes').on('click', function() {
			
			$.ajax({
				
				type: 'GET',
				url: 'http://localhost:8080/api/v1/detalleCuenta/revalidandoInstalacionInternet',
				dataType: 'json',
				success: function(response) {
					
					console.log(response);
					
					if(response.status == "SUCCESS" && response.data == "HECHO") {
						
						swal({
							type: "success",
							title: "Se Reprogramaron las Instalaciones de Internet Pendientes con Exito",
							showConfirmButton: true,
							confirmButtonText: "Cerrar",
							closeOnConfirm: false
						}).then((result) => {

							if(result.value) {
								$(location).attr('href', '/detalleCuenta/reprogramacion/view');
							}
						});
					}
				}
			});
		});
	}
	
	/**
	 * 
	 *funcion para el combo de servicios
	 * 
	 */
	function comboServicio() {
		
		$tipoServicio = $('#tipoServicio');
		
		$tipoServicio.on('change', function() {
			
			if($tipoServicio.val() == "") {
				disabledAllButtons();
				limpiarContador();
			}
			else if($tipoServicio.val() == "IC") {
				disabledAllButtons();
				limpiarContador();
				contadorPendientesInternet();
				reprogramacionDelDiaInternet();
				revalidarInstalacionInternet();
			}
			else if($tipoServicio.val() == "CC") {
				disabledAllButtons();
				limpiarContador();
				contadorPendientesCable();
				reprogramacionDelDiaCable();
				revalidarInstalacionCable();
			}
		});
	}
	
});