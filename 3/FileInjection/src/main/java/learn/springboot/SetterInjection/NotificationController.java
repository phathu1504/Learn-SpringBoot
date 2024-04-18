package learn.springboot.SetterInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    /* Field Injection */
    @Autowired
    private MessageInterface email;

    // Setter tao ra khi cac doi tuong la option co the tao hoac khong
//    @Autowired
//    public void setEmail(EmailService email){
//        this.email = email;
//    }



    @GetMapping("/send-email")
    public String sendEmail(){
        return email.sendMessage();
    }
}
