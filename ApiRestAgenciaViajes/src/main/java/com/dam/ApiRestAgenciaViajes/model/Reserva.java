package com.dam.ApiRestAgenciaViajes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "dni", nullable = false, length = 20)
    private String dni;

    /*Aclaraciones
    ¿Qué significa?

    @ManyToOne: muchas reservas pueden estar asociadas al mismo vuelo.

        Ejemplo: 50 personas pueden reservar el vuelo 1234. Cada reserva es un objeto diferente, pero todos apuntan al mismo vuelo.

    fetch = FetchType.LAZY:

        El vuelo no se carga automáticamente cuando consultas la reserva.

        Se carga solo si haces .getVueloAsociado().

        Esto mejora el rendimiento y evita traer datos innecesarios si no los vas a usar.

    @JoinColumn(name = "vuelo_asociado"):

        Especifica que la columna en la tabla reserva se llama vuelo_asociado, y es una clave foránea (foreign key) que apunta al ID del vuelo.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vuelo_asociado")
    private Vuelo vueloAsociado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_asociado")
    private Hotel hotelAsociado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Vuelo getVueloAsociado() {
        return vueloAsociado;
    }

    public void setVueloAsociado(Vuelo vueloAsociado) {
        this.vueloAsociado = vueloAsociado;
    }

    public Hotel getHotelAsociado() {
        return hotelAsociado;
    }

    public void setHotelAsociado(Hotel hotelAsociado) {
        this.hotelAsociado = hotelAsociado;
    }

}