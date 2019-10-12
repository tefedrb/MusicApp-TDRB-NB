package MusicApp.controller;

import MusicApp.models.Playlist;
import MusicApp.service.PlaylistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistServices playlistServices;

    @PostMapping("/create")
    public Playlist createPlaylist(@RequestBody Playlist playlist){
        return playlist;
    }

}
