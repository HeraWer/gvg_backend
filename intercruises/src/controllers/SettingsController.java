package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class SettingsController extends Application implements Initializable {

	@FXML
	private Button buttonLogout, buttonManageUsers;

	static MainFrameController mfc;

	@FXML
	void openManageUsers() {
		try {
			Parent settingsScene = FXMLLoader.load(getClass().getResource("../views/ManageUsers.fxml"));
			settingsScene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			mfc.bp.setCenter(settingsScene);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("MainFrameController.openSettings - IOException: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@FXML
	void logoutSesion(Event event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Dialogo de confirmacion");
		alert.setHeaderText(null);
		alert.setContentText("De verdad que quieres cerrar sesion?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			try {
				Parent settingsScene = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
				Scene scene = new Scene(settingsScene, 1920, 1080);
				scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("MainFrameController.openSettings - IOException: " + e.getMessage());
				e.printStackTrace();
			}
			
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
