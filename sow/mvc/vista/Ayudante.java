package sow.mvc.vista;

import sow.mvc.controlador.ControladorAyudante;

/**
 * Interfaz que contiene los métodos que se deben utilizar para el JFrame.
 */
public interface Ayudante {

    /**
     * Aquí se pasan los ActionListeners y los MouseListener que se desea 
     * controlar desde el controlador.
     * @param control 
     * Evento que se envía al (control)ador.
     */
    public void setControlador(ControladorAyudante control);

    /**
     * Inicia la vista
     */
    public void iniciaVista();
    
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

}
