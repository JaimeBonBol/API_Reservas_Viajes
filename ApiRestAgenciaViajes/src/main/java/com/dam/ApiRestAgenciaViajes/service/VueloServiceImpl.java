package com.dam.ApiRestAgenciaViajes.service;

import com.dam.ApiRestAgenciaViajes.model.Vuelo;
import com.dam.ApiRestAgenciaViajes.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la lógica de negocio relacionada con los vuelos.
 */
@Service
public class VueloServiceImpl implements VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    @Override
    public List<Vuelo> listarVuelos() {
        return vueloRepository.obtenerVuelos();
    }

    @Override
    public List<Vuelo> listarVuelosConPlazasDisponibles() {
        //Guardar todos los vuelos en una lista.
        List<Vuelo> todosLosVuelos = vueloRepository.obtenerVuelos();

        //Crear lista vacía para almacenar los vuelos con plazas disponibles.
        List<Vuelo> vuelosConPlazas = new ArrayList<Vuelo>();

        for (Vuelo vuelo : todosLosVuelos) {
            if (vuelo.getPlazasDisponibles() > 0){
                vuelosConPlazas.add(vuelo);
            }
        }

        return vuelosConPlazas;
    }

    @Override
    public Vuelo buscarVueloPorId(Long id) {
        Vuelo vueloExistente = vueloRepository.obtenerVueloPorId(id);

        if (vueloExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vuelo no encontrado");
        }

        return vueloExistente;
    }

    @Override
    public Vuelo crearVuelo(Vuelo vuelo) {
        return vueloRepository.agregarVuelo(vuelo);
    }

    @Override
    public Vuelo actualizarVuelo(Long id, Vuelo vuelo) {
        Vuelo vueloExistente = vueloRepository.obtenerVueloPorId(id);

        if (vueloExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vuelo no encontrado");
        }

        return vueloRepository.actualizarVuelo(id, vuelo);
    }

    @Override
    public Vuelo eliminarVuelo(Long id) {
        Vuelo vueloExistente = vueloRepository.obtenerVueloPorId(id);

        if (vueloExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vuelo no encontrado");
        }

        vueloRepository.eliminarVuelo(id);

        return vueloExistente;
    }
}
