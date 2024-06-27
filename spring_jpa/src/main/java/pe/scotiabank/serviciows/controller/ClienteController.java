package pe.scotiabank.serviciows.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.scotiabank.serviciows.dto.ClienteDTO;
import pe.scotiabank.serviciows.dto.TarjetaDTO;
import pe.scotiabank.serviciows.model.TarjetaModel;
import pe.scotiabank.serviciows.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listarClientes")
    public ResponseEntity<List<ClienteDTO>> getCliente(){
        return ResponseEntity.ok(this.clienteService.getAllClientes());
    }

    @GetMapping("/listarTarjetas/{id}")
    public ResponseEntity<List<TarjetaDTO>> getTarjetaClienteById(@PathVariable Integer id){
        return ResponseEntity.ok(this.clienteService.getTarjetaClienteById(id));
    }
}
