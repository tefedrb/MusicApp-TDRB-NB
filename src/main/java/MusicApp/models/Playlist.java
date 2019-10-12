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
    private int id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_song", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songs;


}
