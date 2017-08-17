/**
 * Nombre del programa: Control de Gastos
 * Autores:
 *          Hernández González Esmeralda Yamileth
 *          Cadena Romero mariana
 * Fecha de inicio del desarrollo: 15 de Agosto de 2017
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controladores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gastos extends Application {
  
  
    /**
     * Método sobreescrito que permite cargar la escena principal. Es la primera escena que se carga
     * al iniciar el programa.
     *
     * @param stage Primer Stage del programa.
   * @throws java.lang.Exception
     */
   
  @Override
  public void start(Stage stage) throws Exception {
    Parent pane = FXMLLoader.load(getClass().getResource("/GUI/GUIGastos.fxml"));
    
    Scene scene = new Scene(pane);
    
    stage.setTitle("Control de Gastos");
    stage.setScene(scene);
    stage.show();    
  }
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}
