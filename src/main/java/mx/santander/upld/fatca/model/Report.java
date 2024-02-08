package mx.santander.upld.fatca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author x661902
 * Clase que define el modelo de los reportes
 * 
 *  id:  int | Id del reporte,
 *  name: string | Nombre del reporte,
 *  country:  string | Preguntar posibles paises,
 *  entity: 'Casa de Bolsa' | 'Banco',
 *  year: int | año del reporte,
 *  records: int | Registros en el reporte,
 *  lastUpdate: Datetime | ultima actualizacion,
 *  lastFix: Datetime | Ultima correcion,
 *  status:    | 'Generado'  | 'En Revision'  | 'Listo para Envio'  | 'Enviado'  | 'Recepcion Confirmada'  | 'Rechazado'  | 'Aprobado';,
 *  type: 'CRS' | 'FATCA',
 */

@Getter
@Setter
@AllArgsConstructor
public class Report {
	private final int id;
	private final String name;  
	private final String country;
	private final String entity;
	private final int year;
	private final int records;
	private final String lastUpdate;
	private final String lastFix;
	private final String status;
	private final String type;
	
	
	
	public Report() {
		id = 0;
		name = null;
		country = null;
		entity = null;
		year = 0;
		records = 0;
		lastUpdate = null;
		lastFix = null;
		status = null;
		type = null;
	}
	
	

}
