package kz.iitu.genresservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/genre")
public class GenreController {


    @Autowired
    private GenreRepository genreRepository;


    private GenreService genreService;

    @GetMapping("/all")
    @HystrixCommand(fallbackMethod = "getPayment",
            threadPoolKey = "getPaymentPool",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="20"),
                    @HystrixProperty(name="maxQueueSize", value="10"),
            })
    public ResponseEntity<List<Genre>> getAllPayments() {
        return new ResponseEntity<>(genreRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getPayment(@PathVariable String id) {
        return new ResponseEntity<>(genreService.getGenre(id), HttpStatus.OK);
    }

}
