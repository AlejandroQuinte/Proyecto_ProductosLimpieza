 
package Config;

/**
 *
 * @author alequ
 */
public final class Config {
    
    public static String getConnectionString() throws ClassNotFoundException{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            return ("jdbc:sqlserver://localhost;databaseName=DBLimpieza;user=sa;password=sa");
        }
}
