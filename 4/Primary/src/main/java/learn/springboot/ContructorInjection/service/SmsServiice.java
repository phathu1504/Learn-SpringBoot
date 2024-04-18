package learn.springboot.ContructorInjection.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("smsService")
@Primary
public class SmsServiice implements MessageService{
    @Override
    public String sendMessage() {
        return "SMS sending ...";
    }
}
