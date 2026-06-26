package edu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Startup implements CommandLineRunner {

    private SomeComponent component;

    Startup(SomeComponent component) {
        this.component = component;
    }

    @Override
    public void run(String[] args) {
        log.info(component.getAppInfo());
    }

    static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
    }
}
