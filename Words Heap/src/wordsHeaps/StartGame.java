package wordsHeaps;

import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class StartGame extends StackPane {
    //loading images for different Nodes by its path
    static ImageView play = new ImageView(new Image("images/play.png"));
    static ImageView aboutUsBtn = new ImageView(new Image("images/aboutUs.png"));
    ImageView settingBtn = new ImageView(new Image("images/setting2.png"));
    BackgroundImage backgroundImage = new BackgroundImage(new Image("images/main-background.png", 400, 750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    ImageView logo = new ImageView(new Image("images/logo-2.png"));
    ImageView logo_1 = new ImageView(new Image("images/logo.png"));
    Setting setting = new Setting();
    TranslateTransition translateTransition = new TranslateTransition();
    RotateTransition rotateTransition = new RotateTransition();

    // Animation Arrangement
    SequentialTransition sequentialTransition = new SequentialTransition(logo, translateTransition, rotateTransition);

    // class constructor
    public StartGame() {
        getChildren().addAll(settingBtn, logo, logo_1, play, aboutUsBtn);
        setBackground(new Background(backgroundImage));
        animationLogo();
        animationLogo_1();
        animationButtonPlay();
        animationAboutUsBtn();
        settingBtnStyling();
        sequentialTransition.play();
        Sounds.play_welcom();
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(5), event -> Sounds.play_Gsound())
        );
        timeline.play();
    }

    // animation for upper logo
    private void animationLogo() {
        logo.setRotate(180);
        setMargin(logo, new Insets(0, 0, 1000, 0));

        translateTransition.setDuration(Duration.seconds(2));
        translateTransition.setNode(logo);
        translateTransition.setByY(350);
        translateTransition.setCycleCount(1);

        rotateTransition.setDuration(Duration.seconds(0.5));
        rotateTransition.setNode(logo);
        rotateTransition.setByAngle(-180);
        rotateTransition.setAutoReverse(true);
        rotateTransition.setCycleCount(3);
    }

    // Upper logo animation method
    private void animationLogo_1() {
        logo_1.setScaleX(.6);
        logo_1.setScaleY(.6);
        logo_1.setTranslateY(300);
    }

    // (Start) Button animation method
    private void animationButtonPlay() {
        play.setTranslateY(60);
        play.setFitWidth(110);
        play.setFitHeight(110);
        play.setCursor(Cursor.HAND);

        ScaleTransition scale_btn_start = new ScaleTransition(Duration.seconds(1), play);
        play.setScaleX(0);
        play.setScaleY(0);
        scale_btn_start.setByX(1.7);
        scale_btn_start.setByY(1.7);

        sequentialTransition.setOnFinished(e -> scale_btn_start.play());
    }

    // (About us) Button animation method 
    private void animationAboutUsBtn() {
        aboutUsBtn.setTranslateY(160);
        aboutUsBtn.setFitHeight(110);
        aboutUsBtn.setFitWidth(110);
        aboutUsBtn.setCursor(Cursor.HAND);

        ScaleTransition scale_btn_exit = new ScaleTransition(Duration.seconds(1), aboutUsBtn);
        aboutUsBtn.setScaleX(0);
        aboutUsBtn.setScaleY(0);
        scale_btn_exit.setByX(1.7);
        scale_btn_exit.setByY(1.7);
        scale_btn_exit.setDelay(Duration.seconds(4.5));
        scale_btn_exit.play();
    }

    // setting logo animation and features method 
    public void settingBtnStyling() {
        settingBtn.setTranslateX(-175);
        settingBtn.setTranslateY(-340);
        settingBtn.setFitWidth(40);
        settingBtn.setFitHeight(40);
        settingBtn.setCursor(Cursor.HAND);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(4), settingBtn);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();
        settingBtn.setOnMouseClicked(event -> setting.showSettingsDialog());
    }
}