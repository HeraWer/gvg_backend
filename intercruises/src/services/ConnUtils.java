package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class ConnUtils {
	
	static void enviarBody(HttpURLConnection conn, String body) {
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
			System.out.println("IOException-LoginService.formatearRespuesta: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}
}
