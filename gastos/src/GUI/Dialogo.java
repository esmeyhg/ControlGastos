package GUI;

import javafx.scene.control.Alert;

/**
 * Clase que contiene los métodos que muestran alertas en pantalla.
 */
public class Dialogo {

    /**
     * Método que muestra una alerta de error de conexión en pantalla.
     */
    public void alertaCerrarConexion() {
        Alert alertaUsuario = new Alert(Alert.AlertType.ERROR);
        alertaUsuario.setTitle("Error");
        alertaUsuario.setHeaderText("Error inesperado");
        alertaUsuario.setContentText("Ha ocurrido un error al cerrar las conexiones con la base "
            + "de datos, contacte a un programador del Sistema");
        alertaUsuario.showAndWait();
    }

    /**
     *
     * Método que muestra una alerta de error en pantalla.
     */
    public void alertaError() {
        Alert alertaUsuario = new Alert(Alert.AlertType.ERROR);
        alertaUsuario.setTitle("Error");
        alertaUsuario.setHeaderText("Error inesperado");
        alertaUsuario.setContentText("Ha ocurrido un error inesperado, consulte "
            + "al programador del Sistema");
        alertaUsuario.showAndWait();
    }

    /**
     *
     * Método que muestra una alerta de precaución que informa que existen campos sin llenar en los
     * formularios.
     */
    public void alertaCamposVacios() {
        Alert alertaCampos = new Alert(Alert.AlertType.WARNING);
        alertaCampos.setTitle("Campos incompletos");
        alertaCampos.setHeaderText("Alerta");
        alertaCampos.setContentText("Por favor completa todos los campos");
        alertaCampos.showAndWait();
    }

    /**
     * Método que muestra una alerta que informa que el registro de gastos se realizó
     * exitosamente.
     */
    public void alertaRegistrada() {
        Alert alertaUsuario = new Alert(Alert.AlertType.INFORMATION);
        alertaUsuario.setTitle("¡Registro exitoso!");
        alertaUsuario.setHeaderText("Alerta");
        alertaUsuario.setContentText("El registro se realizó exitosamente");
        alertaUsuario.showAndWait();
    }
}
