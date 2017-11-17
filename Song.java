package com.pesante;

import java.util.ArrayList;

public class Song {

    private String songTitle;
    private double songDuration;

    public Song(String songTitle, double songDuration) {
        this.songTitle = songTitle;
        this.songDuration = songDuration;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songName) {
        this.songTitle = songName;
    }

    public double getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(double songDuration) {
        this.songDuration = songDuration;
    }

@Override
    public String toString(){
        return this.songTitle + ": " + this.songDuration;
}


}
