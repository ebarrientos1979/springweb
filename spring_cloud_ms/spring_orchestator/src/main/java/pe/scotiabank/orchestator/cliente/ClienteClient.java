package pe.scotiabank.orchestator.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import pe.scotiabank.orchestator.dto.ClienteDTO;

import java.util.List;

@FeignClient(name="SPRING-CLOUD-CLIENTE", url="http://localhost:9000")
public interface ClienteClient {
    @GetMapping("/v1/cliente/listarClientes")
    public ResponseEntity<List<ClienteDTO>> listarClientes();
}
