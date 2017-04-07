/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Emil
 */
public class ConnectionManager 
{
    private SQLServerDataSource data;
    
    private static final String configFile = "DatabaseConfig.cfg";
    
    public ConnectionManager() throws IOException
    {
        Properties properties = new Properties();
        properties.load(new FileReader(configFile));
        
        
        data = new SQLServerDataSource();
        data.setServerName(properties.getProperty("SERVER"));
        data.setDatabaseName(properties.getProperty("DATABASE"));
        data.setUser(properties.getProperty("USER"));
        data.setPassword(properties.getProperty("PASSWORD"));
       
    }
    
    public Connection getConnection() throws SQLServerException
    {
        return data.getConnection();
    }
    
    public static void main(String[] args) throws SQLServerException, SQLException, IOException {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        con.close();
    }
}
