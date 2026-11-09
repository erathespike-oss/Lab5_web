package registration;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private final Scanner scanner;
    private final RegistrationManager manager = new RegistrationManager();

    public Main(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new Main(scanner).run();
        } catch (NoSuchElementException exception) {
            System.out.println("\nInput closed. Goodbye!");
        }
    }

    private void run() {
        while (true) {
            printMenu();
            try {
                int choice = readNumber("Choose an option: ");
                switch (choice) {
                    case 1:
                        addRegistration();
                        break;
                    case 2:
                        manager.showAllRegistrations();
                        break;
                    case 3:
                        findRegistration();
                        break;
                    case 4:
                        deleteRegistration();
                        break;
                    case 5:
                        manager.showRegistrationsForEvent(readEvent());
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Unknown option. Choose 0-5.");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println("\n1. Add registration");
        System.out.println("2. Show all registrations");
        System.out.println("3. Find registration by ID");
        System.out.println("4. Delete registration by ID");
        System.out.println("5. Show registrations for an event");
        System.out.println("0. Exit");
    }

    private void addRegistration() {
        String fullName = readLine("Full name: ");
        String email = readLine("Email: ");
        String group = readLine("Student group: ");
        String event = readEvent();
        Registration registration = manager.addRegistration(fullName, email, group, event);
        System.out.println("Registration created. ID: " + registration.getId());
    }

    private void findRegistration() {
        Registration registration = manager.findById(readId());
        if (registration == null) {
            System.out.println("Registration not found.");
        } else {
            System.out.println(registration);
        }
    }

    private void deleteRegistration() {
        if (manager.deleteById(readId())) {
            System.out.println("Registration deleted.");
        } else {
            System.out.println("Registration not found.");
        }
    }

    private int readId() {
        int id = readNumber("Enter ID: ");
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }
        return id;
    }

    private String readEvent() {
        System.out.println("1. Web Design Workshop");
        System.out.println("2. JavaScript Quiz");
        System.out.println("3. IT Career Talk");
        int choice = readNumber("Select event: ");
        switch (choice) {
            case 1:
                return "Web Design Workshop";
            case 2:
                return "JavaScript Quiz";
            case 3:
                return "IT Career Talk";
            default:
                throw new IllegalArgumentException("Event must be between 1 and 3.");
        }
    }

    private int readNumber(String prompt) {
        try {
            return Integer.parseInt(readLine(prompt).trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Enter a whole number.");
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
