$(document).on('ready', function() {
	
	recuperarUsuarioActual(); 
	/**
	 * 
	 * function recuperar usuario actual del sistema
	 * 
	 */
	function recuperarUsuarioActual() {
		
		$.ajax({
			
			type: 'GET',
			url: '/api/v1/usuario/usuarioLogueado',
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#nombreUsuarioLogueado').html(response.username);
				for(var i = 0; i < response.authorities.length; i++) {
					
				}
			}
		});
	}
});