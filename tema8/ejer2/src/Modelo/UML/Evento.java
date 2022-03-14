package Modelo.UML;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {

    private String nombre;
    private String lugar;
    private LocalDate fecha;
    private LocalTime hInicio;
    private LocalTime hFin;
    private int numP;

    public Evento(String nombre, String lugar, LocalDate fecha, LocalTime hInicio, LocalTime hFin, int numP) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hInicio = hInicio;
        this.hFin = hFin;
        this.numP = numP;
    }

    public Evento(String n, String l, java.util.Date fecha, LocalTime horaI, LocalTime horaF, int numP) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime gethInicio() {
        return hInicio;
    }

    public void sethInicio(LocalTime hInicio) {
        this.hInicio = hInicio;
    }

    public LocalTime gethFin() {
        return hFin;
    }

    public void sethFin(LocalTime hFin) {
        this.hFin = hFin;
    }

    public int getNumP() {
        return numP;
    }

    public void setNumP(int numP) {
        this.numP = numP;
    }
}
