package mx.santander.upld.fatca.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.upld.fatca.model.Report;
import mx.santander.upld.fatca.util.http.HttpErrorInfo;

/**
 * Controlador encargado de recibir los request procesarlos y retornar una respuesta
 * exitosa o erronea.
 * 
 */
@RestController
public class ReportManagement implements IReportManagement {
	
	private static final Logger LOG = LoggerFactory.getLogger(ReportManagement.class);

	@Override
	public ResponseEntity<Object> getAll() { 
		ArrayList<Report> reports = new ArrayList<>();
		
		
		
		reports.add(new Report(1,"Zygophlebia sectifrons (Kunze ex Mett.) Bishop","Indonesia","Casa de bolsa",2022,9480,
				"2020-06-24 14:51:20", "2023-01-23 20:56:23", "Listo para Envio", "CRS"));
		
		reports.add(new Report(2,"Ligustrum obtusifolium Siebold & Zucc.","Sweden","Casa de bolsa",2022,4684,
				"2021-11-27 18:03:49", "2023-01-08 00:42:48", "Listo para Envio", "En Revision"));
		
		 ZoneId zone = ZoneId.systemDefault();
		    LOG.debug("Output of systemDefault()-: {} - time -: {}", zone, ZonedDateTime.now(ZoneId.of("GTM")).toString());
		
		return new ResponseEntity<>(reports, HttpStatus.OK);
	}

}
