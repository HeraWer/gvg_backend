package services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import models.NewUser;
import models.UpdateUser;

public class ManageUsersService {

	//String url = "https://app-intercruises.herokuapp.com/updateUser";
	static String url = "http://localhost:3000/";

	public String checkCreds(String oldUsername, String newUsername, String newPassword) {
		UpdateUser user = new UpdateUser(oldUsername, newUsername, newPassword);
		
		String body = new Gson().toJson(user);
		
		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) new URL(url+"updateUser").openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", controllers.MainFrameController.tokenSession);
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
	public static NewUser getUser(String username) {		
		String body = ("{\"username\":\"" + username + "\"}");
		
		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) new URL(url+"getUser").openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", controllers.MainFrameController.tokenSession);
			conn.setDoOutput(true);

			System.out.println(body);

			ConnUtils.enviarBody(conn, body);

			String response = ConnUtils.formatearRespuesta(conn);
			
			System.out.println(response);
			
			conn.disconnect();
			NewUser user = new Gson().fromJson(response, NewUser.class);
			return user;
			
		} catch (IOException e) {
			System.out.println("IOException-LoginService.getUser: " + e.getMessage());
			e.printStackTrace();
			System.out.println("IOEXception - getUser");
			return null;
		}

	}
}
