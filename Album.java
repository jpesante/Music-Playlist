package com.pesante;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String albumName;
    private String artistName;

    private ArrayList<Song> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<Song>();
    }

    public boolean addSong(String songTitle, double songDuration) {
        // be sure not to duplicate song
    if(findSong(songTitle) == null) {
        this.songList.add(new Song(songTitle, songDuration));
        return true;
    }
    return false;
    }

    private Song findSong (String songTitle) {
        // shortcut instead of iterating through i.  ie. for (int i = 0, i<songList.size(); i++) {}
        for (Song checkedSong : this.songList) {
            if (checkedSong.getSongTitle().startsWith(songTitle)) {
                return checkedSong;
            }
        }
        return null;
    }

        public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList) {
            int index = trackNumber -1;
            // make sure there's a song in that entry
            if((index >0) && (index <= this.songList.size())) {
                playList.add(this.songList.get(index));
                return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
            return false;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playList) {
        Song checkedSong = findSong(songTitle);
        if(checkedSong != null) {
            playList.add(checkedSong);
            System.out.println("The song " + songTitle + " has been added to the playList " +playList);
            return true;


        }
        System.out.println("The song " + songTitle + " is not in this album");
        return false;
        }










    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public void setSongList(ArrayList<Song> songList) {
        this.songList = songList;
    }

}
