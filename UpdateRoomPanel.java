import javax.swing.*;
import java.awt.*;

public class UpdateRoomPanel extends JPanel {
    private JTextField roomIdField;
    private JTextField statusField;
    private RoomPanel roomPanel;

    public UpdateRoomPanel(RoomPanel roomPanel) {
        this.roomPanel = roomPanel;
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Room ID:"));
        roomIdField = new JTextField();
        add(roomIdField);

        add(new JLabel("New Status:"));
        statusField = new JTextField();
        add(statusField);

        JButton updateButton = new JButton("Update Status");
        updateButton.addActionListener(e -> updateRoomStatus());
        add(updateButton);
    }

    private void updateRoomStatus() {
        try {
            int roomId = Integer.parseInt(roomIdField.getText().trim()) - 1;
            String newStatus = statusField.getText().trim();
            if (!newStatus.isEmpty()) {
                roomPanel.changeRoomStatus(roomId, newStatus);
                JOptionPane.showMessageDialog(this, "Room status updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Status cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Invalid room ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
