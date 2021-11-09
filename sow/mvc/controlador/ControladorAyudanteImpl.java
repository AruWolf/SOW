package sow.mvc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import sow.mvc.modelo.ModeloAyudante;
import sow.mvc.vista.Ayudante;

/**
 * Clase encargada de interactuar con la vista y definir la lógica del 
 * negocio en base a los eventos invocados.
 */
public class ControladorAyudanteImpl extends ControladorAyudante{

    /**
     * El constructor permite para cada evento manejar el Modelo que se ha 
     * creado para resolver cada una de las acciones invocadas y actualizar la vista.
     * @param vista
     * Proveniente de la interfaz de algún tipo de JFrame que permita obtener 
     * los métodos get y set de la vista para lograr actualizarla.
     * @param modelo 
     * La interfaz de un modelo que brinde conocimiento de los métodos que 
     * sustentan la vista y permita separar la lógica de negocio de los eventos.
     */
    public ControladorAyudanteImpl(Ayudante vista, ModeloAyudante modelo){
        VISTA = vista;
        MODELO = modelo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
