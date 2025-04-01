/*
 * FormPersonal.java
 *
 * Created on June 14, 2004, 10:29 AM
 */

package prsUI;
import persistenta_.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
import javax.swing.text.*;
/**
 *
 * @author  Andy
 */
public class FormPersonal extends javax.swing.JFrame {
    private Connection conn;
    private List sursaDatePersonal;
    private String[] compartimente={"conta","fin","pers","prod","mark","it"};  
    /** Creates new form FormPersonal */
    public FormPersonal() throws Exception {
        conn = Utilitati_.getConexiune();
        sursaDateClienti= Clienti.getObjects(conn,null);        
        initComponents();
        this.formatGUIElements();
      DefaultComboBoxModel modelCboPersonal = new DefaultComboBoxModel(sursaDatePersonal.toArray());
      cboPersonal.setModel(modelCboPersonal);
      DefaultComboBoxModel modelcboCompart = new DefaultComboBoxModel(compartimente);
      cboCompart.setModel(modelcboCompart);
      cboPersonal.setSelectedIndex(0);
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
        txtClienti = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDatasv = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumepren = new javax.swing.JFormattedTextField();
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

        txtClienti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientiActionPerformed(evt);
            }
        });

        getContentPane().add(txtClienti);
        txtClienti.setBounds(130, 110, 80, 21);

        jLabel2.setText("Nume Prenume");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 170, 72, 15);

        getContentPane().add(txtDatasv);
        txtDatasv.setBounds(130, 170, 80, 21);

        jLabel3.setText("Adresa");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 200, 50, 15);

        jLabel4.setText("Codpost");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 230, 50, 15);

        jLabel5.setText("Cnpcl");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 140, 30, 15);

        getContentPane().add(txtNumepren);
        txtNumepren.setBounds(130, 140, 80, 21);

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

    private void txtClientiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientiActionPerformed

    private void cmdNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNextActionPerformed
       int indexCurent = cboPersonal.getSelectedIndex();
       if (indexCurent < cboPersonal.getItemCount()-1)       
           cboPersonal.setSelectedIndex(indexCurent+1);
       else
           JOptionPane.showMessageDialog(this,"Ai ajuns la ultima inregistrare!");       
    }//GEN-LAST:event_cmdNextActionPerformed

    private void cmdStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdStergeActionPerformed
        Personal personal = (Personal)cboPersonal.getSelectedItem();
        personal.setStare(Personal.STERS);
        this.salveazaFormular(personal);
        
    }//GEN-LAST:event_cmdStergeActionPerformed

    private void cmdNouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNouActionPerformed
        Personal personal = new Personal();
        personal.setMarca(new java.math.BigDecimal(7777));
        personal.setNumepren("Salariat Nou");
        cboPersonal.addItem(personal);
        cboPersonal.setSelectedItem(personal);
    }//GEN-LAST:event_cmdNouActionPerformed

    private void cmdAbandonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAbandonActionPerformed
       Personal personal = (Personal)cboPersonal.getSelectedItem();
       this.abandon(personal);
    }//GEN-LAST:event_cmdAbandonActionPerformed

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed
        Personal personal = (Personal)cboPersonal.getSelectedItem();
        this.updateFormular(personal);
        this.salveazaFormular(personal);
    }//GEN-LAST:event_cmdOKActionPerformed

    private void cboClientiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClientiActionPerformed
      Personal personal = (Personal)cboPersonal.getSelectedItem();
      this.refreshFormular(personal);
    }//GEN-LAST:event_cboClientiActionPerformed

    private void cmdPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPreviousActionPerformed
        int indexCurent = cboPersonal.getSelectedIndex();
       if (indexCurent > 0)
           cboPersonal.setSelectedIndex(indexCurent-1);
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
        new FormPersonal().show();
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
    private javax.swing.JFormattedTextField txtClienti;
    private javax.swing.JFormattedTextField txtDatasv;
    private javax.swing.JFormattedTextField txtNumepren;
    private javax.swing.JFormattedTextField txtTelBirou;
    private javax.swing.JFormattedTextField txtTelfix;
    private javax.swing.JFormattedTextField txtTelmobil;
    // End of variables declaration//GEN-END:variables
        private void formatGUIElements(){
       // date calendaristice:
       java.text.SimpleDateFormat formatData=new java.text.SimpleDateFormat("dd/MM/yyyy");
       formatData.setLenient(false);
       this.txtDatasv.setFormatterFactory(new DefaultFormatterFactory(
        new DateFormatter(formatData)));
       // campuri numerice:
       java.text.DecimalFormat formatInt=new java.text.DecimalFormat("#");
       formatInt.setMinimumFractionDigits(0);
       formatInt.setMaximumIntegerDigits(5);
       this.txtMarca.setFormatterFactory(new DefaultFormatterFactory(
        new NumberFormatter(formatInt)));
       NumberFormatter formatterMarca = (NumberFormatter)this.txtMarca.getFormatter();
       formatterMarca.setAllowsInvalid(false);
       SpinnerNumberModel modelSalOrar = new SpinnerNumberModel(10000, 0, 1000000, 500);
       this.spnSalorar.setModel(modelSalOrar);
       SpinnerNumberModel modelSalOrarco = new SpinnerNumberModel(10000, 0, 1000000, 500);
       this.spnSalorarco.setModel(modelSalOrarco);       
    }

    private void refreshFormular(Personal objPers){
        this.txtMarca.setValue(objPers.getMarca());
        this.txtNumepren.setValue(objPers.getNumepren());
        if (objPers.getDatasv()!=null)
            this.txtDatasv.setValue(objPers.getDatasv());

        else
            this.txtDatasv.setValue(null);
        java.math.BigDecimal val = (objPers.getSalorar()!=null) ? objPers.getSalorar(): 
            new java.math.BigDecimal(0);
        this.spnSalorar.setValue(val);
        val = (objPers.getSalorarco()!=null) ? objPers.getSalorarco(): 
            new java.math.BigDecimal(0);        
        this.spnSalorarco.setValue(val);
        boolean colab=objPers.getColaborator().equals("D") ? true : false;
        this.chkColaborator.setSelected(colab);
        this.cboCompart.setSelectedItem(objPers.getCompart());
    }

    private void updateFormular(Personal objPers){
        objPers.setMarca(new java.math.BigDecimal(txtMarca.getValue().toString()));
        objPers.setNumepren(txtNumepren.getValue().toString());
        objPers.setDatasv(new Timestamp(((java.util.Date)txtDatasv.getValue()).getTime()));
        objPers.setSalorar(new java.math.BigDecimal(spnSalorar.getValue().toString()));
        objPers.setSalorarco(new java.math.BigDecimal(spnSalorarco.getValue().toString()));
        objPers.setCompart((String)this.cboCompart.getSelectedItem());
        objPers.setColaborator(this.chkColaborator.isSelected()==true ? "D" :"N") ;
    }
    
    private void abandon(Personal objPers){
       if (objPers.getStare()==Personal.NOU){  
           this.cboPersonal.removeItem(objPers);
           this.refreshFormular(((Personal)this.cboPersonal.getSelectedItem())); 

       }
       else
           try{
               objPers.refresh(this.conn);
               this.refreshFormular(objPers);
           }
           catch(Exception e){
              Utilitati.tratareErori(e);
           }
    }

    private void salveazaFormular(Personal objPers){
        try{
            int stare=objPers.getStare();
            objPers.salveaza(this.conn);
            if (stare==Personal.STERS){   
                this.cboPersonal.removeItemAt(this.cboPersonal.getSelectedIndex());
                this.refreshFormular(((Personal)this.cboPersonal.getSelectedItem()));
            }
        }
        catch(Exception e){
            Utilitati.tratareErori(e);
        }
    }

}
