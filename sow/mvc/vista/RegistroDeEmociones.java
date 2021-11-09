package sow.mvc.vista;

import sow.mvc.controlador.ControladorEmociones;

/**
 * Interfaz que se encarga de definir los métodos que debe contener el JFrame.
*/
public interface RegistroDeEmociones{
    
    /** Correspondiente al setActionCommand */
    static final String GUARDAR_AMBIENTE = "guardarAmbiente";
    
    /**
     * Se debe setear un controlador para cada Vista.
     * @param c 
     */
    void setControlador(ControladorEmociones c);

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

//------------------------------------------------------------------------------
//------------------------------GETTERS-----------------------------------------
//------------------------------------------------------------------------------

    /**
     *
     * @return
     * El estado animico hallado en el JTextField
     */
    String getEstadoAnimicoJText();
    
    
    void setEstadoAnimicoJText(String string);
    
    /**
     *
     * @return
     * La distracción del JTextField
     */
    String getDistractoresJText();
    
    void setDistractoresJText(String string);
    
    /**
     *
     * @return
     * El benefactor del JTField
     */
    String getBenefactoresJText();    
    
    void setBenefactoresJText(String string);
    
    
}
