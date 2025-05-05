package de.ait;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = new URI("http://jsonplaceholder.typicode.com/comments");
        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET,uri);

        ResponseEntity<List<CommentDto>> response =
                restTemplate.exchange(request, new ParameterizedTypeReference<List<CommentDto>> () { });

        List<CommentDto> comments = response.getBody();
        for (CommentDto comment: comments){
            System.out.println(comment);
            System.out.println();
        }
        System.out.printf("Все комментарии:)");
        comments.forEach(System.out::println);
    }
}