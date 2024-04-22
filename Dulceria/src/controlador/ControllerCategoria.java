package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.CategoriaModel;

public class ControllerCategoria {

    public boolean Guardar(CategoriaModel objeto) {

        boolean respuesta = false;

        Connection connection = Conexion.conexionDB();

        try {

            PreparedStatement consulta = connection.prepareStatement("insert into tb_categoria values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar datos: " + e);
        }

        return respuesta;
    }

    public boolean CategoriaExistente(String categoria) {

        boolean respuesta = false;
        String sql = "select descripcion from tb_categoria where descripcion = '"+ categoria +"';";
        Statement statement;

        try {

            Connection connection = Conexion.conexionDB();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
            respuesta = true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar datos: " + e);
        }

        return respuesta;
    }

}
