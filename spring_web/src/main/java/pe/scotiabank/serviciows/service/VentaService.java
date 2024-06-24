package pe.scotiabank.serviciows.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.scotiabank.serviciows.dto.PedidoDTO;
import pe.scotiabank.serviciows.dto.VentaDTO;
import pe.scotiabank.serviciows.model.VentaModel;
import pe.scotiabank.serviciows.repository.VentaRepository;

import java.util.List;

@Service
public class VentaService {
    private final VentaRepository ventaRepository;
    private final ModelMapper modelMapper;

    public VentaService(VentaRepository ventaRepository, ModelMapper modelMapper) {
        this.ventaRepository = ventaRepository;
        this.modelMapper = modelMapper;
    }

    public float calculoImpuesto(List<PedidoDTO> listaPedidoDTO){
        float impuesto = 0.18F;
        float calculoImpuesto = 0.0F;

        for(PedidoDTO pedidoDTO : listaPedidoDTO){
            if(pedidoDTO.isAfectacion()){
                calculoImpuesto += pedidoDTO.getCantidad() * pedidoDTO.getCostoUnitario() * impuesto;
            }
        }
        return  calculoImpuesto;
    }

    public List<VentaDTO> getVentas(){
        List<VentaModel> listaVentas =  this.ventaRepository.findAll();
        List<VentaDTO> listaVentasDTO = modelMapper.map(listaVentas, List.class).stream().toList();
        return listaVentasDTO;
    }

    public VentaDTO addVenta(VentaDTO ventaDTO){
        VentaModel ventaModel = modelMapper.map(ventaDTO, VentaModel.class);
        ventaModel = this.ventaRepository.save(ventaModel);
        return modelMapper.map(ventaModel, VentaDTO.class);
    }
}
