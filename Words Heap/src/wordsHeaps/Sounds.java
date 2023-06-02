package wordsHeaps;

import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class Sounds {
    // Import Sounds
    static AudioClip sound_starPlay = new AudioClip(Objects.requireNonNull(Sounds.class.getResource("/sounds/welcom.mp3")).toString());
    static AudioClip sound_gamePlay = new AudioClip(Objects.requireNonNull(Sounds.class.getResource("/sounds/background.mp3")).toString());
    static AudioClip sound_correctAnswer = new AudioClip(Objects.requireNonNull(Sounds.class.getResource("/sounds/success_answer.mp3")).toString());
    static AudioClip sound_wrongAnswer = new AudioClip(Objects.requireNonNull(Sounds.class.getResource("/sounds/wrong_answer.mp3")).toString());
    static AudioClip sound_newLevel = new AudioClip(Objects.requireNonNull(Sounds.class.getResource("/sounds/successLevel.mp3")).toString());

    // Flags To Control Sounds
    private static boolean soundsFlag = true; // Flag To Control And Switch Between Correct and wrong, end level Sounds
    private static boolean musicFlag = true; // Flag to Control Plays or Stops background music

    // Method Playing  Welcom
    public static void play_welcom() {
        if (musicFlag) {
            sound_starPlay.setCycleCount(1);
            sound_starPlay.play();
        }
    }

    // Method Stoping Welcom
    public static void stop_welcom() {
        sound_starPlay.stop();
    }

    // Method Playing Game Play Sound
    public static void play_Gsound() {
        sound_gamePlay.setCycleCount(MediaPlayer.INDEFINITE);
        if (musicFlag)
            sound_gamePlay.play();
    }

    // Method Stoping Game Play Sound
    public static void stop_Gsound() {
        sound_gamePlay.stop();
    }

    // Method Playing Correct Answer
    public static void play_Correct() {
        sound_correctAnswer.setCycleCount(1);
        if (soundsFlag)
            sound_correctAnswer.play();
    }

    // Method Stoping Correct Answer
    public static void stop_Correct() {
        sound_correctAnswer.stop();
    }

    // Method Playing Wrong Answer
    public static void play_Wrong() {
        sound_wrongAnswer.setCycleCount(1);
        if (soundsFlag)
            sound_wrongAnswer.play();
    }

    // Method Stoping  Wrong Answer
    public static void stop_Wrong() {
        sound_wrongAnswer.stop();
    }

    // Method to play the end of level sound
    public static void play_next() {
        sound_newLevel.setCycleCount(1);
        if (soundsFlag)
            sound_newLevel.play();
    }

    // Method Stop the end of level sound
    public static void stop_next() {
        sound_newLevel.stop();
    }

    // Method to stop correct and wrong and end level sound
    public static void stop() {
        soundsFlag = false;
        stop_Correct();
        stop_Wrong();
        stop_next();
    }

    // Method to play correct and wrong and end level sound
    public static void play() {
        soundsFlag = true;
    }

    // Method to stop welcom and game sound
    public static void stop_background() {
        musicFlag = false;
        stop_Gsound();
        stop_welcom();
    }

    // Method to play welcom and game sound
    public static void play_background() {
        musicFlag = true;
        play_Gsound();
    }
}