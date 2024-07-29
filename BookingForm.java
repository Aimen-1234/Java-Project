import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingForm extends JFrame {
    private JTextField studentIdField;
    private JTextField nameField;
    private JTextField departmentField;
    private JTextField batchField;
    private JTextField endTimeHoursField;
    private JTextField endTimeMinutesField;
    private RoomPanel roomPanel;
    private Room room;

    public BookingForm(RoomPanel roomPanel, Room room) {
        this.roomPanel = roomPanel;
        this.room = room;

        setLayout(new GridLayout(7, 2));

        add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        add(studentIdField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Department:"));
        departmentField = new JTextField();
        add(departmentField);

        add(new JLabel("Batch:"));
        batchField = new JTextField();
        add(batchField);

        add(new JLabel("End Time Hours:"));
        endTimeHoursField = new JTextField();
        add(endTimeHoursField);

        add(new JLabel("End Time Minutes:"));
        endTimeMinutesField = new JTextField();
        add(endTimeMinutesField);

        JButton confirmButton = new JButton("Confirm Booking");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    room.book(nameField.getText(), endTimeHoursField.getText() + ":" + endTimeMinutesField.getText(), studentIdField.getText());
                    roomPanel.updateRoomStatus(room);
                    dispose();
                }
            }
        });
        add(confirmButton);

        setSize(400, 300);
    }

    private boolean validateFields() {
        String studentId = studentIdField.getText().trim();
        if (!studentId.matches("^[fF]\\d{8}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Student ID. Must be 9 characters long starting with 'f' followed by digits.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (nameField.getText().trim().isEmpty() || departmentField.getText().trim().isEmpty() ||
            batchField.getText().trim().isEmpty() || endTimeHoursField.getText().trim().isEmpty() ||
            endTimeMinutesField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
