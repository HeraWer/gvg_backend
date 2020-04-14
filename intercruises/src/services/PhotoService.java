package services;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import javafx.scene.image.Image;
import models.LoginUser;

public class PhotoService {

	// String url = "https://app-intercruises.herokuapp.com/getPhoto";
	String url = "http://localhost:3000/getPhoto";

	public Image getPhoto(String username) {

		String body = ("{\"username\":\"" + username + "\"}");
		Image response = null;
		HttpURLConnection conn = null;

		try {
			conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", controllers.MainFrameController.tokenSession);
			conn.setDoOutput(true);

			System.out.println("BODY: " + body);

			ConnUtils.enviarBody(conn, body);

			try {
				response = ConnUtils.formatearImagen(conn);
			}catch(Exception z) {
				try {
					return new Image("file:src/img/" + username + ".png");
				} catch (Exception y) {
					return new Image("file:src/img/defaultProfile.png");
				}
			}

			System.out.println("RESPONSE: " + response);

			conn.disconnect();

		} catch (IOException e) {
			System.out.println("IOException-LoginService.getPhoto: " + e.getMessage());
			e.printStackTrace();
			
		}
		return response;

	}
}
