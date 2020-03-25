package controllers;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NewsFeedMenuController extends Application{
	
	@FXML 
	private AnchorPane mainAP;
	
	@FXML
	private Pane searchPane;
	
	static MainFrameController mfc;
	
	@Override
	public void start(Stage arg0) throws Exception {
		
	}
	
	@FXML
	void abrirNewsFeedList() {
		try {
			Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../views/NewsFeedList.fxml")));
			
			mfc.bp.setCenter(scene.getRoot());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("NewsFeedMenuController.abrirNewsFeedList -- IOException: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
