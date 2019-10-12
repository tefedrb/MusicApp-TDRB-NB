package MusicApp.service;

import MusicApp.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;

import MusicApp.models.Playlist;

public interface PlaylistService  extends UserDetailsService {
    public Iterable<User> listUsers();
    public String createPlaylist(Playlist newPlaylist);
    public Playlist getPlaylist(String username);
    public Playlist addSong(String username, int songId);
    public Playlist removeSong(String username, int songId);
}
