import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Phonebook phoneBook = new Phonebook();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    addEvent();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    searchContact();
                    break;
                case 5:
                    printEventDetails();
                    break;
                case 6:
                    printContactByFN();
                    break;
                case 7:
                    printAllEventsOrdered();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Welcome to the AFA Phonebook!");
        System.out.println("---------------------");
        System.out.println("1. Add a Contact");
        System.out.println("2. Schedule an Event");
        System.out.println("3. Delete a contact");
        System.out.println("4. Search for a contact");
        System.out.println("5. Print event details");
        System.out.println("6. Print contacts by first name");
        System.out.println("7. Print all events alphbetically");
        System.out.println("8. Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void addContact() {
        System.out.print("Enter the contact name: ");
        scanner.nextLine(); // Consume the newline character
        String name = scanner.nextLine();

        System.out.print("Enter the contact phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter the contact email address: ");
        String emailAddress = scanner.nextLine();

        System.out.println("Enter the contact address: ");
        String address = scanner.nextLine();

        System.out.println("Enter the contact birthday: ");
        String birthday = scanner.nextLine();

        System.out.println("Enter notes you want to leave for the contact: ");
        String notes = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, emailAddress, address, birthday, notes);
        phoneBook.addContact(contact);

        System.out.println("Contact added successfully.");
    }

    private static void addEvent() {
        System.out.print("Enter the event title: ");
        String eventTitle = scanner.nextLine();

        System.out.print("Enter the event date and time(MM/DD/YYY HH:MM): ");
        String dateAndTime = scanner.nextLine();

        System.out.println("Enter the event location: ");
        String location = scanner.nextLine();

        System.out.println("Enter the contact name: ");
        Con

        Event event = new Event(eventTitle, dateAndTime, location, contact);
        phoneBook.addEvent(event);

        System.out.println("Event added successfully.");
    }

    private static void displayContacts() {
        System.out.println("Contacts:");
        phoneBook.displayContacts();
    }

    private static void displayEvents() {
        System.out.println("Events:");
        phoneBook.displayEvents();
    }
}