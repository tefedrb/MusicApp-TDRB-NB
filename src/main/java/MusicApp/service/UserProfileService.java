package MusicApp.service;

import MusicApp.models.UserProfile;

public interface UserProfileService {
    public UserProfile createUserProfile(String username, UserProfile newProfile);
    public UserProfile getUserProfile(String username);
}
