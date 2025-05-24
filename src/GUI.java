import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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

        JButton button = new JButton("Add Item");
        button.addActionListener(this);
        label = new JLabel("Added items: 0");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 10 , 30, 30));
        panel.setLayout(new GridLayout(0 , 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("To Do List");
        frame.pack();
        frame.setVisible(true);

        field = new JTextField(10);
        panel.add(field, BorderLayout.SOUTH);
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
