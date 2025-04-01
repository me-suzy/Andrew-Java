/*
 * Agenti.java
 *
 * Created on June 21, 2004, 10:13 AM
 */

package Persistenta;
//import tools.Utilitati;
import java.sql.*;
import java.util.ArrayList;
import java.math.BigDecimal;

/**
 *
 * @author  Andy
 */
public class Agenti {
    public final static int NOU=1;
    public final static int MODIFICAT=2;
    public final static int STERS=3;
    public final static int SINCRONIZAT=4;
    
    protected BigDecimal cnp_ag;
    public String numeag;   
    protected Timestamp data_ang;    
    protected BigDecimal telfixag;
    protected BigDecimal telmobag;
    protected String email;
    protected String zona;
    protected String sucursala;
    
    public oracle.sql.ROWID idLinieBD;
    protected int stare;
    
    public java.math.BigDecimal getcnp_ag(){return this.cnp_ag;}
    public java.lang.String getnumeag(){return this.numeag;}    
    public java.sql.Timestamp getdata_ang(){return this.data_ang;}
    public java.math.BigDecimal gettelfixag(){return this.telfixag;}
    public java.math.BigDecimal gettelmobag(){return this.telmobag;}
    public java.lang.String getemail(){return this.email;}
    public java.lang.String getzona(){return this.zona;}
    public java.lang.String getsucursala(){return this.sucursala;}
    public oracle.sql.ROWID getIdLinieBD(){return this.idLinieBD;}
    
    //Metodele set
    public void setcnp_ag(java.math.BigDecimal valNoua){
        if(valNoua==null ? cnp_ag!=valNoua : valNoua!=null&&!valNoua.equals(cnp_ag)){
            this.cnp_ag=valNoua;
            this.setStare(MODIFICAT);            
        }
    }
    public void setnumeag(java.lang.String valNoua){
        if (valNoua==null ? numeag!=valNoua : !valNoua.equals(numeag)){
            this.numeag=valNoua;
            this.setStare(MODIFICAT);            
        }
    }
    
    public void setdata_ang(java.sql.Timestamp valNoua){
        if(valNoua==null ? data_ang!=valNoua : !valNoua.equals(data_ang)){
            this.data_ang=valNoua;
            this.setStare(MODIFICAT);
        }
    }
    public void settelfixag(java.math.BigDecimal valNoua){
        if(valNoua==null ? telfixag!=valNoua : !valNoua.equals(telfixag)){
            this.telfixag=valNoua;
            this.setStare(MODIFICAT);
        }
    }
    public void settelmobag(java.math.BigDecimal valNoua){
        if(valNoua==null ? telmobag!=valNoua : !valNoua.equals(telmobag)){
            this.telmobag=valNoua;
            this.setStare(MODIFICAT);            
        }
    }
    public void setemail(java.lang.String valNoua){
        if(valNoua==null ? email!=valNoua : !valNoua.equals(email)){
            this.email=valNoua;
            this.setStare(MODIFICAT);
        }
    }
    public void setzona(java.lang.String valNoua){
        if(valNoua==null ? zona!=valNoua : !valNoua.equals(zona)){
            this.zona=valNoua;
            this.setStare(MODIFICAT);
        }
    }
    public void setsucursala(java.lang.String valNoua){
        if(valNoua==null ? sucursala!=valNoua : !valNoua.equals(sucursala)){
            this.sucursala=valNoua;
            this.setStare(MODIFICAT);
        }
    }
    
