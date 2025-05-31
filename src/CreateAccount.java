import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.Flow;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class CreateAccount {
private JFrame frame;
private JPanel panel;
protected String fieldUserName;
protected String fieldUserPassword;
private JLabel label;

    public CreateAccount(){
        frame = new JFrame();

        label = new JLabel("Create Account");
        label.setPreferredSize(new Dimension(200, 200));
        label.setBorder(new LineBorder(Color.BLACK));

        JButton createAccountButton = new JButton("Create  Aaccount");
        panel = new JPanel();
        panel.add(createAccountButton);
        frame.getContentPane().add(panel);
        panel.setLayout(new FlowLayout());
        panel.add(Box.createHorizontalGlue());
        panel.add(label);
        JTextField userName = new JTextField(10);
        JTextField userPassword = new JTextField(10);
        panel.add(userName, BorderLayout.SOUTH);
        panel.add(userPassword, BorderLayout.NORTH);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Create Account");
        frame.pack();
        frame.setSize(720, 520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        createAccountButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldUserName = userName.getText();
                fieldUserPassword = userPassword.getText();

                if(!(fieldUserName.isEmpty()) && !(fieldUserPassword.isEmpty())){
                    User user = new User();
                    user.name = fieldUserName;
                    user.password = fieldUserPassword;
                    try {
                        FileOutputStream fileOut = new FileOutputStream("UserInfo.ser");
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(user);
                        out.close();
                        fileOut.close();

                        label.setText("Create Account, succesfully created account");
                        userName.setText("");
                        userPassword.setText("");
                        frame = (JFrame) SwingUtilities.getWindowAncestor((Component)e.getSource());
                        new Login();

                    } catch (IOException error){
                        label.setText("Create Account, invalid input");
                    }

                } else {
                    userName.setText("");
                    userPassword.setText("");
                    label.setText("Create Account, failed to create account");
                }
            }
        });
    }
}
