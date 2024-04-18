package learn.springboot.ContructorInjection.rest;

import learn.springboot.ContructorInjection.service.GmailService;
import learn.springboot.ContructorInjection.service.MessageService;
import learn.springboot.ContructorInjection.service.ZaloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private MessageService service1;
    private MessageService service2;

    @Autowired
    public NotificationController(
            @Qualifier("gmailService") MessageService service1,
            @Qualifier("gmailService") MessageService service2) {
        this.service1 = service1;
        this.service2 = service2;
    }

    @GetMapping("/gmail")
    public String sendGmail() {
        return service1.sendMessage();
    }

    @GetMapping("/check")
    public String check() {
        return "Kiem tra: " + (service1 == service2);
    }

    @GetMapping("/check2")
    public String check2() {
        if (service1 == service2) {
            return "Singleton";
        } else {
            return "PROTOTYPE";
        }
    }
}
