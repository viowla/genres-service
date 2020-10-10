package kz.iitu.genresservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Genre {

    private String id;
    private String movieId;
    private String genreName;

    public Genre() {
    }

    public Genre(String id, String movieId, String genreName) {
        this.id = id;
        this.movieId = movieId;
        this.genreName = genreName;
    }
}
