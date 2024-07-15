package pe.scotiabank.serviciows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.scotiabank.serviciows.service.TarjetaService;

import java.util.List;

@RestController
@RequestMapping("/v1/tarjeta")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @GetMapping("/getNombreTelefonoTarjeta/{numeroTarjeta}")
    public ResponseEntity<List<Object[]>> getNombreTelefonoTarjeta(@PathVariable String numeroTarjeta) {
        return ResponseEntity.ok(tarjetaService.getNombreTelefonoTarjeta(numeroTarjeta));
    }

    //Implementar los métodos restantes CRUD
}
