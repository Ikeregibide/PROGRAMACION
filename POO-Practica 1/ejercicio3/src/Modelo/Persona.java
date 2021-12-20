package Modelo;

import java.time.LocalDate;

public class Persona {

    private String nombre;
    private String direccion;
    private String codigoPostal;
    private String ciudad;
    private LocalDate fecha;

    public Persona(String nombre, String direccion, String codigoPostal, String ciudad,LocalDate fecha) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.fecha = fecha;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFecha(){
        return fecha;
    }

    public void setFecha(){
        this.fecha = fecha;
    }

}