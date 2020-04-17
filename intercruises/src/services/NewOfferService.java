package services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import models.Event;

public class NewOfferService {

	private static String url = "http://localhost:3000/createEvent";
	
	public static void crearEvento(Event event) {
		
		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", controllers.MainFrameController.tokenSession);
			conn.setDoOutput(true);
			
			String body = new Gson().toJson(event);
			
			ConnUtils.enviarBody(conn, body);
			
			String response = ConnUtils.formatearRespuesta(conn);

			System.out.println(response);

			conn.disconnect();

		} catch (IOException e) {
			System.out.println("IOException-EventService.recuperarEventos: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
