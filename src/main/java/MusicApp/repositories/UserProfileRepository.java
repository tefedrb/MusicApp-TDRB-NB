package MusicApp.repositories;

import MusicApp.models.UserProfile;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
    @Query("FROM UserProfile up INNER JOIN User u ON u.username = ?1 AND up.id = u.userProfile.id")

    public UserProfile findProfileByUsername(String username);
}
