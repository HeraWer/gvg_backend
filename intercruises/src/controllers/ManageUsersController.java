package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import services.LoginService;

public class ManageUsersController extends Application implements Initializable {

	@FXML
	private TextField texFieldOldUsername, textFieldNewUsername;
	
	@FXML
	private PasswordField textFieldNewPassword, passwordFieldConfirmPassword;

	@FXML
	private ToggleButton toggleButtonNotify;
	
	@FXML
	private Button logoutButton, saveButton;
	
	/*@FXML
	void login() {
		
		if(textField.getText().isEmpty() || password.getText().isEmpty()) {
			
			 * Dialogo de contraseña erronea
			 
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("El campo usuario y/o contraseña estan vacios");
			alert.showAndWait();
			email.setText("");
			password.setText("");
			System.out.println("Contraseña erronea");
		}else {
			String response = new LoginService().checkCreds(email.getText(), password.getText());
			System.out.println(response);
			
			if (!response.contains("token")) {
				
				 * Dialogo de contraseña erronea
				 
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("El usuario y/o contraseña no son correctos");
				alert.showAndWait();
				email.setText("");
				password.setText("");
				System.out.println("Contraseña erronea");
			}else {
				try {
					Main.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/MainFrame.fxml")), 1920, 1080));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("LoginController.login - IOException: " + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
		
	}*/
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
