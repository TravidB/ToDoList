import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class GUI implements ActionListener {
    ArrayList<String> list = new ArrayList<>();
    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JTextField field;
    protected String fieldInput;

    public GUI()  {
        frame = new JFrame();

        JButton button1 = new JButton("Add Item");
        JButton button2 = new JButton("Remove Item");
        button1.addActionListener(this);
        label = new JLabel("Added items: 0");
        label.setPreferredSize(new Dimension(200, 200));
        label.setBorder(new LineBorder(Color.BLACK));

        panel = new JPanel();
        panel.setLayout(new GridLayout(0 , 1));
        panel.add(button1);
        panel.add(Box.createHorizontalGlue());
        panel.add(button2);
        panel.add(label);
        field = new JTextField(10);
        panel.add(field, BorderLayout.SOUTH);
        

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("To Do List");
        frame.pack();
        frame.setBounds(100, 200, 800, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String [] args){
        new GUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        count++;
        fieldInput = field.getText();
        list.add(fieldInput);
        label.setText("Added items " + count + "    List: " + list);
        field.setText("");
    }
}
