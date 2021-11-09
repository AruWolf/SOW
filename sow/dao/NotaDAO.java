package sow.dao;

import java.util.List;
import sow.dto.NotaPOJO;

/**
 * Interfaz al estilo CRUD (Create, Read, Update, Delete).
 */
public interface NotaDAO {
    
    /**
     * Este metodo crea y guarda una nota, se debe corroborar que no exista una
     * nota con el mismo nombre debido a que obtendría un SQLException. 
     * @param nota 
     * tipo de dato: NotaPOJO, la cual está conformada por los siguientes
     * atributos: título nota, cantidad de caracteres, tiempo activo.
     */
    public void crearNuevaNota(NotaPOJO nota);
    
    /**
     * Este método se encarga de realizar la consulta a la base de datos y
     * ordenar la salida según el parámetro especificado.
     * @param nCase
     * 1 = Listado (NotaPOJO) según el título (de la A - Z). /// 
     * 2 = Listado (NotaPOJO) según la nota con mayor cantidad de caracteres. /// 
     * 3 = Listado (NotaPOJO) según la nota con mayor tiempo activo. /// 
     * @return 
     * List (NotaPOJO): Listado con indice [0]título, [1]nota, [2]caracteres, [3]tiempoActivo.
     */
    public List<NotaPOJO> listarNotas(int nCase);

    /**
     * Método que se encarga de consultar en la base de datos el título.
     * @param titulo
     * Debe coincidir exáctamente con el título contenida en la base de datos si es que existe.
     * @return 
     * tituloAndNota[0] = titulo;   ///   
     * tituloAndNota[1] = nota;   ///   
     * tituloAndNota[2] = tiempoActivo;
     */
    public String[] buscarNota(String titulo);
    
    /**
     * Realiza un UPDATE de la nota, reescribiendo en la base de datos
     * los datos contenidos de la nota, el tiempo activo y la cantidad de caracteres.
     * @param nota 
     * tipo de dato: NotaPOJO, la cual está conformada por los siguientes
     * atributos: título nota, cantidad de caracteres, tiempo activo.
     */
    public void actualizarNotaCreadaAnteriormente(NotaPOJO nota);

    /**
     * Borra de la base de datos los datos contenidos en una nota
     * @param titulo 
     * Nombre del titulo de la nota a borrar (String).
     */
    public void borrarNota(String titulo);    
    
    /**Devuelve el número del tipo de consulta que se quiere realizar
     * @return 
     * El número del case de la consulta de listarNota(int nCase).
     * @param actionComand Se refiere al tipo de consulta se quiere, "según..."
     * @deprecated 
     * Utilizado para tener el tipo de consulta a realizar aunque no logró ser
     * implementada adecuadamente según lo esperado.
     */
    public int getCase(String actionComand);
    
    /**
     * Método encargado de responder la existencia de un titulo
     * @param titulo
     * Nombre de la nota a consultar en la base de datos.
     * @return 
     * true: si existe un titulo según el parametro pasado.
     * false: en caso de no encontrar nota con el paramentro.
     */
    public boolean existTitulo(String titulo);
}
