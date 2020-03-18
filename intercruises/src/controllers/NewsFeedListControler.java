package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import models.Event;
import services.EventService;

public class NewsFeedListControler implements Initializable {

	@FXML
	private ListView<Event> listView;

	private ObservableList<Event> ol;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ol = FXCollections.observableArrayList(EventService.recuperarEventos());
		
		//Forma grafica de ver la lista
		/*listView.setCellFactory(new Callback<ListView<Event>, ListCell<Event>>() {
			
			@Override
			public ListCell<Event> call(ListView<Event> param) {
				// TODO Auto-generated method stub
				return new EventCellController();
			}
		});*/
		
		
		
//		Event e = new Event();
//		
//		e.set_id("we");
//		e.setDescription("Locaso");
//		e.setLocation("barcelonaaaaaas");
		
//		ol.add(e);

		listView.setItems(ol);
	}

}
