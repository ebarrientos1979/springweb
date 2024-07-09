package pe.scotiabank.serviciows.service;

import io.micrometer.core.instrument.Counter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.scotiabank.serviciows.dto.ClienteDTO;
import pe.scotiabank.serviciows.dto.TarjetaDTO;
import pe.scotiabank.serviciows.model.ClienteModel;
import pe.scotiabank.serviciows.model.CuentaModel;
import pe.scotiabank.serviciows.model.TarjetaModel;
import pe.scotiabank.serviciows.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clientRepository;
    private final ModelMapper modelMapper;
    private final Counter contarClientes;


    public List<ClienteDTO> getAllClientes(){
        List<ClienteModel> clientes = clientRepository.findAll();
        List<ClienteDTO> clienteDTOS = clientes.stream().
                map(cliente -> modelMapper.map(cliente, ClienteDTO.class)).toList();
        contarClientes.increment();
        return clienteDTOS;
    }

    public List<TarjetaDTO> getTarjetaClienteById(Integer id){
        Optional<ClienteModel> cliente = clientRepository.findById(id);
        List<TarjetaDTO> listaTarjetas = new ArrayList<TarjetaDTO>();

        if(cliente.isPresent()){
            ClienteModel miCliente = cliente.get();
            for(CuentaModel cuenta : miCliente.getCuentas() ){
                for(TarjetaModel tarjetaModel:cuenta.getTarjetas()){
                    listaTarjetas.add(modelMapper.map(tarjetaModel, TarjetaDTO.class));
                }
            }
        }
        return listaTarjetas;
    }
}
