package com.example.GAMusicAppTDRBNB.service;

import MusicApp.models.UserProfile;
import MusicApp.service.UserProfileService;

public class UserProfileServiceStub implements UserProfileService {

    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile) {
        UserProfile userProfile = new UserProfile();

        userProfile.setEmail("batman@superhero.com");

        if(newProfile == null){
            return null;
        }

        return userProfile;
    }

    @Override
    public UserProfile getUserProfile(String username) {return null;}

    @Override
    public UserProfile addSong(String username, Long songId) {
        return null;
    }

    @Override
    public void removeSong(String username,  Long songid){};
}
