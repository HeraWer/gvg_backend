package controllers;

import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginController implements Initializable{
	
	@FXML
	private ImageView title;
	
	@FXML
	private TextField email;
	
	@FXML
	private PasswordField password;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		title.setImage(new Image("file:src/img/intercruises.png"));
		
	}
	
	public boolean login () {
		
		
		
		
		return true;
	}

	
	
}
