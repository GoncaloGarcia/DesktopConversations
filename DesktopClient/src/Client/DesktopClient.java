package Client;

import javax.swing.BorderFactory;

import com.sun.java.swing.plaf.motif.MotifBorders.BevelBorder;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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

	
	BorderPane bPane;
	BorderPane rightPane;
	BorderPane leftPane;
	BorderPane leftContent;
	
	Image paperclip = new Image(getClass().getResourceAsStream("/paperclip.png"));
	Image addContact = new Image(getClass().getResourceAsStream("/newcontact.png"));
	Image filter = new Image(getClass().getResourceAsStream("/search.png"));

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Conversations.im Desktop");

		bPane = new BorderPane();
		bPane.setId("bpane");

		rightPane = new BorderPane();
		rightPane.setId("rpane");
		rightPane.setMinHeight(400);
		rightPane.setPrefSize(550, 550);

		leftPane = new BorderPane();
		leftPane.setId("lpane");
		leftPane.setPrefWidth(250);

		leftContent = new BorderPane();
		

		ConvoPane msgPane = new ConvoPane();
		
		ConvoMenuBar menubar = new ConvoMenuBar();
		menubar.setTitle("Conversations.im Summer of Code 2017");
		
		
		Scene scene = new Scene(bPane);
		primaryStage.setResizable(false);
		loadStyleSheets(scene);

		TextArea msgInput = createWritingArea(msgPane);

		FlowPane convoListPane = createConvoList();
		
		createFilterContact(convoListPane);

		createSmallConvo(convoListPane, "Conversations General", 0,false);
		createSmallConvo(convoListPane, "Conversations Q&A", 3,false);
		createSmallConvo(convoListPane, "Conversations Begginners", 0,false);
		createSmallConvo(convoListPane, "Conversations Deutch", 0,false);
		createSmallConvo(convoListPane, "Conversations Summer of Code 2017", 2,true);
		createSmallConvo(convoListPane, "Conversations Bugs", 15,false);
		
		createAddNewContact(convoListPane);

		leftContent.setCenter(convoListPane);
		
		leftPane.setCenter(leftContent);
		rightPane.setTop(menubar);
		leftPane.setTop(new UserInfoPane());
		rightPane.setCenter(msgPane);
		BorderPane.setMargin(msgPane, new Insets(8,-10,0,-20));
		bPane.setRight(rightPane);
		bPane.setLeft(leftPane);

		primaryStage.sizeToScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void loadStyleSheets(Scene scene) {
		scene.getStylesheets().add(
				DesktopClient.class.getResource("/desktopclient.css")
						.toExternalForm());
		
		scene.getStylesheets().add(
				DesktopClient.class.getResource("/convoItem.css")
						.toExternalForm());
		
		scene.getStylesheets().add(
				DesktopClient.class.getResource("/convoMenuBar.css")
						.toExternalForm());
		
		scene.getStylesheets().add(
				DesktopClient.class.getResource("/userInfoPane.css")
						.toExternalForm());
		
		scene.getStylesheets().add(
				DesktopClient.class.getResource("/convoPane.css")
						.toExternalForm());
	}

	private void createAddNewContact(FlowPane convoListPane) {
		HBox convoBoxSmall = new HBox();
		convoBoxSmall.setSpacing(5);
		convoBoxSmall.setMinSize(250, 20);
		//convoBoxSmall.setPrefWidth(200);
		//convoBoxSmall.setMaxSize(250, 28);
		convoBoxSmall.setId("convoBox");

		ImageView addC = new ImageView(addContact);
		addC.setFitHeight(20);
		addC.setPreserveRatio(true);
		Label title = new Label("Add new contact");
		title.setId("cTitleNotif");
		
		convoBoxSmall.getChildren().add(addC);
		convoBoxSmall.getChildren().add(title);
		
		leftPane.setBottom(convoBoxSmall);
		convoBoxSmall.setAlignment(Pos.TOP_CENTER);
		BorderPane.setMargin(convoBoxSmall, new Insets(-6,10,7,10));
	}
	private void createFilterContact(FlowPane convoListPane) {
		HBox convoBoxSmall = new HBox();
		convoBoxSmall.setSpacing(5);
		convoBoxSmall.setMinSize(250, 20);
		//convoBoxSmall.setPrefWidth(200);
		//convoBoxSmall.setMaxSize(250, 28);
		convoBoxSmall.setId("convoBox");

		ImageView addC = new ImageView(filter);
		addC.setFitHeight(20);
		addC.setPreserveRatio(true);
		Label title = new Label("Filter Contacts");
		title.setId("cTitleNotif");
		
		convoBoxSmall.getChildren().add(addC);
		convoBoxSmall.getChildren().add(title);
		BorderPane.setMargin(convoBoxSmall, new Insets(8,10,0,10));
		leftContent.setTop(convoBoxSmall);
		convoBoxSmall.setAlignment(Pos.TOP_CENTER);
		
	}

	private FlowPane createConvoList() {
		
		FlowPane convoListPane = new FlowPane(Orientation.VERTICAL);
		convoListPane.setVgap(0);
		convoListPane.setPrefWidth(100);
		convoListPane.setColumnHalignment(HPos.CENTER);
		convoListPane.setId("listPane");
		BorderPane.setMargin(convoListPane, new Insets(1.5,10,7.5,10));
		return convoListPane;
	}
	
	

	private TextArea createWritingArea(ConvoPane msgPane) {
		TextArea msgInput = new TextArea();
		msgInput.setId("input");
		msgInput.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {

				if (e.getCode() == KeyCode.ENTER) {
					
					msgPane.addnewMessage(msgInput.getText());
					msgInput.clear();
					e.consume();
				}

			}
		});
		
		msgInput.setMaxSize(500, 39);
		rightPane.setAlignment(msgInput, Pos.BOTTOM_CENTER);
		HBox writingArea = new HBox();
		writingArea.setAlignment(Pos.TOP_CENTER);
		
		Button addMore = new Button();
		addMore.setId("addmore");
		ImageView paperclipView = new  ImageView(paperclip);
		paperclipView.setFitHeight(29);
		paperclipView.setFitWidth(29);
		addMore.setGraphic(paperclipView);
		writingArea.setId("wArea");
		writingArea.setPrefHeight(50);
		BorderPane.setMargin(writingArea, new Insets(0,-10,-13,-20));
		
		writingArea.getChildren().add(addMore);
		writingArea.getChildren().add(msgInput);
		rightPane.setBottom(writingArea);	
		
		return msgInput;
	}

	private void createSmallConvo(FlowPane convoListPane, String title, int notified, boolean select) {
		ConvoItem item = new ConvoItem(title,notified);
		convoListPane.getChildren().add(item);
		if(select){ item.setSelected(); }
			
	}
}
