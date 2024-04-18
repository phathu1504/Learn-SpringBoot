package learn.springboot.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExempleController {

    @GetMapping("/")
    public String index() {
        return "Hello Phan Hoang Anh Thu";
    }

    @GetMapping("/he")
    public String he() {
        return "Hello Phan Hoang Anh Thu H@123";
    }
}
