package kz.iitu.genresservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Genre {

    private String id;
    private String genreName;

    public Genre() {
    }

    public Genre(String id ,String genreName) {
        this.id = id;
        this.genreName = genreName;
    }
}
