package Modelo.BD;

import Modelo.UML.Evento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;

public class EventoDAO {

    private Connection con;

    public EventoDAO(Connection con){
        this.con=con;
    }

    public void registrarEvento(Evento e) throws Exception{

        String platilla = "INSERT INTO evento VALUES (?,?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(platilla);
        ps.setString(1,e.getNombre());
        ps.setString(2,e.getLugar());
        ps.setDate(3, Date.valueOf(e.getFecha()));
        ps.setTime(4, Time.valueOf(e.gethInicio()));
        ps.setTime(5, Time.valueOf(e.gethFin()));
        ps.setInt(6, e.getNumP());
        int n= ps.executeUpdate();

        if (n!=1)
            throw new Exception("El numero de filas actualizadas no es uno");


    }
}
