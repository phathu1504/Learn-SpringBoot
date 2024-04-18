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
    private MessageService service;

    @Autowired
    public NotificationController(@Qualifier("gmailService") MessageService messageService) {
        this.service = messageService;
    }

    @GetMapping("/gmail")
    public String sendGmail() {
        return service.sendMessage();
    }

}
