import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LibraryDiscussionRoomSystem {
    static Map<String, Student> registeredStudents = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Library Discussion Room System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(660, 500);
        frame.setLayout(new CardLayout());

        RegistrationPanel registrationPanel = new RegistrationPanel(frame);
        LoginPanel loginPanel = new LoginPanel(frame);
        RoomPanel roomPanel = new RoomPanel();

        frame.add(registrationPanel, "Registration");
        frame.add(loginPanel, "Login");
        frame.add(roomPanel, "RoomPanel");

        frame.setVisible(true);
    }
}
