/**
 * 
 */
$(document).on('ready', function() {
	
	
	setTimeout(function() {
		cargarTotalRegistrosUsuarios();
		cargarTotalRegistrosPersonas();
		cargarTotalRegistrosPersonita();
		cargarTotalRegistroEmpleados();
		cargarTotalRegistrosClientes();
	}, 2000);
	
	window.setInterval(
		    function(){
		    // Sección de código para modificar el DIV
		    // $("#miDiv").text(variable);
		    	$('#total').load(cargarTotalRegistrosPersona());
		    	evaluando();
		    // Ejemplo: Cada dos segundos se imprime la hora
		    /*console.log(Date());*/
		  }
		  // Intervalo de tiempo
		,5000);
	
	/**
	 * 
	 * funcion para cargar total registros 
	 *
	 */
	
	function cargarTotalRegistrosUsuarios() {
		
		$.ajax({
			
			type: 'GET',
			url: '/api/v1/usuario/totalRegistros',
			dataType: 'json',
			success: function(response) {
				
				$('#totalRegistrosUsuarios').html(response.data);
			}
		});
	}
	
	function cargarTotalRegistrosPersonas() {
		
		$.ajax({
			
			type: 'GET',
			url: '/api/v1/persona/totalRegistros',
			dataType: 'json',
			success: function(response) {
				
				$('#totalRegistrosPersonas').html(response.data);
			}
		});
	}
	
	function cargarTotalRegistroEmpleados() {
		
		$.ajax({
			
			type: 'GET',
			url: '/api/v1/empleado/totalRegistros',
			dataType: 'json',
			success: function(response) {
				
				$('#totalRegistroEmpleados').html(response.data);
			}
		});
	}
	
	function cargarTotalRegistrosClientes() {
		
		$.ajax({
			
			type: 'GET',
			url: '/api/v1/cliente/totalRegistros',
			dataType: 'json',
			success: function(response) {
				
				$('#totalRegistrosCliente').html(response.data);
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
	
	function cargarTotalRegistrosPersona() {
		
		
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
