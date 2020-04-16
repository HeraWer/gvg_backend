package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.calendarfx.view.TimeField;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import models.Event;

public class NewOfferController implements Initializable {
	
	@FXML
	private TextField textFieldTitle, textFieldPlaces, textFieldLocation;
	
	@FXML
	private ComboBox<String> comboBoxType;
	
	@FXML
	private TextArea textAreaDescription;
	
	@FXML
	private GridPane gridPaneContentDataPicker;
	
	@FXML
	ImageView addCalendar;
	
	ArrayList<String> types = new ArrayList<String>();
	
	ArrayList<LocalDate> fechas = new ArrayList<LocalDate>();
	ArrayList<LocalTime> horas = new ArrayList<LocalTime>();
	
	int row = 1;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		types.add("activity");
		types.add("offer");
		comboBoxType.setItems(FXCollections.observableArrayList(types));
		
		MainFrameController.changeColour(addCalendar,new Image("file:src/img/addCalendarFocused.png"),new Image("file:src/img/addCalendar.png"));
	}
	
	@FXML
	public void newDate() {
		DatePicker dp = new DatePicker();
		TimeField tfStart = new TimeField();
		TimeField tfEnd = new TimeField();
		
		dp.setPrefSize(350, 50);
		tfStart.setPrefSize(100, 50);
		tfEnd.setPrefSize(100, 50);
		
		row++;
		gridPaneContentDataPicker.add(dp, 0, row);
		
		gridPaneContentDataPicker.add(tfStart, 1, row);
		gridPaneContentDataPicker.add(tfEnd, 1, row);
		
		gridPaneContentDataPicker.setPrefHeight(gridPaneContentDataPicker.getHeight() + 30);
		gridPaneContentDataPicker.setMargin(dp, new Insets(10, 0, 0, 0));
		gridPaneContentDataPicker.setMargin(tfStart, new Insets(35, 10, 0, 10));
		gridPaneContentDataPicker.setMargin(tfEnd, new Insets(40, 10, 0, 150));
		
	}
	
	@FXML
	void newOffer() {
		java.util.Date fecha = new Date();
		
		//Event e = new Event(40, publisher, textFieldTitle.getText(), textAreaDescription.getText(), fecha, true, "", textFieldPlaces.getText(), textFieldLocation.getText(), schedule)
	}

}
