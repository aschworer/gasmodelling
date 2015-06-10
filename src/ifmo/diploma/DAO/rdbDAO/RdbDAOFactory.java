package ifmo.diploma.DAO.rdbDAO;

import ifmo.diploma.DAO.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class represents DAO Factory Pattern for Relational Database wich allows you to use
 * DB "staff" with given name and login information
 */
public class RdbDAOFactory extends DAOFactory {
    private static Log logger = LogFactory.getLog(RdbDAOFactory.class);

    /**
     * Creates new <code>RdbEmployeeDAO</code> object with current connection settings
     *
     * @return new <code>RdbEmployeeDAO</code> object
     */
    public EmployeeDAO getEmployeeDAO() throws GettingDataFailedException, ConnectionFailedException {
        Connection c = this.createConnection(databaseConnectionProperties);
        return new RdbEmployeeDAO(c);
    }


    public PositionDAO getPositionDAO() throws GettingDataFailedException, ConnectionFailedException {
        Connection c = this.createConnection(databaseConnectionProperties);
        return new RdbPositionDAO(c);
    }

    public DepartmentDAO getDepartmentDAO() throws GettingDataFailedException, ConnectionFailedException {
        Connection c = this.createConnection(databaseConnectionProperties);
        return new RdbDepartmentDAO(c);
    }


    public EmployeeEducationDAO getEmployeeEducationDAO() throws GettingDataFailedException, ConnectionFailedException {
        Connection c = this.createConnection(databaseConnectionProperties);
        return new RdbEmployeeEducationDAO(c);
    }

    /**
     * Method establishes connection with database
     */
    private Connection createConnection(Properties props) {

        String url = (String) props.get("url");
        String userName = (String) props.get("userName");
        String password = (String) props.get("password");
        String database = (String) props.get("dbname");

        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Properties properties = new Properties();
            properties.setProperty("user", userName);
            properties.setProperty("password", password);
            properties.setProperty("useUnicode", "true");
            properties.setProperty("characterEncoding", "UTF-8");
            c = DriverManager.getConnection(url, properties);
            c.createStatement().execute("use " + database + ";");
        } catch (ClassNotFoundException e) {
            logger.error("Driver not found\n" + e.getMessage());
        }
        catch (InstantiationException e) {
            logger.error("InstallationException\n" + e.getMessage());
        }
        catch (IllegalAccessException e) {
            logger.error("Illegal Access\n" + e.getMessage());
        }
        catch (SQLException e) {
            logger.error("\nSQLException caught\n" + e.getMessage());
        }
        return c;
    }

}