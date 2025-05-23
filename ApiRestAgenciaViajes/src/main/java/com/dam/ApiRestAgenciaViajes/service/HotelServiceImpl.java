package com.dam.ApiRestAgenciaViajes.service;

import com.dam.ApiRestAgenciaViajes.model.Hotel;
import com.dam.ApiRestAgenciaViajes.model.Vuelo;
import com.dam.ApiRestAgenciaViajes.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la lógica de negocio relacionada con los hoteles.
 */
@Service
public class HotelServiceImpl implements HotelService {

    /**
     * Atributo autoinyectado del repositorio del hotel para poder utilizar sus métodos.
     */
    @Autowired
    private HotelRepository hotelRepository;

    /**
     * Método para listar todos los hoteles.
     * @return Lista de todos los hoteles.
     */
    @Override
    public List<Hotel> listarHoteles() {
        return hotelRepository.obtenerHoteles();
    }

    /**
     * Método para lisatr todos los hoteles que estén disponibles.
     * @return Listado de hoteles dsiponibles.
     */
    @Override
    public List<Hotel> listarHotelesDisponibles() {
        //Guardar todos los hoteles en una lista.
        List<Hotel> todosLosHoteles =  hotelRepository.obtenerHoteles();

        //Creo lisat vacía donde iré añadiendo los hoteles con disponibilidad.
        List<Hotel> hotelesDisponibles = new ArrayList<>();

        for (Hotel hotel : todosLosHoteles) {
            if (hotel.getDisponibilidad()){
                hotelesDisponibles.add(hotel);
            }
        }

        return hotelesDisponibles;
    }

    /**
     * Método para buscar un hotel por su id.
     * @param id Id del hotel a buscar.
     * @return Hotel enocntrado, si no null.
     */
    @Override
    public Hotel buscarHotelPorId(Long id) {
        Hotel hotelExistente = hotelRepository.obtenerHotelPorId(id);
        if (hotelExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel no encontrado");
        }
        return hotelExistente;
    }

    /**
     * Método para busacr hotel por nombre.
     * @param nombre Nombre del hotel a busacr.
     * @return Hotel encontrado, si no null.
     */
    @Override
    public Hotel buscarHotelporNombre(String nombre) {
        Hotel hotelExistente = hotelRepository.obtenerHotelPorNombre(nombre);
        if (hotelExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel no encontrado");
        }

        return hotelExistente;
    }

    /**
     * Método para crear un hotel.
     * @param hotel Hotel a crear.
     * @return Hotel añadido.
     */
    @Override
    public Hotel crearHotel(Hotel hotel) {
        return hotelRepository.agregarHotel(hotel);
    }

    /**
     * Método para actualizar hotel.
     * @param id Id del hotel a actualizar.
     * @param hotel Nuevos datos del hotel.
     * @return Hotel actualizado.
     */
    @Override
    public Hotel actualizarHotel(Long id, Hotel hotel) {
        Hotel hotelExistente = hotelRepository.obtenerHotelPorId(id);
        if (hotelExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel no encontrado");
        }
        return hotelRepository.actualizarHotel(id, hotel);
    }

    /**
     * Método para eliminar hotel según su id. Guarda el hotel que ha sido eliminado de la base dee datos
     * y si este es null lanza un error.
     * @param id Id del hotel a eliminar.
     * @return Hotel eliminado.
     */
    @Override
    public Hotel eliminarHotelPorId(Long id) {
        Hotel hotelEliminado = hotelRepository.obtenerHotelPorId(id);
        if (hotelEliminado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel no encontrado");
        }

        hotelRepository.eliminarHotelPorId(id);

        return hotelEliminado;
    }

    /**
     * Método para eliminar hotel según su nombre. Guarda el hotel que ha sido eliminado de la base dee datos
     * y si este es null lanza un error.
     * @param nombre Id del hotel a eliminar.
     * @return Hotel eliminado.
     */
    @Override
    public Hotel eliminarHotelPorNombre(String nombre) {
        Hotel hotelEliminado = hotelRepository.obtenerHotelPorNombre(nombre);
        if (hotelEliminado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel no encontrado");
        }

        hotelRepository.eliminarHotelPorNombre(nombre);

        return hotelEliminado;
    }
}
