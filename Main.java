//Project JavaFX Basics by Anna Collins 10/15/19
//This program will create a standard program/Gui that will use two different handlers
//The anonymous and Lambda Expression handlers.


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;


public class Main extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        //Establish and set the Image Views and Buttons
        ImageView coreJavaPng=new ImageView(new Image("CoreJava.png", 300, 440, false, false));
        ImageView artAndSciencePng=new ImageView(new Image("JavaAnEventfulApproach.png", 300, 440, false, false));
        ImageView eventApprPng=new ImageView(new Image("TheArtAndScienceOfJava.png", 300, 440, false, false));//100, 100, false, false));
        Button coreJava = new Button("Core Java"); //change
        Button artAndScience = new Button("The Art and Science of Java");//change
        Button eventAppr = new Button("Eventful Approach");//change

        //Create and define the hBox
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(coreJava, artAndScience,eventAppr);

        // Create a border pane
        // Place nodes in the pane
        BorderPane pane = new BorderPane();
        pane.setTop(new CustomPane("Java Books")); //make this text view
        pane.setBottom(hb);
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setPrefSize(500,600);

        //Anonymous Inner Class Handler
        coreJava.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.setCenter(coreJavaPng);
            }
        });

        //Lambda Expressions Handler
        artAndScience.setOnAction((e) ->{
            pane.setCenter(artAndSciencePng);
        });
        eventAppr.setOnAction((e) ->{
            pane.setCenter(eventApprPng);
        });


        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Event Handling Demonstration"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}

// Define a custom pane to hold a label in the center of the pane
class CustomPane extends StackPane {
    public CustomPane(String title) {
        getChildren().add(new Label(title));
        setStyle("-fx-border-color: pink");
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    }
}

