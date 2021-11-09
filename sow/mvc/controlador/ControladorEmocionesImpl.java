package sow.mvc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import sow.dto.AmbientePOJO;
import sow.mvc.modelo.ModeloRegistroDeEmociones;
import sow.mvc.vista.RegistroDeEmociones;

/**
 * Clase encargada de interactuar con la vista y definir la lógica del 
 * negocio en base a los eventos invocados.
 */
public class ControladorEmocionesImpl extends ControladorEmociones{

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
    public ControladorEmocionesImpl(RegistroDeEmociones vista, ModeloRegistroDeEmociones modelo) {
        MODELO = modelo;
        VISTA = vista;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            switch (e.getActionCommand()){
                case RegistroDeEmociones.GUARDAR_AMBIENTE:
                    logicaCaseGuardarAmbiente();
                    break;
            }
        }catch (Exception ex){
            VISTA.error("Componente inválido: " + ex.toString());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Este método privado se encarga de toda la logica del guardado de un
     * ambiente.
     */
    private void logicaCaseGuardarAmbiente() {
        //Estos datos se obtienen desde la vista
        String estadoAnimico = VISTA.getEstadoAnimicoJText();
        String distractores = VISTA.getDistractoresJText();
        String benefactores = VISTA.getBenefactoresJText();
        
        //Hay que consultar al MODELO de la anterior vista
        int idNota = MODELO.consultarId();
        String ambienteDe = MODELO.getAmbienteDe();
        
        //Hay que consultar si es que existe registrada una fecha para la nota
        Date dateCreacion = null;

        if (MODELO.noTieneFechaDeCreacion() == true){
            dateCreacion = new Date(System.currentTimeMillis());    
        } else{
            dateCreacion = MODELO.getDateCreacion2();
        }
        
        //Siempre se ejecuta al agregar un nuevo ambiente
        Date dateModificacion = new Date(System.currentTimeMillis());
        
        if(!(estadoAnimico.isEmpty() || distractores.isEmpty() || benefactores.isEmpty())){
            AmbientePOJO ambiente = new AmbientePOJO(idNota, ambienteDe, estadoAnimico, distractores, benefactores, dateCreacion, dateModificacion);
            super.MODELO.guardarAmbientePOJO(ambiente);
            VISTA.ejecucionCorrecta(" ¡Has registrado tu emoción!");
            VISTA.setBenefactoresJText("");
            VISTA.setDistractoresJText("");
            VISTA.setEstadoAnimicoJText("");
        }else{
            VISTA.error("Por favor, complete todos los campos");
        }
        
    }
    
}
