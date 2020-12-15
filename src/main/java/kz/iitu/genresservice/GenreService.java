package kz.iitu.genresservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class GenreService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GenreRepository genreRepository;

    @HystrixCommand(fallbackMethod = "getGenre",
            threadPoolKey = "getGenrePool",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="20"),
                    @HystrixProperty(name="maxQueueSize", value="10"),
            })
    public Genre getGenre(String id) {

        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://genre-service/id/"+id, HttpMethod.GET, entity,Genre.class).getBody();

    }


}
