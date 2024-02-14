package mx.santander.upld.fatca.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.upld.fatca.exceptions.UnauthorizedException;
import mx.santander.upld.fatca.model.Report;
import mx.santander.upld.fatca.msgraph.MSGraph;
import mx.santander.upld.fatca.util.business.Utils;

/**
 * Controlador encargado de recibir los request procesarlos y retornar una respuesta
 * exitosa o erronea.
 * 
 */
@RestController
public class ReportManagement implements IReportManagement {
	
	@Autowired
	private  MSGraph graph;
	
	@Override
	public ResponseEntity<Object> getAll(@RequestHeader(value="Authorization") String authorizationHeader) { 
		ArrayList<Report> reports = new ArrayList<>();
		
		try {
			if(graph.getUserDataFromGraph(Utils.getToken(authorizationHeader)).getGivenName() != null) {
				reports.add(new Report(1,"Zygophlebia sectifrons (Kunze ex Mett.) Bishop","Indonesia","Casa de bolsa",2022,9480,
						"2020-06-24 14:51:20", "2023-01-23 20:56:23", "Listo para Envio", "CRS"));
				
				reports.add(new Report(2,"Ligustrum obtusifolium Siebold & Zucc.","Sweden","Casa de bolsa",2022,4684,
						"2021-11-27 18:03:49", "2023-01-08 00:42:48", "Listo para Envio", "En Revision"));
				
				return new ResponseEntity<>(reports, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new UnauthorizedException("Unauthorized action attempted"), HttpStatus.UNAUTHORIZED);
			}
				
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new UnauthorizedException("Unauthorized action attempted"), HttpStatus.UNAUTHORIZED);
		
		
	}

}
