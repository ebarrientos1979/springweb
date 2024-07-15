package pe.scotiabank.serviciows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.scotiabank.serviciows.dto.CuentaDTO;
import pe.scotiabank.serviciows.service.CuentaService;

import java.util.List;

@RestController
@RequestMapping("/v1/cuenta")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/listarCuentas")
    public ResponseEntity<List<CuentaDTO>> getAllCuenta(){
        return ResponseEntity.ok(this.cuentaService.getAllCuenta());
    }

    @GetMapping("/getCuentaById/{id}")
    public ResponseEntity<CuentaDTO> getCuentaById(@PathVariable Integer id){
        CuentaDTO cuentaDTO = this.cuentaService.getCuentaById(id);
        /*if(cuentaDTO.getCuentaId() == null){
            return ResponseEntity.notFound().build();
        }*/
        return ResponseEntity.ok(cuentaDTO);
    }

    @PostMapping("/saveCuenta")
    public ResponseEntity<CuentaDTO> saveCuenta(@RequestBody CuentaDTO cuentaDTO){
        return ResponseEntity.ok(this.cuentaService.saveCuenta(cuentaDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCuenta(@PathVariable Integer id){
        this.cuentaService.deleteCuenta(id);
        return ResponseEntity.ok().build();
    }

}
