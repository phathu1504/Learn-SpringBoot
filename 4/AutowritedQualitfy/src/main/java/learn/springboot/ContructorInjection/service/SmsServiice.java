package learn.springboot.ContructorInjection.service;

import org.springframework.stereotype.Component;

@Component("smsService")
public class SmsServiice implements MessageService{
    @Override
    public String sendMessage() {
        return "SMS sending ...";
    }
}
