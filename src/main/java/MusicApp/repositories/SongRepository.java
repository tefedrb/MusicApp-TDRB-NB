package MusicApp.repositories;

import MusicApp.models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Integer > {
}