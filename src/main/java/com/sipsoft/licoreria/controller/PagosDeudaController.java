package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.dto.PagosDeudaDTO;
import com.sipsoft.licoreria.entity.DeudaProveedor;
import com.sipsoft.licoreria.entity.PagosDeuda;
import com.sipsoft.licoreria.repository.DeudaProveedorRepository;
import com.sipsoft.licoreria.services.IPagosDeudaService;

@RestController
@RequestMapping("/sipsoft")
public class PagosDeudaController {
    @Autowired
    private IPagosDeudaService servicePagosDeuda;
    
    @Autowired
    private DeudaProveedorRepository repoDeudaProveedor;

    @GetMapping("/pagos-deuda")
    public List<PagosDeuda> buscarTodos() {
        return servicePagosDeuda.bucarTodos();
    }
    @PostMapping("/pagos-deuda")
    public ResponseEntity <?> guardar(@RequestBody PagosDeudaDTO dto) {
       PagosDeuda pagosDeuda = new PagosDeuda();
       pagosDeuda.setFechaPagoParcialDeuda(dto.getFechaPagoParcialDeuda());
       pagosDeuda.setMontoAbonado(dto.getMontoAbonado());
       pagosDeuda.setObservaciones(dto.getObservaciones());

        DeudaProveedor deudaProveedor = repoDeudaProveedor.findById(dto.getIdDeuda()).orElse(null);
        pagosDeuda.setIdDeuda(deudaProveedor);        

        return ResponseEntity.ok(servicePagosDeuda.guardar(pagosDeuda));
    }

    @PutMapping("/pagos-deuda")
    public ResponseEntity <?> modificar(@RequestBody PagosDeudaDTO dto) {
        if (dto.getIdPagosDeuda() == null) {
            return ResponseEntity.badRequest().body("ID no existe");            
        }
        PagosDeuda pagosDeuda = new PagosDeuda();
        pagosDeuda.setIdPagosDeuda(dto.getIdPagosDeuda());
        pagosDeuda.setFechaPagoParcialDeuda(dto.getFechaPagoParcialDeuda());
        pagosDeuda.setMontoAbonado(dto.getMontoAbonado());
        pagosDeuda.setObservaciones(dto.getObservaciones());
        
        pagosDeuda.setIdDeuda(new DeudaProveedor(dto.getIdDeuda()));

        return ResponseEntity.ok(servicePagosDeuda.modificar(pagosDeuda));
    }

    @GetMapping("/pagos-deuda/{idPagosDeuda}")
    public Optional<PagosDeuda> buscarId(@PathVariable("idPagosDeuda") Integer idPagosDeuda) {
        return servicePagosDeuda.buscarId(idPagosDeuda);
    }

    @DeleteMapping("/pagos-deuda/{idPagosDeuda}")
    public String eliminar(@PathVariable Integer idPagosDeuda){
        servicePagosDeuda.eliminar(idPagosDeuda);
        return "Pago Deuda eliminado";
    }
}
