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

import com.sipsoft.licoreria.dto.TransaccionDTO;
import com.sipsoft.licoreria.entity.Caja;
import com.sipsoft.licoreria.entity.TipoPago;
import com.sipsoft.licoreria.entity.Transaccion;
import com.sipsoft.licoreria.entity.Usuario;
import com.sipsoft.licoreria.repository.CajaRepository;
import com.sipsoft.licoreria.repository.TipoPagoRepository;
import com.sipsoft.licoreria.repository.UsuarioRepository;
import com.sipsoft.licoreria.services.ITransaccionService;

@RestController
@RequestMapping("/sipsoft")
public class TransaccionController {
    @Autowired
    private ITransaccionService serviceTransaccion;

    @Autowired
    private TipoPagoRepository repoPago;

    @Autowired
    private UsuarioRepository repoUsuario;

    @Autowired
    private CajaRepository repoCaja;

    @GetMapping("/transacciones")
    public List<Transaccion> buscarTodos() {
        return serviceTransaccion.bucarTodos();
    }

    @PostMapping("/transacciones")
    public ResponseEntity<?> guardar(@RequestBody TransaccionDTO dto) {
        Transaccion transaccion = new Transaccion();
        transaccion.setMotivoTransaccion(dto.getMotivoTransaccion());
        transaccion.setMontoTransaccion(dto.getMontoTransaccion());
        transaccion.setTipo(dto.getTipo());
        transaccion.setFechaTransaccion(dto.getFechaTransaccion());

        TipoPago tipoPago = repoPago.findById(dto.getIdTipoPago()).orElse(null);
        Usuario usuario = repoUsuario.findById(dto.getIdUsuario()).orElse(null);
        Caja caja = repoCaja.findById(dto.getIdCaja()).orElse(null);

        transaccion.setIdTipoPago(tipoPago);
        transaccion.setIdUsuario(usuario);
        transaccion.setIdCaja(caja);

        return ResponseEntity.ok(serviceTransaccion.guardar(transaccion));
    }

    @PutMapping("/transacciones")
    public ResponseEntity<?> modificar(@RequestBody TransaccionDTO dto) {
        if (dto.getIdTransaccion() == null) {
            return ResponseEntity.badRequest().body("ID no existe");
        }
        Transaccion transaccion = new Transaccion();
        transaccion.setIdTransaccion(dto.getIdTransaccion());
        transaccion.setMotivoTransaccion(dto.getMotivoTransaccion());
        transaccion.setMontoTransaccion(dto.getMontoTransaccion());
        transaccion.setTipo(dto.getTipo());
        transaccion.setFechaTransaccion(dto.getFechaTransaccion());

        TipoPago tipoPago = repoPago.findById(dto.getIdTipoPago()).orElse(null);
        Usuario usuario = repoUsuario.findById(dto.getIdUsuario()).orElse(null);
        Caja caja = repoCaja.findById(dto.getIdCaja()).orElse(null);

        transaccion.setIdTipoPago(tipoPago);
        transaccion.setIdUsuario(usuario);
        transaccion.setIdCaja(caja);

        return ResponseEntity.ok(serviceTransaccion.modificar(transaccion));
    }

    @GetMapping("/transacciones/{idTransaccion}")
    public Optional<Transaccion> buscarId(@PathVariable("idTransaccion") Integer idTransaccion) {
        return serviceTransaccion.buscarId(idTransaccion);
    }

    @DeleteMapping("/transacciones/{idTransaccion}")
    public String eliminar(@PathVariable Integer idTransaccion) {
        serviceTransaccion.eliminar(idTransaccion);
        return "Transaccion eliminada";
    }
}
