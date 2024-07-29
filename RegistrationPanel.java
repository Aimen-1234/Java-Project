import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegistrationPanel extends JPanel {
    public RegistrationPanel(JFrame frame) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Labels and Text Fields
        JLabel studentIDLabel = new JLabel("Student ID:");
        JTextField studentIDField = new JTextField(20);
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        JLabel batchLabel = new JLabel("Batch:");
        JTextField batchField = new JTextField(20);
        JLabel departmentLabel = new JLabel("Department:");
        JTextField departmentField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton registerButton = new JButton("Register");
        JLabel messageLabel = new JLabel("", JLabel.CENTER);
        JButton switchToLoginButton = new JButton("Go to Login");

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
        add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(batchLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(batchField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(departmentLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(departmentField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);

        gbc.gridy = 6;
        add(messageLabel, gbc);

        gbc.gridy = 7;
        add(switchToLoginButton, gbc);

        // Action Listener for Register Button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = studentIDField.getText();
                String name = nameField.getText();
                String batch = batchField.getText();
                String department = departmentField.getText();
                String password = new String(passwordField.getPassword());

                try {
                    Student student = new Student(studentID, name, batch, department, password);

                    if (student.validate()) {
                        if (LibraryDiscussionRoomSystem.registeredStudents.containsKey(studentID)) {
                            throw new Exception("Student ID already registered.");
                        }
                        LibraryDiscussionRoomSystem.registeredStudents.put(studentID, student);
                        messageLabel.setText("Registration Successful!");
                        messageLabel.setForeground(Color.GREEN);
                        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
                        cl.show(frame.getContentPane(), "Login");
                    } else {
                        throw new Exception("Invalid input! Please check your data.");
                    }
                } catch (Exception ex) {
                    messageLabel.setText(ex.getMessage());
                    messageLabel.setForeground(Color.RED);
                }
            }
        });

        switchToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
                cl.show(frame.getContentPane(), "Login");
            }
        });
    }
}
