package learn.springboot.ContructorInjection.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("gmailService")
//@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GmailService implements MessageService {

    public GmailService() {
        System.out.println("Contructor: " + getClass().getSimpleName());
    }

    @Override
    public String sendMessage() {
        return "Mail send .....";
    }
}
