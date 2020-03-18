package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		title.setImage(new Image("file:src/img/intercruises.png"));
	}
	
	@FXML
	void login() {
		String response = new LoginService().checkCreds(email.getText(), password.getText());
		
		if (response.equals("false")) System.exit(0);
		else
			try {
				Main.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/MainFrame.fxml")), 1920, 1080));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("LoginController.login - IOException: " + e.getMessage());
				e.printStackTrace();
			}
	}

	
	
}
