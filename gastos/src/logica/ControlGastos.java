package logica;

import datos.ControlGastoDAO;
import datos.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import GUI.Dialogo;
import java.time.LocalDate;
/**
 *
 * @author Esmeralda Hdez.
 */

/**
 * Clase que contiene los métodos necesarios para registrar o buscar gastos.
 */
public class ControlGastos implements ControlGastoDAO {

  /**
   * Atributos de la clase
   */
  private String nombreArticulo;
  private double precio;
  private LocalDate fecha;
 
  /**
   * Permite crear objetos tipo controlGastos.
   */
  public ControlGastos() {}

  /**
   * Constructor completo de la clase
   * @param nombreArticulo nombre del artículo comprado
   * @param fecha fecha en la que se registra el gasto
   * @param precio costo del artículo por pieza
   */
  public ControlGastos(String nombreArticulo, double precio, LocalDate fecha) {
    this.nombreArticulo = nombreArticulo;
    this.fecha = fecha;
    this.precio = precio;
  }
  
  /**
   * Bloque de Getters y Setters de la clase.
   */
  public String getNombreArt() {
    return nombreArticulo;
  }

  public void setNombreArt(String nombreArticulo) {
    this.nombreArticulo = nombreArticulo;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }
  
  /**
   *
   * Método encargado de registrar gastos en la base de datos.
   * @param controlGastos Objeto de tipo controlGastos de donde se obtienen todos los datos.
   * @return Regresa verdadero(true) si el registro de los gastos fue exitoso o falso (false) si
   * ocurrió un error
   */
  @Override
  public boolean registrarGastos(ControlGastos controlGastos) {
    Connection conexion = null;
    PreparedStatement sentencia = null;
    Date fechaSQL = Date.valueOf(controlGastos.getFecha());
    
    try {
      conexion = new Conexion().connection();
      String consultaGastos = "INSERT INTO controlgastos (nombre, precio, fecha) VALUES (?, ?, ?);";
      sentencia = conexion.prepareStatement(consultaGastos);
      sentencia.setString(1, controlGastos.getNombreArt());            
      sentencia.setDouble(2, controlGastos.getPrecio());
      sentencia.setDate(3, fechaSQL);
      sentencia.executeUpdate();
      return true;
    } catch (SQLException ex) {
      Dialogo dialogo = new Dialogo();
      dialogo.alertaError();
    } finally {
      Dialogo dialogo = new Dialogo();
      if (sentencia != null) {
               
        try {
          sentencia.close();               
        } catch (SQLException ex) {
          dialogo.alertaCerrarConexion();         
        }        
      }      
      if (conexion != null) {
        try {
          conexion.close();          
        } catch (SQLException ex) {      
          dialogo.alertaCerrarConexion();         
        }       
      }     
    }   
    return false;
  }
}
