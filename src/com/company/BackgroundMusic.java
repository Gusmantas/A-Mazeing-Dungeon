package com.company;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class BackgroundMusic implements Serializable {
    Clip clip;
    AudioInputStream stream;


    public BackgroundMusic(String filePath) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        stream = AudioSystem.getAudioInputStream(new File(filePath));
        clip = AudioSystem.getClip();
        clip.open(stream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
    }

}
