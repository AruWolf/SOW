package sow.dto;

import java.util.Date;

/**
 * Clase con los atributos de una AmbientePOJO.
 * contiene todos los getter y setter de sus atributos y un toString reescrito.
 */
public class AmbientePOJO {
    
    private int idNota;
    private String ambienteDe;
    private String estadoAnimico;
    private String distractores;
    private String benefactores;
    private Date dateCreacion;
    private Date dateModificacion;

    /**
     * Contructor único al menos desde 16/10/2021.
     * @param idNota
     * Se puede utilizar el getMax() del AmbienteDAO para obtener este número.
     * @param ambienteDe
     * El título idéntico de su padre (la nota que contiene este ambiente).
     * @param estadoAnimico
     * Lo debería brinda el usuario.
     * @param distractores
     * Lo debería brinda el usuario.
     * @param benefactores
     * Lo debería brinda el usuario.
     * @param dateCreacion
     * De tipo date (java.util.Date) NO ES DE TIPO java.sql.Date, aunque para
     * interactuar con la BBDD debe ser transformada en ella
     * @param dateModificacion 
     * De tipo date (java.util.Date) NO ES DE TIPO java.sql.Date, aunque para
     * interactuar con la BBDD debe ser transformada en ella
     */
    public AmbientePOJO(int idNota, String ambienteDe, String estadoAnimico, String distractores, String benefactores, Date dateCreacion, Date dateModificacion){
        this.idNota = idNota;
        this.ambienteDe = ambienteDe;
        this.estadoAnimico = estadoAnimico;
        this.distractores = distractores;
        this.benefactores = benefactores;
        this.dateCreacion = dateCreacion;
        this.dateModificacion = dateModificacion;
                
    }

    /**
     *
     * @return
     */
    public int getIdNota() {
        return idNota;
    }

    /**
     *
     * @param idNota
     */
    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    /**
     *
     * @return
     */
    public String getAmbienteDe() {
        return ambienteDe;
    }

    /**
     *
     * @param ambienteDe
     */
    public void setAmbienteDe(String ambienteDe) {
        this.ambienteDe = ambienteDe;
    }
    
    /**
     *
     * @return
     */
    public String getEstadoAnimico() {
        return estadoAnimico;
    }

    /**
     *
     * @param estadoAnimico
     */
    public void setEstadoAnimico(String estadoAnimico) {
        this.estadoAnimico = estadoAnimico;
    }

    /**
     *
     * @return
     */
    public String getDistractores() {
        return distractores;
    }

    /**
     *
     * @param distractores
     */
    public void setDistractores(String distractores) {
        this.distractores = distractores;
    }

    /**
     *
     * @return
     */
    public String getBenefactores() {
        return benefactores;
    }

    /**
     *
     * @param benefactores
     */
    public void setBenefactores(String benefactores) {
        this.benefactores = benefactores;
    }

    /**
     *
     * @return
     */
    public Date getDateCreacion() {
        return dateCreacion;
    }

    /**
     *
     * @param dateCreacion
     */
    public void setDateCreacion(Date dateCreacion) {
        this.dateCreacion = dateCreacion;
    }

    /**
     *
     * @return
     */
    public Date getDateModificacion() {
        return dateModificacion;
    }

    /**
     *
     * @param dateModificacion
     */
    public void setDateModificacion(Date dateModificacion) {
        this.dateModificacion = dateModificacion;
    }

 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Estado animico: ");
        sb.append(estadoAnimico);
        sb.append("Lo que puede haber distraido: ");
        sb.append(distractores);
        sb.append("Lo que puede haber beneficiado: ");
        sb.append(benefactores);
        sb.append("Día creado: ");
        sb.append(dateCreacion);
        sb.append("Día modificado: ");
        sb.append(dateModificacion);
        
        return sb.toString();
    }
    
}
