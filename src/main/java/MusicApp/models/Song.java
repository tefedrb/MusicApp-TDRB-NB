package MusicApp.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
// Check

@Entity
@Table(name= "song")
public class Song {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int length;

    @Column
    private String title;

    @Column
    private String artist;

    public Song() {}

//    @OneToMany (mappedBy = "song", cascade = CascadeType.PERSIST)
//    private UserProfile userProfile;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH,
//                    CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinTable(name = "userProfile_song",
//            joinColumns = {@JoinColumn(name = "song_id")},
//            inverseJoinColumns = @JoinColumn(name = "userProfile_id"))
//    private List<User> users;

//    public List<User> getUsers(){ return users; }
//

//    public void setUsers(List<User> users) { this.users = users; }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}