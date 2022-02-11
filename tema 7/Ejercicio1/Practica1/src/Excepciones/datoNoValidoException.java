package Excepciones;

public class datoNoValidoException extends Exception{

    public datoNoValidoException(String mensaje)
    {
        super(mensaje);
    }
}
