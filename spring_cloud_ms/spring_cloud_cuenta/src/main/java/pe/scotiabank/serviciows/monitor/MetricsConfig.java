package pe.scotiabank.serviciows.monitor;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {
    @Autowired
    private MeterRegistry meterRegistry;

    @Bean
    public Counter customCounter() {
        return Counter.builder("appbanco.counterListaClientes")
            .description("Cuenta el total de invocaciones de Lista Clientes")
            .register(meterRegistry);
    }
}
