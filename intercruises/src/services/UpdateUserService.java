package services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateUserService {
	
	private static String updateUserURL = "https://app-intercruises.herokuapp.com/updateUser";
	//private static String updateUserURL = "http://localhost:3000/updateUser";

	public static void updateUser(String jsonUpdateUser) {
		
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) new URL(updateUserURL).openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", controllers.MainFrameController.tokenSession);
			conn.setDoOutput(true);
			
			ConnUtils.enviarBody(conn, jsonUpdateUser);

			String response = ConnUtils.formatearRespuesta(conn);

			System.out.println(response);
			
			conn.disconnect();
		} catch (IOException e) {
			System.out.println("IOException-NewUserService.insertarUsuario: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
