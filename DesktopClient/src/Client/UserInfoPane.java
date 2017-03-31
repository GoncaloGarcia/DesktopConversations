package Client;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class UserInfoPane extends HBox{
	
	private String userName;
	private String userStatus;
	private Image img;
	private Image dots;
	private Label userNameLabel;
	private Label userStatusLabel;
	
	
	public UserInfoPane() {
		userName = "CurrentUser";
		userStatus = "Online";
		setAppearance();
		loadImages();
		setUserPic();
		setUserInfo();
		//	setSettings();
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	
	private void setAppearance(){
		setId("userTopPane");
		setMinSize(100, 40);
		setPrefHeight(50);
		setSpacing(10);
		
		DropShadow dp = new DropShadow();
		dp.setWidth(0);
		setEffect(dp);
	}
	
	private void setUserInfo(){
		FlowPane userTopNamePane = new FlowPane(Orientation.VERTICAL);
		userTopNamePane.setId("topNamePane");
		userTopNamePane.setPrefHeight(50);
		userTopNamePane.setVgap(-5);
		
		userNameLabel = new Label("CurrentUser");
		userNameLabel.setId("UserNameLabel");

		userStatusLabel = new Label("Online");
		userStatusLabel.setId("userStatusLabel");
		
		userTopNamePane.getChildren().addAll(userNameLabel, userStatusLabel);
		
		getChildren().add(userTopNamePane);
	}
	
	private void loadImages(){
		dots = new Image(getClass().getResourceAsStream("/dots.png"));
		img = new Image(getClass().getResourceAsStream("/transferir.jpg"));
	}
	
	private void setUserPic(){
		ImageView userPicView = new ImageView(img);
		userPicView.setFitHeight(35);
		userPicView.setFitWidth(35);
		
		getChildren().add(userPicView);
	}
	
	private void setSettings(){
		ImageView settingsPicView = new ImageView(dots);
		settingsPicView.setFitHeight(25);
		settingsPicView.setFitWidth(25);

		FlowPane settingsPane = new FlowPane();
		settingsPane.setAlignment(Pos.TOP_RIGHT);
		settingsPane.setId("settingsPane");
		
		settingsPane.getChildren().add(settingsPicView);
		
		getChildren().add(settingsPane);
	}

}
