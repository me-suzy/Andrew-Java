/*
 * TestJDBCParametrizat.java
 *
 * Created on June 21, 2004, 10:16 AM
 */

package Persistenta;
import java.sql.*;

/**
 *
 * @author  Andy
 */
public class TestJDBCParametrizat {
    
    /** Creates a new instance of TestJDBCParametrizat */
    public TestJDBCParametrizat() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        Connection conn=Utilitati.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement pstm=conn.prepareStatement("update agenti SET numeag=? "+"where cnp_ag=?");
        Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet cursor=stm.executeQuery("Select * from agenti");
        while(cursor.next())
            System.out.println("cnp_ag:"+cursor.getString("cnp_ag")+" numeag:"+cursor.getString("numeag"));
        pstm.setString(1,"Agent 1001 Modificat");
        pstm.setInt(2,1001);
        pstm.execute();
        cursor=stm.executeQuery("select * from agenti");
        while(cursor.next())
            System.out.println("cnp_ag:"+cursor.getString("cnp_ag")+" numeag:"+cursor.getString("numeag"));
        conn.rollback();
        conn.close();

    }
    
}
