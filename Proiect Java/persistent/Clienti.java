/*
 * Clienti.java
 *
 * Created on June 21, 2004, 4:40 PM
 */

package persistent;
//import tools.Utilitati;
import java.sql.*;
import java.util.ArrayList;
import java.math.BigDecimal;

/**
 *
 * @author  Andy
 */
public class Clienti {
    public final static int NOU=1;
    public final static int MODIFICAT=2;
    public final static int STERS=3;
    public final static int SINCRONIZAT=4;
    
    protected BigDecimal codcl;
    protected BigDecimal cnpcl;
    public String numecl;
    protected String adresa;
    protected BigDecimal codpost;
    protected BigDecimal telfix;
    protected BigDecimal telmobil;
   protected BigDecimal telbirou;
    protected String calitate;
    
    public oracle.sql.ROWID idLinieBD;
    protected int stare;
    
    public java.math.BigDecimal getcodcl(){return this.codcl;}
    public java.math.BigDecimal getcnpcl(){return this.cnpcl;}
    public java.lang.String getnumecl(){return this.numecl;}
    public java.lang.String getadresa(){return this.adresa;}
    public java.math.BigDecimal getcodpost(){return this.codpost;} 
    public java.math.BigDecimal gettelfix(){return this.telfix;}
    public java.math.BigDecimal gettelmobil(){return this.telmobil;}
    public java.math.BigDecimal gettelbirou(){return this.telbirou;}
    public java.lang.String getcalitate(){return this.calitate;}
    public oracle.sql.ROWID getIdLinieBD(){return this.idLinieBD;}
    
    //Metodele set
    public void setcodcl(java.math.BigDecimal valNoua){
        if(valNoua==null ? codcl!=valNoua : valNoua!=null&&!valNoua.equals(codcl)){
            this.codcl=valNoua;
            this.setStare(MODIFICAT);            
        }
    }
     public void setcnpcl(java.math.BigDecimal valNoua){
        if(valNoua==null ? cnpcl!=valNoua : valNoua!=null&&!valNoua.equals(cnpcl)){
            this.cnpcl=valNoua;
            this.setStare(MODIFICAT);            
        }
    }
    public void setnumecl(java.lang.String valNoua){
        if (valNoua==null ? numecl!=valNoua : !valNoua.equals(numecl)){
            this.numecl=valNoua;
            this.setStare(MODIFICAT);            
        }
    }
    public void setadresa(java.lang.String valNoua){
        if(valNoua==null ? adresa!=valNoua : !valNoua.equals(adresa)){
            this.adresa=valNoua;
            this.setStare(MODIFICAT);            
        }
    }
    public void setcodpost(java.math.BigDecimal valNoua){
        if(valNoua==null ? codpost!=valNoua : !valNoua.equals(codpost)){
            this.codpost=valNoua;
            this.setStare(MODIFICAT);
        }
    }
    public void settelfix(java.math.BigDecimal valNoua){
        if(valNoua==null ? telfix!=valNoua : !valNoua.equals(telfix)){
            this.telfix=valNoua;
            this.setStare(MODIFICAT);
        }
    }
    public void settelmobil(java.math.BigDecimal valNoua){
        if(valNoua==null ? telmobil!=valNoua : !valNoua.equals(telmobil)){
            this.telmobil=valNoua;
            this.setStare(MODIFICAT);
        }
    }
    public void settelbirou(java.math.BigDecimal valNoua){
        if(valNoua==null ? telbirou!=valNoua : !valNoua.equals(telbirou)){
            this.telbirou=valNoua;
            this.setStare(MODIFICAT);
        }
    }
     public void calitate(java.lang.String valNoua){
        if (valNoua==null ? calitate!=valNoua : !valNoua.equals(calitate)){
            this.calitate=valNoua;
            this.setStare(MODIFICAT);            
        }
    }
    
