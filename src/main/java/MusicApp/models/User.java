package MusicApp.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)

@Entity
@Table(name= "users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    //cascade refers to deleting, so in this example since it's Type.ALL,
    // if we delete the user then the profile get's deleted and vice versa.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_profile_id")
    private UserProfile userProfile;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile){
        this.userProfile = userProfile;
    }

    public User() {}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

//cascade refers to deleting
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_role_id", nullable = false)
    private UserRole userRole;

    public UserRole getUserRole(){ return userRole; }

    public void setUserRole(UserRole userRole) { this.userRole = userRole;}

    //FetchType.Lazy - Load it on demand so if there's a query you would load it
    //While if you had FechType.Eager - would load all the data and you don't want it cuz if you
    // had billons of data it would load the whole hting.
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_song",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songs;

    public List<Song> getSong(){ return songs; }

    public void setSong(List<Song> song) { this.songs = song; }

    public List<Song> addSong(Song song){
        if(songs == null)
            songs = new ArrayList<>();
            songs.add(song);
        return songs;
    }
}
