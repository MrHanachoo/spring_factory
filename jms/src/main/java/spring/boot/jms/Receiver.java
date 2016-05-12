package spring.boot.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import java.io.File;

/**
 * Created by mhan on 5/5/16.
 */
@Component
public class Receiver {

    @Autowired
    ConfigurableApplicationContext context;

    @JmsListener(destination = "mailbox", containerFactory = "jmsContainerFactory")
    public void receiveMessage(String message) {
        System.out.println(" Received by jms <<< "+ message+" >>>");
        context.close();
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}
