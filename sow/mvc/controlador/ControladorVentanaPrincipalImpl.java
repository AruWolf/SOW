package sow.mvc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JTable;
import sow.dto.NotaPOJO;
import sow.main.RunSOW;
import sow.mvc.modelo.ModeloVentanaPrincipal;
import sow.mvc.vista.VentanaPrincipal;
import sow.mvc.vista.Recordatorios;

/**
 * Clase encargada de interactuar con la vista y definir la lógica del 
 * negocio en base a los eventos invocados.
 */
public class ControladorVentanaPrincipalImpl extends ControladorVentanaPrincipal {

    //Variables de auxilio para contar el tiempo activo de una nota.
    private Date ahora;
    private Date esperado;
    private int segundos;
    private int minutos;
    private int horas;
    boolean pasoElTiempoEsperado;
    
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
    public ControladorVentanaPrincipalImpl(VentanaPrincipal vista, ModeloVentanaPrincipal modelo) {
        VISTA = vista;
        MODELO = modelo;
    }
    
//  ActionEvent invocados desde ventana Principal
    
    @Override 
    public void mouseClicked(MouseEvent e) {
        //Para borrar el label temporal que indica qué hace cada campo
        if(e.toString().contains("Field")){
            VISTA.setTemporalLabelTitulo("");
        }else if (e.toString().contains("Area")){
            VISTA.setTemporalLabelCuerpo("");
        }
//------------------------------------------------------------------------------        
/* Para poder ver los botones de la intefaz un poco más agradable a la vista
 * se ha recurrido al uso de jlabels, genera mucha dependencia de la imagen
 * es la única solución encontrada en base a mis conocimientos de programación
 * y el tiempo disponible para buscar una solución más estética y mantenible*/
//------------------------------------------------------------------------------        

        if(e.toString().contains("guardarBtn.png")){
            logicaCaseGuardar();
        }else if(e.toString().contains("actualizarNotaBtn.png")){
            logicaCaseActualizar(); 
        }else if(e.toString().contains("revertirCambiosBtn.png")){
            logicaCaseCancelarCambio(1);
        }else if(e.toString().contains("registrarEmocion.png")){
            MODELO.registrarEmocion(VISTA.getJTextTitulo());
        }else if (e.toString().contains("ayudanteBtn.png")){
            MODELO.abrirAyudante(); //su clase se encarga del resto.
        }else if (e.toString().contains("recordatorioBtn.jpg")){
            logicaRecordatorios();
            
//------------------------------------------------------------------------------
//Segundo panel
        }else if(e.toString().contains("abrirNota.png")){
            logicaCaseAbrirNota();
            logicaCaseCancelarCambio(2);//se logra recuperar el tiempoActivo
        }else if(e.toString().contains("borrarNotaBtn.png")){
            logicaCaseBorrarNota();
        }
    }
    
    
    @Override //comboBoxList
    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                    
                case VentanaPrincipal.CONSULTAS_BOX:
                    /*Por la falta de conocimiento, actualmente, en la hora de
                     *implementar este case, estoy cometiendo el error de 
                     *validar el case mediante un string hard coded, lo que
                     *genera una muy alta dependencia de lo que aquí se escriba
                     *siendo así una mala práctica. Se recomienda a futuro 
                     *encontrar forma de poder consultar de forma similar
                     *a como se hacen con los final strings de los botones
                     *con la diferencia que esto se trata de un jComboBox.
                     *08 de ocutbre de 2021 [02:56].
                    */
                    switch (VISTA.getConsultaJComboBox()){
                        case "Listar según título": // Recomendación a futuro: Cambiar por  static final String
                            MODELO.consultaSegun(VISTA.getGrilla(), "Listar según título");
                            break;
                        case "Listar según longitud":
                            MODELO.consultaSegun(VISTA.getGrilla(), "Listar según longitud");
                            break;
                        case "Listar según tiempo activo":
                            MODELO.consultaSegun(VISTA.getGrilla(), "Listar según tiempo activo");
                            break;
                        case "Listar según fecha":
                            MODELO.consultaSegun2(VISTA.getGrilla(), "Listar según fecha");
                            break;
                        case "Listar según modificación":
                            MODELO.consultaSegun2(VISTA.getGrilla(), "Listar según modificación");
                            break;
                        case "Listar según emoción":
                            MODELO.consultaSegun2(VISTA.getGrilla(), "Listar según emoción");
                            break;
                        }
                    
