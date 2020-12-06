package kz.iitu.genresservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/genre")
public class GenreController {


    @GetMapping("")
    @HystrixCommand()
    public List<Genre> getAllGenres(){

        List<Genre> genreList = new ArrayList<>();
        genreList.add(new Genre("1","Action"));
        genreList.add(new Genre("2","Horror"));
        genreList.add(new Genre("3","Comedy"));
        genreList.add(new Genre("4","Thriller"));
        genreList.add(new Genre("5","Sci-fi"));
        return genreList;
    }
}
