package com.dam.ApiRestAgenciaViajes.repository;

import com.dam.ApiRestAgenciaViajes.model.Reserva;

import java.util.List;

/**
 * Interfaz que implementará la clase ReservaRposiotryImpl para utilizar los métodos establecidos en esta.
 */
public interface ReservaRepository {

    public List<Reserva> obtenerReservas();

    public Reserva obtenerReservaPorId(Long id);

    public Reserva agregarReserva(Reserva reserva);

    public Reserva actualizarReserva(Long id, Reserva reserva);

    public void eliminarReserva(Long id);

}
