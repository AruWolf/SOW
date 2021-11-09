package sow.mvc.controlador;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import sow.mvc.modelo.ModeloRegistroDeEmociones;
import sow.mvc.vista.RegistroDeEmociones;

/**
 * Define la VISTA y el MODELO en su tipo (RegistroDeEmociones y ModeloRegistro
 * DeEmociones).
 */
public abstract class ControladorEmociones implements ActionListener, KeyListener{
    protected RegistroDeEmociones VISTA = null;
    protected ModeloRegistroDeEmociones MODELO = null;
}
