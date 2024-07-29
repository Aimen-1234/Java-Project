import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    public LoginPanel(JFrame frame) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel studentIDLabel = new JLabel("Student ID:");
        JTextField studentIDField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        JLabel messageLabel = new JLabel("", JLabel.CENTER);
        JButton switchToRegisterButton = new JButton("Go to Registration");

        // Add components to the panel
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(studentIDLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(studentIDField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);

        gbc.gridy = 3;
        add(messageLabel, gbc);

        gbc.gridy = 4;
        add(switchToRegisterButton, gbc);

        // Action Listener for Login Button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = studentIDField.getText();
                String password = new String(passwordField.getPassword());

                try {
                    if (!LibraryDiscussionRoomSystem.registeredStudents.containsKey(studentID)) {
                        throw new Exception("Student ID not registered.");
                    }
                    Student registeredStudent = LibraryDiscussionRoomSystem.registeredStudents.get(studentID);
                    if (registeredStudent.getPassword().equals(password)) {
                        messageLabel.setText("Login Successful!");
                        messageLabel.setForeground(Color.GREEN);

                        // Show RoomPanel on successful login
                        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
                        cl.show(frame.getContentPane(), "RoomPanel");

                    } else {
                        throw new Exception("Invalid password.");
                    }
                } catch (Exception ex) {
                    messageLabel.setText(ex.getMessage());
                    messageLabel.setForeground(Color.RED);
                }
            }
        });

        switchToRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
                cl.show(frame.getContentPane(), "Registration");
            }
        });
    }
}
