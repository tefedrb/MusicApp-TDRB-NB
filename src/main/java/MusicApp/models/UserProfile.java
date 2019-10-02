package MusicApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_profile")
public class UserProfile {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String mobile;

    @Column
    private String address;

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;

    // Adding this in from the song model to the user profile
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "playlist", joinColumns = {@JoinColumn(name = "song_id")}, inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Song> songs;
    // Added getters and setters
    public List<Song> getSongs(){ return songs;}

    public void setSongs(List<Song> songs) { this.songs = songs; }

    // Added this from User
    public List<Song> addSong(Song song){
        if(songs == null)
            songs = new ArrayList<>();
            songs.add(song);
        return songs;
    }

    public UserProfile(){}

    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }
}
