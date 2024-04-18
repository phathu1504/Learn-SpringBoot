package learn.springboot.ContructorInjection.rest;

import learn.springboot.ContructorInjection.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Notification2Controller {
    private MessageService emailService;
    private MessageService zaloService;
    private MessageService smsService;

    @Autowired
    public Notification2Controller(@Qualifier("zaloService") MessageService zaloService,
                                   @Qualifier("smsService") MessageService smsService,
                                   @Qualifier("gmailService") MessageService emailService
    ) {
        this.zaloService = zaloService;
        this.smsService = smsService;
        this.emailService = emailService;
    }

    @GetMapping("/email1")
    public String sendEmail() {
        return this.emailService.sendMessage();
    }

    @GetMapping("/zalo2")
    public String sendZalo() {
        return this.zaloService.sendMessage();
    }

    @GetMapping("/sms3")
    public String sendSms() {
        return this.smsService.sendMessage();
    }


}
