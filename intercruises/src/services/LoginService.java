package services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import models.LoginUser;

public class LoginService {

	String url = "https://app-intercruises.herokuapp.com/login";
	//String url = "http://localhost:3000/login";

	public String checkCreds(String username, String password) {
		LoginUser user = new LoginUser(username,password);
		
		String body = new Gson().toJson(user);
		
		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) new URL(url).openConnection();

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

}
