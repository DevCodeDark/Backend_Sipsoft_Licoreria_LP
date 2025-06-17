package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.entity.Producto;
import com.sipsoft.licoreria.dto.ProductoDTO;
import com.sipsoft.licoreria.entity.Empresa;
import com.sipsoft.licoreria.entity.Categoria;
import com.sipsoft.licoreria.entity.UnidadMedida;
import com.sipsoft.licoreria.repository.EmpresaRepository;
import com.sipsoft.licoreria.repository.CategoriaRepository;
import com.sipsoft.licoreria.repository.UnidadMedidaRepository;
import com.sipsoft.licoreria.services.IProductoService;

@RestController
@RequestMapping("/sipsoft")
public class ProductoController {
    @Autowired
    private IProductoService serviceProducto;

    @Autowired
    private EmpresaRepository repoEmpresa;

    @Autowired
    private CategoriaRepository repoCategoria;

    @Autowired
    private UnidadMedidaRepository repoUnidadMedida;

    @GetMapping("/productos")
    public List<Producto> buscarTodos() {
        return serviceProducto.bucarTodos();
    }

    @PostMapping("/productos")
    public Producto guardar(@RequestBody ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setCodBarras(dto.getCodBarras());
        producto.setDescripcionProducto(dto.getDescripcionProducto());
        producto.setStockMinimo(dto.getStockMinimo());
        producto.setImagenProducto(dto.getImagenProducto());
        producto.setPrecioVentaProducto(dto.getPrecioVentaProducto());
        producto.setGananciaPorcentaje(dto.getGananciaPorcentaje());
        producto.setEstadoProducto(dto.getEstadoProducto());

        Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
        producto.setEmpresa(empresa);

        Categoria categoria = repoCategoria.findById(dto.getIdCategoria()).orElse(null);
        producto.setIdCategoria(categoria);

        UnidadMedida unidadMedida = repoUnidadMedida.findById(dto.getIdUnidadMedida()).orElse(null);
        producto.setIdUnidadMedida(unidadMedida);

        serviceProducto.guardar(producto);
        return producto;
    }

    @PutMapping("/productos")
    public Producto modificar(@RequestBody ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setIdProducto(dto.getIdProducto());
        producto.setCodBarras(dto.getCodBarras());
        producto.setDescripcionProducto(dto.getDescripcionProducto());
        producto.setStockMinimo(dto.getStockMinimo());
        producto.setImagenProducto(dto.getImagenProducto());
        producto.setPrecioVentaProducto(dto.getPrecioVentaProducto());
        producto.setGananciaPorcentaje(dto.getGananciaPorcentaje());
        producto.setEstadoProducto(dto.getEstadoProducto());

        Empresa empresa = repoEmpresa.findById(dto.getIdEmpresa()).orElse(null);
        producto.setEmpresa(empresa);

        Categoria categoria = repoCategoria.findById(dto.getIdCategoria()).orElse(null);
        producto.setIdCategoria(categoria);

        UnidadMedida unidadMedida = repoUnidadMedida.findById(dto.getIdUnidadMedida()).orElse(null);
        producto.setIdUnidadMedida(unidadMedida);

        serviceProducto.modificar(producto);
        return producto;
    }

    @GetMapping("/productos/{idProducto}")
    public Optional<Producto> buscarId(@PathVariable("idProducto") Integer idProducto) {
        return serviceProducto.buscarId(idProducto);
    }

    @DeleteMapping("/productos/{idProducto}")
    public String eliminar(@PathVariable Integer idProducto){
        serviceProducto.eliminar(idProducto);
        return "Producto eliminado";
    }
}
