/*
 * TestPersistenta.java
 *
 * Created on June 21, 2004, 10:17 AM
 */

package Persistenta;
import java.sql.*;
import java.util.*;
/**
 *
 * @author  Andy
 */
public class TestPersistenta {
    
    /** Creates a new instance of TestPersistenta */
    public TestPersistenta() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Connection conn=Utilitati.getConnection();
        List angajati=Agenti.getObjects(conn,null);
        Iterator itr=angajati.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
        angajati=Agenti.getObjects(conn,"where cnp_ag=1001");          
        Agenti angajat=(Agenti)angajati.get(0);
        //angajat.setSucursala();
        angajat.salveaza(conn);
        angajat=new Agenti();
        //angajat.setcnpag(new java.math.BigDecimal(100013));
        angajat.setnumeag("Agent 100013");        
        java.text.SimpleDateFormat format= new java.text.SimpleDateFormat("dd/mm/yyyy");
        java.util.Date data= format.parse("30/04/2004");
        angajat.setdata_ang(new java.sql.Timestamp(data.getTime()));
        angajat.salveaza(conn);
       conn.close();
            
    }
    
}
