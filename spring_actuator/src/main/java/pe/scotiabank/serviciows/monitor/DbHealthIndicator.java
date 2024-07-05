package pe.scotiabank.serviciows.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DbHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if(isDbHealhty()) {
            return Health.up().withDetail("Estado Salud DB", "Ejecutandose Correctamenta").build();
        }
        return Health.down().withDetail("Estado Salud DB", "No se puede conectar a la base de datos").build();
    }

    private boolean isDbHealhty() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
