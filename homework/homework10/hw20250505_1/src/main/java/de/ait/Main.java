package de.ait;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String imgUrl = "https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg";
        String token = "Basic  .... "; // свой ключ
        String url = "https://api.imagga.com/v2/text";

        RestTemplate restTemplate = new RestTemplate();
        // Установить http-заголовки
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("image_url", imgUrl)
                .build()
                .toUri();

        // создали RequestEntity
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);

        //вызвали restTemplate
        try {
            ResponseEntity<ResultDto> result = restTemplate.exchange(request, ResultDto.class);


            if (result.getStatusCode() == HttpStatus.OK) {
                String resultString = result.getBody().getResult().getText().stream()
                        .map(DataDto::getData)
                        .collect(Collectors.joining(" "));
                System.out.println(resultString);
            } else {
                System.out.println("Error!");
            }
        } catch (Exception e) {
            System.out.println("Ошибка запроса");
            e.printStackTrace();
        }

    }
}