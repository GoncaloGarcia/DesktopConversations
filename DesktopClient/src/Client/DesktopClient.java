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
	Image group = new Image(getClass().getResourceAsStream("group.png"));
	Image lock = new Image(getClass().getResourceAsStream("lock.png"));
	Image dots = new Image(getClass().getResourceAsStream("dots.png"));
	Image convo = new Image(getClass().getResourceAsStream("convo.png"));
	
	
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
		msgPane.setColumnHalignment(HPos.LEFT);
		
		BorderPane convoInfoPane = new BorderPane();
		convoInfoPane.setId("infoPane");
		convoInfoPane.setMinSize(200, 50);
		
		Label convoName = new Label("Conversations.im Summer of Code 2017");
		convoInfoPane.setLeft(convoName);
		convoName.setId("convoname");
		
		rightPane.setTop(convoInfoPane);
		
		leftPane.setTop(userTopPane);
		rightPane.setLeft(msgPane);
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
					
					BorderPane msgContent = new BorderPane();
				
					msgHolder.setHgap(5);
					Label msg = new Label();
					Label pic = new Label();
					Image img = new Image(getClass().getResourceAsStream("transferir.jpg"));
					ImageView imgview = new ImageView(img);
					imgview.setFitHeight(35);
					imgview.setFitWidth(35);
					imgview.setId("userPic");
					pic.setGraphic(imgview);
					msgContent.setCenter(msg);
					Label msginfo = new Label("CurrentUser  12:51");
					msginfo.setId("msginfo");
					msgContent.setTop(msginfo);
					msgContent.setAlignment(msginfo, Pos.TOP_LEFT);
					msgContent.setAlignment(msg, Pos.TOP_LEFT);
					msgHolder.getChildren().add(pic);
					msgHolder.getChildren().add(msgContent);
					
					msgHolder.setAlignment(Pos.TOP_LEFT);
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
		
		ImageView dotsPicView = new ImageView(dots);
		dotsPicView.setId("dotsPic");
		dotsPicView.setFitHeight(20);
		dotsPicView.setFitWidth(20);
		
		ImageView groupPicView = new ImageView(group);
		groupPicView.setId("userPic");
		groupPicView.setFitHeight(20);
		groupPicView.setFitWidth(20);
		
		ImageView lockPicView = new ImageView(lock);
		lockPicView.setFitHeight(20);
		lockPicView.setFitWidth(20);
		
		FlowPane convoListPane = new FlowPane(Orientation.VERTICAL);
		convoListPane.setVgap(5);
	
		
		FlowPane convoInfo = new FlowPane(Orientation.VERTICAL);
		Label convoTitle = new Label("Conversations.im Summer of Code 2017");
		convoTitle.setId("cTitle");
		convoTitle.setPrefWidth(200);
		
		Label convoMsg = new Label("     CurrentUser: Whats up?");
		convoMsg.setId("convoMsg");
		
		
		
		convoInfo.getChildren().add(convoTitle);
		convoInfo.getChildren().add(convoMsg);
		
		
		HBox convoBox = new HBox();
		convoBox.setSpacing(5);
		convoBox.setMinSize(250,56);
		convoBox.setMaxSize(250,56);
		convoBox.setId("convoBox");
		
		Label expandArrowUp = new Label("▼");
		expandArrowUp.setId("expandUp");
		convoBox.getChildren().add(expandArrowUp);
		convoBox.getChildren().add(convoInfo);
		convoListPane.getChildren().add(convoBox);
		
		
		HBox convoBoxSmall = new HBox();
		convoBoxSmall.setSpacing(10);
		convoBoxSmall.setMinSize(250,20);
		convoBoxSmall.setMaxSize(250,20);
		convoBoxSmall.setId("convoBox");
		
		Label expandArrowDown = new Label("▶");
		Label smallTitle = new Label("Conversations General");
		smallTitle.setId("cTitle");
		expandArrowDown.setId("expandDown");
		convoBoxSmall.getChildren().add(expandArrowDown);
		convoBoxSmall.getChildren().add(smallTitle);
		convoListPane.getChildren().add(convoBoxSmall);
		
		HBox convoBoxSmall2 = new HBox();
		convoBoxSmall2.setSpacing(10);
		convoBoxSmall2.setMinSize(250,20);
		convoBoxSmall2.setMaxSize(250,20);
		convoBoxSmall2.setId("convoBox");
		
		Label expandArrowDown2 = new Label("▶");
		Label smallTitle2 = new Label("Conversations Bugs");
		smallTitle2.setId("cTitle");
		expandArrowDown2.setId("expandDown");
		convoBoxSmall2.getChildren().add(expandArrowDown2);
		convoBoxSmall2.getChildren().add(smallTitle2);
		convoListPane.getChildren().add(convoBoxSmall2);
		
		leftPane.setCenter(convoListPane);
		
		FlowPane convoSettingsPane = new FlowPane();
		convoSettingsPane.setHgap(7);
		convoSettingsPane.getChildren().add(lockPicView);
		convoSettingsPane.getChildren().add(groupPicView);
		convoSettingsPane.getChildren().add(dotsPicView);
		convoSettingsPane.setAlignment(Pos.TOP_RIGHT);
		
		convoInfoPane.setRight(convoSettingsPane);
				
		
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
