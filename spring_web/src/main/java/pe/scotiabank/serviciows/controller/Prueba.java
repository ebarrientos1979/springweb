package pe.scotiabank.serviciows.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/prueba")
public class Prueba {

    @GetMapping("/saludo")
    public String getSaludo(){
        return "Bienvenido a SPRING";
    }



}
