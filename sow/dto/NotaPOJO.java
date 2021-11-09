package sow.dto;

/**
 * Clase con los atributos de una NotaPOJO.
 * contiene todos los getter y setter de sus atributos y un toString reescrito.
 */
public class NotaPOJO {

    private String titulo;
    private String nota;
    private int cantidadCaracteres;
    private String tiempoActivo;

    /**
     * Contructor único al menos desde 16/10/2021.
     * @param titulo
     * El título de la nota.
     * @param nota
     * El cuerpo de la nota.
     * @param cantidadCaracteres
     * Se puede utilizar el método .compareTo(""); para saber la cantidad de
     * caracteres hallados en un String.
     * @param tiempoActivo 
     * String donde se recomienda un formato tipo "00:00:00".
     */
    public NotaPOJO(String titulo, String nota, int cantidadCaracteres,
            String tiempoActivo){
        
        this.titulo = titulo;
        this.nota = nota;
        this.cantidadCaracteres = cantidadCaracteres;
        this.tiempoActivo = tiempoActivo;
        
    }

    /**
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
     * @param nota
     */
    public void setNota(String nota) {
        this.nota = nota;
    }

    /**
     *
     * @return
     */
    public int getCantidadCaracteres() {
        return cantidadCaracteres;
    }

    /**
     *
     * @param cantidadCaracteres
     */
    public void setCantidadCaracteres(int cantidadCaracteres) {
        this.cantidadCaracteres = cantidadCaracteres;
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

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Título: ");
        sb.append(this.titulo);
        sb.append(" Nota: " );
        sb.append(this.nota);
        sb.append(" Cantidad de Caracteres: " );
        sb.append(this.cantidadCaracteres);
        sb.append(" Tiempo activo: ");
        sb.append(this.tiempoActivo);
        sb.append("\n");

        return sb.toString();
    }
}
