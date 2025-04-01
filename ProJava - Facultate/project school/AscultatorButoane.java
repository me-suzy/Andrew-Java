/*
 * AscultatorButoane.java
 *
 * Created on June 15, 2004, 8:14 PM
 */

/**
 *
 * @author  andy
 */
public class AscultatorButoane implements ActionListener {
public void actionPerformed(actionEvent e){
    String numeButon=e.getActionComand();
    iesire.addActionListener(new AscultatorButoane());
    iesire.addActionListener(new TratareIesire());
}
}
iesire.addActionListener(new ActionListener){
    public void actionPerformed(ActionEvent e
    String numeButon=e.getActionCommand()
    System.out.println("ati apasat butonul "+numeButon))
}
