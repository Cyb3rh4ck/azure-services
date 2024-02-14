package mx.santander.upld.fatca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import mx.santander.upld.fatca.exceptions.UnauthorizedException;

/**
 * @author x661902
 * Interface que define los métodos, firmas y tipos de repuestas para cada uno.
 */
public interface IReportManagement {
	
	@GetMapping(value = "/reporte", produces = "application/json")
	ResponseEntity<Object> getAll(@RequestHeader(value="Authorization") String authorizationHeader);
	
	 

}
