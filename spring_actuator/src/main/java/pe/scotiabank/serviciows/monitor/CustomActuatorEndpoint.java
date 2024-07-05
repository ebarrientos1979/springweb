package pe.scotiabank.serviciows.monitor;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Endpoint(id = "totalMemoryJVM")
@Component
public class CustomActuatorEndpoint {

    @ReadOperation
    public Map<String, String> customEndpoint(){
        Map<String, String> map = new HashMap<>();
        Runtime runtime = Runtime.getRuntime();
        Long totalMemory = runtime.totalMemory()/1024/1024;
        map.put("totalMemoria", totalMemory.toString().concat(" MB"));

        Long maxMemory = runtime.maxMemory()/1024/1024;
        map.put("maxMemory", maxMemory.toString().concat(" MB"));

        Long freeMemory = runtime.freeMemory()/1024/1024;
        map.put("freeMemory", freeMemory.toString().concat(" MB"));

        Long usedMemory = (totalMemory - freeMemory);
        map.put("usedMemory", usedMemory.toString().concat(" MB"));

        return map;
    }
}
