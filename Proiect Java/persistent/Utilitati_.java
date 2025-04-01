/*
 * Utilitati_.java
 *
 * Created on June 21, 2004, 4:42 PM
 */

package persistent;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author  andy
 */
public class Utilitati_ {
    public static String user="scott";
    public static String password=JOptionPane.showInputDialog(null, "Parola:");
    public static String service="127.0.0.1";
    public static Connection conexiune;
    public static Connection getConnection() throws SQLException{
        if (conexiune==null){
            java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            java.sql.Connection conexiune=java.sql.DriverManager.getConnection("jdbc:oracle:thin:@"+service,user,password);             
        }  
        return conexiune;
    }
    
    
    
    /** Creates a new instance of Utilitati_ */
    public Utilitati_() {
    }
    public static void tratareErori(Exception err){
         if (err instanceof SQLException)
           {   SQLException errSQL=(SQLException)err;
                javax.swing.JOptionPane.showMessageDialog(null,
                        errSQL.getErrorCode()+":"+err.getMessage(),
                         "Eroare SQL!",javax.swing.JOptionPane.ERROR_MESSAGE);
            }
         else if (err instanceof NumberFormatException)
         { javax.swing.JOptionPane.showMessageDialog(null,
                        "Sirul de char. introdus nu corespunde unui numar zecimal !",
                         "Acest camp accepta doar valori numerice.",javax.swing.JOptionPane.ERROR_MESSAGE);
         }
         else if (err instanceof java.text.ParseException)
         { javax.swing.JOptionPane.showMessageDialog(null,
                        "Sirul de char. introdus nu corespunde unei date calend. valide !",
                         "Acest camp accepta doar valori in format dd/mm/yyyy.",javax.swing.JOptionPane.ERROR_MESSAGE);
         }
         else
            javax.swing.JOptionPane.showMessageDialog(null,err.getMessage(),
                         "Eroare Non-SQL!",javax.swing.JOptionPane.ERROR_MESSAGE);
           
    err.printStackTrace();
    }
    
}
