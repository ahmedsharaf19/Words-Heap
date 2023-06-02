package wordsHeaps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainClass extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create an Object From StartGame And put it in Start Game Scene
        StartGame startGame = new StartGame();
        Scene startPlay = new Scene(startGame, 400, 750);

        // To Import and set css file in Start Game Scene
        startPlay.getStylesheets().add("css/style.css");
        primaryStage.setScene(startPlay);
        /*
         * Create Object From Controller to perform the constructor and methods in that class,
         * that class contains all levels properties and when it appears and other details
         * */
        new Controller(primaryStage, startPlay);

        // Set Action In About Us Button To Show About Us Stage
        StartGame.aboutUsBtn.setOnMouseClicked(event -> {
            // Create an Object From About class and put it on Scene
            Scene aboutScene = new Scene(new AboutUs(), 400, 750);
            primaryStage.setScene(aboutScene);
        });

        // Set Action To Back Button To Return Start Game Scene
        AboutUs.back.setOnMouseClicked(event -> primaryStage.setScene(startPlay));
        primaryStage.centerOnScreen();  // To Set Stage In Center Screen
        primaryStage.setTitle("Word Heaps");
        primaryStage.getIcons().add(new Image("images/logoprog5.png")); // To Set Logo Of Game
    }
}