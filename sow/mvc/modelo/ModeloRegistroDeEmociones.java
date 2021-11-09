package sow.mvc.modelo;

import java.util.Date;
import sow.dao.AmbienteDAO;
import sow.dao.factory.DAOFactory;
import sow.dto.AmbientePOJO;

/**
 * Clase que presenta el Modelo (contiene getter y setter de la vista) y que
 * participa en la lógica que la vista necesita para poder almacenar e incluso
 * modificar su vista en base a los eventos de la vista.
 * 
 * Esta clase es puente directo al CRUD de la BBDD.
 */
public class ModeloRegistroDeEmociones {

    private String ambienteDe;
    private String estadoAnimico;
    private String distractores;
    private String benefactores;
    private AmbienteDAO sqlAmbiente;
    private final DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.SQLSpy);

    /**
     * Se encarga de consultar en la BBDD el ID correspondiente a un ambiente.
     * @return 
     * El número del id correspondiente.
     */
    public int consultarId() {
        sqlAmbiente = dao.getAmbienteDAO();
        return sqlAmbiente.maxId()+1;
    }

    /**
     * (AmbienteDAO)Consulta en la BBDD si existe fecha de creación.
     * Nota: Para que este método funcione primero se debe setear en el modelo
     * el ambienteDe.
     * @return 
     * true o false según lo hallado en la BBDD.
     */
    public boolean noTieneFechaDeCreacion() {
        sqlAmbiente = dao.getAmbienteDAO();
        return sqlAmbiente.noTieneFechaDeCreacion(ambienteDe);
    }

    /**
     * (AmbienteDAO) Consulta en la BBDD la fecha de creación.
     * Nota: Para que este método funcione primero se debe setear en el modelo
     * el ambienteDe.
     * @return 
     * Fecha de creación de una nota.
     */
    public Date getDateCreacion2() {
        sqlAmbiente = dao.getAmbienteDAO();
        return sqlAmbiente.fechaDeCreacionDe(ambienteDe);
    }

//------------------------------------------------------------------------------    
//--------------------------GETTERS Y SETTERS-----------------------------------
//------------------------------------------------------------------------------

    /**
     *
     * @return
     */
    
    public String getAmbienteDe() {
        return ambienteDe;
    }

    /**
     *
     * @param ambienteDe
     */
    public void setAmbienteDe(String ambienteDe) {
        this.ambienteDe = ambienteDe;
    }
    
    /**
     *
     * @return
     */
    public String getEstadoAnimico() {
        return estadoAnimico;
    }

    /**
     *
     * @param estadoAnimico
     */
    public void setEstadoAnimico(String estadoAnimico) {
        this.estadoAnimico = estadoAnimico;
    }

    /**
     *
     * @return
     */
    public String getDistractores() {
        return distractores;
    }

    /**
     *
     * @param distractores
     */
    public void setDistractores(String distractores) {
        this.distractores = distractores;
    }

    /**
     *
     * @return
     */
    public String getBenefactores() {
        return benefactores;
    }

    /**
     *
     * @param benefactores
     */
    public void setBenefactores(String benefactores) {
        this.benefactores = benefactores;
    }
    
    /**
     *
     * @param ambiente
     */
    public void guardarAmbientePOJO(AmbientePOJO ambiente){
        sqlAmbiente = dao.getAmbienteDAO();
        sqlAmbiente.crearNuevoAmbiente(ambiente);
    }
}
