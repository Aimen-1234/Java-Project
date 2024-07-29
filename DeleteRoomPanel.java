import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteRoomPanel extends JPanel {
    private JTextField roomIdField;
    private RoomPanel roomPanel;

    public DeleteRoomPanel(RoomPanel roomPanel) {
        this.roomPanel = roomPanel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        roomIdField = new JTextField(20);

        add(new JLabel("Room ID:"));
        add(roomIdField);

        JButton deleteButton = new JButton("Delete Room");
        deleteButton.addActionListener(e -> {
            try {
                int roomId = Integer.parseInt(roomIdField.getText()) - 1;
                roomPanel.deleteRoom(roomId);
                JOptionPane.showMessageDialog(DeleteRoomPanel.this, "Room deleted!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(DeleteRoomPanel.this, "Invalid room ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(deleteButton);
    }
}
