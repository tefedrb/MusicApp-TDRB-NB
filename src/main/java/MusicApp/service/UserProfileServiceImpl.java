package MusicApp.service;

import MusicApp.models.User;
import MusicApp.models.UserProfile;
import MusicApp.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserService userService;

    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile){
        User user = userService.getUser(username);
        newProfile.setUser(user);
        user.setUserProfile(newProfile);
        return userProfileRepository.save(newProfile);
        //user.setUserProfile(newProfile);
        //return userService.createUser(user).getUserProfile();
    }

    @Override
    public UserProfile getUserProfile(String username){
        return userProfileRepository.findProfileByUsername(username);
    }
}
