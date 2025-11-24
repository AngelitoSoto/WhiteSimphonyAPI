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

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @DeleteMapping
    public void limpiarProductos() {
        repo.deleteAll();
    }
}

