package GUI.controladores;

import GUI.Dialogo;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logica.ControlGastos;

/**
 * FXML Controller class
 *
 * @author marianacro
 * @author Esmeralda Hdez.
 */
public class RegistrarGastosController implements Initializable {

  @FXML Label fecha;
  @FXML TextField nombreTF;
  @FXML TextField precioTF;
  @FXML TextField cantidadTF;
  @FXML Button registrarGasto; 
  @FXML Button nuevoGasto;
  @FXML Button regresarPrincipal;


  
    /**
     * Método que inicializa la escena de Registrar y todos los componentes.
     * @param url URL del incializador
     * @param rb ResourceBundel de inicializador
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ControlGastos controlGastos = new ControlGastos();
      habilitarBotonRegistrar();
    }
    
    /**
     * método para registrar los gastos realizados por el usuario.
     */
    @FXML
    public void guardarGasto() {
      ControlGastos controlGastos = new ControlGastos();
      Dialogo dialogo = new Dialogo();
      
      try {
        //Comprobación de campos vacíos.
        if (nombreTF.getText().trim().isEmpty()) {
          throw new NullPointerException();
        }
        if (precioTF.getText().trim().isEmpty()) {
          throw new NullPointerException();
        }
        if (cantidadTF.getText().trim().isEmpty()) {
          throw new NullPointerException();
        }
        
        controlGastos.setNombreArt(nombreTF.getText());
        controlGastos.setPrecio(Double.parseDouble(precioTF.getText()));
        //controlGastos.setFecha();
        
       
        controlGastos.registrarGastos(controlGastos);
        
      /*  if (controlGastos.registrarGastos(controlGastos)) {
           dialogo.alertaRegistrada();
           habilitarBotonRegistrar();
        } else {
          dialogo.alertaError();
        }*/
     } catch (NullPointerException e) {
        Dialogo mensaje = new Dialogo();
        //mensaje.alertaCamposVacios();
      } 
    }
    
    /**
     * método para habilitar el botón de registrar gasto.
     */
    private void habilitarBotonRegistrar() {
      ControlGastos controlGastos = new ControlGastos();
      registrarGasto.setDisable(false);
    }
    
    @FXML
    private void regresar(ActionEvent regresar) throws IOException {
      Stage stage;
      Parent root;
      if(regresar.getSource()== regresarPrincipal){
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/GUI/GUIGastos.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Control de Gastos");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage=(Stage)regresarPrincipal.getScene().getWindow();
        stage.close();
      } else {
        stage=(Stage)regresarPrincipal.getScene().getWindow();
        stage.close();
      }
    }
    
    /**
     * metodo para insertar un nuevo articulo
     * @param event al presionar el boton nuevo reaccionará
     */
  @FXML
  private void nuevo(ActionEvent e) {
    nombreTF.setText("");
    cantidadTF.setText("");
    precioTF.setText("");
    nuevoGasto.setDisable(false);
    regresarPrincipal.setDisable(false);
    registrarGasto.setDisable(false);
  }

    
}