                    break;  
            }
        } catch (Exception ex) {
            VISTA.error(ex.toString());
        }
    }
    
    @Override //Aquí se comienza el metodo que cuenta el tiempoActivo
    public void keyTyped(KeyEvent e) {
        /**
         * La razón por la cual se implementó de la siguiente manera es debido a que utilizar un
         * Thread.Sleep, al ser invocado por un mismo hilo tildaba toda el sistema. El usar 
         * un Timer() elevaba al 40% del uso del CPU. De la forma implementada eso no ocurre y
         * se cuenta con un contado medianamente activo, se recomienda mejorar.
         */
                

        //Se actualiza la hora actual al tipear
        ahora = new Date(System.currentTimeMillis());
        
        /* al precionar tecla se suma un segundo y espera un segundo para determinar si se suma otro */
        if(pasoElTiempoEsperado == false){
            timerTipeo(); //incrementa el tiempo y actualiza correctamente las variables
            ahora = new Date(System.currentTimeMillis());
            esperado = new Date (System.currentTimeMillis()+500);
            pasoElTiempoEsperado = true;
        }else{
            /* 
            Ej.: Fri Oct 08 09:38:01 ART 2021 -> se busca tener la hora, minutos y segs
            Actualizo: 10/10/21[03:05] creo que hay un método "getMinutes, getHour..." 
            Estaría bueno a futuro cambiarlo. Por ahora estoy funciona correcto
            */ 
            String[] primerBloqueAntesDeDosPuntos = ahora.toString().split(":", 3);
            String SplitearPrimeroDeCuatro = primerBloqueAntesDeDosPuntos[0];
            String[] lastPrimerBloque = SplitearPrimeroDeCuatro.split(" ", 0);


            String[] segundoBloque = ahora.toString().split(":", 3);
            String segundoSplit = primerBloqueAntesDeDosPuntos[1];
            String[] lastPrimerSplit = segundoSplit.split(" ", 0);

            String[] tercerBloque = ahora.toString().split(":", 3);
            String tercerSplit = primerBloqueAntesDeDosPuntos[2];
            String[] lastTercerSplit = tercerSplit.split(" ", 0);

            int ahoraHora = Integer.parseInt(lastPrimerBloque[3]);
            int ahoraMins = Integer.parseInt(lastPrimerSplit[0]);
            int ahoraSecs = Integer.parseInt(lastTercerSplit[0]);

            /* Se viene el segundo bloque de ints */

            String[] primerBloqueAntesDeDosPuntosX = esperado.toString().split(":", 3);
            String SplitearPrimeroDeCuatroX = primerBloqueAntesDeDosPuntosX[0];
            String[] lastPrimerBloqueX = SplitearPrimeroDeCuatroX.split(" ", 0);

            String[] segundoBloqueX = esperado.toString().split(":", 3);
            String segundoSplitX = primerBloqueAntesDeDosPuntosX[1];
            String[] lastPrimerSplitX = segundoSplitX.split(" ", 0);

            String[] tercerBloqueX = esperado.toString().split(":", 3);
            String tercerSplitX = primerBloqueAntesDeDosPuntosX[2];
            String[] lastTercerSplitX = tercerSplitX.split(" ", 0);

            int esperadoHora = Integer.parseInt(lastPrimerBloqueX[3]);
            int esperadoMins = Integer.parseInt(lastPrimerSplitX[0]);
            int esperadoSecs = Integer.parseInt(lastTercerSplitX[0]);
            
            /* Se evalua si pasó el tiempo lo que permitiría agregar segundos a lo trabajado */
            if(ahoraHora > esperadoHora || ahoraMins > esperadoMins || ahoraSecs > esperadoSecs) {
                VISTA.imprimeTiempoActivo(horas,minutos,segundos);
                VISTA.setTiempoActivo(imprimeTiempoActivo());
                pasoElTiempoEsperado = false; //Ya se puede sumar otro segundo (es decir, pasó el tiempo)
            }
        }
    }

    @Override //Obtiene la cantidad de caracteres de la nota
    public void keyPressed(KeyEvent e) {
        VISTA.imprimerCaracteres(VISTA.getCuerpoNotaTextArea().compareTo(""));
    }

    @Override //Actializa el tiempoActivo si se cambia el tituloJTextField
    public void keyReleased(KeyEvent e) {
        /*Esta quiere decir que si se detecta que el título cambió entonces hay
        que reiniciar el "tiempoActivo" para que no se permita cargar una nota
        con un tiempo que no corresponde al trabajado en esa nota exclusivamente*/
        if(e.getComponent().getAccessibleContext().toString().contains("Field") == true){
            VISTA.setTiempoActivo("00:00:00");
            horas = 0;
            minutos = 0;
            segundos = 0;
            VISTA.imprimeTiempoActivo(horas, minutos, segundos);
            
        }
    }

