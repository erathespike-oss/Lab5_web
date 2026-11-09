package registration;

import java.util.ArrayList;

public class RegistrationManager {
    private final ArrayList<Registration> registrations = new ArrayList<>();
    private int nextId = 1;

    public Registration addRegistration(String fullName, String email,
                                        String studentGroup, String eventTitle) {
        // The constructor validates every field before we change the list or ID.
        Registration registration = new Registration(nextId, fullName, email,
                studentGroup, eventTitle);
        registrations.add(registration);
        nextId++;
        return registration;
    }

    public void showAllRegistrations() {
        if (registrations.isEmpty()) {
            System.out.println("No registrations yet.");
            return;
        }
        for (Registration registration : registrations) {
            System.out.println(registration);
        }
    }

    public Registration findById(int id) {
        for (Registration registration : registrations) {
            if (registration.getId() == id) {
                return registration;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        for (int i = 0; i < registrations.size(); i++) {
            if (registrations.get(i).getId() == id) {
                registrations.remove(i);
                return true;
            }
        }
        return false;
    }

    public void showRegistrationsForEvent(String eventTitle) {
        boolean found = false;
        for (Registration registration : registrations) {
            if (registration.getEventTitle().equals(eventTitle)) {
                System.out.println(registration);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No registrations for this event.");
        }
    }
}
