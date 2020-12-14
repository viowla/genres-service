package kz.iitu.genresservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/genre")
public class GenreController {


    @GetMapping("")
    @HystrixCommand(fallbackMethod = "getPayment",
            threadPoolKey = "getPaymentPool",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="20"),
                    @HystrixProperty(name="maxQueueSize", value="10"),
            })
    public List<Genre> getAllGenres(){

        List<Genre> genreList = new ArrayList<>();

        return genreList;
    }
}
