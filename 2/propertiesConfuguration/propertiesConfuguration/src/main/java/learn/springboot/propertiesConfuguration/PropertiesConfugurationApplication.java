package learn.springboot.propertiesConfuguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PropertiesConfugurationApplication {
    // Gắn giá trị trong file properties vào

    @Value("${khoahoc.ten}")
    private String ten;
    @Value("${khoahoc.nguoihuongdan}")
    private String nguoihuongdan;
    @Value("${khoahoc.website}")
    private String website;

    public static void main(String[] args) {
        SpringApplication.run(PropertiesConfugurationApplication.class, args);
    }

	@GetMapping("/")
    public String index() {
        return "Xin Chào Thu";
    }

    @GetMapping("/info")
    public String info(){
        return "Ten: "+ten+"<br>nguoi huong dan: "+nguoihuongdan+"<br>website: "+website;
    }

}
