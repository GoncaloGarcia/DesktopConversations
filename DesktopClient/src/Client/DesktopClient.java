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
	
	Image paperclip = new Image(getClass().getResourceAsStream("/paperclip.png"));
	Image addContact = new Image(getClass().getResourceAsStream("/newcontact.png"));

	
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
		rightPane.setPrefSize(600, 550);

		leftPane = new BorderPane();
		leftPane.setId("lpane");
		leftPane.setPrefWidth(250);


		ConvoPane msgPane = new ConvoPane();
		
		ConvoMenuBar menubar = new ConvoMenuBar();
		menubar.setTitle("Conversations.im Summer of Code 2017");
		
		
		Scene scene = new Scene(bPane);
		loadStyleSheets(scene);

		TextArea msgInput = createWritingArea(msgPane);

		FlowPane convoListPane = createConvoList();

		createSmallConvo(convoListPane, "Conversations General", 0,false);
		createSmallConvo(convoListPane, "Conversations Q&A", 3,false);
		createSmallConvo(convoListPane, "Conversations Begginners", 0,false);
		createSmallConvo(convoListPane, "Conversations Deutch", 0,false);
		createSmallConvo(convoListPane, "Conversations Summer of Code 2017", 2,true);
		createSmallConvo(convoListPane, "Conversations Bugs", 15,false);
		
		createAddNewContact(convoListPane);

		leftPane.setCenter(convoListPane);
		rightPane.setTop(menubar);
		leftPane.setTop(new UserInfoPane());
		rightPane.setLeft(msgPane);
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
		convoBoxSmall.setMaxSize(250, 28);
		convoBoxSmall.setId("convoBox");

		ImageView addC = new ImageView(addContact);
		addC.setFitHeight(20);
		addC.setPreserveRatio(true);
		Label title = new Label("Add new contact");
		title.setId("cTitleNotif");
		
		convoBoxSmall.getChildren().add(addC);
		convoBoxSmall.getChildren().add(title);
		
		convoListPane.getChildren().add(convoBoxSmall);
		convoListPane.setAlignment(Pos.TOP_LEFT);
	}

	private FlowPane createConvoList() {
		FlowPane convoListPane = new FlowPane(Orientation.VERTICAL);
		convoListPane.setVgap(-4);
		convoListPane.setColumnHalignment(HPos.CENTER);
		convoListPane.setId("listPane");
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
		
		msgInput.setMaxSize(500, 20);
		rightPane.setAlignment(msgInput, Pos.BOTTOM_CENTER);
		HBox writingArea = new HBox();
		writingArea.setAlignment(Pos.CENTER);
		
		Button addMore = new Button();
		addMore.setId("addmore");
		ImageView paperclipView = new  ImageView(paperclip);
		paperclipView.setFitHeight(29);
		paperclipView.setFitWidth(29);
		addMore.setGraphic(paperclipView);
		
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
