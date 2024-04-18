package learn.springboot.ContructorInjection.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("smsService")
//@Lazy
public class SmsServiice implements MessageService {

    public SmsServiice() {
        System.out.println("Contrustor cua lop: " + getClass().getSimpleName());
    }

    @Override
    public String sendMessage() {
        return "SMS sending ...";
    }
}
