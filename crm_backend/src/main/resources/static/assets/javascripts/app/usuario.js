/**
 * 
 */

$(document).on('ready', function() {
	
	
	limpiarFormulario();
	
	var table = $('#datatable-default').DataTable({
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
		    		"bProcessing": true,
		    		"ajax": {
		    			"url": "http://localhost:8080/api/v1/usuario/usuarios",
		    			"dataSrc": ""
		    		},
		    		"columns": [
		    			{ "data": "usuarioId" },
		    			{ "data": "nombreUsuario" },
		    			{ "data": "passwordUsuario" },
		    			{ "data": "documentoUsuario" },
		    			{ "defaultContent": '<span class="label label-success estadoUsuario">Activo</span>'},
		    			{ "defaultContent": '<div class="btn-group"><button type="button" data-toggle="modal" class="btn btn-info btn-sm btnEditarUsuario" idUsuario><i class="fa fa-pencil" title="Editar"></i></button><button type="button" class="btn btn-danger btnDeshabilitarUsuario btn-sm" idUsuario><i class="fa fa-times" title="Deshabilitar"></i></button><button type="button" class="btn btn-success btn-sm btnHabilitarUsuario" idUsuario><i class="fa fa-check" title="Habilitar"></i></button></div>' }
		    		]});
	 
	
	 $('#datatable-default tbody').on('click', 'button', function() {
		 var data = table.row( $(this).parents('tr') ).data();
		 $(this).attr('idUsuario', data.usuarioId);
	 });
	 
	function cargarEstado(){
		
		var estadoUsuario = $('.estadoUsuario');
		for(var i=0; i < estadoUsuario.length; i++) {

			var data = table.row($(estadoUsuario[i]).parents("tr")).data();
			if(data.habilitado == true) {
				$(estadoUsuario[i]).attr("class", "label label-success");
				$(estadoUsuario[i]).html('Activo');
			}
			else if(data.habilitado == false) {
				$(estadoUsuario[i]).attr("class", "label label-danger");
				$(estadoUsuario[i]).html('Inactivo');
			}
		}
	}
	
	function ocultarBotones() {
		
		var btnHabilitarUsuario = $('.btnHabilitarUsuario');
		for(var i=0; i < btnHabilitarUsuario.length; i++) {
			var data = table.row($(btnHabilitarUsuario[i]).parents("tr")).data();
			if(data.habilitado == true) {
				$(btnHabilitarUsuario[i]).hide();
			}
			else if(data.habilitado == false){
				$(btnHabilitarUsuario[i]).show();
			}
		}
		
		var btnDeshabilitarUsuario = $('.btnDeshabilitarUsuario');
		for(var i=0; i < btnDeshabilitarUsuario.length; i++){
			var data = table.row($(btnDeshabilitarUsuario[i]).parents("tr")).data();
			if(data.habilitado == true) {
				$(btnDeshabilitarUsuario[i]).show();
			}
			else if(data.habilitado == false) {
				$(btnDeshabilitarUsuario[i]).hide();
			}
		}
		
		var btnEditarUsuario = $('.btnEditarUsuario');
		for(var i=0; i <  btnEditarUsuario.length; i++) {
			var data = table.row($(btnEditarUsuario[i]).parents("tr")).data();
			if(data.habilitado == true) {
				$(btnEditarUsuario[i]).show();
			}
			else if(data.habilitado == false) {
				$(btnEditarUsuario[i]).hide();
			}
		}
	}

	
	setTimeout(function(){
		cargarEstado();
		ocultarBotones();
	}, 1000)
			
	$('#btnAgregarUsuario').on('click', function() {
		
		$('#modalAgregarUsuario').modal('show');
		$('#modalAgregarUsuario .modal-title').html('Nuevo Usuario');
	});
	
	$('#guardarUsuario').click(function(e) {
		
		e.preventDefault();
		
		if($('#nombreUsuario').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ0-9\s]+$/) 
			&& $('#passwordUsuario').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ0-9\s]+$/)
			&& $('#documentoUsuario').val().match(/^[0-9]+$/)) {
			
			var formData = {
				
					usuarioId: $('#usuarioId').val(),
					nombreUsuario: $('#nombreUsuario').val(),
					passwordUsuario: $('#passwordUsuario').val(),
					documentoUsuario: $('#documentoUsuario').val()
			};
			
			if(formData.usuarioId) {
				var usuarioId = formData.usuarioId;
				console.log('usuarioId: ' + usuarioId);
				
				$.ajax({
					
					type: 'POST',
					url: 'http://localhost:8080/api/v1/usuario/saveOrUpdate',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response){
						console.log(response);
						
						if(response.status == "UPDATED") {
							
							swal({
								type: "success",
								title: "Usuario Actualizado con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/usuario/view');
								}
							});
						}
						else if(response.status == 'ERROR') {
							
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'Ocurrio un Error al Actualizar al Usuario, verifique su Numero Documento !'
				            });
						}	
					},
					error: function(){
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Actualizar Usuario !'
			            });
					}
				});
			}
			else {
				
				$.ajax({
					
					type: 'POST',
					url: 'http://localhost:8080/api/v1/usuario/saveOrUpdate',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response){
						console.log(response);
						
						if(response.status == 'CREATED') {
							
							swal({
								type: "success",
								title: "Usuario: " + response.data.nombreUsuario + " Registrado con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/usuario/view');
								}
							});
						}
						else if(response.status == 'ERROR') {
							
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'Ocurrio un Error al Registrar al Usuario: '+ response.data.nombreUsuario +', verifique su Numero Documento !'
				            });
						}
					},
					error: function() {
						
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Registrar Usuario !'
			            });
					}
				});
			}
		}
		
		if($('#nombreUsuario').val() == "" && $('#passwordUsuario').val() == "" && $('#documentoUsuario').val() == "") {
			
			swal({
                type: 'error',
                title: 'Ooops',
                text: 'Debe llenar todos los Campos !'
            });
			
			return false;
		}
		else {
			
			if($('#nombreUsuario').val() == "" || $('#nombreUsuario').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Nombre Usuario no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#nombreUsuario').focus();
		    	return false;
			}
			
			if($('#passwordUsuario').val() == "" || $('#passwordUsuario').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Password no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#passwordUsuario').focus();
		    	return false;
			}
			
			if($('#documentoUsuario').val() == "" || $('#documentoUsuario').val() == 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Documento Usuario no puede estar vacio, ingrese un valor valido'
	            });
		    	
		    	$('#documentoUsuario').focus();
		    	return false;
			}
			
			if(!($('#nombreUsuario').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ0-9\s]+$/))) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'El campo Nombre Usuario no permite caracteres especiales'
	            });
				
				$('#nombreUsuario').val('');
				$('#nombreUsuario').focus();
		    	return false;
			}
			else {
				
				if(!($('#passwordUsuario').val().match(/^[a-zA-ZñÑáéíóúÁÉÍÓÚ0-9\s]+$/))) {
					
					swal({
		                type: 'error',
		                title: 'Ooops',
		                text: 'El campo Password no permite caracteres especiales'
		            });
					
					$('#passwordUsuario').val('');
					$('#passwordUsuario').focus();
			    	return false;
				}
				else {
					
					if(!($('#documentoUsuario').val().match(/^[0-9]+$/))) {
					
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'El campo Documento Usuario no permite caracteres especiales ni letras'
			            });
						
						$('#documentoUsuario').val('');
						$('#documentoUsuario').focus();
				    	return false;
					}
				}
			}
		}
	});
	
	$('#datatable-default tbody').on('click', 'button.btnEditarUsuario', function() {
		var usuarioId = $(this).attr('idUsuario');
		console.log("usuarioId: " + usuarioId);
			
		$('#modalAgregarUsuario').modal('show');
		
		$('#modalAgregarUsuario .modal-title').html('Editar Usuario');
		
		$.ajax({
			
			type: 'GET',
			url: 'http://localhost:8080/api/v1/usuario/usuario/' + usuarioId,
			dataType: 'json',
			success: function(response){
				console.log(response);
				$('#usuarioId').val(response.usuarioId);
				$('#nombreUsuario').val(response.nombreUsuario);
				$('#passwordUsuario').val(response.passwordUsuario);
				$('#documentoUsuario').val(response.documentoUsuario);
			}
		});
		
	});
	
	$('.close').on('click', function() {
		limpiarFormulario();
	});
	
	$('#cancelarAccion').on('click', function() {
		limpiarFormulario();
	});
			
	/***
	 * 
	 * Metodo para deshabilitar Usuario
	 * 
	 */
	$('#datatable-default tbody').on('click', 'button.btnDeshabilitarUsuario', function() {
		
		var usuarioId = $(this).attr('idUsuario');
		console.log("usuarioId: " + usuarioId);
		
		swal({
	        title: '¿Esta Seguro de deshabilitar a este Usuario ?',
	        text: '¡Si no lo esta puede Cancelar la accion!',
	        type: 'warning',
	        showCancelButton: true,
	        confirmButtonColor: '#3085d6',
	        cancelButtonColor: '#d33',
	        cancelButtonText: 'Cancelar',
	        confirmButtonText: '¡Si, deshabilitar !'
	    }).then((result) => {
	        if(result.value){
	           
	        	 $.ajax({
	                 url: 'http://localhost:8080/api/v1/usuario/usuario/disabled/' + usuarioId,
	                 type: 'GET',
	                 success: function(response){
	                	 
	                	 console.log(response);
	                     swal({
	                         type: "success",
	                         title: "El Usuario: " + response.data.nombreUsuario + " ha sido deshabilitado correctamente",
	                         showConfirmButton: true,
	                         confirmButtonText: "Cerrar",
	                         closeOnConfirm: false
	                     }).then((result) => {
	                         if(result.value) {
	                             $(location).attr("href", "/usuario/view");
	                         }
	                     })
	                 }
	             });
	        }
	        else {
	            swal({
	                type: "error",
	                title: "Cancelado", 
	                text: "Usted ha cancelado la acción de deshabilitar"
	            });
	        }
	    });
	});
	
	/**
	 * Metodo para habilitar Usuario
	 * 
	 * */
	$('#datatable-default tbody').on('click', 'button.btnHabilitarUsuario', function() {
		
		var usuarioId = $(this).attr('idUsuario');
		console.log("usuarioId: " + usuarioId);
		
		swal({
	        title: '¿Esta Seguro de habilitar a este Usuario ?',
	        text: '¡Si no lo esta puede Cancelar la accion!',
	        type: 'warning',
	        showCancelButton: true,
	        confirmButtonColor: '#3085d6',
	        cancelButtonColor: '#d33',
	        cancelButtonText: 'Cancelar',
	        confirmButtonText: '¡Si, habilitar !'
	    }).then((result) => {
	        if(result.value){
	           
	        	$.ajax({
	        		
	        		url: 'http://localhost:8080/api/v1/usuario/usuario/enabled/' + usuarioId,
	        		type: 'GET',
	        		success: function(response){
	        			
	        			console.log(response);
	        			
	        			swal({
	        				type: "success",
	                        title: "El Usuario: " + response.data.nombreUsuario + " ha sido habilitado correctamente",
	                        showConfirmButton: true,
	                        confirmButtonText: "Cerrar",
	                        closeOnConfirm: false
	                       }).then((result) => {
	                         if(result.value) {
	                            $(location).attr("href", "/usuario/view");
	                        }
	                     })
	                 }
	        	});
	        }
	        else {
	            swal({
	                type: "error",
	                title: "Cancelado", 
	                text: "Usted ha cancelado la acción de habilitar"
	            });
	        }
	    });
	});
});

function limpiarFormulario() {
	
	$('#usuarioId').val('');
	$('#nombreUsuario').val(''),
	$('#passwordUsuario').val(''),
	$('#documentoUsuario').val('')
}
