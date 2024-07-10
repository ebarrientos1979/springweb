package pe.scotiabank.serviciows.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import pe.scotiabank.serviciows.controller.ClienteController;

import java.util.Map;

@Endpoint(id = "contadorWS")
@Component
public class ContadorWSEndpoint {
    @Autowired
    private ClienteController clienteController;

    @ReadOperation
    public Map<String, String> customEndpoint(){
        Map<String, String> map = new java.util.HashMap<>();
        map.put("contador", clienteController.getContador().toString());
        return map;
    }

}
