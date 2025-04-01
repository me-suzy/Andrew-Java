/*
 * TestJDBC.java
 *
 * Created on June 21, 2004, 4:41 PM
 */

package persistent;
import java.sql.*;
/**
 *
 * @author  Andy
 */
public class TestJDBC_ {
    
    /** Creates a new instance of TestJDBC */
    public TestJDBC_() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conexiune = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1","scott", "tiger");
        conexiune.setAutoCommit(false);
        Statement stm=conexiune.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet cursor=stm.executeQuery("SELECT c.* FROM Clienti c");
       
        afiseazaCursor(cursor);
	
        Statement stm2=conexiune.createStatement();
        System.out.println(stm2.executeUpdate("update clienti set numecl=numecl||' Mdf'"));
        afiseazaCursor(cursor);       
        conexiune.rollback();
        
        afiseazaCursor(cursor);
       
       stm2.close();
       
       
    }
    static void afiseazaCursor(ResultSet cursor)throws SQLException{
        cursor.beforeFirst();
        System.out.println("Codcl: "+"numecl: "+"calitate: ");
        while(cursor.next())
                System.out.println(cursor.getString("codcl")+ " "+
                cursor.getString("numecl")+" "+
                cursor.getString("calitate"));
    
    }
}
