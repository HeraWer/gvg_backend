package services;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import javax.imageio.ImageIO;

import org.bson.internal.Base64;

import controllers.LoginController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

public class ConnUtils {

	static void enviarBody(HttpURLConnection conn, String body) {
		try {
			OutputStream os = conn.getOutputStream();
			byte[] input = body.getBytes("utf-8");
			os.write(input, 0, input.length);
			os.close();
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Server connection error");
			alert.showAndWait();
			System.out.println("IOException-ConnUtils.enviarBody " + e.getMessage());
			e.printStackTrace();
		}
	}

	static String formatearRespuesta(HttpURLConnection conn) {
		StringBuilder sb = new StringBuilder();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;

			while ((output = br.readLine()) != null)
				sb.append(output);

			br.close();
			return sb.toString();
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Credential Error");
			alert.showAndWait();
			System.out.println("IOException-ConnUtils.formatearRespuesta: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	static Image formatearImagen(HttpURLConnection conn) {
		StringBuilder sb = new StringBuilder();
		Image img = null;
		BufferedImage image = null;
		byte[] imageByte;
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;

			while ((output = br.readLine()) != null)
				sb.append(output);

			br.close();
			String sourceData = sb.toString();
			sourceData = sourceData.replaceAll("data:image/png;base64,", "");
			imageByte = Base64.decode(sourceData);
			try (OutputStream stream = new FileOutputStream("src/img/" + LoginController.username + ".png")) {
				stream.write(imageByte);
			}
			img = new Image(new ByteArrayInputStream(imageByte));
		} catch (IOException e) {
			System.out.println("IOException-ConnUtils.formatearImagen:");
			e.printStackTrace();
			System.out.println("LOCAL PHOTO");
			if (new File("src/img/" + LoginController.username + ".png").exists()) {
				return new Image("file:src/img/" + LoginController.username + ".png");
			} else {
				System.out.println("DEFAULT PHOTO");
				return new Image("file:src/img/defaultProfile.png");
			}

		}
		return img;

	}
}
