
package prsUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author  andy
 */
public class FormIntern extends JInternalFrame{
    
    /** Creates a new instance of FormIntern */
    public FormIntern() {          
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(new JLabel("Se va deschide formular..."));
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        this.setSize(200, 200);     
    }
    
}
