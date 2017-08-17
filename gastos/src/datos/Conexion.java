package datos;

import java.sql.*;
import GUI.Dialogo;

/**
 * Conexión entre el programa y la base de datos del Sistema.
 */
public class Conexion {

    private Connection conexion;
    private String username;
    private String password;
    private static Conexion connect;

    /**
     * Conexión con la base de datos
     */
    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            username = "personal_gastos";
            password = "#8/Ye7#";
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/gastos", username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Dialogo dialogo = new Dialogo();
            dialogo.alertaError();
        }
    }

    /**
     * Bloque de Getters y Setters de la clase.
     */
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Función que abre la conexión con la base de datos del Sistema.
     *
     */
    public Connection connection() {
        try {
            return conexion;
        } finally {
        }
    }

    /**
     * Cierre de la conexión con la base de datos.
     */
    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            Dialogo dialogo = new Dialogo();
            dialogo.alertaError();
        }
    }

    public static Conexion getConnect() {
        return connect;
    }

    public static void setConnect(Conexion conexion) {
        Conexion.connect = conexion;
    }
}