package org.amigoscodersuapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ping")
public class PingPongController {

    private static int COUNTER  = 0;

    record PingPong(String message) {
    }

    @GetMapping
    public PingPong getPingPong() {
        return new PingPong("Pong " + ++COUNTER);
    }
}
