package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.UpdateUser;
import services.PhotoService;
import services.UpdateUserService;


public class ProfileController extends Application implements Initializable {
	
	@FXML
	ImageView profileImage;
	PhotoService ps = new PhotoService();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Setting image");
		profileImage.setImage(ps.getPhoto(LoginController.username));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
