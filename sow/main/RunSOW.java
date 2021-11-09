package sow.main;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import sow.mvc.controlador.ControladorVentanaPrincipal;
import sow.mvc.controlador.ControladorVentanaPrincipalImpl;
import sow.mvc.modelo.ModeloVentanaPrincipal;
import sow.mvc.vista.VentanaPrincipalJFrame;
import sow.mvc.vista.VentanaPrincipal;
import sow.mvc.vista.Recordatorios;
//branch c2
/**
 * Inicia la ventana principal.
 */
public class RunSOW {
    
    private Date ahora; //Para sobrescribir 
    private Date esperado; //Setear el tiempo esperado

    /**
     * Main
     *
     * @param args
     */
    public static void main(String args[]) {
        runSOW();
    }

    private static void runSOW() {
        ModeloVentanaPrincipal modelo = new ModeloVentanaPrincipal();

        VentanaPrincipal vista = new VentanaPrincipalJFrame();

        ControladorVentanaPrincipal control = new ControladorVentanaPrincipalImpl(vista, modelo);

        vista.setControlador(control);

        vista.iniciaVista();
    }

    /**
     * Método encargado de pasar al usuario (luego de un tiempo especificado) el
     * mensaje que este haya enviado en un string.
     * @param mensaje
     * El mensaje corresponde al recordatorio esperado.
     * @param tiempo
     * El tiempo corresponde a la cantidad (en segundos) en el que desea
     * recibir la notificacion
     * @throws Recordatorios 
     * Una vez cumplido para detener la ejecución se lanza una excepcion
     * personalizada que le avisa al usuario su recordatorio en el momento 
     * indicado. 
     */
    public void recordatorio(String mensaje, long tiempo) throws Recordatorios {
        
        ahora = new Date(System.currentTimeMillis());
        esperado = new Date(System.currentTimeMillis()+(1000*tiempo));
        
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        
        Runnable task1 = () -> {
                if(ahora.getTime() > esperado.getTime()){
                    try{
                        service.shutdownNow();
                        throw new Recordatorios();
                    }catch (Recordatorios ex){Recordatorios.tiempo("\nSe ha cumplido el tiempo para: ".concat(mensaje));}
                }else{
                    ahora = new Date (System.currentTimeMillis());
                }};
        service.scheduleAtFixedRate(task1, 2, 2, TimeUnit.SECONDS);

    }

}
