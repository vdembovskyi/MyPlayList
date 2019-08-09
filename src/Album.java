import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private SongList songs;


    public Album(String name) {
        this.name = name;
        songs = new SongList();
    }

    public String getName() {
        return name;
    }

    public boolean addSongs(Song song) {
        return this.songs.addSongs(song);

    }

    public boolean addSongToThePlaylist(int trackNumber, List<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.songs.size())) {
            playlist.add(this.songs.songs.get(index));
            return true;
        }
        System.out.println("No track");
        return false;

    }

    public void findSong(String title){
        songs.findSong(title);
    }

    public ArrayList<Song> getSongs() {
        return this.songs.songs;
    }

     private class SongList {
        private ArrayList<Song> songs;

         public SongList() {
             songs = new ArrayList<>();
         }

         public boolean addSongs(Song song) {
             if (songs.contains(song)) {
                 return false;
             }
             else{
                 this.songs.add(song);
                 return true;
             }
         }

        public Song findSong(String title) {
            for (Song findSong : this.songs) {
                if (findSong.getTitle().equals(title)) {
                    return findSong;
                }
            }
            return null;
        }
    }
}

