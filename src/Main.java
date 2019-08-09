import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Song> playList = new LinkedList<>();


    public static void main(String[] args) {
        Album album1 = new Album("albumName1");
        Album album2 = new Album("albumName2");

        Song song1 = new Song("songName1", 6.7);
        Song song2 = new Song("songName2", 8.7);
        Song song3 = new Song("songName3", 1.7);
        Song song4 = new Song("songName4", 6.7);
        Song song5 = new Song("songName5", 9.7);
        Song song6 = new Song("songName6", 3.7);
        Song song7 = new Song("songName7", 4.7);

        Song song8 = new Song("songName8", 4.3);
        Song song9 = new Song("songName9", 4.4);
        Song song10 = new Song("songName10", 6.7);
        Song song11 = new Song("songName11", 4.9);

        album1.addSongs(song1);
        album1.addSongToThePlaylist(0, playList);
        album1.addSongs(song2);
        album1.addSongToThePlaylist(1, playList);
        album1.addSongs(song3);
        album1.addSongToThePlaylist(2, playList);
        album1.addSongs(song4);
        album1.addSongToThePlaylist(3, playList);
        album1.addSongs(song5);
        album1.addSongToThePlaylist(4, playList);
        album1.addSongs(song6);
        album1.addSongToThePlaylist(5, playList);
        album1.addSongs(song7);
        album1.addSongToThePlaylist(6, playList);
        album2.addSongs(song8);
        album2.addSongToThePlaylist(7, playList);
        album2.addSongs(song9);
        album2.addSongToThePlaylist(8, playList);
        album2.addSongs(song10);
        album1.addSongToThePlaylist(9, playList);
        album2.addSongs(song11);
        album1.addSongToThePlaylist(10, playList);

        printInstruction();
        play();



    }


    public static void play() {
        ListIterator<Song> iterator = playList.listIterator();
        boolean quit = false;
        boolean forward = true;

        if (playList.size() == 0) {
            System.out.println("The playlist is empty");
        } else {
            System.out.println("Now playing" + iterator.next().toString());
        }

        while (!quit) {
            int key = scanner.nextInt();
            switch (key) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                    }
                    if (!iterator.hasNext()) {
                        forward = false;
                        System.out.println("The end of the playlist");
                    } else {
                        forward = true;
                        System.out.println("Now playing the next song..." + iterator.next().toString());
                    }
                    break;
                case 2:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        forward = false;
                    }
                    if (!iterator.hasPrevious()) {
                        System.out.println("The start of the playlist");
                        forward = true;
                    } else {
                        System.out.println("Now playing the previous song..." + iterator.previous().toString());

                    }
                    break;
                case 3:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            System.out.println("Now replaying" + iterator.previous().toString());
                            forward = false;
                        } else {
                            if (iterator.hasNext()) {
                                System.out.println("Now replaying " + iterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("The end of playlist");
                            }
                        }
                    }
                    break;
                case 4:
                    if (playList.size() > 0) {
                        iterator.remove();
                        System.out.println("The song is removed");
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                    }
                    break;
                case 5:
                    printInstruction();
                    break;
                case 6:
                    printPlayList();

            }
        }


    }

    public static void printInstruction() {
        System.out.println("You may use the follow keys: \n" +
                "0 - quite\n" +
                "1 - skip (forward to the next) the song\n" +
                "2 - skip (backwards to the previous) the song\n" +
                "3 - replay current song\n" +
                "4 - remove current song\n" +
                "5 - show instruction\n");
    }

    public static void printPlayList() {
        for (Song song : playList) {
            System.out.println(song.toString());
        }
    }


}






