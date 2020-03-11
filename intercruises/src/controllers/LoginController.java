package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
		new LoginService().checkCreds(email.getText(), password.getText());
	}

	
	
}
