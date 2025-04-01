/*
 * TestJDBC.java
 *
 * Created on June 21, 2004, 10:15 AM
 */

package Persistenta;
import java.sql.*;
/**
 *
 * @author  Andy
 */
public class TestJDBC {
    
    /** Creates a new instance of TestJDBC */
    public TestJDBC() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1","scott", "tiger");
        conn.setAutoCommit(false);
        Statement stm=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet cursor=stm.executeQuery("SELECT a.* FROM Agenti a");
        afiseazaCursor(cursor);
	
        Statement stm2=conn.createStatement();
        System.out.println(stm2.executeUpdate("update agenti set numeag=numeag||' Mdf'"));
        afiseazaCursor(cursor);       
        conn.rollback();
        
        afiseazaCursor(cursor);
       
       stm2.close();
      
       
    }
    static void afiseazaCursor(ResultSet cursor)throws SQLException{
        cursor.beforeFirst();
        System.out.println("Cnp_ag: "+"numeag: "+"sucursala: ");
        while(cursor.next())
                System.out.println(cursor.getString("cnp_ag")+ " "+
                cursor.getString("numeag")+" "+
                cursor.getString("sucursala"));
    
    }
}
