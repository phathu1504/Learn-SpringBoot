package learn.springboot.ContructorInjection.service;

import org.springframework.stereotype.Component;

@Component("zaloService")
public class ZaloService implements MessageService {
    @Override
    public String sendMessage() {
        return "Zalo send message ....";
    }
}
