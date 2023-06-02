package wordsHeaps;

import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Setting {
    Dialog<Void> settingsDialog = new Dialog<>();

    public Setting() {
        Image backgroundImage = new Image("images/settingBackground1.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));
        settingsDialog.setTitle("Settings");

        DialogPane dialogPane = settingsDialog.getDialogPane();
        dialogPane.setBackground(new Background(background));
        dialogPane.setMaxSize(300, 500);
        dialogPane.setMinSize(300, 500);
        /*
         * this line add button to dialog, we should add button to let we close the dialog,
         *  without it, we can't close the dialog*/
        dialogPane.getButtonTypes().add(ButtonType.CLOSE);
        // we don't need the button so that we will make it invisible
        Node closeButton = dialogPane.lookupButton(ButtonType.CLOSE);
        closeButton.setVisible(false);
        dialogPane.setContent(customPane()); //this line put the pane on the dialog
    }

    private static Pane customPane() {
        ImageView follow = new ImageView(new Image("images/follow.png"));
        ImageView facebook = new ImageView(new Image("images/facebook.png"));
        ImageView twitter = new ImageView(new Image("images/twitter.png"));
        ImageView linkedin = new ImageView(new Image("images/linkedin.png"));
        ImageView musicPlayIcon = new ImageView(new Image("images/musicPlayeIcon.png"));
        ImageView musicMuteIcon = new ImageView(new Image("images/musicMuteIcon.png"));
        ImageView soundsPlay = new ImageView(new Image("images/soundsPlay.png"));
        ImageView soundsMute = new ImageView(new Image("images/soundsMute.png"));
        ImageView googleButton = new ImageView(new Image("images/googleButton.png"));

        musicIcon(musicPlayIcon);
        musicIcon(musicMuteIcon);
        musicPlayIcon.setVisible(false);
        soundsIcon(soundsPlay);
        soundsIcon(soundsMute);
        soundsPlay.setVisible(false);

        follow.setFitWidth(210);
        follow.setFitHeight(210);
        follow.setTranslateY(240);
        follow.setTranslateX(30);

        googleButton.setFitWidth(200);
        googleButton.setFitHeight(200);
        googleButton.setTranslateX(50);
        googleButton.setTranslateY(180);
        AnimationImages(googleButton);

        facebook.setTranslateX(65);
        facebook.setTranslateY(390);
        stylingLogos(facebook);

        twitter.setTranslateX(125);
        twitter.setTranslateY(390);
        stylingLogos(twitter);

        linkedin.setTranslateX(185);
        linkedin.setTranslateY(390);
        stylingLogos(linkedin);

        //play the sound and disappear its icon and appears mute icon
        soundsPlay.setOnMouseClicked(e -> {
            soundsPlay.setVisible(false);
            soundsMute.setVisible(true);
            Sounds.play();
        });

        //stop the sound and disappear its icon and appears play icon
        soundsMute.setOnMouseClicked(e -> {
            soundsMute.setVisible(false);
            soundsPlay.setVisible(true);
            Sounds.stop();
        });

        //stop the background sound and disappear its icon and appears mute icon
        musicPlayIcon.setOnMouseClicked(e -> {
            musicPlayIcon.setVisible(false);
            musicMuteIcon.setVisible(true);
            Sounds.play_background();
        });

        //stop the background sound and disappear its icon and appears play icon
        musicMuteIcon.setOnMouseClicked(e -> {
            musicMuteIcon.setVisible(false);
            musicPlayIcon.setVisible(true);
            Sounds.stop_background();
        });

        Pane pane = new Pane();
        pane.getChildren().addAll(musicPlayIcon, musicMuteIcon, soundsPlay, soundsMute, googleButton, follow, facebook, twitter, linkedin);
        return pane;
    }

    //this method makes the position, width and height of music icons
    private static void musicIcon(ImageView iv) {
        iv.setFitWidth(200);
        iv.setFitHeight(200);
        iv.setTranslateX(50);
        iv.setTranslateY(50);
    }

    //this method makes the position, width and height of sound icons
    private static void soundsIcon(ImageView iv) {
        iv.setFitWidth(200);
        iv.setFitHeight(200);
        iv.setTranslateX(50);
        iv.setTranslateY(120);
    }

    //this method makes the width, height and animation for Twitter, facebook and LinkedIn icons
    private static void stylingLogos(ImageView iv) {
        iv.setFitWidth(50);
        iv.setFitHeight(50);
        AnimationImages(iv);
    }

    // that method makes animation up and down for all images that it receives
    public static void AnimationImages(ImageView iv) {
        // animation the image up
        ScaleTransition scaleUpTransition = new ScaleTransition(Duration.seconds(0.5), iv);
        scaleUpTransition.setFromX(1.0);
        scaleUpTransition.setFromY(1.0);
        scaleUpTransition.setToX(1.18);
        scaleUpTransition.setToY(1.18);

        //animation the image down
        ScaleTransition scaleDownTransition = new ScaleTransition(Duration.seconds(0.5), iv);
        scaleDownTransition.setFromX(1.18);
        scaleDownTransition.setFromY(1.18);
        scaleDownTransition.setToX(1.0);
        scaleDownTransition.setToY(1.0);

        iv.setOnMouseEntered(event -> scaleUpTransition.play());
        iv.setOnMouseExited(event -> {
            scaleUpTransition.stop();
            scaleDownTransition.play();
        });
    }

    //the dialog appears when invoke this method
    public void showSettingsDialog() {
        settingsDialog.showAndWait();
    }
}