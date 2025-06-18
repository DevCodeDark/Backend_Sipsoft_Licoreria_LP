package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
import com.sipsoft.licoreria.services.IProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/sipsoft")
@Transactional(readOnly = true)
@Tag(name = "Productos", description = "Gestión de productos e inventario")
@SecurityRequirement(name = "bearerAuth")
public class ProductoController {
    @Autowired
    private IProductoService serviceProducto;@GetMapping("/productos")
    @Operation(summary = "Obtener todos los productos", 
               description = "Retrieves a list of all products in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente",
                    content = @Content(schema = @Schema(implementation = Producto.class))),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso denegado")
    })
    public List<Producto> buscarTodos() {
        return serviceProducto.bucarTodos();
    }    @PostMapping("/productos")
    @Operation(summary = "Crear un nuevo producto", 
               description = "Creates a new product in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto creado exitosamente",
                    content = @Content(schema = @Schema(implementation = Producto.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso denegado")
    })
    public Producto guardar(@RequestBody ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setCodBarras(dto.getCodBarras());
        producto.setDescripcionProducto(dto.getDescripcionProducto());
        producto.setStockMinimo(dto.getStockMinimo());
        producto.setImagenProducto(dto.getImagenProducto());        producto.setPrecioVentaProducto(dto.getPrecioVentaProducto());
        producto.setGananciaPorcentaje(dto.getGananciaPorcentaje());
        producto.setEstadoProducto(dto.getEstadoProducto());
        producto.setIdEmpresa(dto.getIdEmpresa());
        producto.setIdCategoria(dto.getIdCategoria());
        producto.setIdUnidadMedida(dto.getIdUnidadMedida());

        serviceProducto.guardar(producto);
        return producto;
    }    @PutMapping("/productos")
    @Operation(summary = "Actualizar un producto existente", 
               description = "Updates an existing product in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto actualizado exitosamente",
                    content = @Content(schema = @Schema(implementation = Producto.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso denegado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public Producto modificar(@RequestBody ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setIdProducto(dto.getIdProducto());
        producto.setCodBarras(dto.getCodBarras());
        producto.setDescripcionProducto(dto.getDescripcionProducto());
        producto.setStockMinimo(dto.getStockMinimo());
        producto.setImagenProducto(dto.getImagenProducto());
        producto.setPrecioVentaProducto(dto.getPrecioVentaProducto());
        producto.setGananciaPorcentaje(dto.getGananciaPorcentaje());
        producto.setEstadoProducto(dto.getEstadoProducto());        producto.setPrecioVentaProducto(dto.getPrecioVentaProducto());
        producto.setGananciaPorcentaje(dto.getGananciaPorcentaje());
        producto.setEstadoProducto(dto.getEstadoProducto());
        producto.setIdEmpresa(dto.getIdEmpresa());
        producto.setIdCategoria(dto.getIdCategoria());
        producto.setIdUnidadMedida(dto.getIdUnidadMedida());

        serviceProducto.modificar(producto);
        return producto;
    }    @GetMapping("/productos/{idProducto}")
    @Operation(summary = "Obtener un producto por ID", 
               description = "Retrieves a specific product by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto encontrado",
                    content = @Content(schema = @Schema(implementation = Producto.class))),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso denegado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public Optional<Producto> buscarId(@Parameter(description = "ID del producto a buscar", required = true)
                                       @PathVariable("idProducto") Integer idProducto) {
        return serviceProducto.buscarId(idProducto);
    }    @DeleteMapping("/productos/{idProducto}")
    @Operation(summary = "Eliminar un producto", 
               description = "Deletes a product from the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto eliminado exitosamente"),
        @ApiResponse(responseCode = "401", description = "No autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso denegado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public String eliminar(@Parameter(description = "ID del producto a eliminar", required = true)
                          @PathVariable Integer idProducto){
        serviceProducto.eliminar(idProducto);
        return "Producto eliminado";
    }
}
