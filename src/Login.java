
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Login {
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JTextField field;
    protected String fieldNameInput;
    protected String fieldPasswordInput;

    public Login(){
        User savedUser = saveUserData("UserInfo.ser");
        frame = new JFrame();

        label = new JLabel("Login: ");
        label.setPreferredSize(new Dimension(200, 200));
        label.setBorder(new LineBorder(Color.BLACK));

        JButton loginButton = new JButton("Login");
        JButton createButton = new JButton("Create Account");
        panel = new JPanel();
        panel.add(loginButton);
        panel.add(createButton);
        frame.getContentPane().add(panel);
        panel.setLayout(new FlowLayout());
        panel.add(Box.createHorizontalGlue());
        panel.add(label);
        JTextField fieldName = new JTextField(10);
        JTextField fieldPassword = new JTextField(10);
        panel.add(fieldName, BorderLayout.NORTH);
        panel.add(fieldPassword, BorderLayout.SOUTH);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TodoList Login");
        frame.pack();
        frame.setSize(720, 520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

           loginButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldNameInput = fieldName.getText();
                fieldPasswordInput = fieldPassword.getText();

                if(fieldNameInput.equals(savedUser.getName()) && fieldPasswordInput.equals(savedUser.getPassword())){
                    fieldName.setText("");
                    fieldPassword.setText("");
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component)e.getSource());
                    frame.dispose();
                    new GUI();
                } else {
                    label.setText("Login, Try again"); 
                    fieldName.setText("");
                    fieldPassword.setText("");
                }
            }
        });

        createButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = (JFrame) SwingUtilities.getWindowAncestor((Component)e.getSource());
                new CreateAccount();
            }
        });
    }

    private User saveUserData(String fileName) {
        // TODO Auto-generated method stub
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (User) in.readObject();
        } catch (IOException | ClassNotFoundException e){
             System.err.println("Failed to load user: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
