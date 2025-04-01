/*
 * TestPersistenta_.java
 *
 * Created on June 21, 2004, 4:42 PM
 */

package persistent;
import java.sql.*;
import java.util.*;
/**
 *
 * @author  andy
 */
public class TestPersistenta_ {
    
    /** Creates a new instance of TestPersistenta_ */
    public TestPersistenta_() {
    }
    public static void main(String[] args) throws Exception {
        Connection conexiune=Utilitati_.getConnection();
        List cl=Clienti.getObjects(conexiune,null);
        Iterator itr=cl.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
        cl=Clienti.getObjects(conexiune,"where codcl=1001");          
       //Clienti clin=(Clienti)clin.get(0);
       //clin.salveaza(conexiune);
       //clin = new Clienti();
       //clin.setcodcl(new java.math.BigDecimal(1013));
       //clin.setcnpcl(new java.math.BigDecimal(9999999));
        //cli.setnumecl("Client 1013");
       // cli.settelmobil(new java.math.BigDecimal(1013));
       // cli.settelfix(new java.math.BigDecimal(1013));
       // cli.settelbirou(new java.math.BigDecimal(1013));
        //cli.setcalitate("");
       // cli.salveaza(conexiune);
       conexiune.close();
            
    }
}
