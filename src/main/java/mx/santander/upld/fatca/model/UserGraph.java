package mx.santander.upld.fatca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGraph {
	
	private String displayName;
	private String givenName;
	private String jobTitle;
	private String mail;
	private String surname;
	
	public UserGraph() {
		displayName = null;    
		givenName = null;      
		jobTitle = null;       
		mail = null;           
		surname = null;    
	}
	
}
