package Client;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	
	Image img = new Image(getClass().getResourceAsStream("transferir.jpg"));
	Image settings = new Image(getClass().getResourceAsStream("settings.png"));

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Conversations.im Desktop");
		
		BorderPane bPane = new BorderPane();
		bPane.setId("bpane");
		
		
		BorderPane rightPane = new BorderPane();
		rightPane.setId("rpane");
		rightPane.setPrefSize(600,500);
		
		BorderPane leftPane = new BorderPane();
		leftPane.setId("lpane");
		leftPane.setPrefWidth(250);
		
		HBox userTopPane = new HBox();
		userTopPane.setId("userTopPane");
		userTopPane.setMinSize(100,50);
		userTopPane.setSpacing(10);
		
		FlowPane userTopNamePane= new FlowPane(Orientation.VERTICAL);
		userTopNamePane.setId("topNamePane");
		userTopNamePane.setPrefHeight(50);
		userTopNamePane.setVgap(-5);
		
		
		
		FlowPane msgPane = new FlowPane(Orientation.VERTICAL);
		msgPane.setId("msgPane");
		msgPane.setVgap(10);
		msgPane.setColumnHalignment(HPos.RIGHT);
		
		
		
		leftPane.setTop(userTopPane);
		rightPane.setRight(msgPane);
		bPane.setRight(rightPane);
		bPane.setLeft(leftPane);
		
		Scene scene = new Scene(bPane);
		scene.getStylesheets().add(DesktopClient.class.getResource("desktopclient.css").toExternalForm());
		
		TextArea msgInput = new TextArea();
		msgInput.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				
				if(e.getCode() == KeyCode.ENTER){
					FlowPane msgHolder = new FlowPane();
					msgHolder.setHgap(5);
					Label msg = new Label();
					Label pic = new Label();
					Image img = new Image(getClass().getResourceAsStream("transferir.jpg"));
					ImageView imgview = new ImageView(img);
					imgview.setFitHeight(40);
					imgview.setFitWidth(40);
					imgview.setId("userPic");
					pic.setGraphic(imgview);
					msgHolder.getChildren().add(msg);
					msgHolder.getChildren().add(pic);
					msgHolder.setAlignment(Pos.TOP_RIGHT);
					msg.setText(msgInput.getText());	
					msg.setId("msg");
					
					msgPane.getChildren().add(msgHolder);
					msgInput.clear();
					e.consume();
				}
				
			}
		});
		
		
		ImageView userPicView = new ImageView(img);
		userPicView.setId("userPic");
		userPicView.setFitHeight(50);
		userPicView.setFitWidth(50);
		userTopPane.getChildren().add(userPicView);
		
		
		
		userTopPane.getChildren().add(userTopNamePane);
		
		Label userNameLabel = new Label("CurrentUser");
		userNameLabel.setId("UserNameLabel");
		
		Label userStatusLabel = new Label("Online");
		userStatusLabel.setId("userStatusLabel");
		
		userTopNamePane.getChildren().add(userNameLabel);
		
		userTopNamePane.getChildren().add(userStatusLabel);
		
		FlowPane settingsPane = new FlowPane();
		settingsPane.setAlignment(Pos.BASELINE_RIGHT);
		settingsPane.setId("settingsPane");
		ImageView settingsPicView = new ImageView(settings);
		settingsPicView.setId("settingsPic");
		settingsPicView.setFitHeight(20);
		settingsPicView.setFitWidth(20);
		
		settingsPane.getChildren().add(settingsPicView);
		userTopPane.getChildren().add(settingsPane);
		
		msgInput.setMaxSize(500, 50);
		rightPane.setAlignment(msgInput, Pos.BOTTOM_CENTER);
		rightPane.setBottom(msgInput);
		
		
		primaryStage.sizeToScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
