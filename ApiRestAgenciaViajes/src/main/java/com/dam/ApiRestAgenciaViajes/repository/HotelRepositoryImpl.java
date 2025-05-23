package com.dam.ApiRestAgenciaViajes.repository;

import com.dam.ApiRestAgenciaViajes.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase repositorio que implementa la interfaz de HotelRepository.
 */

@Repository
public class HotelRepositoryImpl implements HotelRepository{

    /**
     * Atributo autoinyectado de la interfaz HotelJpaSpringData para utilizar los metodos
     * de comunicación con la base de datos.
     */
    @Autowired
    public HotelJPASpringData hotelJPASpringData;


    /**
     * Metodo para obtener todos los hoteles de la base de datos.
     * @return Lista de hoteles.
     */
    @Override
    public List<Hotel> obtenerHoteles() {
        return hotelJPASpringData.findAll();
    }

    /**
     * Metodo para obtener un hotel por id.
     * @param id Id del hotel a buscar.
     * @return El hotel encontrado.
     */
    @Override
    public Hotel obtenerHotelPorId(Long id) {
        return hotelJPASpringData.findById(id).orElse(null);
    }

    /**
     * Metodo para obtener un hotel por su nombre.
     * @param nombre Nombre del hotel a buscar.
     * @return El hotel encontrado.
     */
    @Override
    public Hotel obtenerHotelPorNombre(String nombre) {
        return hotelJPASpringData.findByNombre(nombre).orElse(null);
    }

    /**
     * Metodo para agregar un hotel.
     * @param hotel Hotel para guardar.
     * @return El hotel guardado.
     */
    @Override
    public Hotel agregarHotel(Hotel hotel) {
        return hotelJPASpringData.save(hotel);
    }

    /**
     * Metodo para actualizar un hotel.
     * @param id Id del hotel a actualizar.
     * @param hotel Nuevos datos del hotel para actualizar.
     * @return El hotel actualizado.
     */
    @Override
    public Hotel actualizarHotel(Long id, Hotel hotel) {
        hotel.setId(id);
        return hotelJPASpringData.save(hotel);
    }

    /**
     * Metodo para eliminar un hotel según su id.
     * @param id Id del hotel a eliminar.
     * @return Hotel eliminado.
     */
    @Override
    public Hotel eliminarHotelPorId(Long id) {
        return hotelJPASpringData.deleteHotelById(id);
    }

    /**
     * Metodo para eliminar un hotel según su nombre.
     * @param nombre Nombre del hotel a eliminar.
     * @return Hotel eliminado.
     */
    @Override
    public Hotel eliminarHotelPorNombre(String nombre) {
        return hotelJPASpringData.deleteHotelByNombre(nombre);
    }
}
