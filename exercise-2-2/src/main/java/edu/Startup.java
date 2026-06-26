package edu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Startup implements CommandLineRunner {

    private HEXIDGenerator generator1;
    private HEXIDGenerator generator2;

    Startup(HEXIDGenerator generator1, HEXIDGenerator generator2) {
        this.generator1 = generator1;
        this.generator2 = generator2;
    }

    @Override
    public void run(String[] args) {
        log.info(generator1 == generator2 ? "equal" : "non equal");

        int i = 5;
        do {
            log.info(generator1.generateHEXID());
            log.info(generator2.generateHEXID());
        } while(--i > 0);
    }

    static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
    }
}
