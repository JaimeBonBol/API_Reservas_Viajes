package com.dam.ApiRestAgenciaViajes.service;

import com.dam.ApiRestAgenciaViajes.model.Vuelo;

import java.util.List;

/**
 * Interfaz que extenderá la clase implemnetadción de servicio VueloServiceImpl, para usar los
 * métodos que se definan en esta interfaz.
 */
public interface VueloService {

    public List<Vuelo> listarVuelos();

    public List<Vuelo> listarVuelosConPlazasDisponibles();

    public Vuelo buscarVueloPorId(Long id);

    public Vuelo crearVuelo(Vuelo vuelo);

    public Vuelo actualizarVuelo(Long id, Vuelo vuelo);

    public Vuelo eliminarVuelo(Long id);

}
