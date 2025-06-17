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

import com.sipsoft.licoreria.dto.TipoPagoDTO;
import com.sipsoft.licoreria.entity.Empresa;
import com.sipsoft.licoreria.entity.TipoPago;
import com.sipsoft.licoreria.repository.EmpresaRepository;
import com.sipsoft.licoreria.services.ITipoPagoService;

@RestController
@RequestMapping("/sipsoft")
public class TipoPagoController {
    @Autowired
    private ITipoPagoService serviceTipoPago;

    @Autowired EmpresaRepository repoEmpresa;

    @GetMapping("/tipos-pago")
    public List<TipoPago> buscarTodos() {
        return serviceTipoPago.bucarTodos();
    }
    @PostMapping("/tipos-pago")
    public ResponseEntity<?> guardar(@RequestBody TipoPagoDTO dto) {
        TipoPago tipoPago = new TipoPago();
        tipoPago.setDescripcionPago(dto.getDescripcionPago());

        Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);

        tipoPago.setIdEmpresa(empresa);

        return ResponseEntity.ok(serviceTipoPago.guardar(tipoPago));
    }

    @PutMapping("/tipos-pago")
    public ResponseEntity<?> modificar(@RequestBody TipoPagoDTO dto) {
        if (dto.getIdTipoPago() == null) {
            return ResponseEntity.badRequest().body("ID no existe");
        }
        TipoPago tipoPago = new TipoPago();
        tipoPago.setIdTipoPago(dto.getIdTipoPago());
        tipoPago.setDescripcionPago(dto.getDescripcionPago());

        Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
        tipoPago.setIdEmpresa(empresa);

        return ResponseEntity.ok(serviceTipoPago.modificar(tipoPago));
    }

    @GetMapping("/tipos-pago/{idTipoPago}")
    public Optional<TipoPago> buscarId(@PathVariable("idTipoPago") Integer idTipoPago) {
        return serviceTipoPago.buscarId(idTipoPago);
    }

    @DeleteMapping("/tipos-pago/{idTipoPago}")
    public String eliminar(@PathVariable Integer idTipoPago){
        serviceTipoPago.eliminar(idTipoPago);
        return "Tipo Pago eliminado";
    }
}
