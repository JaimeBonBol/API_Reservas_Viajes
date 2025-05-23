package com.dam.ApiRestAgenciaViajes.controller;

import com.dam.ApiRestAgenciaViajes.model.Hotel;
import com.dam.ApiRestAgenciaViajes.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> listarHoteles() {
        return hotelService.listarHoteles();
    }

    @GetMapping("/disponibles")
    public List<Hotel> listarHotelesDisponibles(){
        return hotelService.listarHotelesDisponibles();
    }

    @GetMapping("/id/{id}")
    public Hotel buscarHotelPorId(@PathVariable Long id) {
        return hotelService.buscarHotelPorId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public Hotel buscarHotelPorNombre(@PathVariable String nombre) {
        return hotelService.buscarHotelporNombre(nombre);
    }

    @PostMapping
    public Hotel crearHotel(@RequestBody Hotel hotel) {
        return hotelService.crearHotel(hotel);
    }

    @PutMapping("/{id}")
    public Hotel actualizarHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        return hotelService.actualizarHotel(id, hotel);
    }

    @DeleteMapping("/{id}")
    public void eliminarHotelPorId(@PathVariable Long id) {
        hotelService.eliminarHotelPorId(id);
    }

}
