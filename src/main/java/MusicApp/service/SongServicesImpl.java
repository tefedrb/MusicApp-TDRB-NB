package MusicApp.service;

import MusicApp.models.Song;
import MusicApp.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServicesImpl implements SongServices {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Iterable<Song> listSongs(){
        return songRepository.findAll();
    }
}