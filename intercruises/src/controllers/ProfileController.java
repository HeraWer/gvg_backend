package controllers;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.NewUser;
import models.UpdateUser;
import services.ManageUsersService;
import services.NewUserService;
import services.PhotoService;
import services.UpdateUserService;

public class ProfileController extends Application implements Initializable {

	@FXML
	ImageView profileImage;
	@FXML
	TextField txtName;
	@FXML
	TextField txtSurname;
	@FXML
	TextField txtDni;
	@FXML
	DatePicker txtBirthDate;
	@FXML
	TextField txtPassword;
	@FXML
	TextField txtUsername;
	@FXML
	TextField txtConfirmPassword;
	@FXML
	ComboBox txtRole;

	PhotoService ps = new PhotoService();
	DateTimeFormatter formatterSalida = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter formatterEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	// DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	// SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	LocalDate localDate;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startPage();
	}

	public void startPage() {
		profileImage.setImage(ps.getPhoto(LoginController.username));
		NewUser user = ManageUsersService.getUser(LoginController.username);
		try {
			ObservableList<String> fx = FXCollections.observableArrayList();
			fx.addAll(NewUserService.getRoles());
			txtRole.setItems(fx);
			txtName.setText(user.getName());
			txtSurname.setText(user.getLastname());
			txtDni.setText(user.getDNI());
			txtUsername.setText(user.getUsername());
			System.out.println("DATE 1: " + user.getBirthdate());
			localDate = LocalDate.parse(user.getBirthdate().replaceAll("-", "/"), formatterEntrada);
			txtBirthDate.setValue(localDate);
			txtRole.setValue(user.getRole().get("role_name"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION: cant set 1 or more user values");
		}
	}

	@FXML
	public void confirmUser() {
		NewUser user = new NewUser();
		if (!txtName.getText().isBlank())
			user.setName(txtName.getText());
		if (!txtSurname.getText().isBlank())
			user.setLastname(txtSurname.getText());
		if (!txtUsername.getText().isBlank())
			user.setUsername(txtUsername.getText());
		if (!txtDni.getText().isBlank())
			user.setDNI(txtDni.getText());
		if (!txtBirthDate.getValue().toString().isBlank()) {
			String date2 = txtBirthDate.getEditor().getText();
			System.out.println("DATE 2: " + date2);
			if (date2.charAt(1) == '-' || date2.charAt(1) == '/')
				date2 = "0" + date2;
			if (date2.charAt(4) == '-' || date2.charAt(4) == '/')
				date2 = date2.substring(0, 3) + "0" + date2.substring(3);

			System.out.println("DATE 3: " + date2);
			user.setBirthdate(date2);
		}
		user.setRoleString(txtRole.getSelectionModel().getSelectedItem().toString());
		user.setUsernameOld(LoginController.username);
		
		if (txtPassword.getText().equals(txtConfirmPassword.getText())&&!txtPassword.getText().isBlank()&&!txtConfirmPassword.getText().isBlank()) {
			user.setPassword(txtPassword.getText());
			NewUserService.updateUsuario(new Gson().toJson(user));
			startPage();
		}
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}

}
