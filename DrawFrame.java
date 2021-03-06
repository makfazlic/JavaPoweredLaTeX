import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Allows the frame drawing.
 *
 * @author Mak Fazlic & Roberto Ferrari - Latex project.
 * @version v1.0
 */

public class DrawFrame extends JFrame
{

    
    private ArrayList<String> latex = new ArrayList<String>();
    
    /**
     * Constructor for objects of class DrawFrame
     * @param funct is a Function Object.
     */
    public DrawFrame(final Function funct) {
        super();
        setTitle("Expression to Latex converter");
        setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1000, 700));
        
        final JPanel panel = new JPanel();

        final JButton convert = new JButton("Convert");   
        convert.setPreferredSize(new Dimension(100, 41));
        convert.setFont(new Font("Verdana", Font.PLAIN, 15));
        convert.setBackground(Color.WHITE);
        final JButton add = new JButton("Add");
        add.setPreferredSize(new Dimension(100, 41));
        add.setFont(new Font("Verdana", Font.PLAIN, 15));
        add.setBackground(Color.WHITE);
        final JButton process = new JButton("Process");
        process.setPreferredSize(new Dimension(100, 41));
        process.setBackground(Color.WHITE);
        process.setFont(new Font("Verdana", Font.PLAIN, 15));
        final JButton help = new JButton("Help");
        help.setPreferredSize(new Dimension(100, 41));
        help.setBackground(Color.WHITE);
        help.setFont(new Font("Verdana", Font.PLAIN, 15));
        
        final JTextField sourcecode = new JTextField(funct.getExpression(), 15);
        final Font bigFont = sourcecode.getFont().deriveFont(Font.PLAIN, 30f);
        sourcecode.setFont(bigFont);        

        panel.add(sourcecode);
        panel.add(convert);
        panel.add(add);
        panel.add(process);
        panel.add(help);
        add(panel, BorderLayout.NORTH);

        
        final JLabel label = new JLabel(funct.getExpression(), SwingConstants.CENTER);
        label.setIcon(new ImageIcon("Background.jpg"));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setForeground(Color.white);
        label.setBounds(100, 100, 100, 100);
        label.setFont(new Font("Verdana", Font.PLAIN, 40));
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        add(label, BorderLayout.CENTER);
        
        
        final JLabel counter = new JLabel(funct.getExpression(), SwingConstants.CENTER);
        counter.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(counter, BorderLayout.SOUTH);
        convert.addActionListener(new ActionListener() { 
            public void actionPerformed(final ActionEvent e) {
                final String text = sourcecode.getText();
                funct.setExpression(text);
                final String newText = funct.getExpression();
                label.setText(newText);
            } 
        }
        );
        
        add.addActionListener(new ActionListener() { 
            public void actionPerformed(final ActionEvent e) {
                if (label.getText().equals("Added!") || label.getText().equals("Convert again!")) {
                    label.setText("Convert again!");
                } else if (label.getText() != null) {
                    latex.add(label.getText());
                    counter.setText("Additions: " + latex.size() + ", Last addition = " 
                                        + label.getText());
                    label.setText("Added!");
                } else {
                    label.setText("No LaTex command to add!");
                } 
            } 
        }
        );
        
        process.addActionListener(new ActionListener() { 
            public void actionPerformed(final ActionEvent e) {
                label.setText("Initialized compilation");
                label.setText(FormLatex.form(latex));
                label.setIcon(null);
                label.setIcon(new ImageIcon("done.jpg"));
            }
        }
        );
        
        help.addActionListener(new ActionListener() { 
            public void actionPerformed(final ActionEvent e) {
                Help.main();
            }
        }
        );
        
        pack();
    }
}
