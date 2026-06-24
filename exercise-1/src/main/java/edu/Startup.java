package edu;

import edu.service.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Startup {
    static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SomeService service = context.getBean("someService", SomeService.class);

        service.printLog("message");
        service.printLogs(new String[]{"message1", "message2", "message3"});
    }
}
