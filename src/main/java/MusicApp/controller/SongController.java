package MusicApp.controller;

import MusicApp.models.Song;
import MusicApp.service.SongServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongServices songServices;

    @PostMapping("/uploadsong")
    public Song createSong(@RequestBody Song song){
        return songServices.createSong(song);
    }



    @GetMapping("/list")
    public Iterable<Song> listSongs(){
        return songServices.listSongs();
    }



//    @DeleteSong("/delete/user/{songId}")
//    public HttpStatus deleteUserById(@PathVariable Long userId){
//        return userService.deleteById(userId);
//    }
}