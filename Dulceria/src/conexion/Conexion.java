package conexion;

import Utils.AppLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Conexion() {
    }

    //Metodo conexion local a la base de datos
    public static Connection conexionDB() {

        try {

            //en el ultimo param cambiar la contraseña por la que hayan configurado al instalar mysql
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bd_inventario_dulceria", "root", "519941dave");
            return connection;

        } catch (SQLException e) {
            AppLogger.getLogger().info("Error al conectar a la base de datos: " + e.getMessage());
        }

        return null;
    }

}
