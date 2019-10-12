package MusicApp.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Playlist")
public class Playlist {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playListid;

    @Column
    private String playListName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="userProfileId")
    private UserProfile userProfile;


    public UserProfile getUserProfile(){return userProfile;}

    public void setUserProfile(UserProfile userProfile) {this.userProfile = userProfile;}

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="PlaylistSongId")
    private Song song;

    public Song getSong() {return song;}

    public void setSong() {this.song = song;}


    public Long getPlayListid() {return playListid;}

    public void setPlayListid() {this.playListid = playListid;}

    public String getPlayListName(){return playListName;}

    public void setPlayListName(){this.playListName = playListName;}

}

