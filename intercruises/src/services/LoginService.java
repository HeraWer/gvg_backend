package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import com.google.gson.Gson;

import models.User;

public class LoginService {

	String url = "http://localhost:3000/login";

	public void checkCreds(String username, String password) {
		User user = new User(username,password);
		
		String body = new Gson().toJson(user);
		
		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);

			System.out.println(body);

			enviarBody(conn, body);

			System.out.println(conn.getResponseMessage());

			System.out.println(formatearRespuesta(conn));

			conn.disconnect();
		} catch (IOException e) {
			System.out.println("IOException-LoginService.checkCreds: " + e.getMessage());
			e.printStackTrace();
		}

	}

	void enviarBody(HttpURLConnection conn, String body) {
		try {
			OutputStream os = conn.getOutputStream();
			byte[] input = body.getBytes("utf-8");
			os.write(input, 0, input.length);
			os.close();
		} catch (IOException e) {
			System.out.println("IOException-LoginService.enviarBody " + e.getMessage());
			e.printStackTrace();
		}
	}

	String formatearRespuesta(HttpURLConnection conn) {
		StringBuilder sb = new StringBuilder();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			while ((output = br.readLine()) != null)
				sb.append(output);

			br.close();
			return sb.toString();
		} catch (IOException e) {
			System.out.println("IOException-LoginService.formatearRespuesta: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

}
