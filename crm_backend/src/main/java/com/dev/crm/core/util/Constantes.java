package com.dev.crm.core.util;

public class Constantes {

	public static final String DASHBOARD_VIEW = "dashboard";
	public static final String DASHBOARD_VIEW2 = "dashboard2";
	public static final String USUARIO_VIEW = "modulo-personas/usuario/usuario";
	public static final String PERSONA_VIEW = "modulo-personas/persona/persona";
	public static final String EMPLEADO_VIEW = "modulo-personas/empleado/empleado";
	public static final String DETALLE_CUENTA_VIEW = "modulo-servicios/detallecuenta/detallecuenta";
	public static final String REPROGRAMACION_VIEW = "modulo-servicios/detallecuenta/reprogramacion";
	public static final String PAGOS_VIEW = "modulo-pagos/pagos/pago";
	public static final String ATENCION_VIEW = "modulo-atencion/herramienta/herramienta";
	public static final String HERRAMIENTAS_VIEW = "modulo-atencion/herramientas/herramientas";
	public static final String RECLAMO_VIEW= "modulo-atencion/reclamo/view";
	public static final String RECLAMOS_VIEW= "modulo-atencion/herramienta/index";
	public static final String TAREA_VIEW= "modulo-notificacion/tarea/view";
	public static final String CORTE_VIEW = "modulo-servicios/instalacion/cortes";
	public static final String INSTALACIONES_VIEW = "modulo-servicios/instalacion/instalaciones";
	
	public static final String SP_ACTIVAR_DESACTIVAR_CLIENTE = "sp_activar_desactivar";
	public static final String SP_LISTA_PERSONA_NO_EMPLEADO = "sp_lista_persona_no_empleado";
	public static final String SP_INSERCION_EMPLEADO = "sp_insercion_empleado";
	public static final String SP_ACTUALIZAR_EMPLEADO = "sp_actualizar_empleado";
	public static final String SP_ACT_DES_EMPLEADO = "sp_act_des_empleado";
	public static final String SP_LISTAR_PERSONA_EMPLEADO= "sp_listar_persona_empleado";
	public static final String SP_LISTAR_EMPLEADOS_INT_EXT = "sp_listar_empleados_int_ext";
	public static final String SP_BUSCAR_PERSONA_CLIENTE_VENDEDOR = "sp_buscar_persona_cliente_vendedor";
	public static final String SP_INSERCION_CUENTA_INTERNET = "sp_insercion_cuenta_internet";
	public static final String SP_INSERCION_CUENTA_CABLE ="sp_insercion_cuenta_cable";
	public static final String SP_REPROGRAMAR_INSTALACION_CABLE = "sp_reprogramar_insta_cable";
	public static final String SP_REPROGRAMAR_INSTALACION_INTERNET = "sp_reprogramar_insta_internet";
	public static final String SP_REVALIDANDO_FECHA_CABLE = "sp_revalidando_fecha_cable";
	public static final String SP_REVALIDANDO_FECHA_INTERNET = "sp_revalidando_fecha_internet";
	public static final String SP_CONTADOR_PENDIENTES_CABLE = "sp_contador_pendientes_cable";
	public static final String SP_CONTADOR_PENDIENTES_INTERNET = "sp_contador_pendientes_internet";
	public static final String SP_PAGO_SERVICIO = "sp_pago_servicio";
	public static final String SP_LISTAR_CLIENTE_VENDEDOR = "sp_listar_cliente_vendedor";
	public static final String SP_BUSCAR_CLIENTE_PAGO = "sp_buscar_cliente_pago";
	public static final String SP_LISTAR_COMPROBANTE = "sp_listar_comprobante";
	public static final String SP_MESES_DEUDAS = "sp_meses_deudas";
	public static final String SP_PAGO_MORA = "sp_insercion_pago_mora";
	public static final String SP_LISTAR_CLIENTES_ATENCION = "sp_listar_clientes_atencion";
	public static final String SP_LISTAR_DATOS_GENERALES_CLIENTE = "sp_listar_datos_generales_cliente";
	public static final String SP_LISTAR_CLIENTES_ATENCION_DETALLE = "sp_listar_clientes_atencion_detalle";
	public static final String SP_LISTAR_HERRAMIENTA_GENERAL = "sp_listar_herramienta_general";
	public static final String SP_INSERCCION_HERRAMIENTA = "sp_inserccion_herramienta";
	public static final String SP_INSERCCION_DETALLE_HERRAMIENTA = "sp_inserccion_detalle_herramienta";
	public static final String SP_BUSQUEDA_HERRAMIENTA = "sp_envio_herramienta";
	public static final String SP_LISTAR_PREGUNTAS = "sp_listar_detalle_herramienta";
	public static final String SP_LISTAR_DATOS_GENERAL_HERRAMIENTA = "sp_listar_datos_herramienta";
	public static final String SP_EDITAR_HERRAMIENTA = "sp_update_herramienta";
	public static final String SP_EDITAR_PREGUNTA = "sp_update_pregunta";
	public static final String SP_GUARDAR_RECLAMO = "sp_inserccion_reclamo";
	public static final String SP_LISTAR_EMPLEADO_GENERAL_EXT_INT = "sp_listar_empleados_int_ext";
	public static final String SP_ESTADO_PLANTA = "sp_ubicacion_empleado_planta";
	public static final String SP_EDITAR_TAREA = "sp_update_tarea";
	public static final String SP_LISTAR_COMBO_TECNICO = "sp_combo_asignar_tecnico";
	public static final String SP_LISTAR_RECLAMO = "sp_listar_Reclamo";
	public static final String SP_LISTAR_TAREA = "sp_listar_tarea";
	public static final String SP_EDITAR_RECLAMO_TECNICO = "sp_update_reclamo_tecnico";
	public static final String SP_CANTIDAD_TAREA = "sp_noti_tarea";
	public static final String SP_RECUPERAR_MENSAJE_NOTI = "sp_recuperar_noti_mensajes";
	public static final String SP_LISTAR_CORTE_INTERNET = "sp_listar_corte";
	public static final String SP_UPDATE_SERVICIO_INTERNET = "sp_update_servicio_internet";
	public static final String SP_LISTAR_INSTALACION_DIA_INTERNET = "sp_listar_instalacion_dia";
	
	public static final boolean HABILITADO = true;
	public static final boolean INHABILITADO = false;
	public static final String EMPTY = "";
	
	public static final String CREATED_STATUS = "CREATED";
	public static final String UPDATED_STATUS  = "UPDATED";
	public static final String ERROR_STATUS = "ERROR";
	public static final String SUCCESS_STATUS = "SUCCESS";
	
	public static final String MESSAGE_CREATED = "Se Registro Correctamente";
	public static final String MESSAGE_UPDATED = "Se Actualizo Correctamente";
	public static final String MESSAGE_ERROR = "Ocurrio un Error";
	public static final String MESSAGE_SUCCESS_DISABLED = "Se Deshabilito Correctamente este Registro";
	public static final String MESSAGE_SUCCESS_ENABLED = "Se Habilito Correctamente este Registro";
	public static final String MESSAGE_TOTAL_REGISTROS = "Total Registros";
	public static final String MESSAGE_TOTAL_REGISTROS_CON = "";
	public static final String ESTADO = "SERVICIO OPERANDO";
	public static final String HECHO = "HECHO";
	public static final String UPS = "UPS";
}
