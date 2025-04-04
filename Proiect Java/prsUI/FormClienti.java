/*
 * FormPersonal.java
 *
 * Created on June 14, 2004, 10:29 AM
 */

package prsUI;
import persistent.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
import javax.swing.text.*;
/**
 *
 * @author  Andy
 */
public class FormClienti extends javax.swing.JFrame {
    private Connection conexiune;
    private List sursaDateClienti;
    private String[] codpost={"700472","676570","765765","756006","799907"}; 
    private String[] calitate={"vanzator","cumparator"};
    public FormClienti() throws Exception {
        conexiune = Utilitati_.getConnection();
        sursaDateClienti= Clienti.getObjects(conexiune,null);        
        initComponents();
        this.formatGUIElements();
      DefaultComboBoxModel modelCboClienti = new DefaultComboBoxModel(sursaDateClienti.toArray());
      cboClienti.setModel(modelCboClienti);
      DefaultComboBoxModel modelcboCodpost = new DefaultComboBoxModel(codpost);
      cboCodpost.setModel(modelcboCodpost);
      DefaultComboBoxModel modelcboCalitate = new DefaultComboBoxModel(calitate);
      cboCalitate.setModel(modelcboCalitate);
      cboClienti.setSelectedIndex(0);
      this.setSize(400,400);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        cboClienti = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtCodcl = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNumecl = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCnpcl = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        cmdOK = new javax.swing.JButton();
        cmdAbandon = new javax.swing.JButton();
        cmdPrevious = new javax.swing.JButton();
        cmdNext = new javax.swing.JButton();
        cmdNou = new javax.swing.JButton();
        cmdSterge = new javax.swing.JButton();
        txtAdresa = new javax.swing.JFormattedTextField();
        cboCodpost = new javax.swing.JComboBox();
        txtTelfix = new javax.swing.JFormattedTextField();
        txtTelmobil = new javax.swing.JFormattedTextField();
        txtTelBirou = new javax.swing.JFormattedTextField();
        cboCalitate = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        cboClienti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClientiActionPerformed(evt);
            }
        });

        getContentPane().add(cboClienti);
        cboClienti.setBounds(70, 20, 140, 40);

        jLabel1.setText("Codcl");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 110, 40, 15);

        txtCodcl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodclActionPerformed(evt);
            }
        });

        getContentPane().add(txtCodcl);
        txtCodcl.setBounds(130, 110, 80, 21);

        jLabel2.setText("Nume Prenume");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 170, 72, 15);

        getContentPane().add(txtNumecl);
        txtNumecl.setBounds(130, 170, 80, 21);

        jLabel3.setText("Adresa");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 200, 50, 15);

        jLabel4.setText("Codpost");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 230, 50, 15);

        jLabel5.setText("Cnpcl");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 140, 30, 15);

        getContentPane().add(txtCnpcl);
        txtCnpcl.setBounds(130, 140, 80, 21);

        jLabel6.setText("Telefon Fix");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(280, 110, 70, 15);

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

        getContentPane().add(txtAdresa);
        txtAdresa.setBounds(130, 200, 80, 21);

        getContentPane().add(cboCodpost);
        cboCodpost.setBounds(130, 230, 80, 40);

        getContentPane().add(txtTelfix);
        txtTelfix.setBounds(360, 110, 80, 21);

        getContentPane().add(txtTelmobil);
        txtTelmobil.setBounds(360, 140, 80, 21);

        txtTelBirou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelBirouActionPerformed(evt);
            }
        });

        getContentPane().add(txtTelBirou);
        txtTelBirou.setBounds(360, 170, 80, 21);

        getContentPane().add(cboCalitate);
        cboCalitate.setBounds(360, 200, 80, 40);

        jLabel7.setText("Telefon Mobil");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(280, 140, 70, 15);

        jLabel8.setText("Telefon Birou");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(284, 170, 70, 15);

        jLabel9.setText("Calitate");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(290, 210, 60, 15);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("     FORMULAR CLIENTI");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(230, 20, 310, 60);

        pack();
    }//GEN-END:initComponents

    private void txtTelBirouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelBirouActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelBirouActionPerformed

    private void txtCodclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodclActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodclActionPerformed

    private void cmdNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNextActionPerformed
       int indexCurent = cboClienti.getSelectedIndex();
       if (indexCurent < cboClienti.getItemCount()-1)       
           cboClienti.setSelectedIndex(indexCurent+1);
       else
           JOptionPane.showMessageDialog(this,"Ai ajuns la ultima inregistrare!");       
    }//GEN-LAST:event_cmdNextActionPerformed

    private void cmdStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdStergeActionPerformed
        Clienti clienti = (Clienti)cboClienti.getSelectedItem();
        clienti.setStare(Clienti.STERS);
        this.salveazaFormular(clienti);
        
    }//GEN-LAST:event_cmdStergeActionPerformed

    private void cmdNouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNouActionPerformed
        //Clienti clienti = new clienti();
       // clienti.setcodcl(new java.math.BigDecimal(99999));
        //clienti.setnumecl("Client Nou");
        //cboClienti.addItem(clienti);
        //cboClienti.setSelectedItem(clienti);
    }//GEN-LAST:event_cmdNouActionPerformed

    private void cmdAbandonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAbandonActionPerformed
       Clienti clienti = (Clienti)cboClienti.getSelectedItem();
       this.abandon(clienti);
    }//GEN-LAST:event_cmdAbandonActionPerformed

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed
        Clienti clienti = (Clienti)cboClienti.getSelectedItem();
        this.updateFormular(clienti);
        this.salveazaFormular(clienti);
    }//GEN-LAST:event_cmdOKActionPerformed

    private void cboClientiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClientiActionPerformed
      Clienti clienti = (Clienti)cboClienti.getSelectedItem();
      this.refreshFormular(clienti);
    }//GEN-LAST:event_cboClientiActionPerformed

    private void cmdPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPreviousActionPerformed
        int indexCurent = cboClienti.getSelectedIndex();
       if (indexCurent > 0)
           cboClienti.setSelectedIndex(indexCurent-1);
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
        new FormClienti().show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCalitate;
    private javax.swing.JComboBox cboClienti;
    private javax.swing.JComboBox cboCodpost;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JFormattedTextField txtAdresa;
    private javax.swing.JFormattedTextField txtCnpcl;
    private javax.swing.JFormattedTextField txtCodcl;
    private javax.swing.JFormattedTextField txtNumecl;
    private javax.swing.JFormattedTextField txtTelBirou;
    private javax.swing.JFormattedTextField txtTelfix;
    private javax.swing.JFormattedTextField txtTelmobil;
    // End of variables declaration//GEN-END:variables
        private void formatGUIElements(){
       // campuri numerice:
       java.text.DecimalFormat formatInt=new java.text.DecimalFormat("#");
       formatInt.setMinimumFractionDigits(0);
       formatInt.setMaximumIntegerDigits(5);
       this.txtCodcl.setFormatterFactory(new DefaultFormatterFactory(
        new NumberFormatter(formatInt)));
       NumberFormatter formatterCodcl = (NumberFormatter)this.txtCodcl.getFormatter();
       formatterCodcl.setAllowsInvalid(false);         
    }

    private void refreshFormular(Clienti objClienti){
        this.txtCodcl.setValue(objClienti.getcodcl());
        this.txtCnpcl.setValue(objClienti.getcnpcl());
        this.txtNumecl.setValue(objClienti.getnumecl());
        this.txtAdresa.setValue(objClienti.getadresa());
        this.cboCodpost.setSelectedItem(objClienti.getcodpost());
        this.txtTelfix.setValue(objClienti.gettelfix());
        this.txtTelmobil.setValue(objClienti.gettelmobil());
        this.txtTelBirou.setValue(objClienti.gettelbirou());
        this.cboCalitate.setSelectedItem(objClienti.getcalitate());
            }

    private void updateFormular(Clienti objClienti){
        objClienti.setcodcl(new java.math.BigDecimal(txtCodcl.getValue().toString()));
        objClienti.setcnpcl(new java.math.BigDecimal(txtCnpcl.getValue().toString()));
        objClienti.setnumecl(txtNumecl.getValue().toString());
        objClienti.setadresa(txtAdresa.getValue().toString());
        //objClienti.setcodpost(new java.math.BigDecimal(cboCodpost.getValue().toString()));
        objClienti.settelfix(new java.math.BigDecimal(txtTelfix.getValue().toString()));
        objClienti.settelmobil(new java.math.BigDecimal(txtTelmobil.getValue().toString()));
        objClienti.settelbirou(new java.math.BigDecimal(txtTelBirou.getValue().toString()));
        //objClienti.setcalitate(cboCalitate.getValue().toString());
    }
    
    private void abandon(Clienti objClienti){
       if (objClienti.getStare()==Clienti.NOU){  
           this.cboClienti.removeItem(objClienti);
           this.refreshFormular(((Clienti)this.cboClienti.getSelectedItem())); 

       }
       else
           try{
               objClienti.refresh(this.conexiune);
               this.refreshFormular(objClienti);
           }
           catch(Exception e){
              Utilitati_.tratareErori(e);
           }
    }

    private void salveazaFormular(Clienti objClienti){
        try{
            int stare=objClienti.getStare();
            objClienti.salveaza(this.conexiune);
            if (stare==Clienti.STERS){   
                this.cboClienti.removeItemAt(this.cboClienti.getSelectedIndex());
                this.refreshFormular(((Clienti)this.cboClienti.getSelectedItem()));
            }
        }
        catch(Exception e){
            Utilitati_.tratareErori(e);
        }
    }

}
