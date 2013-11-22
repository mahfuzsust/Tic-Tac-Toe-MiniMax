package tic_tac_toe_minmax;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author romeo
 */
public class game_view extends JFrame implements ActionListener{
    
    JButton[][] tic = new JButton[4][4];
    JPanel view = new JPanel();
    JTextArea jt = new JTextArea();
    JScrollPane jp = new JScrollPane(jt);

    public game_view() throws HeadlessException {
        view();
    }
    
    public final void view()
    {
        setVisible(rootPaneCheckingEnabled);
        setSize(390, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j< 3; j++)
            {
                tic[i][j] = new JButton();
                tic[i][j].setBounds((j+1)*73, (i+1)*73, 70, 70);
                add(tic[i][j]);
            }
        }
        
        jt.setBounds(10, 310, 370, 100);
        jp = new JScrollPane(jt);
        add(jt);
        
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
