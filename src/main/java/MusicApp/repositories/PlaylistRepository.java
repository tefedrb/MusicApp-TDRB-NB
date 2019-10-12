package MusicApp.repositories;

import MusicApp.models.Playlist;
import MusicApp.models.UserProfile;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PlaylistRepository extends CrudRepository<Playlist>, Long {
    @Query("FROM Playlist up INNER JOIN User u ON u.username = ?1 AND up.id = u.playList.id")

    public Playlist findPlaylistByUsername(String username);
}