//------------------------------------------------------------------------------    
//Comienzo de los metodos privados invocados en su mayoria en ActionPerformed
    
    /**
     * Este metodo privado se encarga de la lógica para Guardar la nota en la 
     * BBDD
     */
    private void logicaCaseGuardar(){
        
        //El if valida que el titulo o la nota no están vacia
        if(!(VISTA.getCuerpoNotaTextArea().isEmpty() || VISTA.getJTextTitulo().isEmpty())){
            
            if(MODELO.existTitulo(VISTA.getJTextTitulo()) == false){
                String tiempoActivo = (VISTA.getTiempoActivo().isEmpty()) ? 
                        "00:00:00" : VISTA.getTiempoActivo();
                NotaPOJO nota = new NotaPOJO(
                    VISTA.getJTextTitulo(),
                    VISTA.getCuerpoNotaTextArea(), 
                    VISTA.getCuerpoNotaTextArea().compareTo(""), 
                    tiempoActivo
                );
                MODELO.guardarNota(nota);
                VISTA.ejecucionCorrecta("La nota ha sido guardada por primera "
                        + "vez. \nRecuerda que puedes consultar tus notas creadas"
                        + " en la pestaña \"Menú de consultas\".");
                deseaGuardarEmociones();
            }else{
                VISTA.error("Ya existe el título.");
            }
        }else{
            VISTA.error("Ni el título ni la nota deben estar vacío.");
        }
        
    }    
    
    /** Cronometrar el tiempo activo: Este metodo suma los segundos y arregla su
     * string para enviar a la base de datos si se necesitara.
     */
    private void timerTipeo(){
        segundos ++;
        arreglar();
        VISTA.setTiempoActivo(imprimeTiempoActivo());
        //System.out.println(imprimeTiempoActivo());//para ver en consola
    }
        
    /**
     * Unifica el tipo de salida en el formato desdeado desde 16/10/21
     * @return 
     * String con formato "00:00:00";
     */
    private String imprimeTiempoActivo(){
        String salida = 
                ((horas <= 9 ? "0" : "") + horas + ":" + 
                (minutos <= 9 ? "0" : "") + minutos + ":" + 
                (segundos <= 9 ? "0" : "") + segundos);
        return salida;
    }        

    /**
     * Se tiene que actualizar los 60 seg por 1 min. 60 min por 1 hora.
     */
    private void arreglar() {
        if(segundos == 60){
            minutos++;
            segundos = 0;
        }
        if (minutos == 60){
            horas++;
            minutos = 0;
        }
        if (horas == 24){
            horas = 0;
        }
    }

