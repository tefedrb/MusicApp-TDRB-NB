package com.example.GAMusicAppTDRBNB.service;

import MusicApp.controller.UserProfileController;
import MusicApp.models.UserProfile;
import MusicApp.service.UserProfileService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserProfileServiceTest {
    private UserProfileController userProfileController;



    @Before
    public void initializeUserProfile(){
        userProfileController = new UserProfileController();
        userProfileController.setUserProfileService(new UserProfileServiceStub());

    }

    @Test
    public void createUserProfile_AddsProfile_Success(){
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("KdotLamar@ADHD.com");

        UserProfile newProfile = userProfileController.createUserProfile("Kendrick Lamar", userProfile); //meant to pass
//        UserProfile newProfile = userProfileController.createUserProfile(null, null); // meant to fail

        System.out.println(newProfile);
        Assert.assertNotNull(newProfile);
        Assert.assertEquals(newProfile.getEmail(), userProfile.getEmail());

    }



}
