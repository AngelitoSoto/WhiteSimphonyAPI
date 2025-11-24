package com.whitesimphony.whitesimphony_api.carrito;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/whitesimphony/carrito")
@CrossOrigin(origins = "*")
public class CarritoController {

    private final CarritoRepository repo;

    public CarritoController(CarritoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<CarritoItem> getCarrito() {
        return repo.findAll();
    }

    @PostMapping
    public CarritoItem agregarProducto(@RequestBody CarritoItem item) {
        return repo.save(item);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @DeleteMapping
    public void limpiarCarrito() {
        repo.deleteAll();
    }
}

