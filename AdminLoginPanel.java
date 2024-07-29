import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginPanel extends JFrame {
    private JTextField adminIdField;
    private JPasswordField passwordField;
    private static final String ADMIN_ID = "admin123";
    private static final String ADMIN_PASSWORD = "oop123";

    public AdminLoginPanel() {
        setTitle("Admin Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel adminIdLabel = new JLabel("Admin ID");
        adminIdField = new JTextField();

        JLabel passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());

        add(adminIdLabel);
        add(adminIdField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String adminId = adminIdField.getText();
            String password = new String(passwordField.getPassword());

            if (ADMIN_ID.equals(adminId) && ADMIN_PASSWORD.equals(password)) {
                AdminPanel adminPanel = new AdminPanel();
                adminPanel.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(AdminLoginPanel.this, "Invalid admin ID or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminLoginPanel loginPanel = new AdminLoginPanel();
            loginPanel.setVisible(true);
        });
    }
}
