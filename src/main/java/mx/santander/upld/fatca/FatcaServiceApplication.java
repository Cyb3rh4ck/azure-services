package mx.santander.upld.fatca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author x661902
 * 
 *  Clase principal que inicia la aplicación de Spring Boot
 */

@SpringBootApplication
public class FatcaServiceApplication {

	/**
	 * Método main para iniciar la aplicación Spring Boot
	 * @param args argumentos opcionales de envío al programa
	 */
	public static void main(String[] args) {
		SpringApplication.run(FatcaServiceApplication.class, args);
	}

}
