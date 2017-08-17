package datos;

/**
 *
 * @author Esmeralda Hdez.
 */
import logica.ControlGastos;

public interface ControlGastoDAO {

    /**
     *
     * Método declarado que permite agregar una nuevo gasto a la base de datos del Sistema.
     * @param controlGastos Objeto de tipo controlGastos de donde se obtienen todos los datos que se
     * registrarán.
   * @return true o false 
     */
    public boolean registrarGastos(ControlGastos controlGastos);

}
