import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JFrame {
    private RoomPanel roomPanel;

    public AdminPanel() {
        setTitle("Admin Panel");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        roomPanel = new RoomPanel();

        JButton addRoomButton = new JButton("Add Room");
        addRoomButton.addActionListener(e -> {
            AddRoomPanel addRoomPanel = new AddRoomPanel(roomPanel);
            JFrame addRoomFrame = new JFrame("Add Room");
            addRoomFrame.setContentPane(addRoomPanel);
            addRoomFrame.pack();
            addRoomFrame.setVisible(true);
        });

        JButton deleteRoomButton = new JButton("Delete Room");
        deleteRoomButton.addActionListener(e -> {
            DeleteRoomPanel deleteRoomPanel = new DeleteRoomPanel(roomPanel);
            JFrame deleteRoomFrame = new JFrame("Delete Room");
            deleteRoomFrame.setContentPane(deleteRoomPanel);
            deleteRoomFrame.pack();
            deleteRoomFrame.setVisible(true);
        });

        JButton updateRoomStatusButton = new JButton("Change Room Status");
        updateRoomStatusButton.addActionListener(e -> {
            UpdateRoomPanel updateRoomPanel = new UpdateRoomPanel(roomPanel);
            JFrame updateRoomFrame = new JFrame("Change Room Status");
            updateRoomFrame.setContentPane(updateRoomPanel);
            updateRoomFrame.pack();
            updateRoomFrame.setVisible(true);
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(addRoomButton);
        controlPanel.add(deleteRoomButton);
        controlPanel.add(updateRoomStatusButton);

        add(controlPanel, BorderLayout.NORTH);
        add(new JScrollPane(roomPanel), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminPanel adminPanel = new AdminPanel();
            adminPanel.setVisible(true);
        });
    }
}
