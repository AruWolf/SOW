package sow.mvc.vista;

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTable;
import sow.mvc.controlador.ControladorVentanaPrincipal;

/**
 * JFrame correspondiente a la vista Principal invocada en el runSOW.java.
 */
public class VentanaPrincipalJFrame extends javax.swing.JFrame implements VentanaPrincipal{

    private String tiempo;
    
    /**
     * InitComponents
     */
    public VentanaPrincipalJFrame() {
        this.tiempo = "";
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pestañas = new javax.swing.JTabbedPane();
        panelDeNotas = new javax.swing.JPanel();
        text_guardaNota = new javax.swing.JLabel();
        text_actualizarNota = new javax.swing.JLabel();
        text_revertirCambios = new javax.swing.JLabel();
        text_registrarEmocion = new javax.swing.JLabel();
        text_ayudante = new javax.swing.JLabel();
        text_recprdatorios = new javax.swing.JLabel();
        temporalLabelCuerpo = new javax.swing.JLabel();
        actualizarNotaLabel = new javax.swing.JLabel();
        temporalLabelTitulo = new javax.swing.JLabel();
        guardarBtnLabel = new javax.swing.JLabel();
        revertirCambiosLabel = new javax.swing.JLabel();
        registrarEmocionLabel = new javax.swing.JLabel();
        ayudanteLabel = new javax.swing.JLabel();
        recordatorioBtn = new javax.swing.JLabel();
        jScrollPanelNota = new javax.swing.JScrollPane();
        cuerpoNotaTextArea = new javax.swing.JTextArea();
        titulojTextField = new javax.swing.JTextField();
        jLabelTiempo = new javax.swing.JLabel();
        jLabelCaracteres = new javax.swing.JLabel();
        backgorund1 = new javax.swing.JLabel();
        panelDeMenuConsultas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        grilla = new javax.swing.JTable();
        consutasJComboBox = new javax.swing.JComboBox<>();
        text_abrirNota = new javax.swing.JLabel();
        text_borrarNota = new javax.swing.JLabel();
        abrirNotaLabel = new javax.swing.JLabel();
        borrarNotaLabel = new javax.swing.JLabel();
        backgorund2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Strategic Open Writer – Tu conjunto de herramientas para redactar");
        setBackground(new java.awt.Color(63, 63, 63));
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        pestañas.setForeground(new java.awt.Color(63, 63, 63));
        pestañas.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        pestañas.setMinimumSize(new java.awt.Dimension(1920, 1080));

        panelDeNotas.setForeground(new java.awt.Color(63, 63, 63));
        panelDeNotas.setMinimumSize(new java.awt.Dimension(1920, 1080));
        panelDeNotas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text_guardaNota.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        text_guardaNota.setForeground(new java.awt.Color(204, 204, 204));
        text_guardaNota.setText("Guarda nota nueva");
        panelDeNotas.add(text_guardaNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(1102, 65, -1, -1));

        text_actualizarNota.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        text_actualizarNota.setForeground(new java.awt.Color(204, 204, 204));
        text_actualizarNota.setText("Actualizar nota");
        panelDeNotas.add(text_actualizarNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(1123, 165, -1, -1));

        text_revertirCambios.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        text_revertirCambios.setForeground(new java.awt.Color(204, 204, 204));
        text_revertirCambios.setText("Revertir cambios");
        panelDeNotas.add(text_revertirCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1113, 273, -1, -1));

