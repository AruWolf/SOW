package sow.mvc.modelo;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sow.dao.factory.DAOFactory;
import sow.dto.NotaPOJO;
import sow.dao.AmbienteDAO;
import sow.dao.NotaDAO;
import sow.dto.AmbientePOJO;
import sow.mvc.controlador.ControladorAyudante;
import sow.mvc.controlador.ControladorAyudanteImpl;
import sow.mvc.controlador.ControladorEmociones;
import sow.mvc.controlador.ControladorEmocionesImpl;
import sow.mvc.vista.Ayudante;
import sow.mvc.vista.AyudanteJFrame;
import sow.mvc.vista.RegistroDeEmociones;
import sow.mvc.vista.RegistroDeEmocionesJFrame;

/**
 * Clase que presenta el Modelo (contiene getter y setter de la vista) y que
 * participa en la lógica que la vista necesita para poder almacenar e incluso
 * modificar su vista en base a los eventos de la vista.
 * 
 * Esta clase es puente directo al CRUD de la BBDD.
 */
public class ModeloVentanaPrincipal {
    
    private String tituloNota;
    private String nota;
    private String tiempoActivo;
    private AmbienteDAO sqlAmbiente;
    private NotaDAO sqlNota;
    private final DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.SQLSpy);
    
    /**
     * Método encargado llamar el método que guarda una nota en la BBDD.
     * @param nota 
     * Se envía la nota que se desea guardar.
     */
    public void guardarNota(NotaPOJO nota){
        sqlNota = dao.getNotaDAO();
        sqlNota.crearNuevaNota(nota);
    }
    
    /**
     * Método que se encarga de actualizar una nota en la BBDD.
     */
    public void actualizarNota() {
        sqlNota = dao.getNotaDAO();
        try{
            int cantCaracteres = nota.compareTo("");
            NotaPOJO notaX = new NotaPOJO(tituloNota, this.nota, cantCaracteres, tiempoActivo);
            sqlNota.actualizarNotaCreadaAnteriormente(notaX);
        }catch(IndexOutOfBoundsException | NullPointerException ex){}
    }
    
    /**
     * Revierte los cambios de una nota según el nombre del título.
     * @param titulo 
     * Titulo de la nota a consultar en la BBDD.
     */
    public void revertirCambios(String titulo){
        sqlNota = dao.getNotaDAO();
        String[] tituloAndNota;
        tituloAndNota = sqlNota.buscarNota(titulo);
        setTituloNota(tituloAndNota[0]);
        setNota(tituloAndNota[1]);
        setTiempoActivo(tituloAndNota[2]);
    }
    
    /**
     * Método encargado de iniciar el JFrame para registrar emociones.
     * @param jTextTitulo 
     * El título que se haya en la Vista.
     */
    public void registrarEmocion(String jTextTitulo){

        ModeloRegistroDeEmociones modelo = new ModeloRegistroDeEmociones();
        modelo.setAmbienteDe(jTextTitulo);
        
        RegistroDeEmociones vista = new RegistroDeEmocionesJFrame();
        
        ControladorEmociones control = new ControladorEmocionesImpl(vista, modelo);
        
        vista.setControlador(control);
        vista.iniciaVista();
    }
    
    /**
     * Inicializa un nuevo JFrame donde se encuentra el Ayudante.
     */
    public void abrirAyudante(){
        
        ModeloAyudante modelo = new ModeloAyudante();
        
        Ayudante vista = new AyudanteJFrame();
        
        ControladorAyudante control = new ControladorAyudanteImpl(vista, modelo);
        
        vista.setControlador(control);
        vista.iniciaVista();
    }

