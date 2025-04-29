package de.ait;

import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID поста для получения комментариев: ");
        int commentId = scanner.nextInt();

        URI uri = new URI("http://jsonplaceholder.typicode.com/comments/" + commentId);
        CommentDto comment = restTemplate.getForObject(uri, CommentDto.class);

        System.out.println("Комментарии с ID " + commentId + ":");
            System.out.println(comment);
            System.out.println();
    }
}