package pe.scotiabank.orchestator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.scotiabank.orchestator.cliente.ClienteClient;
import pe.scotiabank.orchestator.dto.ClienteDTO;

import java.util.List;

@RestController
@RequestMapping("/v1/orquestator")
public class OrqClienteCuentaController {

    @Autowired
    ClienteClient clienteClient;

    @GetMapping("/listarClientes")
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        return clienteClient.listarClientes();
    }

}
