package com.dam.ApiRestAgenciaViajes.repository;

import com.dam.ApiRestAgenciaViajes.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que extiende de JpaRepository para utilizar los métodos de JpaRepository  que permiten la
 * comunicación con la base de datos.
 */
public interface ReservaJPASpringData extends JpaRepository<Reserva, Long> {

    Reserva deleteReservaById(Long id);
}
