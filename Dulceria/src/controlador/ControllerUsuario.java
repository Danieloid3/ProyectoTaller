
package controlador;

import Utils.AppLogger;
import conexion.Conexion;
import modelo.UsuarioModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerUsuario {

    //metodo para iniciar sesion

    public boolean iniciarSesion(UsuarioModel objeto) {

        boolean respuesta = false;

        Connection connection = Conexion.conexionDB();
        String sql = "select * from tb_usuario where usuario = '" + objeto.getUsuario() + "' and password = '" + objeto.getPassword() + "'";

        Statement statement;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            AppLogger.getLogger().info("Error al iniciar sesion: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
        }

        return respuesta;
    }
}
