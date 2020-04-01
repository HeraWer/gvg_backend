package services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import models.Event;

public class EventService {

	//private static String url = "https://app-intercruises.herokuapp.com/allEvents";
	private static String url = "http://localhost:3000/allEvents";

	public static ArrayList<Event> recuperarEventos() {
		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", controllers.MainFrameController.tokenSession);

			String response = ConnUtils.formatearRespuesta(conn);

			System.out.println(response);

			conn.disconnect();

			return responseIntoArr(response);

		} catch (IOException e) {
			System.out.println("IOException-EventService.recuperarEventos: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	private static ArrayList<Event> responseIntoArr(String response) {

		ArrayList<Event> arr = new ArrayList<Event>();
		Gson gson = new Gson();
		
		for (JsonElement x : JsonParser.parseString(response).getAsJsonArray())
			arr.add(gson.fromJson(x, Event.class));
		
		System.out.println("respone: " + response);
		System.out.println(arr.toString());

		return arr;
	}

}
