package learn.springboot.ContructorInjection.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("zaloService")
//@Lazy
public class ZaloService implements MessageService {

    public ZaloService() {
        System.out.println("Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String sendMessage() {
        return "Zalo send message ....";
    }
}
