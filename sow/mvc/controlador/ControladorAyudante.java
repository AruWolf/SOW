package sow.mvc.controlador;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import sow.mvc.modelo.ModeloAyudante;
import sow.mvc.vista.Ayudante;

/**
 * Define la VISTA y el MODELO en su tipo (Tipo Ayudante y ModeloAyudante).
 */
public abstract class ControladorAyudante implements ActionListener, MouseListener{
    protected Ayudante VISTA = null;
    protected ModeloAyudante MODELO = null;    
}
