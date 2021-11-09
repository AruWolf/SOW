package sow.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sow.dao.AmbienteDAO;
import static sow.dao.factoryImpl.SQLSpyFactory.createConnection;
import sow.dto.AmbientePOJO;

/**
 * Clase encargada de hacer las consultas a la BBDD referido al ambiente
 */
public class SQLSpyAmbienteDAO implements AmbienteDAO {
    
    private static final String NUEVO_AMBIENTE = "INSERT INTO ambiente VALUES (?,?,?,?,?,?,?)";
    private static final String MAX_ID = "SELECT MAX(idAmbiente) FROM ambiente WHERE idAmbiente = idAmbiente";
    private static final String EXISTE_FECHA_DE_CREACION = "SELECT * FROM ambiente WHERE ambiente.ambientesDe = (?)";
    private static final String BUSCAR_FECHA_CREACION = "SELECT creacion FROM ambiente WHERE ambiente.ambientesDe = (?)";
    
    private static final String LISTAR_SEGUN_FECHA_CREAC = "SELECT * FROM ambiente ORDER BY creacion DESC";
    private static final String LISTAR_SEGUN_FECHA_MODIF = "SELECT * FROM ambiente ORDER BY modificacion DESC";
    private static final String LISTAR_SEGUN_EMOC = "SELECT * FROM ambiente ORDER BY estadoAnimico, distractores DESC";
    
    private static final String BORRAR_AMBIENTE = "DELETE FROM ambiente WHERE ambientesDe = (?)";
    
    private static final String ACTUALIZAR_AMBIENTE = "UPDATE ambiente SET estadoAnimico = ?, distractores = ?, benefactores = ? WHERE idAmbiente = ?";
            
            
    
    @Override
    public void crearNuevoAmbiente(AmbientePOJO ambiente) {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        java.sql.Date conversionSQL;
        java.sql.Date conversionSQL2;
        
        try {
            conexion = createConnection();
            
            preparedStatement = conexion.prepareStatement(NUEVO_AMBIENTE);
            
            preparedStatement.setInt(1, maxId()+1);
            preparedStatement.setString(2, ambiente.getAmbienteDe());
            preparedStatement.setString(3, ambiente.getEstadoAnimico());
            preparedStatement.setString(4, ambiente.getDistractores());
            preparedStatement.setString(5, ambiente.getBenefactores());
            
            conversionSQL = new java.sql.Date(ambiente.getDateCreacion().getTime());
            preparedStatement.setDate(6, conversionSQL);
            
            conversionSQL2 = new java.sql.Date(ambiente.getDateModificacion().getTime());
            preparedStatement.setDate(7, conversionSQL2);
            
            
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
    public List<AmbientePOJO> listarNotas(int nCase) {
        
        ArrayList listadoDeAmbientes = new ArrayList();
        Connection conexion = createConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        try {
            switch (nCase){
                case 1:
                    preparedStatement = conexion.prepareStatement(LISTAR_SEGUN_FECHA_CREAC);
                    break;
                case 2:
                    preparedStatement = conexion.prepareStatement(LISTAR_SEGUN_FECHA_MODIF);
                    break;
                case 3:
                    preparedStatement = conexion.prepareStatement(LISTAR_SEGUN_EMOC);
                    break;
                }

            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                int idNota = rs.getInt("idAmbiente");
                String titulo = rs.getString("ambientesDe");
                String estadoAnimico = rs.getString("estadoAnimico");
                String distractores = rs.getString("distractores");
                String benefactores = rs.getString("benefactores");
                
                long creacion = rs.getLong("creacion");
                Date creacionDateType = new Date(creacion);

                long modificacion = rs.getLong("modificacion");
                Date modificaionDateType = new Date(modificacion);
                
                AmbientePOJO ambienteInfo = new AmbientePOJO(
                        idNota, 
                        titulo, 
                        estadoAnimico, 
                        distractores, 
                        benefactores, 
                        creacionDateType, 
                        modificaionDateType);

                listadoDeAmbientes.add(ambienteInfo);
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
        
        return listadoDeAmbientes;        
    }
    
    @Override
    public void actualizarAmbiente(AmbientePOJO ambiente) {

        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conexion = createConnection();
            
            preparedStatement = conexion.prepareStatement(ACTUALIZAR_AMBIENTE);
            preparedStatement.setString(1, ambiente.getEstadoAnimico());
            preparedStatement.setString(2, ambiente.getDistractores());
            preparedStatement.setString(3, ambiente.getBenefactores());
            preparedStatement.setInt(4, ambiente.getIdNota());
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
    public void borrarNota(String ambientesDe) {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conexion = createConnection();
            
            preparedStatement = conexion.prepareStatement(BORRAR_AMBIENTE);
            preparedStatement.setString(1, ambientesDe);
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
    public int maxId(){

        int max = 0;
        ResultSet rs = null;
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conexion = createConnection();
            preparedStatement = conexion.prepareStatement(MAX_ID);
            
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                if (rs.getInt(1) > max){
                    max = rs.getInt(1);
                }
            }
            return max;
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
        return max;
    }

    @Override
    public boolean noTieneFechaDeCreacion(String ambienteDe) {

        String noFueNull = "";
        ResultSet rs = null;
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            conexion = createConnection();
            preparedStatement = conexion.prepareStatement(EXISTE_FECHA_DE_CREACION);
            preparedStatement.setString(1, ambienteDe);
            rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                if (rs.getString(1) != null){
                    noFueNull = "break";
                    break;
                }
            }
            return noFueNull.isEmpty();
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
        return noFueNull.isEmpty();
    }

    @Override
    public Date fechaDeCreacionDe(String ambienteDe) {
        long fechaCreacion;
        Date salida = null;
        ResultSet rs = null;
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        try {
            conexion = createConnection();
            preparedStatement = conexion.prepareStatement(BUSCAR_FECHA_CREACION);
            preparedStatement.setString(1, ambienteDe);
            rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                fechaCreacion = rs.getLong("creacion");
                salida = new Date(fechaCreacion);
                break;
            }
            return salida;
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
        return salida;
    }

    @Override
    public int getCase(String segun) {
        int salida = 0;
        switch (segun){
            case "Listar según fecha":
                salida = 1;
                break;
            case "Listar según modificación":
                salida = 2;
                break;
            case "Listar según emoción":
                salida = 3;
                break;
        }
        return salida;
    }

}
