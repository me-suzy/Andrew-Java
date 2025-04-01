package persistent;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.sql.*;

public class Imobile {
   public final static  int NOU=1;
   public final static  int MODIFICAT=2;
   public final static  int STERS=3;
   public final static  int SINCRONIZAT=4;


protected java.math.BigDecimal   codimobil;
public java.lang.String   denimobil;
public java.lang.String   zona;
protected java.math.BigDecimal   suprafata;
protected java.math.BigDecimal   confort;
protected java.math.BigDecimal   nr_camere;
protected java.math.BigDecimal   etaj;
public java.lang.String   strada;
public java.lang.String   blocul;
protected java.math.BigDecimal   apart;
public java.lang.String   scara;
protected java.math.BigDecimal   codcl;
public java.lang.String   situatie;
public java.lang.String   observatii;

protected oracle.sql.ROWID idLinieBD;
protected int stare;

public Imobile(){this.stare=NOU;}
public Imobile(oracle.sql.ROWID id, BigDecimal pcodimobil, String pdenimobil,String pzona, BigDecimal psuprafata, BigDecimal pconfort, BigDecimal pnr_camere, BigDecimal petaj, String pstrada, String pblocul, BigDecimal papart,String pscara, BigDecimal pcodcl, String psituatie, String pobservatii)
{
 this.idLinieBD=id;
 this.codimobil=pcodimobil;
 this.denimobil=pdenimobil;
 this.zona=pzona;
 this.suprafata=psuprafata;
 this.confort=pconfort;
 this.nr_camere=pnr_camere;
 this.etaj=petaj;
 this.strada=pstrada;
 this.blocul=pblocul;
 this.apart=papart;
 this.scara=pscara;
 this.codcl=pcodcl;
 this.situatie=psituatie;
 this.observatii=pobservatii;
 this.stare=NOU;
}
public int   getStare(){return this.stare;}
  public void  setStare(int stareNoua){
       if (this.stare==NOU && stareNoua==MODIFICAT)
          return;
       else
          this.stare=stareNoua;
   }
  
