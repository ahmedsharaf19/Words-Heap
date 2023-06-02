package wordsHeaps;

import javafx.scene.Cursor;
import javafx.scene.control.Label;

// Class inherits from Class Label And With some of its distinctive features
public class StyledLabel extends Label {
    public StyledLabel(String s) {
        super(s); // Call the super Contractor to s on the button
        setCursor(Cursor.CLOSED_HAND);  // change mouse to hand
        getStyleClass().add("my-text"); // Set Style To StyledLabel
    }
}