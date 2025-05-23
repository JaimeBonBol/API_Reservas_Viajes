package com.dam.ApiRestAgenciaViajes.repository;

import com.dam.ApiRestAgenciaViajes.model.Hotel;

import java.util.List;

/**
 * Interfaz que implementará la clase HotelRepositoryImpl para utilizar los métodos establecidos en esta.
 */
public interface HotelRepository {

    public List<Hotel> obtenerHoteles();

    public Hotel obtenerHotelPorId(Long id);

    public Hotel obtenerHotelPorNombre(String nombre);

    public Hotel agregarHotel(Hotel hotel);

    public Hotel actualizarHotel(Long id, Hotel hotel);

    public void eliminarHotelPorId(Long id);

}
