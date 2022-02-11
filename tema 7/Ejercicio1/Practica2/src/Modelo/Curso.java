package Modelo;

import java.util.ArrayList;

public class Curso {

    private String codigo;

    private ArrayList<Persona> ListaAlumnos;

    public Curso() {
    }

    public Curso(String codigo) {
        this.codigo = codigo;

        this.ListaAlumnos=new ArrayList<>();

    }

    public String getCurso() {
        return codigo;
    }

    public void setCurso(String curso) {
        this.codigo = curso;
    }


}