//------------------------------------------------------------------------------    
    /**
     * Método privado encargado de realizar la lógica que Actualizaa una nota 
     * en la BBDD.
     */
    private void logicaCaseActualizar() {

        MODELO.setNota(VISTA.getCuerpoNotaTextArea());
        MODELO.setTiempoActivo(VISTA.getTiempoActivo());
        MODELO.setTituloNota(VISTA.getJTextTitulo());
        
        //si se quiere actualizar, ni el titulo ni el cuerpo debe estar vacio
        if(!(VISTA.getJTextTitulo().isEmpty() || VISTA.getCuerpoNotaTextArea().isEmpty())){
        //si el titulo existe actualizar seguir
            if(MODELO.existTitulo(VISTA.getJTextTitulo())){
                //si evidentemente hay cambios que actualizar, entonces actualizar
                if (!(MODELO.huboCambios() == true)){
                    MODELO.actualizarNota();
                    VISTA.ejecucionCorrecta("Tu nota ha sido actuaizara correctamente.");
                    deseaGuardarEmociones();
                }else{
                    VISTA.error("Para actualizar su nota debe escribir algo nuevo.");
                }
            }else{
                VISTA.error("El titulo encontrado para la nota que estás creando no coincide con ninguno de las notas creadas");
            }
        }else{
            VISTA.error("Por favor cree una nota nueva o favor de abrir \n una creada para actualizar datos en una nota");
        }
    }
        
//------------------------------------------------------------------------------    
    
    /**
     * Metodo privado que se encarga de la logica de devolver al estado original
     * de una nota, es decir revertir los cambios.
     */
    private void logicaCaseCancelarCambio(int nCase) {
        if (MODELO.existTitulo(VISTA.getJTextTitulo()) == true){
            MODELO.revertirCambios(VISTA.getJTextTitulo());
            VISTA.setJTextTitulo(MODELO.getTituloNota());
            VISTA.setCuerpoNotaTextArea(MODELO.getNota());
            VISTA.setTiempoActivo(MODELO.getTiempoActivo());
            setPrivateInts(MODELO.getTiempoActivo());
            if(nCase == 1) VISTA.ejecucionCorrecta("Se ha reestablecido los "
                    + "datos según la última actualización");
        }else{
            VISTA.error("No existe el título");
        }
    }    
    
    /**
     * Carga la información obtenida del tiempo activo de una nota a esta clase.
     * @param tiempoActivo 
     * El tiempo activo de una nota que ya ha sido creada.
     */
    private void setPrivateInts(String tiempoActivo) {
        String[] segunDosPuntos = tiempoActivo.split(":", 3);
        
        horas = Integer.parseInt(segunDosPuntos[0]);
        minutos = Integer.parseInt(segunDosPuntos[1]);
        segundos = Integer.parseInt(segunDosPuntos[2]);
    }
//------------------------------------------------------------------------------
    /**
     * Valida de que estén bien los parámetros que se reciben y en caso
     * afirmativo, se registra el recordatorio y se imprime según el tiempo 
     * solicitado
     */
    private void logicaRecordatorios() {

        String[] recordatorioYTiempo = new String[3];

        recordatorioYTiempo = VISTA.recordatorios();

        try {
            if ((!(recordatorioYTiempo[0].isEmpty())) && (!(recordatorioYTiempo[1].isEmpty()))) {
                try {
                    Long.parseLong(recordatorioYTiempo[1]);
                    
                    if(Long.parseLong(recordatorioYTiempo[1]) > 4){
                        RunSOW nuevoHilo = new RunSOW();
                        
                        nuevoHilo.recordatorio(recordatorioYTiempo[0], Long.parseLong(recordatorioYTiempo[1]));
                    
                        VISTA.ejecucionCorrecta(" El recordatorio se ha registrado correctamente.");
                    }else{
                        VISTA.error("Ingrese periodo en segundos mayor o igual a 5 (Ej: 20).");
                    }
                } catch (NumberFormatException ex) {
                    VISTA.error("Debe ingresar un número, intente nuevamente.");
                } catch (Recordatorios ex){ex.toString();}
            }else{
                VISTA.error("Debe responder adecuadamente a los anteriores cuadros.");
            }
        } catch (NullPointerException ex) {
            VISTA.error("Ingresaste algún valor vacío... Intente nuevamente.");
        } catch (IndexOutOfBoundsException ex) {
            VISTA.error("Debe ingresar un número cuando se le pregunta por el tiempo.");
        } catch (Exception ex) {

        }
            
    }  

    //Botón "Registrar emoción" y "Ayudante" contenido en el ActionPerformed
    
