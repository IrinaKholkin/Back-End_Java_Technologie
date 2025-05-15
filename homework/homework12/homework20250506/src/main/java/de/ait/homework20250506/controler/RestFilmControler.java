package de.ait.homework20250506.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestFilmControler {
    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public List<Film> getUser(){
        List<Film> filmsList = new ArrayList<>();
        filmsList.add(new Film("Forrest Gump", "Robert Zemeckis"));
        filmsList.add(new Film("1+1","Eric Toledano"));

        return filmsList;
    }
}
