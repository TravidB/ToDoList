import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.HashMap;

//implements ActionListener
public class GUI {
    ArrayList<String> list = new ArrayList<>();
    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JTextField field;
    protected String fieldInput;
    //protected ImageIcon image;

    /**
     * 
     */
    public GUI()  {
        frame = new JFrame();

        //button1.addActionListener(this);
        //button2.addActionListener(this);
        label = new JLabel("Added items: 0");
        label.setPreferredSize(new Dimension(200, 200));
        label.setBorder(new LineBorder(Color.BLACK));

        JButton button1 = new JButton("Add Item");
        JButton button2 = new JButton("Remove Item");
        panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(new FlowLayout());
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
        //frame.setBounds(100, 200, 800, 500);
        //frame.setResizable(false) prevents resize
        frame.setSize(720, 520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        setIcon();

        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                count++;
                fieldInput = field.getText();

                if(fieldInput.equals("")){
                } else {
                    list.add(fieldInput);
                    label.setText("Added items " + count + "    List: " + list);
                }
                field.setText("");
            }
        });

        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                count--;
                fieldInput = field.getText();

                if(!fieldInput.isEmpty()){
                    list.remove(fieldInput);
                    label.setText("Added items " + count + "     List: " + list);
                }

                field.setText("");
            }
        });
    }
    

    private void setIcon(){
        ImageIcon image = new ImageIcon(getClass().getResource("/todoIcon.png"));
        frame.setIconImage(image.getImage());  //change icon 
    }

    public static void main(String [] args) throws IOException{ 
        User user = new User();
        user.name = ("Player");
        user.password = ("Password123");
        //user.sayHello(); 
        FileOutputStream fileOut = new FileOutputStream("UserInfo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(user);
        out.close();
        fileOut.close();
        
        System.out.println("Data Saved!");

        //new GUI();
    }
    
}
