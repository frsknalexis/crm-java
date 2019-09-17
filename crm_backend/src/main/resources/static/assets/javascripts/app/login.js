$(document).on('ready', function() {
	
	login();
	
	function login() {
		
		$('#btnLogin').on('click', function(e) {
			e.preventDefault();
			
			if($('#username').val() != "" && $('#password').val() != "") {
				
				var formData = {
					nombreUsuario: $('#username').val(),
					passwordUsuario: $('#password').val()
				};
				
				console.log(formData);
				
				$.ajax({
					
					type: 'POST',
					url: '/crm-app/api/v1/usuario/searchUsuario',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response) {
						if(response != null) {
							if(response.habilitado == true) {
								$(location).attr('href', '/crm-app/dashboard');
							}
						}
						else {
							
							if(response == null) {
								
								swal({
					                type: 'error',
					                title: 'Ooops',
					                text: 'Error al Acceder al Sistema, verifique su usuario o contraseña !'
					            });
							}
						}
					}
				});
			}
		});
	}
});