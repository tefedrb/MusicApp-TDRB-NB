package MusicApp.service;

import MusicApp.models.Playlist;
import org.springframework.stereotype.Service;

@Service
public class PlaylistServicesImpl implements PlaylistServices{
    @Override
    public Playlist createPlaylist(Playlist playlist){
        return playlist;
    }
}
