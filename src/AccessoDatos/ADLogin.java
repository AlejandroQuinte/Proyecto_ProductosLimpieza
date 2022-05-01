 
package AccessoDatos;

import Config.Config;
import Entidades.Login;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alequ
 */
public class ADLogin {
    //atributos
    private Connection _cnn;
    private String _mensaje;
    Login user = new Login();
//metodos
    public String getMensaje() {
        return _mensaje;
    }
//metodo para crear la coneccion
    public ADLogin() throws Exception {
        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
        } catch (Exception e) {
            throw e;
        }
    }
    
    //metodo para comprobar si existe el usuario enviando un comando sql con usuario y password para ejecutar el procedimiento almacenado de la base de datos
    public int ComprobarLogin(String user, String password)  throws Exception{
        int resultado =-1;
        CallableStatement stmt = null;
        String sentencia;
        try {
            
            
             sentencia = "exec LoginUser ?, ?,?";
             stmt = _cnn.prepareCall(sentencia);
             
             stmt.setString(1, user);
             stmt.setString(2, password);
             stmt.registerOutParameter(3,java.sql.Types.INTEGER);
             
             stmt.execute();
             
             resultado = stmt.getInt(3);
             
             
            stmt.close();
            _cnn.close();
        } catch (Exception e) {
            throw e;
        }
        
        
        
        return resultado;
    }
 
}
