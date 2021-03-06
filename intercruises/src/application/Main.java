package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
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
			
			
			Scene scene = new Scene(root, 1080, 1020);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setMaximized(true);
			stage.setResizable(true);
			
			/*Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
			stage.setX(primaryScreenBounds.getMinX());
			stage.setY(primaryScreenBounds.getMinY());
			stage.setMaxWidth(primaryScreenBounds.getWidth());
			stage.setMinWidth(primaryScreenBounds.getWidth());
			stage.setMaxHeight(primaryScreenBounds.getHeight());
			stage.setMinHeight(primaryScreenBounds.getHeight());*/
			
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
