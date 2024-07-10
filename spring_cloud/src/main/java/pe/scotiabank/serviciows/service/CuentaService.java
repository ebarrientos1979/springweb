package pe.scotiabank.serviciows.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.scotiabank.serviciows.dto.CuentaDTO;
import pe.scotiabank.serviciows.model.CuentaModel;
import pe.scotiabank.serviciows.repository.CuentaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    private final ModelMapper modelMapper;
    private final CuentaRepository cuentaRepository;

    public CuentaService(ModelMapper modelMapper, CuentaRepository cuentaRepository) {
        this.modelMapper = modelMapper;
        this.cuentaRepository = cuentaRepository;
    }

    public List<CuentaDTO> getAllCuenta(){
        return this.cuentaRepository.findAll().stream()
                .map(cuenta -> this.modelMapper.map(cuenta, CuentaDTO.class))
                .toList();
    }

    public CuentaDTO getCuentaById(Integer id){
        Optional<CuentaModel> cuentaModel = this.cuentaRepository.findById(id);

        if(cuentaModel.isEmpty()){
            return new CuentaDTO();
        }
        return this.modelMapper.map(cuentaModel, CuentaDTO.class);
    }

    public CuentaDTO saveCuenta(CuentaDTO cuentaDTO){
        CuentaModel cuentaModel = this.modelMapper.map(cuentaDTO, CuentaModel.class);
        cuentaModel = this.cuentaRepository.save(cuentaModel);
        return this.modelMapper.map(cuentaModel, CuentaDTO.class);
    }

    public void deleteCuenta(Integer id){
        this.cuentaRepository.deleteById(id);
    }
}