//------------------------------------------------------------------------------
//--------------------Pertenecientes al segundo panel---------------------------
//------------------------------------------------------------------------------
    
    /**
     * Se encarga de reescribir los nombres del Header de la JTable y también
     * imprime en el mismo los datos correspondientes a la consulta.
     * @param jtable
     * La tabla de la Vista.
     * @param segun 
     * String que debería tener el setActionCommand.
     */
    public void consultaSegun(JTable jtable, String segun) {
        
        sqlNota = dao.getNotaDAO();
        int nCase = sqlNota.getCase(segun); //Se recomienda cambiar a futuro.
        List<NotaPOJO> array = sqlNota.listarNotas(nCase);
        int max = sqlNota.listarNotas(1).size();

        jtable.getColumnModel().getColumn(0).setHeaderValue("Título");
        jtable.getColumnModel().getColumn(1).setHeaderValue("Nota");
        jtable.getColumnModel().getColumn(2).setHeaderValue("Cantidad caracteres");
        jtable.getColumnModel().getColumn(3).setHeaderValue("Tiempo activo");
        jtable.getColumnModel().getColumn(4).setHeaderValue("Reservado");
        
        TableModel model = jtable.getModel();
        /*
        10/10/21[21:30] -> Resulta que si se crean más notas o más ambientes que
        el modelo (columnas x filas) soporta, genera un error IndexOutOfBounds
        */
        if(max > 30) agregarFilasNecesarias(jtable, max);
        
        limpiar(jtable);//No llamar este metodo sin tener las filas necesarias
        
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 4; j++) {
                if (j==0){
                    model.setValueAt(array.get(i).getTitulo(), i, j);
                }
                if (j==1){
                    model.setValueAt(array.get(i).getNota(), i, j);
                }
                if (j==2){
                    model.setValueAt(array.get(i).getCantidadCaracteres(), i, j);
                }
                if (j==3){
                    model.setValueAt(array.get(i).getTiempoActivo(), i, j);
                }
            }
            
        }
        
    }
    
    /**
     * Se encarga de reescribir los nombres del Header de la JTable y también
     * imprime en el mismo los datos correspondientes a la consulta.
     * @param jtable
     * La tabla de la Vista.
     * @param segun 
     * String que debería tener el setActionCommand.
     */
    public void consultaSegun2(JTable jtable, String segun) {

        sqlAmbiente = dao.getAmbienteDAO();
        int nCase = sqlAmbiente.getCase(segun); //Cambiar a futuro.
        List<AmbientePOJO> array = sqlAmbiente.listarNotas(nCase);
        int max = sqlAmbiente.listarNotas(1).size();

        jtable.getColumnModel().getColumn(0).setHeaderValue("Título");
        jtable.getColumnModel().getColumn(1).setHeaderValue("Estado animico");
        jtable.getColumnModel().getColumn(2).setHeaderValue("Benefactores");
        jtable.getColumnModel().getColumn(3).setHeaderValue("creacion");
        jtable.getColumnModel().getColumn(4).setHeaderValue("Modificacion");
        
        TableModel model = jtable.getModel();
        
        /*
        10/10/21[21:30] -> Resulta que si se crean más notas o más ambientes que
        el modelo (columnas x filas) soporta, genera un error IndexOutOfBounds
        */
        
        if(max > 30) agregarFilasNecesarias(jtable, max);
        
        limpiar(jtable); //no llamar este metodo sin tener las filas necesarias

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (j==0){
                    model.setValueAt(array.get(i).getAmbienteDe(), i, j);
                }
                if (j==1){
                    model.setValueAt(array.get(i).getEstadoAnimico(), i, j);
                }
                if (j==2){
                    model.setValueAt(array.get(i).getBenefactores(), i, j);
                }
                if (j==3){
                    model.setValueAt(array.get(i).getDateCreacion(), i, j);
                }
                if (j==4){
                    model.setValueAt(array.get(i).getDateModificacion(), i, j);
                }
            }
            
        }
        
    }

    /**
     * Para no dejar la JTable estáticamente con los datos antiguios es que
     * se realiza una limpieza dejando todos los datos de la JTable vacio.
     * @param jtable 
     * JTable de la Vista.
     */
    public void limpiar(JTable jtable) {
        /*
        Se que hay una mejor forma de hacerlo, intente con jtableRemove all
        y con jtable.getModel.getDataVector.removeAllElements() y nada...
        por lo que decidí hacerlo de una forma artesanal, se que los for
        anidado no son la mejor opcion al tener muchos datos.
        Recomendación a futuro: Mejorar o encontrar el metodo que limpia la 
        tabla.
        */
        sqlNota = dao.getNotaDAO();
        sqlAmbiente = dao.getAmbienteDAO();
        
        int max = sqlNota.listarNotas(1).size();
        int max2 = sqlAmbiente.listarNotas(1).size();
        
        int maxDefinitivo = (max > max2) ? max : max2; 
        
        /*
        10/10/21[21:30] -> Resulta que si se crean más notas o más ambientes que
        el modelo (columnas x filas) soporta, genera un error IndexOutOfBounds
        */
        if (maxDefinitivo > jtable.getModel().getRowCount())agregarFilasNecesarias(jtable, maxDefinitivo);
        
        
        for (int i = 0; i < maxDefinitivo; i++) {
            for (int j = 0; j < maxDefinitivo; j++) {
                if (j==0){
                    jtable.setValueAt("", i, j);
                }
                if (j==1){
                    jtable.setValueAt("", i, j);
                }
                if (j==2){
                    jtable.setValueAt("", i, j);
                }
                if (j==3){
                    jtable.setValueAt("", i, j);
                }
                if (j==4){
                    jtable.setValueAt("", i, j);
                }
            }
        }
    }
    
    /**
     * 
     * @param tituloNota
     * El título de la nota a consultar a la BBDD.
     * @return 
     * True si existe un título con el parametro del modelo.
     * false si no existe título del this.tituloNota.
     */
    public boolean existTitulo(String tituloNota){
        sqlNota = dao.getNotaDAO();
        return (sqlNota.existTitulo(tituloNota));
    }

    /**
     * Se conecta a la base de datos para eliminar una Nota.
     * @param valoresDeLaFila 
     * Se refiere al título de la nota
     */
    public void borrarNota(String valoresDeLaFila) {
        sqlNota = dao.getNotaDAO();
        sqlNota.borrarNota(valoresDeLaFila);
        //limpiar(jtable);
    }

    /**
     * Método privado encargado de determinar si se detectan cambios comparado
     * a los datos contenidos en la BBDD con respecto a lo que hay en el Modelo.
     * @return 
     * true si se hallaron cambios en el cuerpo de la nota. False en caso 
     * contrario.
     */
    public boolean huboCambios() {
        boolean huboCambios = false;
        sqlNota = dao.getNotaDAO();
        
        String[] tituloAndCuerpo = sqlNota.buscarNota(tituloNota);
        try{
            if(tituloAndCuerpo[1].equals(nota)){
                huboCambios = true;
                return huboCambios;
            }
        }catch (NullPointerException ex){huboCambios = false; return huboCambios;}
        
        return huboCambios;
    }

    /**
     * Método privado que agrega nuevas filas a la tabla.
     * @param jt
     * Se necesita tener la Tabla a la cual se le agregarán filas.
     * @param max 
     * Máximo establecido de la JTable desde la Vista.
     */
    private void agregarFilasNecesarias(JTable jt, int max) {
        int diferencia = max - jt.getModel().getRowCount();
        DefaultTableModel dtm = (DefaultTableModel) jt.getModel();
        
        for (int i = 0; i < diferencia; i++) {
            dtm.addRow(new Object[]{"","","","",""});
        }
    }
    
//------------------------------------------------------------------------------    
//--------------------------GETTERS Y SETTERS-----------------------------------
//------------------------------------------------------------------------------

    /**
     *
     * @return
     */
    
    public String getTituloNota() {
        return tituloNota;
    }

    /**
     *
     * @param tituloNota
     */
    public void setTituloNota(String tituloNota) {
        this.tituloNota = tituloNota;
    }

    /**
     *
     * @return
     */
    public String getNota() {
        return nota;
    }

    /**
     *
     * @param Nota
     */
    public void setNota(String Nota) {
        this.nota = Nota;
    }

    /**
     *
     * @return
     */
    public String getTiempoActivo() {
        return tiempoActivo;
    }

    /**
     *
     * @param tiempoActivo
     */
    public void setTiempoActivo(String tiempoActivo) {
        this.tiempoActivo = tiempoActivo;
    }
}
