package com.dam.ApiRestAgenciaViajes.repository;

import com.dam.ApiRestAgenciaViajes.model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase repositorio que implementa la interfaz de VueloRepository para establecer un contrato
 * y que tenga esos métodos obligatoriamente.
 */
@Repository
public class VueloRepositoryImpl implements VueloRepository{

    /**
     * Atributo autoinyectado de la interfaz VueloJPASpringData para utilizar los metodos
     * de comunicación con la base de datos.
     */
    @Autowired
    private VueloJPASpringData vueloJPASpringData;

    /**
     * Método para obtener todos los vuelos.
     * @return Vuelos de la base de datos.
     */
    @Override
    public List<Vuelo> obtenerVuelos() {
        return vueloJPASpringData.findAll();
    }

    /**
     * Método para obtener un vuelo según sdu id.
     * @param id Id del vuelo que se busca.
     * @return El vuelo encontrado, si no null.
     */
    @Override
    public Vuelo obtenerVueloPorId(Long id) {
        return vueloJPASpringData.findById(id).orElse(null);
    }

    /**
     * Método para guardar un nuevo vuelo a nuestra base de datos.
     * @param vuelo Vuelo a guardar.
     * @return El vuelo que se ha añadido.
     */
    @Override
    public Vuelo agregarVuelo(Vuelo vuelo) {
        return vueloJPASpringData.save(vuelo);
    }

    /**
     * Método para actualizar un vuelo.
     * @param id Id del vuelo ha actualizar.
     * @param vuelo Nuevos datos del vuelo.
     * @return El vuelo actualizado.
     */
    @Override
    public Vuelo actualizarVuelo(Long id, Vuelo vuelo) {
        vuelo.setId(id);
        return vueloJPASpringData.save(vuelo);
    }

    /**
     * Método apra eliminar un vuelo por id.
     * @param id Id del vuelo que se desea eliminar.
     * @return El vuelo eliminado.
     */
    @Override
    public Vuelo eliminarVuelo(Long id) {
        return vueloJPASpringData.deleteVueloById(id);
    }
}
