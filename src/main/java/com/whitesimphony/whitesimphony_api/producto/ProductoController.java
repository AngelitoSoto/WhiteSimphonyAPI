package com.whitesimphony.whitesimphony_api.producto;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/whitesimphony/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Producto> getProductos() {
        return repo.findAll();
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return repo.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto productoActualizado) {

        Producto existente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        existente.setNombre(productoActualizado.getNombre());
        existente.setPrecio(productoActualizado.getPrecio());
        existente.setRating(productoActualizado.getRating());
        existente.setImagenUrl(productoActualizado.getImagenUrl());

        return repo.save(existente);
    }


    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @DeleteMapping
    public void limpiarProductos() {
        repo.deleteAll();
    }
}

