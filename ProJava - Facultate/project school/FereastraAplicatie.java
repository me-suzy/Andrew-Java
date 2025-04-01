/*
 * meniu.java
 *
 * Created on June 15, 2004, 7:36 PM
 */

/**
 *
 *
 * @author  andy
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;


public class FereastraAplicatie extends JFrame{      
    //variabile de clasa
    static JMenuBar meniuBara;
    Image img;
    int pozitie=230;
    public FereastraAplicatie() throws Exception {
        super("FereastraAplicatie\u0163ie");
        //pozitionam fereastra si-i setam dimensiunile
        Toolkit t=this.getToolkit();
        Dimension marimeEcran=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(pozitie,pozitie,marimeEcran.width-2*pozitie,marimeEcran.height/2-30);
        //setam iconul din coltul stanga sus al ferestrei
        img=t.getImage("icon.jpg");
        this.setIconImage(img);
        this.getContentPane().setLayout(new BorderLayout());
        //construim partile componente
        faMeniu();
        faContinut();
        faBaraStare();
        //specificam modul de reactie al ferestrei la inchidere
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(windowEvent e){
                iesire();                
            }});
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
