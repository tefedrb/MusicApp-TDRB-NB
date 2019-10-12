package MusicApp.models;


import sun.jvm.hotspot.memory.Generation;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="playlists")

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

    private int id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_song", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songs;


}

