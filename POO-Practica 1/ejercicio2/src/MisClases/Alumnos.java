package MisClases;

public class Alumnos {

    private String codigo;
    private String nombre;
    private String domicilio;
    private String telefono;

    public Alumnos() {
    }

    public Alumnos(String codigo, String nombre, String domicilio, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public String setCodigo(String codigo) {
        this.codigo = codigo;
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Alumnos{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