  public void salveaza(Connection conexiune) throws Exception{
      if (this.stare==SINCRONIZAT)
         return;
      boolean conexiuneNula=false;
      if (conexiune==null)
         {conexiune=Utilitati_.getConnection();
          conexiuneNula=true;
         }
        
        PreparedStatement stmt=null;
        PreparedStatement stmtRowid=null;
      try{
        
      if (this.stare==NOU){
            stmt= conexiune.prepareStatement("insert into imobile" +
                                          "(codimobil,denimobil,zona,suprafata,confort,nr_camere,etaj,strada,blocul,apart,scara,codcl,situatie,observatii) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setBigDecimal(1,this.codimobil);
            stmt.setString(2,this.denimobil);
            stmt.setString(3,this.zona);
            stmt.setBigDecimal(4,this.suprafata);
            stmt.setBigDecimal(5,this.confort);
            stmt.setBigDecimal(6,this.nr_camere);
            stmt.setBigDecimal(7,this.etaj);
            stmt.setString(8,this.strada);
            stmt.setString(9,this.blocul);
            stmt.setBigDecimal(10,this.apart);
            stmt.setString(11,this.scara);
            stmt.setBigDecimal(12,this.codcl);
            stmt.setString(13,this.situatie);
            stmt.setString(14,this.observatii);
            stmt.execute();
            // trebuie sa obtinem rowid-ul noii inregistrari
            stmtRowid=conexiune.prepareStatement("select rowid from pontaje where codimobil=? and codcl=?");
            stmtRowid.setBigDecimal(1, this.codimobil);
            stmtRowid.setBigDecimal(2,this.codcl);
            oracle.jdbc.OracleResultSet rs=(oracle.jdbc.OracleResultSet)stmtRowid.executeQuery();
            rs.next();
            this.idLinieBD=rs.getROWID(1);
            //System.out.print(this.idLinieBD);
            rs.close();
            stmtRowid.close();
            this.stare=SINCRONIZAT;
      }
      else if (this.stare==MODIFICAT){
            stmt=conexiune.prepareStatement("update imobile set "+
                                            "codimobil=?,denimobil=?,zona=?,suprafata=?,confort=?,nr_camere=?,etaj=?,strada=?,blocul=?,apart=?,scara=?,codcl=?,situatie=?,observatii=? where rowid=?");
                                                    
            stmt.setBigDecimal(1,this.codimobil);
            stmt.setString(2,this.denimobil);
            stmt.setString(3,this.zona);
            stmt.setBigDecimal(4,this.suprafata);
            stmt.setBigDecimal(5,this.confort);
            stmt.setBigDecimal(6,this.nr_camere);
            stmt.setBigDecimal(7,this.etaj);
            stmt.setString(8,this.strada);
            stmt.setString(9,this.blocul);
            stmt.setBigDecimal(10,this.apart);
            stmt.setString(11,this.scara);
            stmt.setBigDecimal(12,this.codcl);
            stmt.setString(13,this.situatie);
            stmt.setString(14,this.observatii);
           // pentru setROWID trebuie downcasting 
            ((oracle.jdbc.OraclePreparedStatement)stmt).setROWID(7,this.idLinieBD);
            stmt.execute();
            this.stare=SINCRONIZAT;
      }
      else if (this.stare==STERS){
            stmt=conexiune.prepareStatement("delete from imobile where rowid=?");
            ((oracle.jdbc.OraclePreparedStatement)stmt).setROWID(1,this.idLinieBD);
            stmt.execute();
            this.stare=SINCRONIZAT;
      }
      }// sf. try
      catch(Exception e){e.printStackTrace(); throw e;}
      finally{ 
            if (stmt!=null) stmt.close();
            if (stmtRowid!=null) stmtRowid.close();
            if (conexiuneNula) // daca nu am primit conexiunea o inchid
                 conexiune.close();
            
      }   
      
      
  }
  public void refresh(Connection conn) throws Exception{
       if (conn==null)
            conn=Utilitati_.getConnection();
       PreparedStatement stmt=null;
   try{    
       stmt=conn.prepareStatement("select * from imobile where rowid=?");
       ((oracle.jdbc.OraclePreparedStatement)stmt).setROWID(1,this.idLinieBD);
       ResultSet rs=stmt.executeQuery();
       if (rs.next())
         { this.codimobil=rs.getBigDecimal("codimobil");
           this.denimobil=rs.getString("denimobil");
           this.zona=rs.getString("zona");
           this.suprafata=rs.getBigDecimal("suprafata");
           this.confort=rs.getBigDecimal("confort");
           this.nr_camere=rs.getBigDecimal("nr_camere");
           this.etaj=rs.getBigDecimal("etaj");
           this.strada=rs.getString("strada");
           this.blocul=rs.getString("blocul");
           this.apart=rs.getBigDecimal("apart");
           this.scara=rs.getString("scara");
           this.codcl=rs.getBigDecimal("codcl");
           this.situatie=rs.getString("situatie");
           this.observatii=rs.getString("observatii");
       }
       this.stare=SINCRONIZAT;
       }
   catch(Exception e){throw e;}
   finally{ stmt.close();}
  }
  public static ArrayList getObjects(Connection conn,String whereFiltru) throws Exception{
       if (conn==null)
            conn=Utilitati_.getConnection();
       String frazaSelect="Select rowid,imobile.* from imobile";
       if (whereFiltru!=null)
           frazaSelect +=" "+whereFiltru; 
       
      Statement stmt=null;
        ArrayList listaObiecte=new ArrayList();
  try{ 
      stmt=conn.createStatement();
      ResultSet rs=stmt.executeQuery(frazaSelect);
     
      Imobile i;
      while (rs.next())
      {   i=new Imobile(
                   ((oracle.jdbc.OracleResultSet)rs).getROWID("rowid"),
                   rs.getBigDecimal("codimobil"),
                   rs.getString("denimobil"),
                   rs.getString("zona"),
                   rs.getBigDecimal("suprafata"),
                   rs.getBigDecimal("confort"),
                   rs.getBigDecimal("nr_camere"),
                   rs.getBigDecimal("etaj"),
                   rs.getString("strada"),
                   rs.getString("blocul"),
                   rs.getBigDecimal("apart"),
                   rs.getString("scara"),
                   rs.getBigDecimal("codcl"),
                   rs.getString("situatie"),
                   rs.getString("observatii"));
          i.stare=SINCRONIZAT;
          listaObiecte.add(i);
      }
      
     }
  catch(Exception e){throw e;}
  finally{ 
      stmt.close();
      }
  return listaObiecte; 
  }

  /** metodele get */ 
public java.math.BigDecimal getcodimobil(){ return this.codimobil;}
public java.lang.String getdenimobil(){ return this.denimobil;}
public java.lang.String getzona(){ return this.zona;}
public java.math.BigDecimal getsuprafata(){ return this.suprafata;}
public java.math.BigDecimal getconfort(){ return this.confort;}
public java.math.BigDecimal getnr_camere(){ return this.nr_camere;}
public java.math.BigDecimal getetaj(){ return this.etaj;}
public java.lang.String getstrada(){ return this.strada;}
public java.lang.String getblocul(){ return this.blocul;}
public java.math.BigDecimal getapart(){ return this.apart;}
public java.lang.String getscara(){ return this.scara;}
public java.math.BigDecimal getcodcl(){ return this.codcl;}
public java.lang.String getsituatie(){ return this.situatie;}
public java.lang.String getobservatii(){ return this.observatii;}

/** metodele set */ 
public void setcodimobil(java.math.BigDecimal valNoua){ 
if (valNoua==null ? codimobil!=valNoua : valNoua!=null&&!valNoua.equals(codimobil))
{     this.codimobil=valNoua;
     this.setStare(MODIFICAT);
}}
public void setdenimobil(java.lang.String valNoua){ 
if (valNoua==null ? denimobil!=valNoua : valNoua!=null&&!valNoua.equals(denimobil))
{     this.denimobil=valNoua;
     this.setStare(MODIFICAT);
}}
public void setzona(java.lang.String valNoua){ 
if (valNoua==null ? zona!=valNoua : valNoua!=null&&!valNoua.equals(zona))
{     this.zona=valNoua;
     this.setStare(MODIFICAT);
}}
public void setsuprafata(java.math.BigDecimal valNoua){ 
if (valNoua==null ? suprafata!=valNoua : valNoua!=null&&!valNoua.equals(suprafata))
{     this.suprafata=valNoua;
     this.setStare(MODIFICAT);
}}
public void setconfort(java.math.BigDecimal valNoua){ 
if (valNoua==null ? confort!=valNoua : valNoua!=null&&!valNoua.equals(confort))
{     this.confort=valNoua;
     this.setStare(MODIFICAT);
}}
public void setnr_camere(java.math.BigDecimal valNoua){ 
if (valNoua==null ? nr_camere!=valNoua : valNoua!=null&&!valNoua.equals(nr_camere))
{     this.nr_camere=valNoua;
     this.setStare(MODIFICAT);
}}
public void setetaj(java.math.BigDecimal valNoua){ 
if (valNoua==null ? etaj!=valNoua : valNoua!=null&&!valNoua.equals(etaj))
{     this.etaj=valNoua;
     this.setStare(MODIFICAT);
}}
public void setstrada(java.lang.String valNoua){ 
if (valNoua==null ? strada!=valNoua : valNoua!=null&&!valNoua.equals(strada))
{     this.strada=valNoua;
     this.setStare(MODIFICAT);
}}
public void setblocul(java.lang.String valNoua){ 
if (valNoua==null ? blocul!=valNoua : valNoua!=null&&!valNoua.equals(blocul))
{     this.blocul=valNoua;
     this.setStare(MODIFICAT);
}}
public void setapart(java.math.BigDecimal valNoua){ 
if (valNoua==null ? apart!=valNoua : valNoua!=null&&!valNoua.equals(apart))
{     this.apart=valNoua;
     this.setStare(MODIFICAT);
}}
public void setscara(java.lang.String valNoua){ 
if (valNoua==null ? scara!=valNoua : valNoua!=null&&!valNoua.equals(scara))
{     this.scara=valNoua;
     this.setStare(MODIFICAT);
}}
public void setcodcl(java.math.BigDecimal valNoua){ 
if (valNoua==null ? codcl!=valNoua : valNoua!=null&&!valNoua.equals(codcl))
{     this.codcl=valNoua;
     this.setStare(MODIFICAT);
}}
public void setsituatie(java.lang.String valNoua){ 
if (valNoua==null ? situatie!=valNoua : valNoua!=null&&!valNoua.equals(situatie))
{     this.situatie=valNoua;
     this.setStare(MODIFICAT);
}}
public void setobservatii(java.lang.String valNoua){ 
if (valNoua==null ? observatii!=valNoua : valNoua!=null&&!valNoua.equals(observatii))
{     this.observatii=valNoua;
     this.setStare(MODIFICAT);
}}
}