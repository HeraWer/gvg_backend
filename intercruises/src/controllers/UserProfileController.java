package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import models.NewUser;
import services.UserProfileService;

public class UserProfileController implements Initializable{

	@FXML
	private ImageView ivFoto;
	
	@FXML
	private Label lblUsername;
	
	@FXML
	private Label lblRol;
	
	@FXML
	private Label lblNombre;
	
	@FXML
	private Label lblApellidos;
	
	@FXML
	private Label lblDNI;
	
	@FXML
	private Label lblCiudad;
	
	@FXML
	private Label lblNacimiento;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//		NewUser user = UserProfileService.recuperarUsuario();
	}
	
}
