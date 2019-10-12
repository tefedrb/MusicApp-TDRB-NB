package MusicApp.service;

import MusicApp.config.JwtUtil;
import MusicApp.models.*;
import MusicApp.repositories.PlaylistRepository;
import MusicApp.repositories.SongRepository;
import MusicApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public Iterable<Playlist> listPlaylists() {return PlaylistRepository.findAll();}

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    SongServices songServices;

    @Autowired
    SongRepository songRepository;
//
//    @Override
//    public Playlist addSong(String username, int songId) {
//        Song song = songRepository.findById(songId).get();
//        Playlist playlist = getPlaylist(username);
//        Playlist.addSong(song);
//
//        return PlaylistRepository.save(playlist);
//
//        @Override
//        public void removeSong(String username, int songId){
//            Song song = songRepository.findById(songId).get();
//            Playlist userProfile = getPlaylist(username);
//
//            // userProfileRepository.deleteSongById(song.getId());
//        }
//    }



}
