package sow.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sow.dao.NotaDAO;
import static sow.dao.factoryImpl.SQLSpyFactory.createConnection;
import sow.dto.NotaPOJO;

/**
 * Clase que contiene las consultas SQL de la base de datos
 */
public class SQLSpyNotaDAO implements NotaDAO {

    
    private static final String NUEVA_NOTA = "INSERT INTO notas VALUES (?,?,?,?,?)"; 
    private static final String ACTUALIZAR_NOTA = "UPDATE notas SET nota = ?, caracteres = ?, tiempoActivo = ? WHERE tituloNota = ?"; 
    private static final String BORRAR_NOTA = "DELETE FROM notas WHERE tituloNota = (?)";
    
    //El valor de esta cadena debe ser 1.
    private static final String CASE_SEGUN_TITULO = "SELECT * FROM notas ORDER BY notas.tituloNota ASC";
    //El valor de esta cadena debe ser 2
    private static final String CASE_SEGUN_LONGITUD = "SELECT * FROM notas ORDER BY notas.caracteres DESC";
    //El valor de esta cadena debe ser 3
    private static final String CASE_SEGUN_TIEMPO_ACTIVO = "SELECT * FROM notas ORDER BY notas.tiempoActivo DESC";
    //El valor de esta cadena debe ser 4;
    private static final String CASE_SEGUN_NOMBRE = "SELECT tituloNota, nota, tiempoActivo FROM notas WHERE tituloNota = (?)";
    
    
    @Override
    public void crearNuevaNota(NotaPOJO nota) {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conexion = createConnection();
            
            preparedStatement = conexion.prepareStatement(NUEVA_NOTA);
            preparedStatement.setString(1, nota.getTitulo());
            preparedStatement.setString(2, nota.getNota());
            preparedStatement.setInt(3, nota.getCantidadCaracteres());
            preparedStatement.setString(4, nota.getTiempoActivo());
            preparedStatement.setString(5, nota.getTitulo());
            
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();    
                }
                if (conexion != null) {
                    conexion.close();
                }
            } 
            catch (SQLException ex) {
                System.out.println(ex);
            }
        }        
    }

    @Override
    public List<NotaPOJO> listarNotas(int nCase) {
        
        ArrayList listadoDeNotas = new ArrayList();
        Connection conexion = createConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        try {
            switch (nCase){
                case 1:
                    preparedStatement = conexion.prepareStatement(CASE_SEGUN_TITULO);
                    break;
                case 2:
                    preparedStatement = conexion.prepareStatement(CASE_SEGUN_LONGITUD);
                    break;
                case 3:
                    preparedStatement = conexion.prepareStatement(CASE_SEGUN_TIEMPO_ACTIVO);
                    break;
                }

            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                String titulo = rs.getString("tituloNota");
                String notax = rs.getString("nota");
                int caracteres = rs.getInt("caracteres");
                String tiempoActivo = rs.getString("tiempoActivo");

                NotaPOJO notaInfo = new NotaPOJO(titulo, notax, caracteres, tiempoActivo);

                listadoDeNotas.add(notaInfo);
            }
        }
        catch(SQLException e){ 
            System.out.println(e); 
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return listadoDeNotas;        
    }
    
    @Override
    public String[] buscarNota(String titulo) {
        
        String [] tituloAndNota = new String[3];
        
        Connection conexion = createConnection();

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = conexion.prepareStatement(CASE_SEGUN_NOMBRE);
            preparedStatement.setString(1, titulo);
            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                String tituloLoad = rs.getString("tituloNota");
                String notax = rs.getString("nota");
                String tiempoActivoX = rs.getString("tiempoActivo");

                tituloAndNota[0] = tituloLoad;
                tituloAndNota[1] = notax;
                tituloAndNota[2] = tiempoActivoX;
            }
        }
        catch(SQLException e){ 
            System.out.println(e); 
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return tituloAndNota;        
    }
    
    @Override
    public void actualizarNotaCreadaAnteriormente(NotaPOJO nota) {

        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conexion = createConnection();
            
            preparedStatement = conexion.prepareStatement(ACTUALIZAR_NOTA);
            preparedStatement.setString(1, nota.getNota());
            preparedStatement.setInt(2, nota.getCantidadCaracteres());
            preparedStatement.setString(3, nota.getTiempoActivo());
            preparedStatement.setString(4, nota.getTitulo());
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();    
                }
                if (conexion != null) {
                    conexion.close();
                }
            } 
            catch (SQLException ex) {
                System.out.println(ex);
            }
        }        
    }

    @Override
    public int getCase(String s){
        int salida = 0;
        switch (s){
            case "Listar según título":
                salida = 1;
                break;
            case "Listar según longitud":
                salida = 2;
                break;
            case "Listar según tiempo activo":
                salida = 3;
                break;
        }
        return salida;
    }

    @Override
    public void borrarNota(String titulo) {
        
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conexion = createConnection();
            
            preparedStatement = conexion.prepareStatement(BORRAR_NOTA);
            preparedStatement.setString(1, titulo);
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();    
                }
                if (conexion != null) {
                    conexion.close();
                }
            } 
            catch (SQLException ex) {
                System.out.println(ex);
            }
        }           
    }

    @Override
    public boolean existTitulo(String titulo) {
        boolean salida = false;
        String[] existeTitulo = buscarNota(titulo);
        
        try{
            if(existeTitulo[0].equals(titulo)){
                salida = true; 
            }
        }catch(NullPointerException ex){
            //System.out.println(ex); #GRAFICAR
        }
        return salida;
    }

}
