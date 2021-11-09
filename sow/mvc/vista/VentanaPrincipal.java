package sow.mvc.vista;

import java.util.List;
import javax.swing.JTable;
import sow.mvc.controlador.ControladorVentanaPrincipal;

/**
 * Interfaz que se encarga de definir los métodos que debe contener el JFrame.
 */
public interface VentanaPrincipal {
    
    /*** único sobreviviente de la antigua lógica.*/
    static final String CONSULTAS_BOX = "Consultar";
    
    /*
    //Debido a lo poco estético que tienen los botones, se ha cambiado la
    //lógica pensada en un primer momento respecto a los setActionCommand() de
    //los botones de la vista.
    //Ahora se hace por medio de MouseListener y JLabels.
    //Se guarda con la esperanza de aprender a utilizar CSS para mejorar el 
    //aspecto visual de un botón de Swing
    static final String GUARDAR = "Guardar";
    static final String ACTUALIZAR_NOTA = "Actualizar";
    static final String CANCELAR_CAMBIOS = "CancelarCambios";
    static final String REGISTRO_EMOCION = "RegistrarEmocion";
    static final String INVOCAR_AYUDANTE = "InvocarAyudante";
    
    static final String ABRIR_NOTA = "abrirNota";
    static final String BORRAR_NOTA = "borrarNota";
    */
    
    /**
     * Aquí se pasan los ActionListeners y los MouseListener que se desea 
     * controlar desde el controlador.
     * @param c 
     * Evento que se envía al (c)ontrolador.
     */
    void setControlador(ControladorVentanaPrincipal c);
    
    /**
     * Inicia la vista.
     */
    void iniciaVista();

    /**
     * Recibe el string que se desea poner dentro de un JOptionPanel.
     * @param error 
     * String con el tipo de error producido.
     */
    void error(String error);
    
    /**
     * Si algo sale satisfactoriamente y se desea imprimir un mensaje se 
     * puede utilizar este metodo y pasar como parametro el mensaje que se 
     * desea pasar por medio de un JOptionPanel.
     * @param mensaje 
     * String con el contenido del mensaje a imprimir en pantalla.
     */
    void ejecucionCorrecta(String mensaje);
    
    /**
     * Se le pregunta al usuario si desea registrar emocion
     * @return 
     * 0 en caso positivo. 1 en caso negativo
     */
    int deseaGuardarEmociones();

    /**
     * Te lleva directo a la primera pestaña (Notas)
     */
    public void irALaNota();
    
//------------------------------------------------------------------------------
//--------------------------GETTER Y SETTERS------------------------------------
//------------------------------------------------------------------------------

    /**
     *
     * @return
     */

    String getJTextTitulo();
    
    /**
     *
     * @param titulo
     */
    public void setJTextTitulo(String titulo);
    
    /**
     *
     * @return
     */
    String getCuerpoNotaTextArea();

    /**
     *
     * @param cuerpoNota
     */
    public void setCuerpoNotaTextArea(String cuerpoNota);
    
    /**
     *
     * @return
     */
    String getConsultaJComboBox();
    
    /**
     *
     * @param horas
     * @param minutos
     * @param segundos
     */
    void imprimeTiempoActivo(int horas, int minutos, int segundos);
    
    /**
     *
     * @param cantidadDeCaracteres
     */
    void imprimerCaracteres(int cantidadDeCaracteres);

    /**
     *
     * @return
     */
    public JTable getGrilla();
    
    /**
     *
     * @return
     */
    public String getTiempoActivo();
    
    /**
     *
     * @param tiempoActivo
     */
    public void setTiempoActivo(String tiempoActivo);
    
    /**
     *
     * @return
     */
    public String getTemporalLabelCuerpo();
    
    /**
     *
     * @param temporalLabelCuerpo
     */
    public void setTemporalLabelCuerpo(String temporalLabelCuerpo);

    /**
     *
     * @return
     */
    public String getTemporalLabelTitulo();

    /**
     * Usado para borrar el tip que se da al iniciar SOW
     * @param temporalLabelTitulo 
     * Se recomienda pasar como parámetro "".
     */
    public void setTemporalLabelTitulo(String temporalLabelTitulo);

    /**
     * Encargado de llamar a la vista que registrará los recordatorios.
     * @return 
     * String[0] contiene el recordatorio
     * String[1] contiene el tiempoInt.
     */
    public String[] recordatorios();
    
}