    public Agenti(){
        this.stare=NOU; 
        this.sucursala="Copou";
    }
    
    
    /** Creates a new instance of agenti */
    public Agenti(oracle.sql.ROWID pIdlinieBD, BigDecimal pcnp_ag, String pnumeag, Timestamp pdata_ang, BigDecimal ptelfixag,BigDecimal ptelmobag, String pemail, String pzona, String psucursala){
        this.idLinieBD=pIdlinieBD;
        this.cnp_ag=pcnp_ag;
        this.numeag=pnumeag;        
        this.data_ang=pdata_ang;
        this.telfixag=ptelfixag;
        this.telmobag=ptelmobag;
        this.email=pemail;
        this.zona=pzona;
        this.sucursala=psucursala;
    }
    public int getStare(){return this.stare;}
    public void setStare(int stareNoua){
        if(this.stare==NOU && stareNoua==MODIFICAT)
            return;
        else
            this.stare=stareNoua;        
    }
    public void salveaza(Connection conn) throws Exception{
        if(this.stare==SINCRONIZAT)
            return;
        boolean conexiuneNula=false;
        if(conn==null){
            conn=Utilitati.getConnection();
            conexiuneNula=true;
        }
        PreparedStatement stmt=null;
        Statement stmtRowid=null;
        try{
            if(this.stare==NOU){
                stmt=conn.prepareStatement("insert into agenti"+"(cnp_ag,numeag,data_ang,telfixag,telmobag,email,zona,sucursala)"+" values (?,?,?,?,?,?,?,?)");
                stmt.setBigDecimal(1, this.cnp_ag);
                stmt.setString(2, this.numeag);                
                stmt.setTimestamp(3,this.data_ang);
                stmt.setBigDecimal(4, this.telfixag);
                stmt.setBigDecimal(5, this.telmobag);
                stmt.setString(6, this.email);
                stmt.setString(7, this.zona);
                stmt.setString(8,this.sucursala);
                stmt.execute();
                //tre' sa se obtina rowid-ul noii inregistrari
                stmtRowid=conn.createStatement();
                oracle.jdbc.OracleResultSet rs=(oracle.jdbc.OracleResultSet)
                    stmtRowid.executeQuery("select rowid from agenti where cnp_ag="+this.cnp_ag.toString());
                rs.next();
                this.idLinieBD=rs.getROWID(1);
                rs.close();
                this.stare=SINCRONIZAT;
            }
            else
                if(this.stare==MODIFICAT){
                    stmt=conn.prepareStatement("update agenti set "+"cnp_ag=?,numeag=?,data_ang=?,telfixag=?,telmobag=?,email=?,zona=?,sucursala=? where rowid=?");
                    stmt.setBigDecimal(1, this.cnp_ag);
                    stmt.setString(2,this.numeag);                    
                    stmt.setTimestamp(3,this.data_ang);
                    stmt.setBigDecimal(4, this.telfixag);
                    stmt.setBigDecimal(5,this.telmobag);
                    stmt.setString(6, this.email);
                    stmt.setString(7, this.zona);
                    stmt.setString(8,this.sucursala);
                    
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
                conn.close();
            if(stmtRowid !=null)
                stmt.close();
            throw e;
        }
        if (conexiuneNula) //daca nu am primit conexiunea, o inchid
            conn.close();      
            
    }
    public void refresh(Connection conn) throws Exception{
        if(this.idLinieBD==null)
            return;
        boolean conexiuneNula=false;
        if(conn==null){
            conn=Utilitati.getConnection();
            conexiuneNula=true;            
        }
        PreparedStatement stmt=null;
        try{
            stmt=conn.prepareStatement("select* from agenti where rowid=?");
            ((oracle.jdbc.OraclePreparedStatement)stmt).setROWID(1, this.idLinieBD);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                this.cnp_ag=rs.getBigDecimal("cnp_ag");
                this.numeag=rs.getString("numeag");                
                this.data_ang=rs.getTimestamp("data_ang");
                this.telfixag=rs.getBigDecimal("telfixag");
                this.telmobag=rs.getBigDecimal("telmobag");
                this.email=rs.getString("email");
                this.zona=rs.getString("zona");
                this.sucursala=rs.getString("sucursala");                
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
            conn=Utilitati.getConnection();
            conexiuneNula=true;
        }
        String frazaSelect="Select rowid,agenti.* from agenti";
        if(whereFiltru!=null)
            frazaSelect +=" "+whereFiltru;
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(frazaSelect);
        ArrayList listaObiecte=new ArrayList();
        try{
            Agenti ag;
            while(rs.next()){
                ag=new Agenti(
                    ((oracle.jdbc.OracleResultSet)rs).getROWID("rowid"), 
                   rs.getBigDecimal("cnp_ag"),
                    rs.getString("numeag"),                    
                    rs.getTimestamp("data_ang"),
                    rs.getBigDecimal("telfixag"),
                    rs.getBigDecimal("telmobag"),
                    rs.getString("email"),
                    rs.getString("zona"),
                    rs.getString("sucursala"));
                    ag.stare=SINCRONIZAT;
                   listaObiecte.add(ag);
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
        return this.getnumeag();
    }
}
    
