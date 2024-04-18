package learn.springboot.ContructorInjection.service;

import org.springframework.stereotype.Component;

@Component
public class GmailService implements MessageInterface {
    @Override
    public String sendMessage() {
        return "Mail send .....";
    }
}
