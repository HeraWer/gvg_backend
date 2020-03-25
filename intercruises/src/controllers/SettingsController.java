package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class SettingsController extends Application implements Initializable {
	
	@FXML
	private Label labelChangeUsername, labelChangePassword;

	@FXML
	private TextField textFieldChangeUsername;
	
	@FXML
	private PasswordField textFieldChangePassword;

	@FXML
	private ToggleButton toggleButtonDisableNotify;
	
	@FXML
	private Button logoutButton, saveButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
