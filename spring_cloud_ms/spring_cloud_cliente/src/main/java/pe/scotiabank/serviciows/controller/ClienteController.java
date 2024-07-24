package pe.scotiabank.serviciows.controller;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.scotiabank.serviciows.dto.ClienteDTO;
import pe.scotiabank.serviciows.dto.TarjetaDTO;
import pe.scotiabank.serviciows.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/v1/cliente")
@Getter
@CrossOrigin(origins = "*")
public class ClienteController {
    private final ClienteService clienteService;
    private transient Long contador = 0L;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> getCliente(){
        System.out.println("INVOCACION AL METODO");
        contador++;
        return ResponseEntity.ok(this.clienteService.getAllClientes());
    }

    @GetMapping("/listarTarjetas/{id}")
    public ResponseEntity<List<TarjetaDTO>> getTarjetaClienteById(@PathVariable Integer id){
        return ResponseEntity.ok(this.clienteService.getTarjetaClienteById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCliente(@PathVariable("id") Integer id) {

        try{
            this.clienteService.deleteCliente(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Eliminado Correctamente");
    }


    @PostMapping("/save")
    public ResponseEntity<ClienteDTO> saveCliente(@RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(this.clienteService.saveCliente(clienteDTO));
    }

}
