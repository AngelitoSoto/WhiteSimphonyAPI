package com.whitesimphony.whitesimphony_api.carrito;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<CarritoItem, Long> {
}
