package org.amigoscodersuapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPongController {
    record PingPong(String message) {
    }

    @GetMapping
    public PingPong getPingPong() {
        return new PingPong("PongPongPangPangPingPangAAAAPingPongPingPangPangPongPing");
    }
}
