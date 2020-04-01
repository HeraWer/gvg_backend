package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainFrameController implements Initializable {

	@FXML
	public ImageView newsIcon;

	@FXML
	public ImageView chatIcon;
	
	@FXML
	public ImageView userIcon;

	@FXML
	public ImageView calendarIcon;

	@FXML
	public ImageView configIcon;

	@FXML
	public BorderPane bp;

	@FXML
	private GridPane gridPane;
	
	public static String tokenSession;

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
		System.out.println(tokenSession);
		NewsFeedMenuController.mfc = this;
		SettingsController.mfc = this;
		ManageUsersController.mfc = this;
		
		changeColour(newsIcon,new Image("file:src/img/newsFocused.png"),new Image("file:src/img/news_icon.png"));
		changeColour(chatIcon,new Image("file:src/img/chatFocused.png"),new Image("file:src/img/chat_icon.png"));
		changeColour(userIcon,new Image("file:src/img/profileFocused.png"),new Image("file:src/img/profile_boy_icon.png"));
		changeColour(calendarIcon,new Image("file:src/img/calendarFocused.png"),new Image("file:src/img/calendar_icon.png"));
		changeColour(configIcon,new Image("file:src/img/configFocused.png"),new Image("file:src/img/config_icon.png"));

	}
	
	
	public void changeColour(ImageView img,Image imgFocused,Image imgNotFocused) {
		try {
			img.setOnMouseEntered(e -> img.setImage(imgFocused));
			img.setOnMouseExited(e -> img.setImage(imgNotFocused));

		} catch (Exception e) {
			System.out.println("Image not loaded");
		}
	}


}
