package de.ait.homework20250506.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class RestTimeControler {
    @GetMapping("/now")
    public Map<String, String> getNow() {
        return Map.of("now", LocalDateTime.now().toString());
    }
}
