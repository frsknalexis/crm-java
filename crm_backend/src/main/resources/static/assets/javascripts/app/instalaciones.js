$(document).on('ready', function() {
	
	redireccionarCortesView();
	
	/**
	 * 
	 *function para redireccionar a la vista de cortes
	 * 
	 */
	function redireccionarCortesView() {
		
		$('#buttonCortes').on('click', function() {
			$(location).attr('href', '/instalacion/cortes/view');
		});
	}
});