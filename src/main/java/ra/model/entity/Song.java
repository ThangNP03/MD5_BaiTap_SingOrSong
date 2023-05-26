package ra.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "Song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String songName;
    private String artistName;
    private String kindOfMusic;
    private String urlSong;

    public Song() {
    }

    public Song(long id, String songName, String artistName, String kindOfMusic, String urlSong) {
        this.id = id;
        this.songName = songName;
        this.artistName = artistName;
        this.kindOfMusic = kindOfMusic;
        this.urlSong = urlSong;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getUrlSong() {
        return urlSong;
    }

    public void setUrlSong(String urlSong) {
        this.urlSong = urlSong;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", kindOfMusic='" + kindOfMusic + '\'' +
                ", urlSong='" + urlSong + '\'' +
                '}';
    }
    @Override
    public Song clone(){
        Song song = new Song();
        song.setId(id);
        song.setSongName(songName);
        song.setArtistName(artistName);
        song.setKindOfMusic(kindOfMusic);
        song.setUrlSong(urlSong);
        return song;
    }
}
