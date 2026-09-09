package com.merida.tecnm.market_backend_v3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

    @GetMapping("/saludo")
    public String helloWorld() {
        return "Hello World!";
    }

}
