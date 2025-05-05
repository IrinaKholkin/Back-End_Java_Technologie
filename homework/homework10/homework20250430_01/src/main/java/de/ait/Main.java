package de.ait;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class Main {
    public static void main(String[] args) {
String imageUrl = "https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg";
String token = "Basic YWNjXzhlMGNlMzgzMTA3MjdkYzozN2RhNjg0ODY2NWEyODFkYTM1NWRjYWY1ZWUyN2Y5NQ==";
String apiUrl = "https://api.imagga.com/v2/text";

RestTemplate restTemplate = new RestTemplate();

URI url = UriComponentsBuilder.fromHttpUrl(apiUrl)
        .queryParam("image_url", imageUrl)
        .build()
        .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        RequestEntity<String> requestEntity = new RequestEntity<>( headers, HttpMethod.GET, url);
        ResponseEntity<TextResponseDto> response = restTemplate.exchange( requestEntity, TextResponseDto.class);

        System.out.println("Распознанный текст" + response.getBody().getResult().getText().get(0).getData());

    }
}