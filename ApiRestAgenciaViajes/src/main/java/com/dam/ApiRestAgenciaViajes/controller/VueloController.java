package com.dam.ApiRestAgenciaViajes.controller;

import com.dam.ApiRestAgenciaViajes.model.Vuelo;
import com.dam.ApiRestAgenciaViajes.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase controlador la cuál se encarga de recibir y responder a las peticiones HTTP.
 */
@RestController
@RequestMapping("api/vuelos")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @GetMapping
    public List<Vuelo> listarVuelos(){
        return vueloService.listarVuelos();
    }

    @GetMapping("/disponibles")
    public List<Vuelo> listarVuelosDisponibles(){
        return vueloService.listarVuelosConPlazasDisponibles();
    }

    @GetMapping("/{id}")
    public Vuelo buscarVueloPorId(@PathVariable("id") Long id){
        return vueloService.buscarVueloPorId(id);
    }

    @PostMapping
    public Vuelo agregarVuelo(@RequestBody Vuelo vuelo){
        return vueloService.crearVuelo(vuelo);
    }

    @PutMapping("/{id}")
    public Vuelo actualizarVuelo(@PathVariable("id") Long id, @RequestBody Vuelo vuelo){
        return vueloService.actualizarVuelo(id, vuelo);
    }

    @DeleteMapping("/{id}")
    public void eliminarVuelo(@PathVariable("id") Long id){
        vueloService.eliminarVuelo(id);
    }

}
