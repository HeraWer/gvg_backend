package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SettingsController extends Application implements Initializable {

	@FXML
	private Button buttonLogout, buttonManageUsers;

	static MainFrameController mfc;

	@FXML
	void openManageUsers() {
		try {
			Scene settingsScene = new Scene(FXMLLoader.load(getClass().getResource("../views/ManageUsers.fxml")));
			settingsScene.getStylesheets().add("/application/application.css");
			mfc.bp.setCenter(settingsScene.getRoot());

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
