package Modelo;

public class Mascotas {

    private String raza;
    private String nombre;
    private String fechaN;
    private String sexo;
    private String peso;
    private String longitud;
    private String color;

    private Cliente dueño;
    private Veterinario v;

    public Mascotas(String raza, String nombre, String fechaN, String sexo, String peso, String longitud,String color) {
        this.raza = raza;
        this.nombre = nombre;
        this.fechaN = fechaN;
        this.sexo = sexo;
        this.peso = peso;
        this.longitud = longitud;
        this.color=color;
    }

    public Mascotas() {
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Cliente getDueño() {
        return dueño;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    public Veterinario getV() {
        return v;
    }

    public void setV(Veterinario v) {
        this.v = v;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


