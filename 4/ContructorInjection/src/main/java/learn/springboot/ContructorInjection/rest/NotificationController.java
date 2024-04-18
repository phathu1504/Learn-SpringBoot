package learn.springboot.ContructorInjection.rest;

import learn.springboot.ContructorInjection.service.GmailService;
import learn.springboot.ContructorInjection.service.MessageInterface;
import learn.springboot.ContructorInjection.service.ZaloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private MessageInterface email;
    private MessageInterface zalo;

    @Autowired
    public NotificationController(ZaloService zalo, GmailService mail) {
        this.zalo = zalo;
        this.email = mail;
    }

    @GetMapping("/zalo")
    public String sendZalo() {
        return zalo.sendMessage();
    }

    @GetMapping("/mail")
    public String sendMail() {
        return email.sendMessage();
    }
}
