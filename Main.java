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
                    printEvent();
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
        System.out.println("Welcome to AFA Phonebook!");
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
        System.out.println("Enter the event title: ");
        String eventTitle = scanner.next();

        System.out.println("Enter the event date and time(MM/DD/YYYY HH:MM): ");
        String dateAndTime = scanner.next();

        System.out.println("Enter the event location: ");
        String location = scanner.next();

        System.out.println("Enter the contact name: ");
        String contact = scanner.next();
        Contact c = new Contact();
        c.setName(contact);
        if (!phoneBook.existsContact(c)) {
            phoneBook.addContact(c);
        }

        Event event = new Event(eventTitle, dateAndTime, location, c);
        phoneBook.scheduleEvent(event);

        System.out.println("Event added successfully.");
    }

    private static void removeContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        phoneBook.deleteContact(name);
        System.out.println("Contact deleted successfully.");
    }

    private static void searchContact() {

        boolean e = false;
        while (!e) {
            System.out.println("Enter search criteria: ");
            System.out.println(" 1. Name \n 2. Phone Number \n 3. Email Address \n 4. Address \n 5. Exit");
            System.out.println("Enter your choice: ");
            int choicee = scanner.nextInt();
            switch (choicee) {

                case 1:
                    System.out.println("Enter contact name: ");
                    String name = scanner.next();
                    System.out.println("------------");
                    phoneBook.findContactByName(name);
                    System.out.println("------------");
                    break;
                case 2:
                    System.out.println("Enter contact Phone number: ");
                    String phoneNumber = scanner.next();
                    System.out.println("------------");
                    phoneBook.findContactByPhone(phoneNumber);
                    System.out.println("------------");
                    break;
                case 3:
                    System.out.println("Enter contact Email address: ");
                    String email = scanner.next();
                    System.out.println("------------");
                    phoneBook.findContactByEmail(email);
                    System.out.println("------------");
                    break;
                case 4:
                    System.out.println("Enter contact address: ");
                    String address = scanner.next();
                    System.out.println("------------");
                    phoneBook.findContactByAddress(address);
                    System.out.println("------------");
                    break;
                case 5:
                    e = true;
                    break;
                default:
                    System.out.println("Invalid choice please try again.");
                    break;
            }
        }

    }
    private static void printEvent(){
        System.out.println("Enter the event name: ");
        String eventName = scanner.next();
        phoneBook.findEvent(eventName);
    }
    private static void printContactByFN(){
        System.out.println("Enter the first name: ");
        String firstName = scanner.next();
        phoneBook.findContactByName(firstName);
    }
    private static void printAllEventsOrdered(){
        phoneBook.printAllEventsOrdered();
    }

}