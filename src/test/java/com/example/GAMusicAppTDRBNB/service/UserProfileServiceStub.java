package com.example.GAMusicAppTDRBNB.service;

import MusicApp.models.UserProfile;
import MusicApp.service.UserProfileService;

public class UserProfileServiceStub implements UserProfileService {

    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile) {
        UserProfile userProfile = new UserProfile();

        userProfile.setEmail("KdotLamar@ADHD.com");

        if(newProfile == null){
            return null;
        }

        return userProfile;
    }



    @Override
    public UserProfile getUserProfile(String username) {return null;}

    }
}
