package Client;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class ConvoPane extends FlowPane{
	
	public ConvoPane() {
		setAppearance();
	}
	
	private void setAppearance(){
		setOrientation(Orientation.VERTICAL);
		setId("cPane");
		//BorderPane.setMargin(this, new Insets(10,0,0,0));
		//setVgap(10);
		
		setColumnHalignment(HPos.LEFT);
		setPrefWidth(500);
		
	}
	
	public void addnewMessage(String title){
		FlowPane msgHolder = new FlowPane();
		BorderPane msgContent = new BorderPane();
		Label msg = new Label();
		Label pic = new Label();
		Label msginfo = new Label("CurrentUser  12:51");
		msginfo.setId("msginfo");
		Image img = new Image(getClass().getResourceAsStream("/transferir.jpg"));
		ImageView imgview = new ImageView(img);

		
		
		imgview.setFitHeight(35);
		imgview.setFitWidth(35);

		pic.setGraphic(imgview);
		
		msgContent.setCenter(msg);
		msgContent.setTop(msginfo);
		BorderPane.setAlignment(msginfo, Pos.TOP_LEFT);
		BorderPane.setAlignment(msg, Pos.TOP_LEFT);
		
		msgHolder.getChildren().add(pic);
		msgHolder.getChildren().add(msgContent);
		msgHolder.setHgap(5);
		msgHolder.setAlignment(Pos.TOP_LEFT);
		
		msg.setText(title);
		msg.setId("msg");
		
		getChildren().add(msgHolder);
		
		setMargin(msgHolder, new Insets(7,0,0,10));
	}

}
