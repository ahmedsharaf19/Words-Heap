package wordsHeaps;

import javafx.animation.RotateTransition;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URI;
import java.awt.Desktop;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;

public class AboutUs extends StackPane {
    static ImageView back = new ImageView(new Image("images/back.png"));

    public AboutUs() {
        Image backgroundImage = new Image("images/aboutBackGround.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));
        setBackground(new Background(background));
        stylingBackButton();

        ImageView our = new ImageView(new Image("images/our.jpeg"));
        our.setFitWidth(260);
        our.setFitHeight(260);
        //we need our image to be circled, so that we will make a shape circle and clip image from that shape
        Circle clip = new Circle(130, 130, 130);
        our.setClip(clip);
        our.setTranslateY(-75);

        ImageView[] arrayIcons = createIcons();
        arrayIcons[0].setTranslateX(-95);
        arrayIcons[0].setTranslateY(210);
        arrayIcons[1].setTranslateX(-180);
        arrayIcons[1].setTranslateY(253);
        arrayIcons[2].setTranslateX(-180);
        arrayIcons[2].setTranslateY(300);
        arrayIcons[3].setTranslateX(-180);
        arrayIcons[3].setTranslateY(342);
        arrayIcons[4].setTranslateX(20);
        arrayIcons[4].setTranslateY(253);
        arrayIcons[5].setTranslateX(20);
        arrayIcons[5].setTranslateY(300);
        arrayIcons[6].setTranslateX(20);
        arrayIcons[6].setTranslateY(342);
        arrayIcons[0].setOnMouseClicked(event -> openURL("https://www.linkedin.com/in/redaelsayied"));
        arrayIcons[1].setOnMouseClicked(event -> openURL("https://www.linkedin.com/in/ahmed-almohamdy-16723524a"));
        arrayIcons[2].setOnMouseClicked(event -> openURL("https://www.linkedin.com/in/3bdo-elkamed"));
        arrayIcons[3].setOnMouseClicked(event -> openURL("https://twitter.com/ahmedmo36423530?s=20"));
        arrayIcons[4].setOnMouseClicked(event -> openURL("https://www.linkedin.com/in/ahmedsharaf9"));
        arrayIcons[5].setOnMouseClicked(event -> openURL("https://www.linkedin.com/in/bassem-motlak-91886b249"));
        arrayIcons[6].setOnMouseClicked(event -> openURL("https://www.linkedin.com/in/marawan-walid-258621211"));
        getChildren().addAll(arrayIcons);
        getChildren().addAll(createCircle(), our, back);
    }

    //this method creates a circle and makes it rotation with time
    public Circle createCircle() {
        Circle circle = new Circle(140);
        circle.setTranslateY(-75);
        circle.setFill(null);
        circle.setStroke(Color.WHITE);
        circle.setStrokeWidth(5);
        circle.getStrokeDashArray().addAll(10.0, 10.0);// ححم الداش والشرطه الي ف الدايره

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(25), circle);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();
        return circle;
    }

    public void stylingBackButton() {
        back.setTranslateY(-350);
        back.setTranslateX(-175);
        back.setFitWidth(40);
        back.setFitHeight(40);
        back.setCursor(Cursor.HAND);
        Setting.AnimationImages(back);
    }

    /*this method creates an array of imageview
     * that images appear next to names,and make animation in it  */
    public ImageView[] createIcons() {
        Image personIcon = new Image("images/personIcon.png");
        ImageView[] arrayIcons = new ImageView[7];
        for (int i = 0; i < arrayIcons.length; i++) {
            arrayIcons[i] = new ImageView(personIcon);
            arrayIcons[i].setFitWidth(200);
            arrayIcons[i].setFitHeight(200);
            arrayIcons[i].setCursor(Cursor.HAND);
            Setting.AnimationImages(arrayIcons[i]);
        }
        return arrayIcons;
    }

    //that method opens any link sent to it
    private void openURL(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            System.out.println("invalid URL");
        }
    }
}