package de.ait.homework20250506.controler;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainControler {


    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String redirectToInfoPage(){
        return "info.html";
    }
}


//    @GetMapping("/now")
//    public Map<String, String> getNow() {
//        return Map.of("now", LocalDateTime.now().toString());
//    }
//}
