package Modelo.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDatos {

    private String login = "root";
    private String password = "usbw";
    private String url = "jdbc:mysql://localhost:3306/p1ejer2";

    private Connection connection;

    public BaseDatos() throws Exception{
    Class.forName("com.mysql.cj.jdbc.Driver");
    connection= DriverManager.getConnection(url,login,password);

    if (connection==null){
        throw new Exception("Problemas con la conexion");
    }
}

    public Connection getConnection() {
        return connection;
    }

    public void Desconectar() throws Exception{
    connection.close();
    }
}
