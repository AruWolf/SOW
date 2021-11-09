package sow.dao.factoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import sow.dao.AmbienteDAO;
import sow.dao.NotaDAO;
import sow.dao.factory.DAOFactory;
import sow.dao.impl.SQLSpyAmbienteDAO;
import sow.dao.impl.SQLSpyNotaDAO;

/**
 * Realiza conexion a la BBDD en este caso a SQLSpy. a un .db3
 */
public class SQLSpyFactory extends DAOFactory {
    
    /**
     * El driver que se utiliza org.sqlite.JDBC.
     */
    public static final String DRIVER = "org.sqlite.JDBC";
    
    /**
     * DBURL: nombre de la base de datos donde se realizan los CRUDs.
     */
    public static final String DBURL = "jdbc:sqlite:SQLSpy_sow_database.db3"; 
    
    /**
     * Heredado del patrón JDBC, se encarga de crear la conexión con la BBDD.
     * @return 
     * La conexión a la base de datos especificada según DRIVER y DBURL.
     */
    public static Connection createConnection() {
        Connection conexion = null;
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(DBURL);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return conexion;
    }

    @Override
    public NotaDAO getNotaDAO() {
        return new SQLSpyNotaDAO();
    }

    @Override
    public AmbienteDAO getAmbienteDAO() {
        return new SQLSpyAmbienteDAO();
    }
}