    //public Clienti(){
      //  this.stare=NOU; 
         //   }
    
    
    /** Creates a new instance of agenti */
     public Clienti(oracle.sql.ROWID pidLinieBD, BigDecimal pcodcl, BigDecimal pcnpcl, String pnumecl, String padresa, BigDecimal pcodpost, BigDecimal ptelfix, BigDecimal ptelmobil, BigDecimal ptelbirou, String pcalitate){
        this.idLinieBD=pidLinieBD;
        this.codcl=pcodcl;
        this.cnpcl=pcnpcl;
        this.numecl=pnumecl;
	this.adresa=padresa;
        this.codpost=pcodpost;
        this.telfix=ptelfix;
        this.telmobil=ptelmobil;
        this.telbirou=ptelbirou;
        this.calitate=pcalitate;
    }
    public int getStare(){return this.stare;}
    public void setStare(int stareNoua){
        if(this.stare==NOU && stareNoua==MODIFICAT)
            return;
        else
            this.stare=stareNoua;        
    }
    public void salveaza(Connection conexiune) throws Exception{
        if(this.stare==SINCRONIZAT)
            return;
        boolean conexiuneNula=false;
        if(conexiune==null){
            conexiune=Utilitati_.getConnection();
            conexiuneNula=true;
        }
        PreparedStatement stmt=null;
        Statement stmtRowid=null;
        try{
            if(this.stare==NOU){
                stmt=conexiune.prepareStatement("insert into clienti"+"(codcl,cnpcl,numecl,adresa,codpost,telfix,telmobil,telbirou,calitate)"+" values (?,?,?,?,?,?,?,?,?)");
                stmt.setBigDecimal(1, this.codcl);
                stmt.setBigDecimal(1, this.cnpcl);
                stmt.setString(2, this.numecl);
                stmt.setString(3, this.adresa);
                stmt.setBigDecimal(4,this.codpost);
                stmt.setBigDecimal(5, this.telfix);
                stmt.setBigDecimal(5, this.telmobil);
                stmt.setBigDecimal(5, this.telbirou);
                stmt.setString(7,this.calitate);
                stmt.execute();
                //trebuie sa se obtina rowid-ul noii inregistrari
                stmtRowid=conexiune.createStatement();
                oracle.jdbc.OracleResultSet rs=(oracle.jdbc.OracleResultSet)
                    stmtRowid.executeQuery("select rowid from clienti where codcl="+this.codcl.toString());
                rs.next();
                this.idLinieBD=rs.getROWID(1);
                rs.close();
                this.stare=SINCRONIZAT;
            }
            else
                if(this.stare==MODIFICAT){
                    stmt=conexiune.prepareStatement("update clienti set "+"codcl=?,cnpcl=?,numecl=?,adresa=?,codpost=?,telfix=?,telmobil=?,telbirou=?,calitate=? where rowid=?");
                    stmt.setBigDecimal(1, this.codcl);
                stmt.setBigDecimal(1, this.cnpcl);
                stmt.setString(2, this.numecl);
                stmt.setString(3, this.adresa);
                stmt.setBigDecimal(4,this.codpost);
                stmt.setBigDecimal(5, this.telfix);
                stmt.setBigDecimal(5, this.telmobil);
                stmt.setBigDecimal(5, this.telbirou);
                stmt.setString(7,this.calitate);
                    
                    //pentru setROWID trebuie downcasting
                    ((oracle.jdbc.OraclePreparedStatement)stmt).setROWID(8,this.idLinieBD);
                    stmt.execute();
                    if(stmt.getUpdateCount()==0)
                        throw new Exception("Inregistrarea nu mai exista in baza de date!!!");
                    this.stare=SINCRONIZAT;                    
                }
            stmt.close();
        }
        catch(Exception e){
            if(stmt!=null)
                stmt.close();
            if(conexiuneNula) //daca nu am primit conexiunea, o inchid
                conexiune.close();
            if(stmtRowid !=null)
                stmt.close();
            throw e;
        }
        if (conexiuneNula) //daca nu am primit conexiunea, o inchid
            conexiune.close();      
            
    }
    public void refresh(Connection conn) throws Exception{
        if(this.idLinieBD==null)
            return;
        boolean conexiuneNula=false;
        if(conn==null){
            conn=Utilitati_.getConnection();
            conexiuneNula=true;            
        }
        PreparedStatement stmt=null;
        try{
            stmt=conn.prepareStatement("select* from agenti where rowid=?");
            ((oracle.jdbc.OraclePreparedStatement)stmt).setROWID(1, this.idLinieBD);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                this.codcl=rs.getBigDecimal("codcl");
                this.cnpcl=rs.getBigDecimal("cnpcl");
                this.numecl=rs.getString("numecl");
                this.adresa=rs.getString("adresa");
                this.codpost=rs.getBigDecimal("codpost");
                this.telfix=rs.getBigDecimal("telfix");
                this.telmobil=rs.getBigDecimal("telmobil");
                this.telbirou=rs.getBigDecimal("telbirou");
                this.calitate=rs.getString("calitate");                
            }
            else // inregistrarea nu mai este in BD
                throw new Exception("Inregistrarea nu mai este in baza de date!!!");
            this.stare=SINCRONIZAT;
            stmt.close();
            if(conexiuneNula)//daca nu am primit conexiunea o inchid
                conn.close();            
        }
        catch(Exception e){
            if(stmt!=null)
                stmt.close();
            if(conexiuneNula)
                conn.close();
            throw e;//trimit eroarea mai departe bloului apelant
        }
    }
    public static ArrayList getObjects(Connection conn,String whereFiltru) throws Exception{
        boolean conexiuneNula=false;
        if(conn==null){
            conn=Utilitati_.getConnection();
            conexiuneNula=true;
        }
        String frazaSelect="Select rowid,clienti.* from clienti";
        if(whereFiltru!=null)
            frazaSelect +=" "+whereFiltru;
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(frazaSelect);
        ArrayList listaObiecte=new ArrayList();
        try{
            Clienti cl;
            while(rs.next()){
                cl=new Clienti(
                    ((oracle.jdbc.OracleResultSet)rs).getROWID("rowid"), 
                   rs.getBigDecimal("codcl"),
                   rs.getBigDecimal("cnpcl"),
                   rs.getString("numecl"),
                   rs.getString("adresa"),
                   rs.getBigDecimal("codpost"),
                   rs.getBigDecimal("telfix"),
                   rs.getBigDecimal("telmobil"),
                   rs.getBigDecimal("telbirou"),
                   rs.getString("calitate"));                   
                   cl.stare=SINCRONIZAT;
                   listaObiecte.add(cl);
            }
            stmt.close();
        }
        catch(Exception e){if(stmt!=null)
            stmt.close();
        throw e;
    }
        if(conexiuneNula)
            conn.close();
        return listaObiecte;
    }
    public String toString(){
        return this.getnumecl();
    }
}
    
