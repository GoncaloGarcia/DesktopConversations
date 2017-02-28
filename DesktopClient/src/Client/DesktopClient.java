package Client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DesktopClient extends Application{
	
	@Override
	public void start(Stage primaryStage){
		Button btn = new Button();
		btn.setText("OLA");
		Button btn2 = new Button();
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				btn.setText(btn.getText() + " Ola");
				
			}
		});
		
		BorderPane root = new BorderPane();
		
		root.setTop(btn);
		root.setCenter(btn2);
		root.setAlignment(btn, Pos.TOP_CENTER);
		
		Scene scene = new Scene(root,300,250);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
