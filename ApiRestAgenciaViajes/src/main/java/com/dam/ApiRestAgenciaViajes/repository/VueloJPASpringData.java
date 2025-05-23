package com.dam.ApiRestAgenciaViajes.repository;

import com.dam.ApiRestAgenciaViajes.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que extiende de JpaRepository para utilizar los métodos de JpaRepository  que permiten la
 * comunicación con la base de datos.
 */
public interface VueloJPASpringData extends JpaRepository<Vuelo, Long> {
    Vuelo deleteVueloById(Long id);
}
