package com.pattern.adapter;

public class AudioPlayer implements MediaPlayer {
    private Mp4Player mp4Player = new Mp4Player();

    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else if(audioType.equalsIgnoreCase("mp4")) {
            mp4Player.playMp4(fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
