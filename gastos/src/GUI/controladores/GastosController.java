package GUI.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Esmeralda Hdez.
 * @author marianacro
 */
public class GastosController implements Initializable {
  
  @FXML private Button botonObtenerGastos;
  @FXML private Button botonRegistrarGastos;
  //@FXML private Button salir;
  
  /**
   * Abre la ventana para registrar los gastos.
   * @param registrar
   * @throws IOException 
   */
  @FXML
  private void gotoRegistrar(ActionEvent registrar) throws IOException {
    Stage stage;
    Parent root;
    if(registrar.getSource()==botonRegistrarGastos){
      stage = new Stage();
      root = FXMLLoader.load(getClass().getResource("/GUI/GUIRegistrarGastos.fxml"));
      stage.setScene(new Scene(root));
      stage.setTitle("Registrar Gastos");
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.initOwner(botonRegistrarGastos.getScene().getWindow());
      stage.showAndWait();
      stage.close();
    } else {
      stage=(Stage)botonRegistrarGastos.getScene().getWindow();
      stage.close();
    }
  }
   
  /**
   * Abre la ventana para buscar los gastos registrados en la base de datos. 
   * @param buscar
   * @throws IOException 
   */
  @FXML
  private void gotoBuscar(ActionEvent buscar) throws IOException {
    Stage stage;
    Parent root;
    if(buscar.getSource()==botonObtenerGastos){
      stage = new Stage();
      root = FXMLLoader.load(getClass().getResource("/GUI/GUIObtencionGastos.fxml"));
      stage.setScene(new Scene(root));
      stage.setTitle("Busqueda de Gastos");
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.initOwner(botonObtenerGastos.getScene().getWindow());
      stage.showAndWait();
      stage.close();
    } else {
      stage=(Stage)botonObtenerGastos.getScene().getWindow();
      stage.close();
    }
  }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
