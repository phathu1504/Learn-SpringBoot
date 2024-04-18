package learn.springboot.ContructorInjection.service;

import org.springframework.stereotype.Component;

@Component("gmailService")
public class GmailService implements MessageService {
    @Override
    public String sendMessage() {
        return "Mail send .....";
    }
}
