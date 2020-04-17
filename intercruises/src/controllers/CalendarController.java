package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import models.Event;
import services.CalendarService;

public class CalendarController implements Initializable {

	@FXML
	private CalendarView calendar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		recogerEventosUsuario();
	}

	void recogerEventosUsuario() {
		String userId = CalendarService.recuperarUserId(LoginController.username);
		ArrayList<Event> arrE = CalendarService.recuperarEventosUsuario(userId.replaceAll("\"", ""));
		Calendar calendario = new Calendar("Calendario proletariado");

		for (Event x : arrE) {
			Entry<String> auxEntry = new Entry<String>();
			auxEntry.setTitle(x.getTitle());
			System.out.println(x.getSchedule().toString());
			auxEntry.changeStartDate(formatearDia(x.getSchedule().get(0).getDay()));
			if (arrE.size() == 1) auxEntry.changeEndDate(formatearDia(x.getSchedule().get(0).getDay()));
			auxEntry.setInterval(formatearHora(x.getSchedule().get(0).getHour_start()),
					formatearHora(x.getSchedule().get(0).getHour_end()));
			
			System.out.println("heyheyhyehyeh");
			auxEntry.setCalendar(calendario);
		}
		
		CalendarSource csTest = new CalendarSource("prova");
		csTest.getCalendars().add(calendario);
		calendar.getCalendarSources().setAll(csTest);

	}

	LocalDate formatearDia(String day) {
		int dia = Integer.parseInt(day.split("-")[2]);
		int mes = Integer.parseInt(day.split("-")[1]);
		int ano = Integer.parseInt(day.split("-")[0]);

		return LocalDate.of(ano, mes, dia);
	}

	LocalTime formatearHora(String hora) {
		int horaaa = Integer.parseInt(hora.split(":")[0]);
		int minuto = Integer.parseInt(hora.split(":")[1]);

		return LocalTime.of(horaaa, minuto);
	}

}
