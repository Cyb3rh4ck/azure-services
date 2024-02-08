package mx.santander.upld.fatca.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import mx.santander.upld.fatca.model.Report;

/**
 * @author x661902
 * Interface que define los métodos, firmas y tipos de repuestas para cada uno.
 */
public interface IReportManagement {
	
	@GetMapping(value = "/reporte", produces = "application/json")
	ResponseEntity<Object> getAll();
	
	 

}
