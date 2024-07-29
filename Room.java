public class Room {
    private String name;
    private boolean booked;
    private String bookedBy;
    private String endTime;
    private String studentId;

    public Room(String name) {
        this.name = name;
        this.booked = false;
    }

    public String getName() {
        return name;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book(String bookedBy, String endTime, String studentId) {
        this.booked = true;
        this.bookedBy = bookedBy;
        this.endTime = endTime;
        this.studentId = studentId;
    }

    public void exit() {
        this.booked = false;
        this.bookedBy = null;
        this.endTime = null;
        this.studentId = null;
    }

    public String getStatus() {
        return booked ? "Booked by " + bookedBy + " for " + endTime : "Available";
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStudentId() {
        return studentId;
    }
}
