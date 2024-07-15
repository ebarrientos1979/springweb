package pe.scotiabank.serviciows.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import pe.scotiabank.serviciows.dto.ClienteDTO;
import pe.scotiabank.serviciows.dto.TarjetaDTO;
import pe.scotiabank.serviciows.model.ClienteModel;
import pe.scotiabank.serviciows.model.CuentaModel;
import pe.scotiabank.serviciows.model.TarjetaModel;
import pe.scotiabank.serviciows.repository.ClienteRepository;
import io.micrometer.core.instrument.Counter;

import javax.swing.text.html.Option;
import java.sql.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClienteServiceTest {
    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private Counter counter;
    @Mock
    private ClienteModel clienteModel;
    @Mock
    private CuentaModel cuentaModel;

    @InjectMocks
    private ClienteService clienteService;

    private ClienteModel cliente;
    private CuentaModel cuenta;
    private TarjetaModel tarjeta;


    @BeforeEach
    void setUp() {
        try{
            MockitoAnnotations.openMocks(this);

            cliente = new ClienteModel();
            cliente.setClienteId(1);
            cliente.setNombre("Juan");
            cliente.setDireccion("Direccion 1");
            cliente.setTelefono("123456789");
            cliente.setCuentas(new ArrayList<CuentaModel>());

            cuenta = new CuentaModel();
            cuenta.setCuentaId(1);
            cuenta.setCliente(cliente);
            cuenta.setTarjetas(new ArrayList<TarjetaModel>());

            tarjeta = new TarjetaModel();
            tarjeta.setTarjetaId(1);
            tarjeta.setNumeroTarjeta("123456789");
            tarjeta.setCuenta(cuenta);


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAllClientes() {
        when(clienteRepository.findAll()).thenReturn(new ArrayList<ClienteModel>());
        when(modelMapper.map(Mockito.any(),Mockito.any())).thenReturn(new ArrayList<ClienteDTO>());

        assertNotNull(clienteService.getAllClientes());
    }

    @Test
    void getAllClientes_ClienteDTONull() {
        when(clienteRepository.findAll()).thenReturn(new ArrayList<>());
        when(modelMapper.map(Mockito.any(),Mockito.any())).thenReturn(null);
        var vacio = new ArrayList<>();

        assertArrayEquals(clienteService.getAllClientes().toArray(), vacio.toArray());

    }

    @Test
    void getTarjetaClienteById() {
        when(clienteRepository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(cliente));
        when(clienteModel.getCuentas()).thenReturn(Collections.emptyList());
        when(cuentaModel.getTarjetas()).thenReturn(Collections.singletonList(tarjeta) );
        when(modelMapper.map(Mockito.any(),Mockito.any())).thenReturn(
                new TarjetaDTO()
        );

        assertNotNull(clienteService.getTarjetaClienteById(1));
    }

    @Test
    void getTarjetaClienteByIdCuentaExistente() {
        when(clienteRepository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(cliente));
        when(clienteModel.getCuentas()).thenReturn(Collections.singletonList(cuenta));
        when(cuentaModel.getTarjetas()).thenReturn(Collections.singletonList(tarjeta) );
        when(modelMapper.map(Mockito.any(),Mockito.any())).thenReturn(
                new TarjetaDTO()
        );

        assertNotNull(clienteService.getTarjetaClienteById(1));
    }
}