package Client;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ConvoItem extends HBox{
	
	private String title;
	private int notifications;
	private Label titleLabel;
	private Label notificationLabel;
	
	public ConvoItem(String title) {
		setAppearance();
		setTitle(title);
	}

	public ConvoItem(String title, int notifications){
		setAppearance();
		setTitle(title);
		setNotifications(notifications);
	}

	private void setAppearance() {
		setSpacing(10);
		setMinSize(250, 20);
		setMaxSize(250, 28);
		setId("convoBox");
		
	}
	
	public void setSelected() {
		setId("convoBoxSelected");
	}
	
	public void setTitle(String title){
		this.title = title;
		titleLabel = new Label(title);
		titleLabel.setId("cTitle");
		getChildren().add(titleLabel);
	}
	
	
	public void setNotifications(int notifications){
		this.notifications = notifications;
		notificationLabel = new Label("" + notifications);
		notificationLabel.setMinWidth(20);
		notificationLabel.setId("expandUp");
		notificationLabel.setAlignment(Pos.CENTER);
		if(notifications > 0){
			titleLabel.setId("cTitleNotif");
			getChildren().add(notificationLabel);
		}
		
	}

}
