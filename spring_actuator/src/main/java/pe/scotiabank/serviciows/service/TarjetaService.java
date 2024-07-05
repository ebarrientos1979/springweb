package pe.scotiabank.serviciows.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.scotiabank.serviciows.repository.TarjetaRepository;

import java.util.List;

@Service
public class TarjetaService {
    private final TarjetaRepository tarjetaRepository;
    private final ModelMapper modelMapper;

    public TarjetaService(TarjetaRepository tarjetaRepository, ModelMapper modelMapper) {
        this.tarjetaRepository = tarjetaRepository;
        this.modelMapper = modelMapper;
    }

    public List<Object[]> getNombreTelefonoTarjeta(String numeroTarjeta) {
        return tarjetaRepository.getDatosTarjeta(numeroTarjeta);
    }
}
