package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.Event;

public class EventCellController extends ListCell<Event> implements Initializable{
	
	@FXML
	private AnchorPane mainAP;
	
	@FXML
	private ImageView userIcon;
	
	@FXML
	private Label location;
	
	@FXML
	private Label description;
	
	@FXML
	private ImageView editIcon;
	
	@FXML
	private ImageView activaIcon;
	
	@FXML
	private Label activa;
	
	@Override
	protected void updateItem(Event event, boolean empty) {
		// TODO Auto-generated method stub
		super.updateItem(event, empty);
		
		if (empty || event == null) {
			setText(null);
			setGraphic(null);
		} else {
			try {
				mainAP = FXMLLoader.load(getClass().getResource("../views/EventCell.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("EventCellController.updateItem - IOException: " + e.getMessage());
				e.printStackTrace();
			}
			
			System.out.println(location == null);
			
			location.setText(event.getLocation());
			description.setText(event.getDescription());
			
			setText(null);
			setGraphic(mainAP);
		}
	}
	
	@FXML
	void chivato() {
		System.out.println("lsaidjaioudjhasiodjisaod");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
}
