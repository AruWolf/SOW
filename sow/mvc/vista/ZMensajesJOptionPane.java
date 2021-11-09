package sow.mvc.vista;

import javax.swing.JOptionPane;

/**
 * Se modifica el método de JOptionPane para imprimir un mensaje personalizado
 * en la pantalla
 */
public class ZMensajesJOptionPane {

    static void getMensajeError(String error) {
        JOptionPane.showMessageDialog(null, "Ocurrio una excepción: " + error, 
                "Información", JOptionPane.ERROR_MESSAGE);
    }

    static void getMensajeEjecucionCorrecta(String mensaje) {
        JOptionPane.showMessageDialog(null, "¡Exito! " + mensaje,
                "Acción realizada satisfactoriamente", JOptionPane.INFORMATION_MESSAGE);
    }

    static int getRespuestaUsuario() {
        //JOptionPane.showConfirmDialog(null, "¿Quiere registrar sus emociones?", "Atención", 0);
        int s = JOptionPane.showConfirmDialog(null, "¿Quiere registrar sus emociones?", "Atención", 0);
        return s;
    }

    static String[] getRecordatorios() {
        
        String[] salida = new String[3];
        
        salida[0] = JOptionPane.showInputDialog("Ingersar recordatorio: ");
        salida[1] = JOptionPane.showInputDialog("Ingrese (en valor numerico, ej: 20) \n que desee recibir su recordatorio ");
        
        return salida;
    }
    
}
