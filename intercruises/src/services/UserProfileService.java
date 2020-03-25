package services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import com.google.gson.Gson;

import models.NewUser;

public class UserProfileService {
	
	private static String getUserURL = "https://app-intercruises.herokuapp.com/getUser";
	
	public static NewUser recuperarUsuario(String username) {
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("username",username);
		System.out.println("iniciando recuperarUsuario...");
		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) new URL(getUserURL).openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			
			Gson gson = new Gson();
			
			ConnUtils.enviarBody(conn, gson.toJson(hm));
			
			String response = ConnUtils.formatearRespuesta(conn);

			System.out.println(response);

			conn.disconnect();

			return gson.fromJson(response, NewUser.class);
			
		} catch (IOException e) {
			System.out.println("IOException-EventService.recuperarEventos: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	
}
