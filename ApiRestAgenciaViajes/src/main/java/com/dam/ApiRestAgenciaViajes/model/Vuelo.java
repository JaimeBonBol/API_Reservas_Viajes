package com.dam.ApiRestAgenciaViajes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "vuelo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "compania", nullable = false)
    private String compania;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "plazas_disponibles", nullable = false)
    private Integer plazasDisponibles;

    /*Aclaraciones
    @OneToMany: Un vuelo puede tener muchas reservas.

    mappedBy = "vueloAsociado": significa que no se crea otra columna extra en la tabla.
    Le estás diciendo que la relación ya se mapea desde el lado de Reserva usando el atributo vueloAsociado.

    new LinkedHashSet<>()

    Esto asegura que si más tarde haces vuelo.getReservas(), la colección ya existe y no tendrás un NullPointerException.

    No usas una List porque los Set son más adecuados para relaciones donde no quieres elementos duplicados (dos veces la misma reserva en el mismo vuelo no tiene sentido).

    LinkedHashSet además da la ventaja de preservar el orden de llegada, lo cual puede ser útil si muestras las reservas en orden de creación.
     */
    @OneToMany(mappedBy = "vueloAsociado")
    @JsonIgnore
    private Set<Reserva> reservas = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public void setPlazasDisponibles(Integer plazasDisponibles) {
        this.plazasDisponibles = plazasDisponibles;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

}