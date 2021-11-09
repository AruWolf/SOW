package sow.mvc.vista;

import javax.swing.JOptionPane;

/**
 * Clase utilizada para imprimir el recordatorio una vez pasado el tiempo.
 */
public class Recordatorios extends Throwable {

    public static void tiempo(String tiempo) {
        JOptionPane.showMessageDialog(null, "¡Hey! " + tiempo,
                "¡Recordatorio!", JOptionPane.INFORMATION_MESSAGE);
    }

}
