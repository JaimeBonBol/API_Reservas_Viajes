package com.dam.ApiRestAgenciaViajes.service;

import com.dam.ApiRestAgenciaViajes.model.Reserva;

import java.util.List;

/**
 * Interfaz que extenderá la clase implemnetadción de servicio reservaServiceImpl, para usar los
 * métodos que se definan en esta interfaz.
 */
public interface ReservaService {

    public List<Reserva> listarReservas();

    public Reserva buscarReservaPorId(Long id);

    public Reserva guardarReserva(Reserva reserva);

    public Reserva actualizarReserva(Long id, Reserva reserva);

    public Reserva eliminarReserva(Long id);

}
