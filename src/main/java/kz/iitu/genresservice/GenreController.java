package kz.iitu.genresservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @GetMapping("/{movieId}")
    public Genre getGenreByMovieId(@PathVariable("movieId") String movieId){
        return new Genre("1", movieId, "default");
    }
}
