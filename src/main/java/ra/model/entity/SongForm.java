package ra.model.entity;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private Long id;
    private String songName;
    private String artistName;
    private String kindOfMusic;
    private MultipartFile urlSong;

    public SongForm() {
    }

    public SongForm(Long id, String songName, String artistName, String kindOfMusic, MultipartFile urlSong) {
        this.id = id;
        this.songName = songName;
        this.artistName = artistName;
        this.kindOfMusic = kindOfMusic;
        this.urlSong = urlSong;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public MultipartFile getUrlSong() {
        return urlSong;
    }

    public void setUrlSong(MultipartFile urlSong) {
        this.urlSong = urlSong;
    }
}
