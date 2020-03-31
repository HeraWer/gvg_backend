package services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class NewUserService {

	private static String allRolesURL = "https://app-intercruises.herokuapp.com/allRoles";
	private static String newUserURL = "https://app-intercruises.herokuapp.com/newUser";
	//private static String allRolesURL = "http://localhost:3000/allRoles";
	//private static String newUserURL = "http://localhost:3000/newUser";

	public static void insertarUsuario(String jsonUser) {
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) new URL(newUserURL).openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			
			ConnUtils.enviarBody(conn, jsonUser);

			String response = ConnUtils.formatearRespuesta(conn);

			System.out.println(response);
			
			conn.disconnect();
		} catch (IOException e) {
			System.out.println("IOException-NewUserService.insertarUsuario: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getRoles() {
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) new URL(allRolesURL).openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");

			String response = ConnUtils.formatearRespuesta(conn);

			System.out.println(response);

			conn.disconnect();

			return rolesIntoArr(response);

		} catch (IOException e) {
			System.out.println("IOException-NewUserService.getRoles: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	private static ArrayList<String> rolesIntoArr(String response) {

		ArrayList<String> arr = new ArrayList<String>();
		Gson gson = new Gson();

		for (JsonElement x : JsonParser.parseString(response).getAsJsonArray())
			arr.add((String) gson.fromJson(x, HashMap.class).get("role_name"));

		System.out.println("respone: " + response);
		System.out.println(arr.toString());

		return arr;
	}

}
