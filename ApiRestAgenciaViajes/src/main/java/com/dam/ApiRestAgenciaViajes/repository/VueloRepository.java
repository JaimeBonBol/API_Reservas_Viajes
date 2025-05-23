package com.dam.ApiRestAgenciaViajes.repository;

import com.dam.ApiRestAgenciaViajes.model.Vuelo;

import java.util.List;

/**
 * Interfaz que implementará la clase VueloRepositoryImpl para utilizar los métodos establecidos en esta.
 */
public interface VueloRepository {

    public List<Vuelo> obtenerVuelos();

    public Vuelo obtenerVueloPorId(Long id);

    public Vuelo agregarVuelo(Vuelo vuelo);

    public Vuelo actualizarVuelo(Long id, Vuelo vuelo);

    public Vuelo eliminarVuelo(Long id);

}
