package com.dam.ApiRestAgenciaViajes.repository;

import com.dam.ApiRestAgenciaViajes.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interfaz que extiende de JpaRepository para utilizar los métodos de JpaRepository  que permiten la
 * comunicación con la base de datos.
 */
public interface HotelJPASpringData extends JpaRepository<Hotel, Long> {

    /**
     * Metodo adicional para buscar hotel por nombre.
     * @param nombre Nombre del hotel a buscar
     * @return El hotel encontrado.
     */
    Optional<Hotel> findByNombre(String nombre);

    /**
     * Metodo adicional para eliminar un hotel según su id
     * @param id Id de hotel para eliminar.
     * @return El hotel eliminado.
     */
    Hotel deleteHotelById(Long id);

    /**
     * Metodo adicional para eliminar hotel por nombre.
     * @param nombre Nombre del hotel que se desea eliminar.
     * @return El hotel eliminado.
     */
    Hotel deleteHotelByNombre(String nombre);
}
