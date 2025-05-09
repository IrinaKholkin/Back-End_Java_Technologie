package de.ait.homework20250506.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestBookControler {
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getUser(){
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Pollyanna", "Eleonor Porter"));
        booksList.add(new Book("Parsley Syndrome","Dina Rubina"));

        return booksList;
    }
}