        text_registrarEmocion.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        text_registrarEmocion.setForeground(new java.awt.Color(204, 204, 204));
        text_registrarEmocion.setText("Registrar emoción");
        panelDeNotas.add(text_registrarEmocion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 60, -1, -1));

        text_ayudante.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        text_ayudante.setForeground(new java.awt.Color(204, 204, 204));
        text_ayudante.setText("Ayudante");
        panelDeNotas.add(text_ayudante, new org.netbeans.lib.awtextra.AbsoluteConstraints(1462, 274, -1, -1));

        text_recprdatorios.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        text_recprdatorios.setForeground(new java.awt.Color(204, 204, 204));
        text_recprdatorios.setText("Recordatorios");
        panelDeNotas.add(text_recprdatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 160, -1, -1));

        temporalLabelCuerpo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        temporalLabelCuerpo.setForeground(new java.awt.Color(204, 204, 204));
        temporalLabelCuerpo.setText("No has escrito nada aún ¡Es hora de escribir!");
        panelDeNotas.add(temporalLabelCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 610, 60));

        actualizarNotaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizarNotaBtn.png"))); // NOI18N
        panelDeNotas.add(actualizarNotaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 130, -1, -1));

        temporalLabelTitulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        temporalLabelTitulo.setForeground(new java.awt.Color(204, 204, 204));
        temporalLabelTitulo.setText("Ingrese el título de su nota aquí");
        panelDeNotas.add(temporalLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 440, 60));

        guardarBtnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarBtn.png"))); // NOI18N
        panelDeNotas.add(guardarBtnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 30, -1, -1));

        revertirCambiosLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/revertirCambiosBtn.png"))); // NOI18N
        panelDeNotas.add(revertirCambiosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 240, -1, -1));

        registrarEmocionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarEmocion.png"))); // NOI18N
        panelDeNotas.add(registrarEmocionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 30, -1, -1));

        ayudanteLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ayudanteBtn.png"))); // NOI18N
        panelDeNotas.add(ayudanteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 240, -1, -1));

        recordatorioBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/recordatorioBtn.jpg"))); // NOI18N
        panelDeNotas.add(recordatorioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 130, -1, -1));

        cuerpoNotaTextArea.setBackground(new java.awt.Color(63, 63, 63));
        cuerpoNotaTextArea.setColumns(20);
        cuerpoNotaTextArea.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cuerpoNotaTextArea.setForeground(new java.awt.Color(204, 204, 204));
        cuerpoNotaTextArea.setLineWrap(true);
        cuerpoNotaTextArea.setRows(5);
        cuerpoNotaTextArea.setDoubleBuffered(true);
        cuerpoNotaTextArea.setDragEnabled(true);
        cuerpoNotaTextArea.setHighlighter(null);
        cuerpoNotaTextArea.setMargin(new java.awt.Insets(10, 25, 10, 25));
        jScrollPanelNota.setViewportView(cuerpoNotaTextArea);

        panelDeNotas.add(jScrollPanelNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 152, 1000, 730));

        titulojTextField.setBackground(new java.awt.Color(63, 63, 63));
        titulojTextField.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        titulojTextField.setForeground(new java.awt.Color(204, 204, 204));
        titulojTextField.setToolTipText("");
        titulojTextField.setMargin(new java.awt.Insets(5, 5, 5, 5));
        panelDeNotas.add(titulojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 32, 1000, 60));

        jLabelTiempo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabelTiempo.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTiempo.setText("Tiempo transcurrido:");
        panelDeNotas.add(jLabelTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 900, -1, -1));

        jLabelCaracteres.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabelCaracteres.setForeground(new java.awt.Color(204, 204, 204));
        jLabelCaracteres.setText("Cantidad de caracteres:");
        panelDeNotas.add(jLabelCaracteres, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 930, -1, -1));

        backgorund1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoDePantalla.jpg"))); // NOI18N
        panelDeNotas.add(backgorund1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1920, 1080));

        pestañas.addTab("Notas", panelDeNotas);

        panelDeMenuConsultas.setBackground(new java.awt.Color(63, 63, 63));
        panelDeMenuConsultas.setForeground(new java.awt.Color(63, 63, 63));
        panelDeMenuConsultas.setMinimumSize(new java.awt.Dimension(1920, 1080));
        panelDeMenuConsultas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setForeground(new java.awt.Color(64, 64, 64));

        grilla.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        grilla.setForeground(new java.awt.Color(204, 204, 204));
        grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Strategic", "Open", "Writer", "Tu conjunto de herramientas", "para redactar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grilla.setGridColor(new java.awt.Color(204, 204, 204));
        grilla.setRowHeight(25);
        grilla.setSelectionBackground(new java.awt.Color(150, 150, 150));
        grilla.setSelectionForeground(new java.awt.Color(63, 63, 63));
        grilla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(grilla);
        this.grilla.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 16));
        float[] hsbColor = new float[3];
        hsbColor = Color.RGBtoHSB(64, 64, 64, hsbColor);
        this.grilla.setBackground(Color.getHSBColor(hsbColor[0], hsbColor[1], hsbColor[2]));

        hsbColor = Color.RGBtoHSB(125, 125, 125, hsbColor);
        this.grilla.getTableHeader().setBackground(Color.getHSBColor(hsbColor[0], hsbColor[1], hsbColor[2]));

        panelDeMenuConsultas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 1870, 770));

        consutasJComboBox.setBackground(new java.awt.Color(64, 64, 64));
        consutasJComboBox.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        consutasJComboBox.setForeground(new java.awt.Color(255, 255, 255));
        consutasJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un item", "Listar según título", "Listar según longitud", "Listar según tiempo activo", "Listar según fecha", "Listar según modificación", "Listar según emoción" }));
        panelDeMenuConsultas.add(consutasJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        consutasJComboBox.setActionCommand(CONSULTAS_BOX);

        text_abrirNota.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        text_abrirNota.setForeground(new java.awt.Color(204, 204, 204));
        text_abrirNota.setText("Abrir nota");
        panelDeMenuConsultas.add(text_abrirNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 72, -1, -1));

        text_borrarNota.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        text_borrarNota.setForeground(new java.awt.Color(204, 204, 204));
        text_borrarNota.setText("BorrarNota");
        panelDeMenuConsultas.add(text_borrarNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 73, -1, -1));

        abrirNotaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/abrirNota.png"))); // NOI18N
        panelDeMenuConsultas.add(abrirNotaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        borrarNotaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrarNotaBtn.png"))); // NOI18N
        panelDeMenuConsultas.add(borrarNotaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        backgorund2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoDePantalla.jpg"))); // NOI18N
        panelDeMenuConsultas.add(backgorund2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1920, 1080));

        pestañas.addTab("Menú de Consultas", panelDeMenuConsultas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pestañas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pestañas, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abrirNotaLabel;
    private javax.swing.JLabel actualizarNotaLabel;
    private javax.swing.JLabel ayudanteLabel;
    private javax.swing.JLabel backgorund1;
    private javax.swing.JLabel backgorund2;
    private javax.swing.JLabel borrarNotaLabel;
    private javax.swing.JComboBox<String> consutasJComboBox;
    private javax.swing.JTextArea cuerpoNotaTextArea;
    private javax.swing.JTable grilla;
    private javax.swing.JLabel guardarBtnLabel;
    private javax.swing.JLabel jLabelCaracteres;
    private javax.swing.JLabel jLabelTiempo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPanelNota;
    private javax.swing.JPanel panelDeMenuConsultas;
    private javax.swing.JPanel panelDeNotas;
    private javax.swing.JTabbedPane pestañas;
    private javax.swing.JLabel recordatorioBtn;
    private javax.swing.JLabel registrarEmocionLabel;
    private javax.swing.JLabel revertirCambiosLabel;
    private javax.swing.JLabel temporalLabelCuerpo;
    private javax.swing.JLabel temporalLabelTitulo;
    private javax.swing.JLabel text_abrirNota;
    private javax.swing.JLabel text_actualizarNota;
    private javax.swing.JLabel text_ayudante;
    private javax.swing.JLabel text_borrarNota;
    private javax.swing.JLabel text_guardaNota;
    private javax.swing.JLabel text_recprdatorios;
    private javax.swing.JLabel text_registrarEmocion;
    private javax.swing.JLabel text_revertirCambios;
    private javax.swing.JTextField titulojTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setControlador(ControladorVentanaPrincipal c) {
        //Antiguamente JBottons, actualmente labels
        //En orden de aparicion del primer panel (arriba - abajo, izq - der)
        this.guardarBtnLabel.addMouseListener(c);
        this.actualizarNotaLabel.addMouseListener(c);
        this.revertirCambiosLabel.addMouseListener(c);
        this.registrarEmocionLabel.addMouseListener(c);
        this.ayudanteLabel.addMouseListener(c);
        this.recordatorioBtn.addMouseListener(c);

        //ActionListeners para los campos de texto
        this.cuerpoNotaTextArea.addKeyListener(c); //cuenta el tiempo activo
        this.titulojTextField.addKeyListener(c); //borra tiempo activo
        this.titulojTextField.addMouseListener(c); //borra el temporal label
        this.cuerpoNotaTextArea.addMouseListener(c);//borra el temporal label
        //Labels y ComboBox segundo panel:
        this.consutasJComboBox.addActionListener(c);
        this.abrirNotaLabel.addMouseListener(c);
        this.borrarNotaLabel.addMouseListener(c);
    }

    @Override
    public void iniciaVista() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Según los parámetros que recibe, imprime en la vista un mensaje per
     * sonalizado
     * @param horas
     * @param minutos
     * @param segundos 
     */
    @Override
    public void imprimeTiempoActivo(int horas, int minutos, int segundos) {
        if(horas > 0){
            jLabelTiempo.setText("¡WOW! ¿Que bueno escribir, no? Tiempo transcurrido: " + horas + ":" + minutos + ":" + segundos + ".");
        }else if (minutos > 0){
            jLabelTiempo.setText("¡Sigue así! Tiempo transcurrido: " + minutos + " minutos, " + segundos + " Segundos.");
        }else{
            jLabelTiempo.setText("Llevas escribiendo: " + segundos + " segundos.");
        }
    }

    /**
     * Actualiza en la vista la cantidad de caracteres de la nota.
     * @param cantidadDeCaracteres 
     */
    @Override
    public void imprimerCaracteres(int cantidadDeCaracteres) {
        jLabelCaracteres.setText("Cantidad de caracteres: " + cantidadDeCaracteres);
    }
    
    @Override
    public void irALaNota() {
        pestañas.setSelectedIndex(0);
    }
    
    @Override
    public void error(String error) {
        ZMensajesJOptionPane.getMensajeError(error);
    }    

    @Override
    public void ejecucionCorrecta(String mensaje) {
        ZMensajesJOptionPane.getMensajeEjecucionCorrecta(mensaje);
    }
    
    @Override
    public int deseaGuardarEmociones(){
        int desea = ZMensajesJOptionPane.getRespuestaUsuario(); 
        return (desea);
    }
    
    @Override
    public String[] recordatorios() {
        return (ZMensajesJOptionPane.getRecordatorios());
        
    }    
//------------------------------------------------------------------------------
//--------------------------GETTER Y SETTERS------------------------------------
//------------------------------------------------------------------------------    

    /**
     *
     * @return
     */
    
    @Override
    public JTable getGrilla() {
        return grilla;
    }

    /**
     *
     * @return
     */
    @Override
    public String getTiempoActivo() {
        return tiempo;
    }

    /**
     *
     * @param tiempoActivo
     */
    @Override
    public void setTiempoActivo(String tiempoActivo) {
        this.tiempo = tiempoActivo;
    }

    /**
     *
     * @return
     */
    @Override
    public String getJTextTitulo() {
        return titulojTextField.getText();
    }

    /**
     *
     * @param titulo
     */
    @Override
    public void setJTextTitulo(String titulo) {
        this.titulojTextField.setText(titulo);
    }

    /**
     *
     * @return
     */
    @Override
    public String getCuerpoNotaTextArea() {
        return cuerpoNotaTextArea.getText();
    }

    /**
     *
     * @param cuerpoNota
     */
    @Override
    public void setCuerpoNotaTextArea(String cuerpoNota) {
        this.cuerpoNotaTextArea.setText(cuerpoNota);
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getConsultaJComboBox() {
        return consutasJComboBox.getSelectedItem().toString();
    }        
    
    /**
     *
     * @return
     */
    @Override
    public String getTemporalLabelCuerpo() {
        return temporalLabelCuerpo.toString();
    }

    /**
     *
     * @param temporalLabelCuerpo
     */
    @Override
    public void setTemporalLabelCuerpo(String temporalLabelCuerpo) {
        this.temporalLabelCuerpo.setText(temporalLabelCuerpo);
    }

    /**
     *
     * @return
     */
    @Override
    public String getTemporalLabelTitulo() {
        return temporalLabelTitulo.toString();
    }

    @Override
    public void setTemporalLabelTitulo(String temporalLabelTitulo) {
        this.temporalLabelTitulo.setText(temporalLabelTitulo);
    }    

}
