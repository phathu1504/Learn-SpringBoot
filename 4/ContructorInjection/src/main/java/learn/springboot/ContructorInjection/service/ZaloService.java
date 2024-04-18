package learn.springboot.ContructorInjection.service;

import org.springframework.stereotype.Component;

@Component
public class ZaloService implements MessageInterface {
    @Override
    public String sendMessage() {
        return "Zalo send message ....";
    }
}
