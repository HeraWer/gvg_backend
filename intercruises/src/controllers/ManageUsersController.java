package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.UpdateUser;
import services.UpdateUserService;


public class ManageUsersController extends Application implements Initializable {

	@FXML
	private TextField texFieldOldUsername, textFieldNewUsername;
	
	@FXML
	private PasswordField passwordFieldNewPassword, passwordFieldConfirmPassword;

	@FXML
	private ToggleButton toggleButtonNotify;
	
	@FXML
	private Button buttonNewUser, buttunSaveButton;
	
	static MainFrameController mfc;
	
	
	@FXML
	void updateUserButton() {
		if(!texFieldOldUsername.getText().isEmpty() && !textFieldNewUsername.getText().isEmpty() && !passwordFieldNewPassword.getText().isEmpty() && !passwordFieldConfirmPassword.getText().isEmpty()) {
			if(passwordFieldNewPassword.getText().equals(passwordFieldConfirmPassword.getText())) {
				UpdateUser uu = new UpdateUser(texFieldOldUsername.getText(), textFieldNewUsername.getText(), passwordFieldNewPassword.getText());
				System.out.println(new Gson().toJson(uu));
				UpdateUserService.updateUser(new Gson().toJson(uu));
				System.out.println("Usuario actualizado");
			}else {
				/*
				 * Dialogo de las contraseñas no cuenciden
				 */
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Los campos de contraseña no cuenciden");
				alert.showAndWait();
				texFieldOldUsername.setText("");
				textFieldNewUsername.setText("");
				passwordFieldNewPassword.setText("");
				passwordFieldConfirmPassword.setText("");
			}
		}else {
			/*
			 * Dialogo de campos vacios
			 */
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Es necesario rellenar todos los campos para poder guardar el usuario actualizado");
			alert.showAndWait();
			texFieldOldUsername.setText("");
			textFieldNewUsername.setText("");
			passwordFieldNewPassword.setText("");
			passwordFieldConfirmPassword.setText("");
		}
		
	}
	
	@FXML
	void openNewUserForm() {
		try {
			Parent newUserFormScene = FXMLLoader.load(getClass().getResource("../views/NewUserForm.fxml"));
			newUserFormScene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			mfc.bp.setCenter(newUserFormScene);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("MainFrameController.openSettings - IOException: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