//------------------------------------------------------------------------------
//--------------------Pertenecientes al segundo panel---------------------------
//------------------------------------------------------------------------------

    // jComboBox contenido en el ActionPerformed
    
    /**
     * Método privado que se encarga de la logica de Abrir una nota que ha sido
     * recuperada de un JTable.
     */
    private void logicaCaseAbrirNota() {
        int filaSelec = VISTA.getGrilla().getSelectedRow();
        String valoresDeLaFila = "";

        JTable jt = VISTA.getGrilla();

        //Comprobar que una fila esté seleccionada y tenga datos en ella para 
        //realizar la consulta
        try{
            //Si la fila no tiene datos, .toString() genera un Null Pointer Ex.
            valoresDeLaFila = jt.getValueAt(filaSelec, 0).toString();
            //Si los valores de la fila no son vacios... consulta los a abrir
            if (!(valoresDeLaFila.isEmpty())){
                MODELO.revertirCambios(valoresDeLaFila);
                VISTA.setJTextTitulo(MODELO.getTituloNota());
                VISTA.setCuerpoNotaTextArea(MODELO.getNota());
                VISTA.setTiempoActivo(MODELO.getTiempoActivo());
                VISTA.setTemporalLabelCuerpo("");
                VISTA.setTemporalLabelTitulo("");
                VISTA.irALaNota();
            }
            
        }catch (NullPointerException ex){
            VISTA.error("Por favor seleccione una fila que no esté vacía...");
        }catch (IndexOutOfBoundsException ex){
            VISTA.error("Por favor seleccione una fila");
        }
    }    
    
//------------------------------------------------------------------------------
    /**
     * Método privado que se encarga de eliminar una nota seleccionada en la 
     * vista según la JTable de la VISTA.
     */
    private void logicaCaseBorrarNota() {
        
        int filaSelec = VISTA.getGrilla().getSelectedRow();
        String valoresDeLaFila = ""; //Se buscará el título de la nora

        JTable jt = VISTA.getGrilla();

        //Comprobar que una fila esté seleccionada y tenga datos en ella para 
        //realizar el borrado de la nota
        try{
            //obtiene el titulo de la nota
            valoresDeLaFila = jt.getValueAt(filaSelec, 0).toString();
            //Si los valores de la fila no son vacios... consulta los a borrar
            if (!(valoresDeLaFila.isEmpty())){
                MODELO.limpiar(VISTA.getGrilla());
                MODELO.borrarNota(valoresDeLaFila);
                MODELO.limpiar(VISTA.getGrilla());
                VISTA.ejecucionCorrecta("La nota seleccionada fue eliminada");
            }else{
                VISTA.error("Debe seleccionar una fila que no esté vacía.");
            }
            
        }catch (NullPointerException ex){ //por el si falla el .toString
            VISTA.error("Por favor seleccione una fila que no esté vacía...");
        }catch (IndexOutOfBoundsException ex){
            VISTA.error("Por favor seleccione una fila");
        }
    }

    private void deseaGuardarEmociones() {
        //Si el usuario quiere agragar una emocion (responde si a JOptionPane).
        if (VISTA.deseaGuardarEmociones() == 0){
            MODELO.registrarEmocion(VISTA.getJTextTitulo());
        }
    }

}