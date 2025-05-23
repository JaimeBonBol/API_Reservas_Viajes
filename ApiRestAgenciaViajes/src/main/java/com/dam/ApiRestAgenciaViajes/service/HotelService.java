package com.dam.ApiRestAgenciaViajes.service;

import com.dam.ApiRestAgenciaViajes.model.Hotel;

import java.util.List;

/**
 * Interfaz que extenderá la clase implemnetadción de servicio HotelServiceImpl, para usar los
 * métodos que se definan en esta interfaz.
 */
public interface HotelService {

    public List<Hotel> listarHoteles();

    public List<Hotel> listarHotelesDisponibles();

    public Hotel buscarHotelPorId(Long id);

    public Hotel buscarHotelporNombre(String nombre);

    public Hotel crearHotel(Hotel hotel);

    public Hotel actualizarHotel(Long id, Hotel hotel);

    public Hotel eliminarHotelPorId(Long id);

    public Hotel eliminarHotelPorNombre(String nombre);

}
