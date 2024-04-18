package learn.springboot.SetterInjection;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageInterface{

    @Override
    public String sendMessage() {
        return "Email sending..... 12345611111";
    }
}
