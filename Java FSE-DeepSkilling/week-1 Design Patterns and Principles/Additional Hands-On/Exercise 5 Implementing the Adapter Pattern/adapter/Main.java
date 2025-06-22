package com.pattern.adapter;

public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("mp4", "video.mp4");
    }
}
