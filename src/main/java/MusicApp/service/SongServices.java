package MusicApp.service;


import MusicApp.models.Song;

public interface SongServices {

    public Song createSong(Song song);

    public Iterable<Song> listSongs();
}