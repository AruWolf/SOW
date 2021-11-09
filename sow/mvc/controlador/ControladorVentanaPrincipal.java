package sow.mvc.controlador;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import sow.mvc.modelo.ModeloVentanaPrincipal;
import sow.mvc.vista.VentanaPrincipal;

/**
 * Define la VISTA y el MODELO en su tipo (Tipo VentanaPrincipal y ModeoVentanaPrincipal).
 */
public abstract class ControladorVentanaPrincipal extends MouseAdapter implements ActionListener, KeyListener{
    protected VentanaPrincipal VISTA = null;
    protected ModeloVentanaPrincipal MODELO = null;
}
