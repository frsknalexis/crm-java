package com.dev.crm.core.util;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class JdbcTemplateUtil {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	public void callStoredProcedure(String procedureName, Map<String, Object> parameters) {
		
		simpleJdbcCall.withProcedureName(procedureName);
		MapSqlParameterSource inParams = new MapSqlParameterSource();
		
		if(parameters != null) {
			for(Map.Entry<String, Object> parameter : parameters.entrySet()) {
				inParams.addValue(parameter.getKey(), parameter.getValue());
			}
		}
		
		simpleJdbcCall.execute(inParams);
		System.out.println("PROCEDURE {} IS CALLED : " + procedureName);
	}
	
	public Object callStoredFunction(String functionName, Map<String, Object> parameters, Class<?> classReturn) {
		
		simpleJdbcCall.withFunctionName(functionName);
		simpleJdbcCall.withReturnValue();
		
		MapSqlParameterSource inParams = new MapSqlParameterSource();
		if(parameters != null) {
			for(Map.Entry<String, Object> parameter : parameters.entrySet()) {
				inParams.addValue(parameter.getKey(), parameter.getValue());
			}
		}
		
		System.out.println("FUNCTION {} IS CALLED: " + functionName);
		return simpleJdbcCall.executeFunction(classReturn, inParams);
	}
}
