import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitRoomPanel extends JFrame {
    private JTextField studentIdField;
    private RoomPanel roomPanel;
    private Room room;

    public ExitRoomPanel(RoomPanel roomPanel, Room room) {
        this.roomPanel = roomPanel;
        this.room = room;

        setLayout(new GridLayout(3, 2));

        add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        add(studentIdField);

        JLabel infoLabel = new JLabel("You have booked the room at " + room.getEndTime() + " o'clock. Click the button to exit the room.");
        add(infoLabel);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (studentIdField.getText().trim().equals(room.getStudentId())) {
                    room.exit();
                    roomPanel.updateRoomStatus(room);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(exitButton);

        setSize(400, 200);
    }
}
