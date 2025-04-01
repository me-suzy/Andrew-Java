package prsUI;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.sql.*;
import java.math.BigDecimal;
import persistent.*;

public class ModelJTableImobile extends AbstractTableModel {
    public ArrayList listaImobile=new ArrayList();
    public Connection conexiune;
    
    /** Creates a new instance of ModelGridStudenti */
    public ModelJTableImobile(Connection conn){
       this.conexiune=conn;
    }
     public String getColumnName(int column) {
     if (column==0)
         return "Codimobil";
     else if(column==1)
         return "Denimobil";
     else if(column==2)
         return "Zona";
     else if(column==3)
        return "Suprafata";
     else if(column==4)
        return "Confort";
      else if(column==5)
        return "Nr_camere";
      else if(column==6)
        return "Etaj";
      else if(column==7)
        return "Strada";
      else if(column==8)
        return "Blocul";
      else if(column==9)
        return "Apart";
      else if(column==10)
        return "Scara";
      else if(column==11)
        return "Codcl";
      else if(column==12)
        return "Situatie";
     else 
        return "Observatii";
       
     }
    public int getColumnCount() {//nr de coloane
        return 14;
    }
    
    public int getRowCount() {//nr de linii
        return this.listaImobile.size();
    }
    //public Class getColumnClass(int col) {
           // return String.class;
       // else      
           // return BigDecimal.class;
      //}
 public Object getValueAt(int rowIndex, int columnIndex) {
        Imobile objImob=(Imobile)this.listaImobile.get(rowIndex);
     if (columnIndex==0)
         return objImob.getcodimobil();
     else if(columnIndex==1)
         return objImob.getdenimobil();
     else if(columnIndex==2)
         return objImob.getzona();
     else if(columnIndex==3)
        return objImob.getsuprafata();
     else if(columnIndex==4)
        return objImob.getconfort();
     else if(columnIndex==5)
        return objImob.getnr_camere();
     else if(columnIndex==6)
        return objImob.getetaj();
     else if(columnIndex==7)
        return objImob.getstrada();
     else if(columnIndex==8)
        return objImob.getblocul();
     else if(columnIndex==9)
        return objImob.getapart();
     else if(columnIndex==10)
        return objImob.getscara();
     else if(columnIndex==11)
        return objImob.getcodcl();
     else if(columnIndex==12)
        return objImob.getsituatie();
     else
        return objImob.getobservatii(); 
     
    }
 public void setValueAt(Object valNoua, int rowIndex, int columnIndex) {//modific modelul si pun o val protected
    Imobile objImob=(Imobile)this.listaImobile.get(rowIndex);
        
     if (columnIndex==0)
         objImob.setcodimobil((BigDecimal)valNoua);
     else if(columnIndex==1)
         objImob.setdenimobil((String)valNoua);
     else if(columnIndex==2)
        objImob.setzona((String)valNoua);
     else if(columnIndex==3)
        objImob.setsuprafata((BigDecimal)valNoua);
     else if(columnIndex==4)
        objImob.setconfort((BigDecimal)valNoua);
     else if(columnIndex==5)
        objImob.setnr_camere((BigDecimal)valNoua);
     else if(columnIndex==6)
        objImob.setetaj((BigDecimal)valNoua);
     else if(columnIndex==7)
         objImob.setstrada((String)valNoua);
     else if(columnIndex==8)
         objImob.setblocul((String)valNoua);
     else if(columnIndex==9)
        objImob.setapart((BigDecimal)valNoua);
     else if(columnIndex==10)
         objImob.setscara((String)valNoua);
     else if(columnIndex==11)
        objImob.setcodcl((BigDecimal)valNoua);
     else if(columnIndex==11)
         objImob.setsituatie((String)valNoua);
     else 
        objImob.setobservatii((String)valNoua); 
        
     }
     public boolean isCellEditable(int rowIndex, int columnIndex) {
         if (columnIndex==0)
            return false;
         else
            return true;
    }
     
 // zona tranzactionala specfica     
 public void comiteModificari(){
     Imobile objImob=null;
     for (int i=0;i<this.listaImobile.size();i++)
         try{    // incercam salvarea obiectului curent
            objImob=(Imobile)this.listaImobile.get(i);
            int stare=objImob.getStare();
            System.out.println(stare);
            if (stare!=Imobile.SINCRONIZAT)
                objImob.salveaza(this.conexiune);
            // daca nu a dat eroare si era STERS tre' sa-l elimin din colectie
            if (stare==Imobile.STERS)
                this.listaImobile.remove(i);
         }
         catch(Exception e){Utilitati_.tratareErori(e);} 
     }
     
 public void anulezModificari(){
     Imobile objImob=null;
     for (int i=0;i<this.listaImobile.size();i++)
         try{    
            objImob=(Imobile)this.listaImobile.get(i);
            int stare=objImob.getStare();
            if (stare==Imobile.NOU)
                this.listaImobile.remove(i);
            else if (stare!=Imobile.SINCRONIZAT)
                objImob.refresh(this.conexiune);
             }
         catch(Exception e){Utilitati_.tratareErori(e);} 
     }
 public void requeryModel(BigDecimal pcodimobil, BigDecimal codcl){
     try{
        this.listaImobile=Imobile.getObjects(this.conexiune, "where codimobil="+pcodimobil
                                           +"  and codcl="+codcl);
                                           
    }
    catch(Exception e){Utilitati_.tratareErori(e);} 
    
    }
  public void addLinieNoua(BigDecimal codimobil){
        
        Imobile obiectNou=new Imobile(null,codimobil,new String(""),new String(""),BigDecimal.valueOf(0), BigDecimal.valueOf(0),BigDecimal.valueOf(0), BigDecimal.valueOf(0),new String(""),new String(""),BigDecimal.valueOf(0),new String(""),BigDecimal.valueOf(0),new String(""),new String(""));
        this.listaImobile.add(obiectNou);
        
        
    }
    public void stergLinie(int rowIndex){
       Imobile objImob=(Imobile)this.listaImobile.get(rowIndex);
       objImob.setStare(Imobile.STERS);
      }   
}