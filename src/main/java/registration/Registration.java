package registration;

public class Registration {
    private final int id;
    private final String fullName;
    private final String email;
    private final String studentGroup;
    private final String eventTitle;

    public Registration(int id, String fullName, String email,
                        String studentGroup, String eventTitle) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }
        if (fullName == null || fullName.trim().length() < 3) {
            throw new IllegalArgumentException("Full name must contain at least 3 characters.");
        }
        if (email == null || email.trim().indexOf('@') <= 0
                || email.trim().indexOf('@') == email.trim().length() - 1) {
            throw new IllegalArgumentException("Email must contain text before and after @.");
        }
        if (studentGroup == null || studentGroup.trim().isEmpty()) {
            throw new IllegalArgumentException("Student group must not be blank.");
        }
        if (!"Web Design Workshop".equals(eventTitle)
                && !"JavaScript Quiz".equals(eventTitle)
                && !"IT Career Talk".equals(eventTitle)) {
            throw new IllegalArgumentException("Choose one of the three available events.");
        }
        this.id = id;
        this.fullName = fullName.trim();
        this.email = email.trim();
        this.studentGroup = studentGroup.trim();
        this.eventTitle = eventTitle;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    @Override
    public String toString() {
        return id + " | " + fullName + " | " + email + " | "
                + studentGroup + " | " + eventTitle;
    }
}
