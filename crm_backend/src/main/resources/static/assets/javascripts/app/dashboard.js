/**
 * 
 */
$(document).on('ready', function() {
	
	setTimeout(function() {
		cargarTotalRegistrosUsuarios();
		cargarTotalRegistrosPersonas();
		cargarTotalRegistroEmpleados();
		cargarTotalRegistrosClientes();
	}, 2000);
	
	
	/**
	 * 
	 * funcion para cargar total registros 
	 *
	 */
	
	function cargarTotalRegistrosUsuarios() {
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/usuario/totalRegistros',
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#totalRegistrosUsuarios').html(response.data);
			}
		});
	}
	
	function cargarTotalRegistrosPersonas() {
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/persona/totalRegistros',
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#totalRegistrosPersonas').html(response.data);
			}
		});
	}
	
	function cargarTotalRegistroEmpleados() {
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/empleado/totalRegistros',
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#totalRegistroEmpleados').html(response.data);
			}
		});
	}
	
	function cargarTotalRegistrosClientes() {
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/cliente/totalRegistros',
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#totalRegistrosCliente').html(response.data);
			}
		});
	}
});
