package Client;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class ConvoMenuBar extends BorderPane{
	
	Image group;
	Image lock;
	Image dots;
	String convoName;
	Label convoNameLabel;
	
	
	public ConvoMenuBar() {
		setAppearance();
		LoadImages();
		createSettings();
	}
	
	public void setTitle(String convoName){
		this.convoName = convoName;
		convoNameLabel = new Label(convoName);
		
		BorderPane.setAlignment(convoNameLabel, Pos.CENTER_RIGHT);
		BorderPane.setMargin(convoNameLabel, new Insets(0,0,0,30));
		convoNameLabel.setId("convoname");
		
		
		setLeft(convoNameLabel);
		
	}
	
	private void setAppearance(){
		setId("infoPane");
		setMinSize(200, 20);
		setPrefHeight(50);
		DropShadow dp = new DropShadow();
		dp.setWidth(0);
		setEffect(dp);
		
		BorderPane.setMargin(this, new Insets(-20,-20,0,-20));
	}
	
	private void LoadImages(){
		group = new Image(getClass().getResourceAsStream("/group.png"));
		lock = new Image(getClass().getResourceAsStream("/lock.png"));
		dots = new Image(getClass().getResourceAsStream("/dots.png"));
	}
	
	
	private void createSettings(){

		ImageView dotsPicView = new ImageView(dots);
		dotsPicView.setFitHeight(23);
		dotsPicView.setFitWidth(23);

		ImageView groupPicView = new ImageView(group);
		groupPicView.setFitHeight(23);
		groupPicView.setFitWidth(23);

		ImageView lockPicView = new ImageView(lock);
		lockPicView.setFitHeight(23);
		lockPicView.setFitWidth(23);
		
		
		FlowPane convoSettingsPane = new FlowPane();
		BorderPane.setMargin(convoSettingsPane, new Insets(0,20,0,0));
		convoSettingsPane.setHgap(7);
		convoSettingsPane.getChildren().add(lockPicView);
		convoSettingsPane.getChildren().add(groupPicView);
		convoSettingsPane.getChildren().add(dotsPicView);
		convoSettingsPane.setAlignment(Pos.CENTER_RIGHT);
		
		setRight(convoSettingsPane);
	}

}
