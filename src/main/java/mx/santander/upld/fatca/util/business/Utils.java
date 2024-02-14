package mx.santander.upld.fatca.util.business;

public class Utils {
	
	private Utils() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String getToken(String accessToken) {
		String[] token = accessToken.split(" ");
		return token[1];
	}

}
