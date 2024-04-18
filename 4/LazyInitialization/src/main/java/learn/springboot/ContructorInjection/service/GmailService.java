package learn.springboot.ContructorInjection.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("gmailService")
//@Lazy
public class GmailService implements MessageService {

    public GmailService() {
        System.out.println("Contructor: " + getClass().getSimpleName());
    }

    @Override
    public String sendMessage() {
        return "Mail send .....";
    }
}
