package learn.springboot.ContructorInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NontificationController {
    private MessageInterface email;

    @Autowired
    public NontificationController(EmailService emailService, ZaloService zaloService) {
        this.email = emailService;
        this.email = zaloService;
    }

    @GetMapping("/send-email")
    public String sendEmail(){
        return this.email.sendMessage();
    }

    @GetMapping("/send-zalo")
    public String sendZalo(){
        return this.email.sendMessage();
    }
}
