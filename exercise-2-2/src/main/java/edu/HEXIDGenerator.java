package edu;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HEXIDGenerator {
    private static long counter = 0L;

    public String generateHEXID() {
        return Long.toHexString(++counter + System.nanoTime());
    }
}
