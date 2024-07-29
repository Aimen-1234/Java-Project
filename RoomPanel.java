import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RoomPanel extends JPanel {
    private List<Room> rooms;
    private List<JPanel> roomPanels;
    private List<JLabel> statusLabels;
    private List<JButton> bookButtons;
    private List<JButton> exitButtons;

    public RoomPanel() {
        rooms = new ArrayList<>();
        roomPanels = new ArrayList<>();
        statusLabels = new ArrayList<>();
        bookButtons = new ArrayList<>();
        exitButtons = new ArrayList<>();

        setLayout(new GridLayout(0, 1)); // Use a dynamic grid layout

        // Initial room setup
        for (int i = 0; i < 6; i++) {
            addRoom(new Room("Room " + (i + 1)));
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);

        JPanel roomPanel = new JPanel(new BorderLayout());
        JLabel statusLabel = new JLabel("Status: " + room.getStatus());
        JButton bookButton = new JButton("Book Room");
        JButton exitButton = new JButton("Exit Room");

        bookButton.addActionListener(e -> {
            if (room.isBooked()) {
                JOptionPane.showMessageDialog(null, "Room already booked!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                BookingForm bookingForm = new BookingForm(RoomPanel.this, room);
                bookingForm.setVisible(true);
            }
        });

        exitButton.addActionListener(e -> {
            if (!room.isBooked()) {
                JOptionPane.showMessageDialog(null, "Room is not booked yet!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ExitRoomPanel exitRoomPanel = new ExitRoomPanel(RoomPanel.this, room);
                exitRoomPanel.setVisible(true);
            }
        });

        roomPanel.add(new JLabel(room.getName()), BorderLayout.NORTH);
        roomPanel.add(statusLabel, BorderLayout.CENTER);
        roomPanel.add(bookButton, BorderLayout.SOUTH);
        roomPanel.add(exitButton, BorderLayout.EAST);

        roomPanels.add(roomPanel);
        statusLabels.add(statusLabel);
        bookButtons.add(bookButton);
        exitButtons.add(exitButton);

        add(roomPanel);
        revalidate();
        repaint();
    }

    public void deleteRoom(int roomId) {
        if (roomId >= 0 && roomId < rooms.size()) {
            remove(roomPanels.get(roomId));
            rooms.remove(roomId);
            roomPanels.remove(roomId);
            statusLabels.remove(roomId);
            bookButtons.remove(roomId);
            exitButtons.remove(roomId);

            revalidate();
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "No such room exists", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRoomStatus(Room room) {
        int index = rooms.indexOf(room);
        if (index != -1) {
            statusLabels.get(index).setText("Status: " + room.getStatus());
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void changeRoomStatus(int roomId, String newStatus) {
        if (roomId >= 0 && roomId < rooms.size()) {
            Room room = rooms.get(roomId);
            if (newStatus.equalsIgnoreCase("booked")) {
                room.book("Admin", "End Time", "1234");
            } else if (newStatus.equalsIgnoreCase("available")) {
                room.exit();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid status", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            updateRoomStatus(room);
        } else {
            JOptionPane.showMessageDialog(this, "No such room exists", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
