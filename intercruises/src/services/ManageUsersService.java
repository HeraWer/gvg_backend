package services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import models.UpdateUser;

public class ManageUsersService {

	String url = "https://app-intercruises.herokuapp.com/updateUser";
	//String url = "http://localhost:3000/updateUser";

	public String checkCreds(String oldUsername, String newUsername, String newPassword) {
		UpdateUser user = new UpdateUser(oldUsername, newUsername, newPassword);
		
		String body = new Gson().toJson(user);
		
		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);

			System.out.println(body);

			ConnUtils.enviarBody(conn, body);

			String response = ConnUtils.formatearRespuesta(conn);
			
			System.out.println(response);
			
			conn.disconnect();
			
			return response;
			
		} catch (IOException e) {
			System.out.println("IOException-LoginService.checkCreds: " + e.getMessage());
			e.printStackTrace();
			return "IOEXception - checkCreds";
		}

	}
}
