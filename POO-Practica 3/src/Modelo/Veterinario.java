package Modelo;

public class Veterinario extends Persona{

        private String dni;
        private String numeroSS;

    public Veterinario() {
    }

    public Veterinario(String nombre, String direccion, String telefono, String dni, String numeroSS) {
        super(nombre, direccion, telefono);
        this.dni = dni;
        this.numeroSS = numeroSS;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }
}
