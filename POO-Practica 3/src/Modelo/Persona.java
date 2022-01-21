package Modelo;

import java.util.ArrayList;

public class Persona {

    private String nombre;
    private String direccion;
    private String telefono;

    private ArrayList<Mascotas> listaMascota;

    public Persona(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;

        this.listaMascota=new ArrayList<>();

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Mascotas> getListaMascota() {
        return listaMascota;
    }

    public void setListaMascota(ArrayList<Mascotas> listaMascota) {
        this.listaMascota = listaMascota;
    }
}
