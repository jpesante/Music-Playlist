package com.pesante;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
	// write your code here
    Album album = new Album("Born This Way", "Lady Gaga");
    album.addSong("Bad Romance",3.5);
    album.addSong("Poparazi",2.30);
    album.addSong("Edge of Glory",5.20);
    album.addSong("Born This Way",4.20);
    album.addSong("Marry the Night", 4.24);
    album.addSong("Judas",4.09);
    albums.add(album);

    album = new Album("Follow The Leader", "Korn");
    album.addSong("It's On!",4.29);
    album.addSong("Freak On a Leash",4.15);
    album.addSong("Got the Life",3.45);
    album.addSong("Dead Bodies Everywhere",4.45);
    album.addSong("Childeren of the",3.52);
    album.addSong("BBK",3.57);
    albums.add(album);

    // albums are stored in an ArrayList & playList is stored in a LinkedList.

    LinkedList<Song> playList = new LinkedList<Song>();
    // LikedList object of the Song class called playList
    albums.get(0).addToPlayList("Bad", playList);
    albums.get(0).addToPlayList("Edge",playList);
    albums.get(1).addToPlayList("It's",playList);
    albums.get(1).addToPlayList("Follow",playList);
    //albums.get(2).addToPlayList("test element 1",playList); // nothing added, no new album is at element 2.

    albums.get(1).addToPlayList("Freak",playList);
    albums.get(1).addToPlayList("Got",playList);
    //albums.get(1).addToPlayList(2,playList);

    play(playList);



    }
    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;

        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }
        while(!quit) {
            //System.out.println("Enter playlist position");
            int action = scanner.nextInt();
            scanner.nextLine(); // clear next line

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();

                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                        forward = false;

                    }
                    break;
                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();

                        }
                        forward = false;

                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.next().toString());

                    } else {
                        System.out.println("We are at the start of the playList");
                        forward = true;

                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                        } else {
                            System.out.println("We are at the beginning of the list");

                        }

                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;

                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                   printList(playList);
                    break;
                case 5:
                   printMenu();
                    break;
                case 6:
                    if(playList.size() > 0 ) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }

        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
        "1 - to play next song\n" +
        "2 - to play previous song\n" +
        "3 - to replay the current song\n" +
        "4 - list songs in the playList\n" +
        "5 - print available actions\n" +
        "6 - delete current song form playList");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("=====================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        System.out.println("=====================");
    }
}
