package br.com.fiap.sub10aojoEngSoftDev346409.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<Object> status(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("version")
    public ResponseEntity<String> version() throws IOException {
        Properties properties = new Properties();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.yml");
        properties.load(inputStream);
        return ResponseEntity.ok(properties.getProperty("build.name")+" - "+ properties.getProperty("build.version"));
    }
}
