package com.pablo.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "garajes")  // Definimos el nombre de la tabla en la base de datos
public class Garaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)  // Definimos que la dirección será única y no puede ser nula
    private String direccion;

    @Column(nullable = false)  // La columna 'nombre' no puede ser nula
    private String nombre;

    @Column(nullable = false)  // La columna 'capacidad' no puede ser nula
    private int capacidad;

    @OneToMany(mappedBy = "garaje", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehiculo> vehiculos = new ArrayList<>();

    // Constructor vacío (requerido por JPA)
    public Garaje() {}

    // Constructor con parámetros
    public Garaje(String direccion, String nombre, int capacidad) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    // Métodos auxiliares para gestionar la relación bidireccional
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        vehiculo.setGaraje(this);  // Establece la relación con el garaje
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
        vehiculo.setGaraje(null);  // Elimina la relación con el garaje
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                ", vehiculos=" + vehiculos.size() +
                '}';
    }
}

