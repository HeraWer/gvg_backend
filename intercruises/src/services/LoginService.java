package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import com.google.gson.Gson;

public class LoginService {

<<<<<<< HEAD
	String url = "http://localhost:3000/login";

	public void checkCreds(String username, String password) {
		HashMap<String, String> mapa = new HashMap<String, String>();
		mapa.put("username", username);
		mapa.put("password", password);

		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json; utf-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			String body = new Gson().toJson(mapa);

			System.out.println(body);

			try (OutputStream os = conn.getOutputStream()) {
				byte[] input = body.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				System.out.println(response.toString());
			}
			
			conn.disconnect();
		} catch (IOException e) {
			System.out.println("IOException-LoginService.checkCreds: " + e.getMessage());
		}

	}

=======
	
>>>>>>> 6efc15bf74e122605cfb3201d0e43442618b6e92
}
