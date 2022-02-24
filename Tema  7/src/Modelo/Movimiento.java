package Modelo;

public class Movimiento {

    private String descripcion;
    private double importe;
    private String fecha;

    public Movimiento(String descripcion, double importe, String fecha) {
        this.descripcion = descripcion;
        this.importe = importe;
        this.fecha = fecha;
    }

    public Movimiento() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "descripcion='" + descripcion + '\'' +
                ", importe='" + importe + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
