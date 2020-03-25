package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import models.NewUser;
import services.NewUserService;

public class NewUserFormController implements Initializable {

	@FXML
	private TextField tfNombre;

	@FXML
	private TextField tfApellidos;

	@FXML
	private TextField tfDNI;

	@FXML
	private TextField tfNacimiento;

	@FXML
	private TextField tfCiudad;

	@FXML
	private TextField tfDireccion;

	@FXML
	private TextField tfUsername;

	@FXML
	private TextField tfContraseña;

	@FXML
	private CheckBox activo;

	@FXML
	private ComboBox<String> roles;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		roles.setItems(FXCollections.observableArrayList(NewUserService.getRoles()));

	}

	@FXML
	void crear() {
		String username = tfUsername.getText();
		String password = tfContraseña.getText();
		String name = tfNombre.getText();
		String apellidos = tfApellidos.getText();
		String dni = tfDNI.getText();
		String nacimiento = tfNacimiento.getText();
		String ciudad = tfCiudad.getText();
		String direccion = tfDireccion.getText();
		String rol = roles.getSelectionModel().getSelectedItem();
		boolean active = activo.isSelected();

		HashMap<String, String> location = new HashMap<String, String>();
		location.put("city", ciudad);
		location.put("address", direccion);
		
		HashMap<String, String> role = new HashMap<String, String>();
		role.put("role_name", rol);

		NewUser user = new NewUser(username, password, name, apellidos, dni, nacimiento, location, role, active, false);

		String result = new Gson().toJson(user);

		System.out.println(result);

		NewUserService.insertarUsuario(result);

	}

	byte[] cargaImagen(String ruta) {
		try {
			File f = new File(ruta);
			int size = (int) f.length();
			byte[] buffer = new byte[size];
			FileInputStream in = new FileInputStream(f);
			in.read(buffer);
			in.close();
			return buffer;
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException-NewUserFormController.cargaImagen: " + e.getMessage());
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println("IOException-NewUserFormController.cargaImagen: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

}
