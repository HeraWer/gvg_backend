package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("../views/MainFrame.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("../views/NewsFeedMenu.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("../views/NewsFeedList.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("../views/NewUserForm.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("../views/UserProfile.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("../views/UserProfile.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("../views/Settings.fxml"));

			stage = primaryStage;
			
			Scene scene = new Scene(root, 1920, 1080);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setMaximized(true);
			stage.setResizable(false);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
