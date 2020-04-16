package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import services.LoginService;

public class LoginController implements Initializable{
	
	@FXML
	private ImageView title;
	
	@FXML
	private TextField email;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button loginButton;
	
	public static String username;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		title.setImage(new Image("file:src/img/intercruises.png"));
		
		loginButton.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.ENTER) {
				login();
			}
		});
		
		password.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.ENTER) {
				login();
			}
		});
	}
	
	@FXML
	void login() {
		
		if(email.getText().isEmpty() || password.getText().isEmpty()) {
			/*
			 * Dialogo de contraseña erronea
			 */
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("El campo usuario y/o contraseña estan vacios");
			alert.showAndWait();
			email.setText("");
			password.setText("");
			System.out.println("Contraseña erronea");
		}else {
			String response = new LoginService().checkCreds(email.getText(), password.getText());
			
			
			if (!response.contains("token")) {
				/*
				 * Dialogo de contraseña erronea
				 */
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("El usuario y/o contraseña no son correctos");
				alert.showAndWait();
				email.setText("");
				password.setText("");
				System.out.println("Contraseña erronea");
			}else {
				try {
					username = response.substring(response.indexOf("username\":\"")+11,response.indexOf("\",\"token"));
					System.out.println("CURRENT USER: "+username);
					response = response.substring(response.indexOf("token"));
					response = (String) response.subSequence(8, response.length() - 2);					
					controllers.MainFrameController.tokenSession = response;
					
					Main.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/MainFrame.fxml")), 1920, 1080));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("LoginController.login - IOException: " + e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
}
