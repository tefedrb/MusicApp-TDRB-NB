package MusicApp.controller;

import MusicApp.models.UserProfile;
import MusicApp.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/{username}")
    public UserProfile getUserProfile(@PathVariable String username){
        return userProfileService.getUserProfile(username);
    }

    @PostMapping("/{username}")
    public UserProfile createUserProfile(@PathVariable String username, @RequestBody UserProfile userProfile){
        return userProfileService.createUserProfile(username, userProfile);
    }

    // This code is coming from user controller // swapped return from userService to userProfileService
    @PutMapping("/{username}/{songId}")
    public UserProfile addSong(@PathVariable String username, @PathVariable int songId){
        return userProfileService.addSong(username, songId);
    }
}
