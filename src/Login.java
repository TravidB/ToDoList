
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Login {
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    protected String fieldNameInput;
    protected String fieldPasswordInput;

    public Login(){
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

                for(User user : userStorage.loadUser()){
                    if(fieldNameInput.equals(user.getName()) && fieldPasswordInput.equals(user.getPassword())){
                        fieldName.setText("");
                        fieldPassword.setText("");
                        frame.dispose();
                        new GUI();
                    } else {
                        label.setText("Login, Try again"); 
                        fieldName.setText("");
                        fieldPassword.setText("");
                    }
                }
            }
        });

        createButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
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
