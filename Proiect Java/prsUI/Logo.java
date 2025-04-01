/*
 * Logo.java
 *
 * Created on June 27, 2004, 10:31 PM
 */

package prsUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
/**
 *
 * @author  andy
 */
public class Logo {   
    JWindow w;
    /** Creates a new instance of Logo */
    public Logo(JFrame f) {
        JWindow j=new JWindow(f);
        w=j;
        //inconjuram fereastra JWindow cu borduri pt a nu se intrepatrunde cu fundalul
        Border raisedbevel=
        BorderFactory.createRaisedBevelBorder();
        Border loweredbevel = 
        BorderFactory.createLoweredBevelBorder();
        Border compus = BorderFactory.
        createCompoundBorder(raisedbevel, loweredbevel);
        JPanel panu=new JPanel();  //panoul continut
        panu.setBorder(compus);
        panu.setBackground(Color.white);
        //imaginea
        ImageIcon imaginea = new ImageIcon("logo.jpg");
        //eticheta1
        Font font1=new Font("Comic Sans MS",Font.ITALIC,40);
        JLabel eticheta1=new JLabel("IMOBILIARA");
        eticheta1.setFont(font1);
        //eticheta2
        Font font2=new Font("Verdana",Font.BOLD,20);
        JLabel eticheta2=new JLabel("Versiunea 1.0");
        eticheta2.setFont(font2);
        panu.add(eticheta1);
        panu.add(new JLabel(imaginea));
        panu.add(eticheta2);
        j.getContentPane().add(panu);
        //stabilim dimensiunile si pozitionarea logoului
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        j.setLocation(screenSize.width/2-100,screenSize.height/2-75);
        j.setSize(200,150); //dimensiuni
        j.setBackground(Color.white);
        j.show();
        j.toFront();
        j.setVisible(true);           
        
        
    }
    //metoda care elibereaza resursele alocate ferestrei
    public void stop(){
        w.dispose();        
    }
}
