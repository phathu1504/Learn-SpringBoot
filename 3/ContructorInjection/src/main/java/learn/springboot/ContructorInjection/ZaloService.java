package learn.springboot.ContructorInjection;

import org.springframework.stereotype.Component;

@Component
public class ZaloService implements MessageInterface{
    @Override
    public String sendMessage() {
        return "Zalo sending Message";
    }
}
