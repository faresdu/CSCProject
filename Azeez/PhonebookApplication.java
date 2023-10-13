import java.util.Scanner;
public class PhonebookApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phonebook = new PhoneBook();

        System.out.println("Welcome to the Linked List Phonebook!");
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Add contact");
            System.out.println("2. Delete contact");
            System.out.println("3. Search contact");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter contact details:");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Email address: ");
                    String emailAddress = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Birthday: ");
                    String birthday = scanner.nextLine();
                    System.out.print("Notes: ");
                    String notes = scanner.nextLine();

                    Contact newContact = new Contact(name, phoneNumber, emailAddress, address, birthday, notes);
                    phonebook.addContact(newContact);

                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    System.out.print("Enter the name of the contact you want to delete: ");
                    String deleteName = scanner.nextLine();

                    Contact deleteContact = phonebook.searchContactByName(deleteName);
                    if (deleteContact != null) {
                        phonebook.deleteContact(deleteContact);
                        System.out.println("Contact deleted successfully!");
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter the name of the contact you want to search: ");
                    String searchName = scanner.nextLine();

                    Contact searchContact = phonebook.searchContactByName(searchName);
                    if (searchContact != null) {
                        System.out.println("Contact found:");
                        System.out.println("Name: " + searchContact.getName());
                        System.out.println("Phone number: " + searchContact.getPhoneNumber());
                        System.out.println("Email address: " + searchContact.getEmailAddress());
                        System.out.println("Address: " + searchContact.getAddress());
                        System.out.println("Birthday: " + searchContact.getBirthday());
                        System.out.println("Notes: " + searchContact.getNotes());
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;
                case 4:
                    
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}