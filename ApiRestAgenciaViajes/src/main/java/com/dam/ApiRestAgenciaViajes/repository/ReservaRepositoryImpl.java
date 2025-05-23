package com.dam.ApiRestAgenciaViajes.repository;

import com.dam.ApiRestAgenciaViajes.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase repositorio que implementa la interfaz de ReservaRepository para establecer un contrato
 * y que tenga esos métodos obligatoriamente.
 */
@Repository
public class ReservaRepositoryImpl implements ReservaRepository {

    /**
     * Atributo autoinyectado de la interfaz ReservaJPASpringData para utilizar los metodos
     * de comunicación con la base de datos.
     */
    @Autowired
    private ReservaJPASpringData reservaJPASpringData;

    /**
     * Método para obtener todas las reservas de la base de datos.
     * @return Listado de reservas.
     */
    @Override
    public List<Reserva> obtenerReservas() {
        return reservaJPASpringData.findAll();
    }

    /**
     * Método para obtener una reserva por su id.
     * @param id Id de la reserva a buscar.
     * @return Reserva encontrada, si no null.
     */
    @Override
    public Reserva obtenerReservaPorId(Long id) {
        return reservaJPASpringData.findById(id).orElse(null);
    }

    /**
     * Método para agregar una reserva a nuestra base de datos.
     * @param reserva Reserva a añadir.
     * @return Reserva añadida.
     */
    @Override
    public Reserva agregarReserva(Reserva reserva) {
        return reservaJPASpringData.save(reserva);
    }

    /**
     * Método para actualizar una resrerva de la base de datos.
     * @param id Id de la reserva a actualizar.
     * @param reserva Nuevos datos de la reserva.
     * @return Reserrva actualizada.
     */
    @Override
    public Reserva actualizarReserva(Long id, Reserva reserva) {
        reserva.setId(id);
        return reservaJPASpringData.save(reserva);
    }

    /**
     * Método para eliminar una reservpor su id.Obtiene la resrerva a eliminar a partir del
     * id  y si este no es null lo elimina.
     * @param id Id de la resrva a eliminar.
     * @return Reserva eliminada.
     */
    @Override
    public Reserva eliminarReserva(Long id) {
        /*Reserva reservaEliminar = reservaJPASpringData.findById(id).orElse(null);
        if (reservaEliminar != null) {
            reservaJPASpringData.deleteById(id);
        }
        return reservaEliminar;*/
        return reservaJPASpringData.deleteReservaById(id);
    }
}
