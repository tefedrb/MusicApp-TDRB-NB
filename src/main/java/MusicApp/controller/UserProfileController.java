package MusicApp.controller;

import MusicApp.models.Song;
import MusicApp.models.User;
import MusicApp.models.UserProfile;
import MusicApp.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/{username}")
    public UserProfile getUserProfile(@PathVariable String username) {
        return userProfileService.getUserProfile(username);
    }

    @PostMapping("/{username}")
    public UserProfile createUserProfile(@PathVariable String username, @RequestBody UserProfile userProfile) {
        return userProfileService.createUserProfile(username, userProfile);
    }


    // This code is coming from user controller // swapped return from userService to userProfileService


    @PutMapping("/remove/{username}/{songId}")
    public void removeSong(@PathVariable String username, @PathVariable Long songId) {
        userProfileService.removeSong(username, songId);

    }

    //
    @Autowired
    public void setUserProfileService(UserProfileService userProfileService){
        this.userProfileService =  userProfileService;
    }
}
