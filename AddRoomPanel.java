import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoomPanel extends JPanel {
    private JTextField roomNameField;
    private RoomPanel roomPanel;

    public AddRoomPanel(RoomPanel roomPanel) {
        this.roomPanel = roomPanel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        roomNameField = new JTextField(20);

        add(new JLabel("Room Name:"));
        add(roomNameField);

        JButton addButton = new JButton("Add Room");
        addButton.addActionListener(e -> {
            String roomName = roomNameField.getText();
            if (!roomName.isEmpty()) {
                roomPanel.addRoom(new Room(roomName));
                JOptionPane.showMessageDialog(AddRoomPanel.this, "Room added!");
            } else {
                JOptionPane.showMessageDialog(AddRoomPanel.this, "Room name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(addButton);
    }
}
