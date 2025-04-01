/*
 * TestJDBCParametrizat.java
 *
 * Created on June 21, 2004, 4:41 PM
 */

package persistent;
import java.sql.*;
/**
 *
 * @author  andy
 */
public class TestJDBCParametrizat_ {
    
    /** Creates a new instance of TestJDBCParametrizat */
    public TestJDBCParametrizat_() {
    }
    public static void main(String[] args) throws SQLException{
        Connection conexiune=Utilitati_.getConnection();
        conexiune.setAutoCommit(false);
        PreparedStatement pstm=conexiune.prepareStatement("update clienti SET numecl=? "+"where codcl=?");
        Statement stm = conexiune.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet cursor=stm.executeQuery("Select * from clienti");
        while(cursor.next())
            System.out.println("codcl:"+cursor.getString("codcl")+" numecl:"+cursor.getString("numecl"));
        pstm.setString(1,"Client 1001 Modificat");
        pstm.setInt(2,1001);
        pstm.execute();
        cursor=stm.executeQuery("select * from clienti");
        while(cursor.next())
            System.out.println("codcl:"+cursor.getString("codcl")+" numecl:"+cursor.getString("numecl"));
        conexiune.rollback();
        conexiune.close();

    }
    
}

