package MusicApp.service;

import MusicApp.models.User;
import MusicApp.models.UserProfile;
import org.springframework.http.HttpStatus;

public interface UserProfileService {
    public UserProfile createUserProfile(String username, UserProfile newProfile);
    public UserProfile getUserProfile(String username);
    public UserProfile addSong(String username, int songId);
    public UserProfile removeSong(String username, int songId);
}
