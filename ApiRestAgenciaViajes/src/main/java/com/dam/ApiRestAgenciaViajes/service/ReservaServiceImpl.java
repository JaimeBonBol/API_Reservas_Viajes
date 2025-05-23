package com.dam.ApiRestAgenciaViajes.service;

import com.dam.ApiRestAgenciaViajes.model.Hotel;
import com.dam.ApiRestAgenciaViajes.model.Reserva;
import com.dam.ApiRestAgenciaViajes.model.Vuelo;
import com.dam.ApiRestAgenciaViajes.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private VueloService vueloService;  // usa la lógica de negocio completa del vuelo

    @Autowired
    private HotelService hotelService;

    @Override
    public List<Reserva> listarReservas() {
        return reservaRepository.obtenerReservas();
    }

    @Override
    public Reserva buscarReservaPorId(Long id) {
        Reserva reservaExistente = reservaRepository.obtenerReservaPorId(id);

        if (reservaExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vuelo no encontrado");
        }

        return reservaExistente;
    }

    @Override
    public Reserva guardarReserva(Reserva reserva) {
        //Vuelo asociado a la reserva. Ya controla gracias a vueloService si el vuelo existe o no (en ese caso lanzaz excepción).
        Vuelo vueloReserva = vueloService.buscarVueloPorId(reserva.getVueloAsociado().getId());
        Hotel hotelReserva = hotelService.buscarHotelPorId(reserva.getHotelAsociado().getId());

        // Se compreuba si hay plazas disponibles.
        if (vueloReserva.getPlazasDisponibles() <= 0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay plazas disponibles en el vuelo");
        }

        if (!hotelReserva.getDisponibilidad()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El hotel no está disponible");
        }

        //Se resta una plaza al vuelo.
        vueloReserva.setPlazasDisponibles(vueloReserva.getPlazasDisponibles() - 1);

        //Se actualiza el vuelo.
        vueloService.actualizarVuelo(vueloReserva.getId(), vueloReserva);

        // Asignar las entidades completas a la reserva antes de guardar
        reserva.setVueloAsociado(vueloReserva);
        reserva.setHotelAsociado(hotelReserva);

        return reservaRepository.agregarReserva(reserva);
    }

    @Override
    public Reserva actualizarReserva(Long id, Reserva reserva) {
        Reserva reservaExistente = reservaRepository.obtenerReservaPorId(id);

        if (reservaExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vuelo no encontrado");
        }

        return reservaRepository.actualizarReserva(id, reserva);
    }

    @Override
    public Reserva eliminarReserva(Long id) {
        Reserva reservaExistente = reservaRepository.obtenerReservaPorId(id);

        if (reservaExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vuelo no encontrado");
        }

        reservaRepository.eliminarReserva(id);

        //Aumentar la plaza del vuelo asociado al eliminar la reserva.
        Vuelo vueloReserva = vueloService.buscarVueloPorId(reservaExistente.getVueloAsociado().getId());
        vueloReserva.setPlazasDisponibles(vueloReserva.getPlazasDisponibles() + 1);
        vueloService.actualizarVuelo(vueloReserva.getId(), vueloReserva);


        return reservaExistente;
    }
}
