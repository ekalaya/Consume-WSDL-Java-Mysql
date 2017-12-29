package cellulanttest;

/**
 *
 * @author Ernest
 *  NAME: ConnectionManager
 * 
 * Description: Class to connect to DB
 * 
 *
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
       //Start Creating Objects of classes
    WriteLog writeLogObject=new WriteLog();
    
    // initialize database constants
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cellulant";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String MAX_POOL = "250";

    // initialize connection object
    private Connection connection;
    // initialize properties object
    private Properties properties;

    // create properties
    private Properties getProperties()
    {
        if (properties == null) 
        {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    // connect to DB
    public Connection connect() 
    {
        if (connection == null) 
        {
            try 
            {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            } 
            
            catch (ClassNotFoundException | SQLException ex) 
            {
            ex.printStackTrace();
            //Write to log
            writeLogObject.LogNow("Error:" +  ex.getMessage() , "severe"); 
            }
        }
        return connection;
    }

    // disconnect DB
    public void disconnect()
    {
        if (connection != null) 
        {
            try 
            {
                connection.close();
                connection = null;
            } 
            
            catch (SQLException ex)
            {
            ex.printStackTrace();
            //Write to log
            writeLogObject.LogNow("Error:" +  ex.getMessage() , "severe"); 
            }
        }
    }
}