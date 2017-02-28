package Client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DesktopClient extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Conversations.im Desktop");
		BorderPane bPane = new BorderPane();
		bPane.setId("bpane");
		
		
		FlowPane rightPane = new FlowPane();
		rightPane.setId("rpane");
		rightPane.setPrefSize(600,500);
		
		BorderPane leftPane = new BorderPane();
		leftPane.setId("lpane");
		leftPane.setPrefWidth(250);
		
		HBox userTopPane = new HBox();
		userTopPane.setId("userTopPane");
		userTopPane.setMinSize(100,100);
		
		leftPane.setTop(userTopPane);
		
		bPane.setRight(rightPane);
		bPane.setLeft(leftPane);
		
		Scene scene = new Scene(bPane);
		scene.getStylesheets().add(DesktopClient.class.getResource("desktopclient.css").toExternalForm());
		
		
		
		
		primaryStage.sizeToScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
