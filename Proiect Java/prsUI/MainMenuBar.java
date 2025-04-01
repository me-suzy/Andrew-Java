
package prsUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author  Andy
 */
public class MainMenuBar extends JMenuBar{
    JFrame frmParent;
    /** Creates a new instance of MainMenuBar */
    public MainMenuBar() {
        JMenu fileMenu = new JMenu("Formulare");        
        JMenu quitMenu = new JMenu("Quit");
        
        
        JMenuItem openItem = new JMenuItem("Formular Agenti");
        openItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JInternalFrame formAgenti = new JInternalFrame();
                
                formAgenti.setContentPane(new FormPane());
                formAgenti.setSize(300, 300);
                frmParent.getContentPane().add(formAgenti);
                
                formAgenti.setVisible(true);
            }
        });        
        JMenuItem saveItem = new JMenuItem("Formular Clienti");
        saveItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JInternalFrame formClienti = new FormIntern();
                formClienti.setContentPane(new FormPane());
                formClienti.setSize(300, 300);
                frmParent.getContentPane().add(formClienti);
                
                formClienti.setVisible(true);
            }
        });      
        
        JMenuItem closeItem = new JMenuItem("Formular Imobile ");
        closeItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JInternalFrame formClientiImobile = new FormIntern();
              formClientiImobile.setContentPane(new FormPane());
                formClientiImobile.setSize(300, 300);
                frmParent.getContentPane().add(formClientiImobile);
                
                formClientiImobile.setVisible(true);
            }
        });      
        
        
        //Meniul Quit
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setAccelerator(KeyStroke.getKeyStroke('A', 
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        aboutItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Aplicatie realizata de Panzariu Andrei");  
            }
        });
        
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(closeItem);
        
        
        
        quitMenu.add(exitItem);
        quitMenu.add(aboutItem);
        
        add(fileMenu);
        
        add(quitMenu);
    }
    
}
