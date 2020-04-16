package services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import models.Event;

public class CalendarService {

	// private static String url = "https://app-intercruises.herokuapp.com/";
	private static String url = "http://localhost:3000/";

	public static String recuperarUserId(String username) {
		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) new URL(url+"getUser_Id").openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", controllers.MainFrameController.tokenSession);
			conn.setDoOutput(true);

			HashMap<String, String> hm = new HashMap<String, String>();

			hm.put("username", username);

			String body = new Gson().toJson(hm);

			ConnUtils.enviarBody(conn, body);

			String response = ConnUtils.formatearRespuesta(conn);

			System.out.println(response);

			conn.disconnect();

			return response;

		} catch (IOException e) {
			System.out.println("IOException-CalendarServices.recuperarUserId: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<Event> recuperarEventosUsuario(String userId) {
		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) new URL(url+"getUserEvents").openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", controllers.MainFrameController.tokenSession);
			conn.setDoOutput(true);

			HashMap<String, String> hm = new HashMap<String, String>();

			hm.put("_id", userId);

			String body = new Gson().toJson(hm);

			ConnUtils.enviarBody(conn, body);

			String response = ConnUtils.formatearRespuesta(conn);

			System.out.println(response);

			conn.disconnect();

			return responseIntoArr(response);

		} catch (IOException e) {
			System.out.println("IOException-CalendarServices.recuperarEventosUsuario: " + e.getMessage());
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
