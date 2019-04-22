package com.dev.crm.core.util;

public class Constantes {

	public static final String DASHBOARD_VIEW = "dashboard";
	public static final String USUARIO_VIEW = "modulo-personas/usuario/usuario";
	public static final String PERSONA_VIEW = "modulo-personas/persona/persona";
	public static final String EMPLEADO_VIEW = "modulo-personas/empleado/empleado";
	public static final String DETALLE_CUENTA_VIEW = "modulo-servicios/detallecuenta/detallecuenta";
	public static final String REPROGRAMACION_VIEW = "modulo-servicios/detallecuenta/reprogramacion";
	
	public static final String SP_ACTIVAR_DESACTIVAR_CLIENTE = "sp_activar_desactivar";
	public static final String SP_LISTA_PERSONA_NO_EMPLEADO = "sp_lista_persona_no_empleado";
	public static final String  SP_INSERCION_EMPLEADO = "sp_insercion_empleado";
	public static final String SP_ACTUALIZAR_EMPLEADO = "sp_actualizar_empleado";
	public static final String SP_ACT_DES_EMPLEADO = "sp_act_des_empleado";
	public static final String  SP_LISTAR_PERSONA_EMPLEADO= "sp_listar_persona_empleado";
	public static final String SP_LISTAR_EMPLEADOS_INT_EXT = "sp_listar_empleados_int_ext";
	public static final String SP_BUSCAR_PERSONA_CLIENTE_VENDEDOR = "sp_buscar_persona_cliente_vendedor";
	public static final String SP_INSERCION_CUENTA_INTERNET = "sp_insercion_cuenta_internet";
	public static final String SP_INSERCION_CUENTA_CABLE ="sp_insercion_cuenta_cable";
	public static final String SP_REPROGRAMAR_INSTALACION_CABLE = "sp_reprogramar_insta_cable";
	public static final String SP_REPROGRAMAR_INSTALACION_INTERNET = "sp_reprogramar_insta_internet";
	public static final String SP_REVALIDANDO_FECHA_CABLE = "sp_revalidando_fecha_cable";
	public static final String SP_REVALIDANDO_FECHA_INTERNET = "sp_revalidando_fecha_internet";
	
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
}
