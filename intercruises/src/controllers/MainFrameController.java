package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainFrameController implements Initializable {

	@FXML
	private ImageView newsIcon;

	@FXML
	private ImageView chatIcon;

	@FXML
	private ImageView calendarIcon;

	@FXML
	private ImageView configIcon;

	@FXML
	public BorderPane bp;

	@FXML
	private GridPane gridPane;

	@FXML
	void abrirNewsFeed() {
		try {
			Parent newsFeedScene = FXMLLoader.load(getClass().getResource("../views/NewsFeedMenu.fxml"));
			bp.setCenter(newsFeedScene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("MainFrameController.abrirNewsFeed - IOException: " + e.getMessage());
			e.printStackTrace();
		}

	}

	@FXML
	void openSettings() {
		try {
			Parent settingsScene = FXMLLoader.load(getClass().getResource("../views/Settings.fxml"));
			settingsScene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			bp.setCenter(settingsScene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("MainFrameController.openSettings - IOException: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@FXML
	void chivato() {
		System.out.println("chivato MainFrameContorller");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
//		borderPane.getCenter().setStyle("-fx-background-color: #b51e37");
		NewsFeedMenuController.mfc = this;
		SettingsController.mfc = this;
	}

}