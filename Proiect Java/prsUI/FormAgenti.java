/*
 * FormPersonal.java
 *
 * Created on June 14, 2004, 10:29 AM
 */

package prsUI;
import Persistenta.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
import javax.swing.text.*;
/**
 *
 * @author  Andy
 */
public class FormAgenti extends javax.swing.JFrame {
    private Connection conn;
    private List sursaDateAgenti;
    private String[] zona={"Copou","Pacurari","Centru","Nicolina","Tatarasi"}; 
    private String[] sucursala={"Copou","Tatarasi"};
    public FormAgenti() throws Exception {
        conn = Utilitati.getConnection();
        sursaDateAgenti= Agenti.getObjects(conn,null);        
        initComponents();
        this.formatGUIElements();
      DefaultComboBoxModel modelCboAgenti = new DefaultComboBoxModel(sursaDateAgenti.toArray());
      cboAgenti.setModel(modelCboAgenti);
      DefaultComboBoxModel modelcboZona = new DefaultComboBoxModel(zona);
      cboZona.setModel(modelcboZona);
      DefaultComboBoxModel modelcboSucursala = new DefaultComboBoxModel(sucursala);
      cboSucursala.setModel(modelcboSucursala);
      cboAgenti.setSelectedIndex(0);
      this.setSize(400,400);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        cboAgenti = new javax.swing.JComboBox();
        txtCnp_ag = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtData_ang = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNumeag = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        cmdOK = new javax.swing.JButton();
        cmdAbandon = new javax.swing.JButton();
        cmdPrevious = new javax.swing.JButton();
        cmdNext = new javax.swing.JButton();
        cmdNou = new javax.swing.JButton();
        cmdSterge = new javax.swing.JButton();
        txttelfixag = new javax.swing.JFormattedTextField();
        txtTelmobag = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JFormattedTextField();
        cboZona = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboSucursala = new javax.swing.JComboBox();

        getContentPane().setLayout(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        cboAgenti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgentiActionPerformed(evt);
            }
        });

        getContentPane().add(cboAgenti);
        cboAgenti.setBounds(70, 20, 140, 40);

        txtCnp_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCnp_agActionPerformed(evt);
            }
        });

        getContentPane().add(txtCnp_ag);
        txtCnp_ag.setBounds(130, 110, 80, 21);

        jLabel2.setText("Nume Prenume");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 140, 72, 15);

        getContentPane().add(txtData_ang);
        txtData_ang.setBounds(130, 170, 80, 21);

        jLabel5.setText("Cnp Agent");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 110, 60, 15);

        getContentPane().add(txtNumeag);
        txtNumeag.setBounds(130, 140, 80, 21);

        jLabel6.setText("Telefon Fix");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 200, 70, 15);

        cmdOK.setText("OK");
        cmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOKActionPerformed(evt);
            }
        });

        getContentPane().add(cmdOK);
        cmdOK.setBounds(290, 250, 47, 23);

        cmdAbandon.setText("Abandon");
        cmdAbandon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAbandonActionPerformed(evt);
            }
        });

        getContentPane().add(cmdAbandon);
        cmdAbandon.setBounds(470, 140, 90, 23);

        cmdPrevious.setText("<");
        cmdPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPreviousActionPerformed(evt);
            }
        });

        getContentPane().add(cmdPrevious);
        cmdPrevious.setBounds(70, 70, 39, 23);

        cmdNext.setText(">");
        cmdNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNextActionPerformed(evt);
            }
        });

        getContentPane().add(cmdNext);
        cmdNext.setBounds(170, 70, 40, 23);

        cmdNou.setText("Nou");
        cmdNou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNouActionPerformed(evt);
            }
        });

        getContentPane().add(cmdNou);
        cmdNou.setBounds(490, 110, 51, 23);

        cmdSterge.setText("Sterge");
        cmdSterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdStergeActionPerformed(evt);
            }
        });

        getContentPane().add(cmdSterge);
        cmdSterge.setBounds(390, 250, 65, 23);

        txttelfixag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelfixagActionPerformed(evt);
            }
        });

        getContentPane().add(txttelfixag);
        txttelfixag.setBounds(130, 200, 80, 21);

        getContentPane().add(txtTelmobag);
        txtTelmobag.setBounds(130, 230, 80, 21);

        getContentPane().add(txtEmail);
        txtEmail.setBounds(360, 110, 80, 21);

        cboZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboZonaActionPerformed(evt);
            }
        });

        getContentPane().add(cboZona);
        cboZona.setBounds(360, 140, 80, 40);

        jLabel7.setText("Telefon Mobil");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 230, 70, 15);

        jLabel8.setText("Email");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(300, 110, 40, 15);

        jLabel9.setText("Zona");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(300, 150, 40, 15);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("     FORMULAR AGENTI");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(230, 20, 310, 60);

        jLabel1.setText("Data Angajarii");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 170, 70, 15);

        jLabel3.setText("Sucursala");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(300, 200, 50, 15);

        cboSucursala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSucursalaActionPerformed(evt);
            }
        });

        getContentPane().add(cboSucursala);
        cboSucursala.setBounds(360, 190, 80, 41);

        pack();
    }//GEN-END:initComponents

    private void cboSucursalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSucursalaActionPerformed
        Agenti agenti = (Agenti)cboSucursala.getSelectedItem();
      this.refreshFormular(agenti);
    }//GEN-LAST:event_cboSucursalaActionPerformed

    private void cboZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboZonaActionPerformed
       Agenti agenti = (Agenti)cboZona.getSelectedItem();
      this.refreshFormular(agenti);
    }//GEN-LAST:event_cboZonaActionPerformed

    private void txttelfixagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelfixagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelfixagActionPerformed

    private void txtCnp_agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCnp_agActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCnp_agActionPerformed

    private void cmdNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNextActionPerformed
       int indexCurent = cboAgenti.getSelectedIndex();
       if (indexCurent < cboAgenti.getItemCount()-1)       
           cboAgenti.setSelectedIndex(indexCurent+1);
       else
           JOptionPane.showMessageDialog(this,"Ai ajuns la ultima inregistrare!");       
    }//GEN-LAST:event_cmdNextActionPerformed

    private void cmdStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdStergeActionPerformed
        Agenti agenti = (Agenti)cboAgenti.getSelectedItem();
        agenti.setStare(Agenti.STERS);
        this.salveazaFormular(agenti);
        
    }//GEN-LAST:event_cmdStergeActionPerformed

    private void cmdNouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNouActionPerformed
        Agenti agenti = new Agenti();
        //agenti.setCnp_ag(new java.math.BigDecimal(888888));
        //agenti.setNumeag("Agent Nou");
        cboAgenti.addItem(agenti);
        cboAgenti.setSelectedItem(agenti);
    }//GEN-LAST:event_cmdNouActionPerformed

    private void cmdAbandonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAbandonActionPerformed
       Agenti agenti = (Agenti)cboAgenti.getSelectedItem();
       this.abandon(agenti);
    }//GEN-LAST:event_cmdAbandonActionPerformed

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed
        Agenti agenti = (Agenti)cboAgenti.getSelectedItem();
        this.updateFormular(agenti);
        this.salveazaFormular(agenti);
    }//GEN-LAST:event_cmdOKActionPerformed

    private void cboAgentiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgentiActionPerformed
      Agenti agenti = (Agenti)cboAgenti.getSelectedItem();
      this.refreshFormular(agenti);
    }//GEN-LAST:event_cboAgentiActionPerformed

    private void cmdPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPreviousActionPerformed
        int indexCurent = cboAgenti.getSelectedIndex();
       if (indexCurent > 0)
           cboAgenti.setSelectedIndex(indexCurent-1);
       else
           JOptionPane.showMessageDialog(this,"Ai ajuns la prima inregistrare!");  
    }//GEN-LAST:event_cmdPreviousActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        new FormAgenti().show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboAgenti;
    private javax.swing.JComboBox cboSucursala;
    private javax.swing.JComboBox cboZona;
    private javax.swing.JButton cmdAbandon;
    private javax.swing.JButton cmdNext;
    private javax.swing.JButton cmdNou;
    private javax.swing.JButton cmdOK;
    private javax.swing.JButton cmdPrevious;
    private javax.swing.JButton cmdSterge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JFormattedTextField txtCnp_ag;
    private javax.swing.JFormattedTextField txtData_ang;
    private javax.swing.JFormattedTextField txtEmail;
    private javax.swing.JFormattedTextField txtNumeag;
    private javax.swing.JFormattedTextField txtTelmobag;
    private javax.swing.JFormattedTextField txttelfixag;
    // End of variables declaration//GEN-END:variables
        private void formatGUIElements(){
            // date calendaristice:
       java.text.SimpleDateFormat formatData=new java.text.SimpleDateFormat("dd/MM/yyyy");
       formatData.setLenient(false);
       this.txtData_ang.setFormatterFactory(new DefaultFormatterFactory(
        new DateFormatter(formatData)));
       // campuri numerice:
       java.text.DecimalFormat formatInt=new java.text.DecimalFormat("#");
       formatInt.setMinimumFractionDigits(0);
       formatInt.setMaximumIntegerDigits(5);
       this.txtCnp_ag.setFormatterFactory(new DefaultFormatterFactory(
        new NumberFormatter(formatInt)));
       NumberFormatter formatterCnp_ag = (NumberFormatter)this.txtCnp_ag.getFormatter();
       formatterCnp_ag.setAllowsInvalid(false);         
    }

    private void refreshFormular(Agenti objAgenti){
        this.txtCnp_ag.setValue(objAgenti.getcnp_ag());
        this.txtNumeag.setValue(objAgenti.getnumeag());
        this.txtData_ang.setValue(objAgenti.getdata_ang());
        this.txttelfixag.setValue(objAgenti.gettelfixag());
        this.txtTelmobag.setValue(objAgenti.gettelmobag());
        this.txtEmail.setValue(objAgenti.getemail());
        //this.cboZona.setValue(objAgenti.getzona());
        //this.cboSucursala.setValue(objAgenti.getsucursala());
         }

    private void updateFormular(Agenti objAgenti){
        objAgenti.setcnp_ag(new java.math.BigDecimal(txtCnp_ag.getValue().toString()));
        objAgenti.setnumeag(txtNumeag.getValue().toString());
        objAgenti.setdata_ang(new Timestamp(((java.util.Date)txtData_ang.getValue()).getTime()));        
        objAgenti.settelfixag(new java.math.BigDecimal(txttelfixag.getValue().toString()));
        objAgenti.settelmobag(new java.math.BigDecimal(txtTelmobag.getValue().toString()));
        objAgenti.setemail(txtEmail.getValue().toString());
        //objAgenti.setzona(cboZona.getValue().toString());
        //objAgenti.setsucursala(cboSucursala.getValue().toString());
    }
    
    private void abandon(Agenti objAgenti){
       if (objAgenti.getStare()==Agenti.NOU){  
           this.cboAgenti.removeItem(objAgenti);
           this.refreshFormular(((Agenti)this.cboAgenti.getSelectedItem())); 

       }
       else
           try{
               objAgenti.refresh(this.conn);
               this.refreshFormular(objAgenti);
           }
           catch(Exception e){
              //Utilitati.tratareErori(e);
           }
    }

    private void salveazaFormular(Agenti objAgenti){
        try{
            int stare=objAgenti.getStare();
            objAgenti.salveaza(this.conn);
            if (stare==Agenti.STERS){   
                this.cboAgenti.removeItemAt(this.cboAgenti.getSelectedIndex());
                this.refreshFormular(((Agenti)this.cboAgenti.getSelectedItem()));
            }
        }
        catch(Exception e){
            Utilitati.tratareErori(e);
        }
    }

}
