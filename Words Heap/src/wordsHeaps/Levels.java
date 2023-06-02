package wordsHeaps;

import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Levels extends Pane {
    // Declare and definition some Variable using in the game
    static int swapLevelAnimation = 0; // To Control the Type Of Animation Of the Elimination Words
    static int pointScore = 0; // To Store Coins Of Player
    // Import Logo and Some Images
    static ImageView back = new ImageView(new Image("images/back.png"));
    int currentScore = 0; // To Score the Number Of Correct Words Selected By User
    ImageView img;
    ImageView next = new ImageView(new Image("images/next.png"));
    Image background = new Image("images/background-1.png");
    ImageView logo = new ImageView(new Image("images/logo.png"));
    ImageView table = new ImageView(new Image("images/table.png"));
    ImageView board = new ImageView(new Image("images/board.png"));
    Label score = new Label(String.valueOf(pointScore)); // To View Score Of User
    Label totalItem = new Label(currentScore + "/" + 4); // Number Of Words In Each Level
    Rectangle progressBar_1 = new Rectangle(0, 7); // start width progress initial 0
    GridPane gridPane = new GridPane();

    // congratulation message after complete level
    public Levels(ImageView img) {
        setImage(img);
        styling();
        backButton();
        nextButtonStyling();
        // Swap Between Two Animations
        if (swapLevelAnimation % 2 == 0) {
            levelAnimation();
        } else {
            levelAnimation2();
        }

    }

    // Method To Arrangement Words In Level 
    public void setLevel(ArrayList<StyledLabel> word1, ArrayList<StyledLabel> word2, ArrayList<StyledLabel> word3, ArrayList<StyledLabel> word4) {
        StyledLabel[] w1 = word1.toArray(new StyledLabel[0]);
        StyledLabel[] w2 = word2.toArray(new StyledLabel[0]);
        StyledLabel[] w3 = word3.toArray(new StyledLabel[0]);
        StyledLabel[] w4 = word4.toArray(new StyledLabel[0]);

        gridPane.addColumn(1, w1);
        gridPane.addColumn(2, w2);
        gridPane.addRow(word2.size(), w3);
        gridPane.addRow((word2.size() + 1), w4);
    }

    // Method to put the image and adjust some of its genes
    public void setImage(ImageView img) {
        this.img = img;
        img.setFitWidth(357);
        img.setFitHeight(195);
        img.setTranslateX(20);
        img.setTranslateY(75);
    }

    // Method To Put Adjust And Set Back Button
    public void backButton() {
        back.setTranslateY(3);
        back.setTranslateX(12);
        back.setFitWidth(34);
        back.setFitHeight(34);
        back.setCursor(Cursor.HAND);
        Setting.AnimationImages(back);
    }

    // Method To Put And Create Form Levels
    public void styling() {
        // Add Fixed Node In The Game
        getChildren().addAll(table, logo, img, board, totalItem, score, progressBar_1, gridPane, next, back);
        setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1, 1, true, true, false, false))));

        table.setTranslateY(580);
        table.setFitWidth(500);
        table.setFitHeight(180);

        logo.setTranslateX(100);
        logo.setTranslateY(620);
        logo.setFitHeight(190);
        logo.setFitWidth(190);

        board.setFitWidth(400);
        board.setFitHeight(250);
        board.setTranslateY(55);

        totalItem.setTranslateX(190);
        totalItem.setTranslateY(257);
        totalItem.setTextFill(Color.WHITE);
        totalItem.setFont(new Font("family", 12));
        totalItem.setStyle("-fx-font-weight: bold;");

        score.setTranslateX(328);
        score.setTranslateY(13.5);
        score.setFont(new Font("family", 15));
        score.setStyle("-fx-font-weight: bold;-fx-text-fill:white;");
        progressBar_1.setFill(Color.rgb(102, 240, 102));
        progressBar_1.setTranslateX(24.5);
        progressBar_1.setTranslateY(275.7);
        progressBar_1.setArcHeight(5);
        progressBar_1.setArcWidth(5);

        gridPane.setTranslateX(75);
        gridPane.setTranslateY(400);
        gridPane.setHgap(1);
        gridPane.setVgap(1);
    }

    // Method to set animation of Create Level
    public void levelAnimation() {
        gridPane.setScaleX(0);
        gridPane.setScaleY(0);
        swapLevelAnimation++;
        RotateTransition rotateLevel = new RotateTransition(Duration.seconds(1), gridPane);
        rotateLevel.setByAngle(360);
        rotateLevel.play();
        ScaleTransition scaleLevel = new ScaleTransition(Duration.seconds(1), gridPane);
        scaleLevel.setToX(1);
        scaleLevel.setToY(1);
        scaleLevel.play();
    }

    // Method to set animation2 of Create Level
    // We will Swap Between Them
    public void levelAnimation2() {
        swapLevelAnimation++;
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), gridPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    // Set Adjust To Back button
    public void nextButtonStyling() {
        next.setTranslateY(350);
        next.setTranslateX(130);
        next.setFitWidth(150);
        next.setFitHeight(150);
        next.setCursor(Cursor.HAND);
        next.setVisible(false);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2), next);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(.9);
        scaleTransition.setToY(.9);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition.play();
    }

    // Create Congrats Word after Finish The Level
    public void congrats() {
        StyledLabel[] congratArray = {new StyledLabel("C"), new StyledLabel("O"), new StyledLabel("N"), new StyledLabel("G"), new StyledLabel("R"), new StyledLabel("A"), new StyledLabel("T"), new StyledLabel("S")};
        HBox congrats = new HBox(congratArray);
        getChildren().add(congrats);
        congrats.setTranslateX(38);
        congrats.setTranslateY(900);

        TranslateTransition CongratsTranslate = new TranslateTransition(Duration.seconds(0.7), congrats);
        CongratsTranslate.setToX(38);
        CongratsTranslate.setToY(600);
        CongratsTranslate.play();
    }
}