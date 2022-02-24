package com.example.demo.Controller;

import com.example.demo.Entity.Saludo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SaludoController {
    private static final String template = "Hola, %s!";
    private final AtomicLong contador = new AtomicLong();

    @GetMapping("/saludo")
    public Saludo saludo(@RequestParam(value = "nombre", defaultValue = "Sil") String nombre){
        return new Saludo(contador.incrementAndGet(), String.format(
                template, nombre
        ));
    }
}
