package sow.dao;

import java.util.Date;
import java.util.List;
import sow.dto.AmbientePOJO;

/**
 * Interfaz al estilo CRUD (Create, Read, Update, Delete) 
 */
public interface AmbienteDAO {

    /**
     * Este metodo crea y guarda un ambiente de una nota en la base de datos. 
     * Se debe corroborar de antemano que se encuentren todos los valores 
     * requeridos de un AmbientePOJO
     * @param ambiente 
     * tipo de dato: ambientePOJO, la cual está conformada por los siguientes atributos: 
     * idNota, ambienteDe, estadoAnimico, distractores, benefactores, dateCreacion, dateModificacion
     */
    public void crearNuevoAmbiente(AmbientePOJO ambiente);
    
    /**
     * Este método se encarga de realizar la consulta a la base de datos y
     * ordenar la salida según el parámetro especificado.
     * @param nCase
     * 1 = Listado (AmbientePOJO) según fecha de creación. /// 
     * 2 = Listado (AmbientePOJO) según fecha de modificación. /// 
     * 3 = Listado (AmbientePOJO) según emoción.
     * @return 
     * List (AmbientePOJO): Listado con indice [0]idAmbiente, [1]ambientesDe, 
     * [2]estadoAnimico, [3]distractores, [4]benefactores, [5]creación(Date), [6]modificación(Date).
     */    
    public List<AmbientePOJO> listarNotas(int nCase);

    /**
     * Actualiza en la base de datos: estado animico, benefactores y 
     * distractores. Aún así, se pide el ambiente completo. pudiendose pasar 
     * como nulo los valores que no se cargarán en la BBDD.
     * @param ambiente 
     * Se necesitan el contenido de estado animico, benefactores y distractores
     * de un ambiente, es lo único que se permite actualizar.
     */
    public void actualizarAmbiente(AmbientePOJO ambiente);
    
    /**
     * Borra de la base de datos todos los datos contenidos en un ambiente.
     * @param ambientesDe
     * El padre del ambiente, es decir, el título de la nota a la cual pertenece
     * este ambiente.
     */    
    public void borrarNota(String ambientesDe);       
    
    /**
     * Método que se encarga de obtener el último id del ambiente.
     * @return 
     * El índice (id) más alto contenida en la base de datos respecto al ambiente.
     */
    public int maxId();

    /**
     * Determina si existe una fecha de creación de un ambiente
     * @param ambienteDe
     * Título de la nota que crea el ambiente.
     * @return 
     * false: si es que no hubo un anterior ambiente.   ///
     * true: Si es que existe una fecha de creación perteneciente a otro ambiente
     * de la misma nota.
     */
    public boolean noTieneFechaDeCreacion(String ambienteDe);

    /**
     * Permite tener la fecha de creación de una nota (respecto a su ambiente).
     * @param ambienteDe
     * Título de la nota que crea los ambientes.
     * @return 
     */
    public Date fechaDeCreacionDe(String ambienteDe);

    /**
     * Devuelve el número del tipo de consulta a hacer en listarNotas(int nCase).
     * @param segun
     * String que contiene el actionCommand.
     * @return 
     * El número del case necesario para listarNotas(int nCase).
     * @deprecated 
     * Utilizado para tener el tipo de consulta a realizar aunque no logró ser
     * implementada adecuadamente según lo esperado.
     */
    public int getCase(String segun);

}