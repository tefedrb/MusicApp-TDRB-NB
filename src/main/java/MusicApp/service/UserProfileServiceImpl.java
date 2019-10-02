package MusicApp.service;

import MusicApp.models.Song;
import MusicApp.models.User;
import MusicApp.models.UserProfile;
import MusicApp.repositories.SongRepository;
import MusicApp.repositories.UserProfileRepository;
import MusicApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SongRepository songRepository;

    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile) {
        User user = userService.getUser(username);
        newProfile.setUser(user);
        user.setUserProfile(newProfile);
        return userProfileRepository.save(newProfile);
        //user.setUserProfile(newProfile);
        //return userService.createUser(user).getUserProfile();
    }

    @Override
    public UserProfile getUserProfile(String username) {
        return userProfileRepository.findProfileByUsername(username);
    }

    // This came from UserServiceImpl
    @Override
    public UserProfile addSong(String username, int songId) {
        Song song = songRepository.findById(songId).get();
        UserProfile userprofile = getUserProfile(username);
        userprofile.addSong(song);

        return userProfileRepository.save(userprofile);
    }
}
