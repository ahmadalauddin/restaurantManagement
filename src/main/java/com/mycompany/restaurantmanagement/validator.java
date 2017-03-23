
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahmad
 */
public class validator {
    
    String type;
   // public static Connection conn;
    
    
    public static userData validate(String username, String password) 
    {
        String uname="";
        String passwd="";
        Boolean flag = false;
        String name="";
        String type="";
        
        
        try {
            
            String id = "hr";
            String pass = "hr";
            String host = "jdbc:derby://localhost:1527/hrManagement";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(host, id, pass);
            

        
            
            ResultSet result;
            PreparedStatement ps= conn.prepareStatement("select * from login where USERNAME=?  and PASSWORD=?");
            
            ps.setString(1, username);
            ps.setString(2, password);
            
            result = ps.executeQuery();
            result.next();
            
            uname = result.getString("username");
            passwd = result.getString("password");
            type = result.getString("type");
            name = result.getString("name");
            
            userData p = new userData(type, name, flag);
            
           
            if(username.equals(uname) && password.equals(passwd) )
                flag = true;
            
            else
                flag = false;
                
        } 
        
        
        catch (SQLException ex) {
            Logger.getLogger(validator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(validator.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        userData p = new userData(type, name, flag);
        
        return p;
    }
    
    
    
}
