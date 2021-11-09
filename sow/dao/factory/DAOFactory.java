package sow.dao.factory;

import sow.dao.AmbienteDAO;
import sow.dao.NotaDAO;
import sow.dao.factoryImpl.SQLSpyFactory;

/**
 * Clase abstracta que define la estructura a implementar en las clases
 * extendidas. Contiene los final int necesarios según el tipo de base de 
 * datos presentes.
 */
public abstract class DAOFactory {

    /**
     * Número que interpreta una conexión del tipo SQLSpy
     */
    public static final int SQLSpy = 1;
    
    /**
     * Método que devuelve según el tipo de ConcreteFactory (en este caso 
     * del paquete sow.dao.factory.impl) los métodos CRUD según las reglas de
     * la BBDD utilizada en su instancia.
     * @return 
     * Retorna todos los métodos CRUD de la interfaz NotaDao.
     */
    public abstract NotaDAO getNotaDAO();
    
    /**
     * Método que devuelve según el tipo de ConcreteFactory (en este caso 
     * del paquete sow.dao.factory.impl) los métodos CRUD según las reglas de
     * la BBDD utilizada en su instancia.
     * @return 
     * Retorna todos los métodos CRUD de la interfaz AmbienteDao.
     */
    public abstract AmbienteDAO getAmbienteDAO();
    
    /**
     * 
     * @param factory
     * uno de los public static final int de la clase abstracta ej: SQLSpy
     * @return 
     * Concret factory del Abstract factory model
     */
    public static DAOFactory getDAOFactory(int factory) {
        //Modificar código para extender bases de datos
        switch (factory) {
            case SQLSpy:
                return new SQLSpyFactory();
            default:
                return null;
        }
    }
        
}
