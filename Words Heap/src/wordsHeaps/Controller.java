package wordsHeaps;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    static int cnt = 0; // counter of correct words
    private final ArrayList<StyledLabel> selectedLabels = new ArrayList<>(); // to store letters
    private boolean flag = false; // flag to control play sounds selected word right or not
    private int swap = 0; // variable to control in Swap animation

    // constructor that executed directly when get instance from it
    public Controller(Stage primaryStage, Scene startPlay) {
        primaryStage.centerOnScreen();

            // when click on start button we need to enter level 1
        StartGame.play.setOnMouseClicked(e -> {
            Sounds.stop_welcom();
            // we need to create level 1, with image
            Levels level1 = new Levels(new ImageView(new Image("levels/level1.jpg")));
            // we need to create words that exist in every level
            ArrayList<StyledLabel> word1 = new ArrayList<>(Arrays.asList(new StyledLabel("L"), new StyledLabel("E"), new StyledLabel("M"), new StyledLabel("O"), new StyledLabel("N")));
            ArrayList<StyledLabel> word2 = new ArrayList<>(Arrays.asList(new StyledLabel("P"), new StyledLabel("A"), new StyledLabel("N")));
            ArrayList<StyledLabel> word3 = new ArrayList<>(Arrays.asList(new StyledLabel("B"), new StyledLabel("L"), new StyledLabel("U"), new StyledLabel("E")));
            ArrayList<StyledLabel> word4 = new ArrayList<>(Arrays.asList(new StyledLabel("F"), new StyledLabel("I"), new StyledLabel("S"), new StyledLabel("H")));
            // this method to create full level, I need to pass to it that thing,
            //  so we pass level and the words
            createLevel(primaryStage, level1, word1, word2, word3, word4);
            // we need to enter level 2 after complete level 1 and so on...
            level1.next.setOnMouseClicked(e1 -> {
                Levels level2 = new Levels(new ImageView(new Image("levels/level2.png")));
                ArrayList<StyledLabel> word1_2 = new ArrayList<>(Arrays.asList(new StyledLabel("F"), new StyledLabel("L"), new StyledLabel("O"), new StyledLabel("A"), new StyledLabel("T")));
                ArrayList<StyledLabel> word2_2 = new ArrayList<>(Arrays.asList(new StyledLabel("I"), new StyledLabel("N"), new StyledLabel("T")));
                ArrayList<StyledLabel> word3_2 = new ArrayList<>(Arrays.asList(new StyledLabel("C"), new StyledLabel("H"), new StyledLabel("A"), new StyledLabel("R")));
                ArrayList<StyledLabel> word4_2 = new ArrayList<>(Arrays.asList(new StyledLabel("D"), new StyledLabel("O"), new StyledLabel("U"), new StyledLabel("B"), new StyledLabel("L"), new StyledLabel("E")));
                createLevel(primaryStage, level2, word1_2, word2_2, word3_2, word4_2);

                level2.next.setOnMouseClicked(e3 -> {
                    Levels level3 = new Levels(new ImageView(new Image("levels/level3.jfif")));
                    ArrayList<StyledLabel> word1_3 = new ArrayList<>(Arrays.asList(new StyledLabel("M"), new StyledLabel("A"), new StyledLabel("N")));
                    ArrayList<StyledLabel> word2_3 = new ArrayList<>(Arrays.asList(new StyledLabel("S"), new StyledLabel("k"), new StyledLabel("y")));
                    ArrayList<StyledLabel> word3_3 = new ArrayList<>(Arrays.asList(new StyledLabel("O"), new StyledLabel("R"), new StyledLabel("A"), new StyledLabel("N"), new StyledLabel("G"), new StyledLabel("E")));
                    ArrayList<StyledLabel> word4_3 = new ArrayList<>(Arrays.asList(new StyledLabel("J"), new StyledLabel("A"), new StyledLabel("C"), new StyledLabel("K"), new StyledLabel("E"), new StyledLabel("T")));
                    createLevel(primaryStage, level3, word1_3, word2_3, word3_3, word4_3);

                    level3.next.setOnMouseClicked(e4 -> {
                        Levels level4 = new Levels(new ImageView(new Image("levels/level4.png")));
                        ArrayList<StyledLabel> word1_4 = new ArrayList<>(Arrays.asList(new StyledLabel("B"), new StyledLabel("R"), new StyledLabel("E"), new StyledLabel("A"), new StyledLabel("K")));
                        ArrayList<StyledLabel> word2_4 = new ArrayList<>(Arrays.asList(new StyledLabel("T"), new StyledLabel("R"), new StyledLabel("Y")));
                        ArrayList<StyledLabel> word3_4 = new ArrayList<>(Arrays.asList(new StyledLabel("N"), new StyledLabel("E"), new StyledLabel("W")));
                        ArrayList<StyledLabel> word4_4 = new ArrayList<>(Arrays.asList(new StyledLabel("D"), new StyledLabel("E"), new StyledLabel("F"), new StyledLabel("U"), new StyledLabel("L"), new StyledLabel("T")));
                        createLevel(primaryStage, level4, word1_4, word2_4, word3_4, word4_4);

                        level4.next.setOnMouseClicked(e5 -> {
                            Levels level5 = new Levels(new ImageView(new Image("levels/level5.jpg")));
                            ArrayList<StyledLabel> word1_5 = new ArrayList<>(Arrays.asList(new StyledLabel("J"), new StyledLabel("U"), new StyledLabel("I"), new StyledLabel("C"), new StyledLabel("E")));
                            ArrayList<StyledLabel> word2_5 = new ArrayList<>(Arrays.asList(new StyledLabel("R"), new StyledLabel("E"), new StyledLabel("D")));
                            ArrayList<StyledLabel> word3_5 = new ArrayList<>(Arrays.asList(new StyledLabel("T"), new StyledLabel("A"), new StyledLabel("B"), new StyledLabel("L"), new StyledLabel("E")));
                            ArrayList<StyledLabel> word4_5 = new ArrayList<>(Arrays.asList(new StyledLabel("O"), new StyledLabel("R"), new StyledLabel("A"), new StyledLabel("N"), new StyledLabel("G"), new StyledLabel("E")));
                            createLevel(primaryStage, level5, word1_5, word2_5, word3_5, word4_5);

                            level5.next.setOnMouseClicked(e6 -> {
                                Levels level6 = new Levels(new ImageView(new Image("levels/level6.jpeg")));
                                ArrayList<StyledLabel> word1_6 = new ArrayList<>(Arrays.asList(new StyledLabel("P"), new StyledLabel("Y"), new StyledLabel("T"), new StyledLabel("H"), new StyledLabel("O"), new StyledLabel("N")));
                                ArrayList<StyledLabel> word2_6 = new ArrayList<>(Arrays.asList(new StyledLabel("H"), new StyledLabel("T"), new StyledLabel("M"), new StyledLabel("L")));
                                ArrayList<StyledLabel> word3_6 = new ArrayList<>(Arrays.asList(new StyledLabel("S"), new StyledLabel("W"), new StyledLabel("I"), new StyledLabel("F"), new StyledLabel("T")));
                                ArrayList<StyledLabel> word4_6 = new ArrayList<>(Arrays.asList(new StyledLabel("K"), new StyledLabel("O"), new StyledLabel("T"), new StyledLabel("L"), new StyledLabel("I"), new StyledLabel("N")));
                                level6.gridPane.setTranslateY(355);
                                createLevel(primaryStage, level6, word1_6, word2_6, word3_6, word4_6);

                                level6.next.setOnMouseClicked(e7 -> {
                                    Levels level7 = new Levels(new ImageView(new Image("levels/level7.jpeg")));
                                    ArrayList<StyledLabel> word1_7 = new ArrayList<>(Arrays.asList(new StyledLabel("C"), new StyledLabel("U"), new StyledLabel("T"), new StyledLabel("E")));
                                    ArrayList<StyledLabel> word2_7 = new ArrayList<>(Arrays.asList(new StyledLabel("C"), new StyledLabel("A"), new StyledLabel("T")));
                                    ArrayList<StyledLabel> word3_7 = new ArrayList<>(Arrays.asList(new StyledLabel("R"), new StyledLabel("O"), new StyledLabel("C"), new StyledLabel("K")));
                                    ArrayList<StyledLabel> word4_7 = new ArrayList<>(Arrays.asList(new StyledLabel("E"), new StyledLabel("A"), new StyledLabel("R"), new StyledLabel("S")));
                                    createLevel(primaryStage, level7, word1_7, word2_7, word3_7, word4_7);

                                    level7.next.setOnMouseClicked(e8 -> {
                                        Levels level8 = new Levels(new ImageView(new Image("levels/level8.jpg")));
                                        ArrayList<StyledLabel> word1_8 = new ArrayList<>(Arrays.asList(new StyledLabel("P"), new StyledLabel("L"), new StyledLabel("A"), new StyledLabel("T"), new StyledLabel("E")));
                                        ArrayList<StyledLabel> word2_8 = new ArrayList<>(Arrays.asList(new StyledLabel("R"), new StyledLabel("E"), new StyledLabel("D")));
                                        ArrayList<StyledLabel> word3_8 = new ArrayList<>(Arrays.asList(new StyledLabel("G"), new StyledLabel("L"), new StyledLabel("O"), new StyledLabel("V"), new StyledLabel("E"), new StyledLabel("S")));
                                        ArrayList<StyledLabel> word4_8 = new ArrayList<>(Arrays.asList(new StyledLabel("C"), new StyledLabel("A"), new StyledLabel("N"), new StyledLabel("D"), new StyledLabel("L"), new StyledLabel("E")));
                                        createLevel(primaryStage, level8, word1_8, word2_8, word3_8, word4_8);

                                        level8.next.setOnMouseClicked(e9 -> {
                                            Levels level9 = new Levels(new ImageView(new Image("levels/level9.jpeg")));
                                            ArrayList<StyledLabel> word1_9 = new ArrayList<>(Arrays.asList(new StyledLabel("H"), new StyledLabel("E"), new StyledLabel("A"), new StyledLabel("R"), new StyledLabel("T")));
                                            ArrayList<StyledLabel> word2_9 = new ArrayList<>(Arrays.asList(new StyledLabel("L"), new StyledLabel("O"), new StyledLabel("V"), new StyledLabel("E")));
                                            ArrayList<StyledLabel> word3_9 = new ArrayList<>(Arrays.asList(new StyledLabel("H"), new StyledLabel("A"), new StyledLabel("N"), new StyledLabel("D")));
                                            ArrayList<StyledLabel> word4_9 = new ArrayList<>(Arrays.asList(new StyledLabel("B"), new StyledLabel("L"), new StyledLabel("A"), new StyledLabel("C"), new StyledLabel("K")));
                                            level9.gridPane.setTranslateY(355);
                                            createLevel(primaryStage, level9, word1_9, word2_9, word3_9, word4_9);

                                            level9.next.setOnMouseClicked(e10 -> {
                                                Levels level10 = new Levels(new ImageView(new Image("levels/level10.jpg")));
                                                ArrayList<StyledLabel> word1_10 = new ArrayList<>(Arrays.asList(new StyledLabel("F"), new StyledLabel("L"), new StyledLabel("O"), new StyledLabel("W"), new StyledLabel("E"), new StyledLabel("R"), new StyledLabel("S")));
                                                ArrayList<StyledLabel> word2_10 = new ArrayList<>(Arrays.asList(new StyledLabel("C"), new StyledLabel("H"), new StyledLabel("A"), new StyledLabel("I"), new StyledLabel("R")));
                                                ArrayList<StyledLabel> word4_10 = new ArrayList<>(Arrays.asList(new StyledLabel("G"), new StyledLabel("R"), new StyledLabel("O"), new StyledLabel("U"), new StyledLabel("N"), new StyledLabel("D")));
                                                ArrayList<StyledLabel> word3_10 = new ArrayList<>(Arrays.asList(new StyledLabel("T"), new StyledLabel("A"), new StyledLabel("B"), new StyledLabel("L"), new StyledLabel("E")));
                                                level10.gridPane.setTranslateY(310);
                                                createLevel(primaryStage, level10, word1_10, word2_10, word3_10, word4_10);

                                                level10.next.setOnMouseClicked(e11 -> {
                                                    Levels level11 = new Levels(new ImageView(new Image("images/youWin.png")));
                                                    Scene playGame11 = new Scene(level11, 400, 750);
                                                    primaryStage.setScene(playGame11);
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
        });
        // when click on back button --> return to start Play
        Levels.back.setOnMouseClicked(event -> primaryStage.setScene(startPlay));
        primaryStage.show();
        primaryStage.setResizable(false); // Disable resize of Stage
    }

    // this for create the level I want to pass the words and the level to apply
    // on levels not one level
    private void createLevel(Stage primaryStage, Levels level, ArrayList<StyledLabel> word1, ArrayList<StyledLabel> word2, ArrayList<StyledLabel> word3, ArrayList<StyledLabel> word4) {
        Scene playGame = new Scene(level, 400, 750);
        playGame.getStylesheets().add("css/style.css"); // link a scene with css file to apply style button
        level.setLevel(word1, word2, word3, word4); // to put and arrange words on grid pane
        cnt = 0; // reset num. of correct words every level
        drag(level, wordArray(word1, word2, word3, word4)); // Drag Event on words, a word array is a method that collect words in one array
        primaryStage.setScene(playGame); // set level on stage
    }

    // we need to collect word...s in one array. if I don't that we repeated drag
    // code on every word * 4
    public ArrayList<ArrayList<StyledLabel>> wordArray(ArrayList<StyledLabel> word1, ArrayList<StyledLabel> word2, ArrayList<StyledLabel> word3, ArrayList<StyledLabel> word4) {
        ArrayList<ArrayList<StyledLabel>> words = new ArrayList<>();
        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        return words;
    }

    // // Drag Event on words I pass level and words
    public void drag(Levels level, ArrayList<ArrayList<StyledLabel>> words) {
        level.gridPane.setOnMouseDragged(event -> { // when mouse drag on gridpane
            for (ArrayList<StyledLabel> word : words) { // loop on every word
                for (StyledLabel label : word) { // inside every word on label letter
                    // استخدام هذا لمعرفة ما إذا كانت نقطة النقر الحالية في حدود العنصر المحدد أو لا
                    // check to know if the click inside the button or not
                    if (label.getBoundsInParent().contains(event.getX(), event.getY()) && !selectedLabels.contains(label)) {
                        selectedLabels.add(label); // store label to reset selected label style on Released
                        fadeButtonHover(label);
                        // if click exist inside a button, change a style letter to yellow color
                        label.setStyle("-fx-background-color: linear-gradient(rgb(238, 240, 102),rgb(172, 161, 10));" +
                                "-fx-effect: dropshadow(three-pass-box, rgb(165, 163, 18), 1, 3, 0, -4);" +
                                "-fx-pref-width:43px;" +
                                "-fx-pref-height:43px;");
                    }
                }
            }
        });
        // the important method, main idea after he drags we want to make many things
        level.gridPane.setOnMouseReleased((MouseEvent event) -> {
            for (ArrayList<StyledLabel> word : words) { // loop on every word
                for (StyledLabel label : word) { // inside every word on label letter
                    label.setStyle(""); // reset label style to green color again
                }
            }
            for (ArrayList<StyledLabel> word : words) { // loop on every word
                if (word.equals(selectedLabels)) { // check if selectedLabel is equal to word
                    for (StyledLabel label : word) { // inside every word on label letter
                        if (swap % 2 == 0) { // swap animation Button from ButtonSuccess and ButtonSuccess2 and so on
                            animationButtonSuccess(label);
                        } else {
                            animationButtonSuccess2(label);
                        }
                    }
                    swap++; // swap animation Button from ButtonSuccess and ButtonSuccess2 and so on
                    cnt++; // increase counter of correct words
                    Levels.pointScore += 21; // increase score
                    level.score.setText(String.valueOf(Levels.pointScore)); // increase score
                    level.progressBar_1.setWidth(cnt * 87.7); // increase progress
                    flag = true;
                }
            }

            level.totalItem.setText(cnt + "/" + "4"); // increase num of word that I solved
            // Clear to return check again with an empty array
            selectedLabels.clear();

            // Play sounds when correct & wrong answer
            if (flag)
                Sounds.play_Correct();
            else
                Sounds.play_Wrong();

            flag = false;

            if (cnt == 4) { // check if all words solved and no words exist
                level.next.setVisible(true); // show button next to translate next level
                level.congrats();
                Sounds.play_next();
            }
        });
    }

    // Fade Transition on letters when he hovers on it;
    private void fadeButtonHover(StyledLabel bt) {
        FadeTransition fade_btn = new FadeTransition(Duration.seconds(0.5), bt);
        fade_btn.setFromValue(0.7);
        fade_btn.setToValue(1);
        fade_btn.play();
    }

    // Animation On Words after he gets solve the correct word
    private void animationButtonSuccess(StyledLabel bt) {
        ScaleTransition shrink_btn = new ScaleTransition(Duration.seconds(0.3), bt);
        shrink_btn.setToX(0);
        shrink_btn.setToY(0);
        shrink_btn.play();
    }

    // Another Animation On Words after he gets solve the correct word
    private void animationButtonSuccess2(StyledLabel bt) {
        TranslateTransition shrink_btn = new TranslateTransition(Duration.seconds(0.4), bt);
        shrink_btn.setToX(500);
        shrink_btn.setByY(500);
        shrink_btn.play();
    }
}