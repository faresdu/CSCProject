public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

       
        Contact contact1 = new Contact("John Doe", "1234567890", "john@example.com", "123 Main St", "1980-01-01");
        Contact contact2 = new Contact("Jane Smith", "9876543210", "jane@example.com", "456 Elm St", "1985-05-05");
        phonebook.addContact(contact1);
        phonebook.addContact(contact2);

        
        phonebook.scheduleEvent(contact1, "Meeting", "2023-09-25 10:00 AM", "Conference Room A");
        phonebook.scheduleEvent(contact2, "Lunch", "2023-09-26 12:30 PM", "Restaurant XYZ");
        phonebook.scheduleEvent(contact1, "Presentation", "2023-09-27 2:00 PM", "Boardroom");

      
        phonebook.printAllEventsOrdered();

        
        Contact foundContact = phonebook.findContactByName("John Doe");
        if (foundContact != null) {
            System.out.println("Contact found: " + foundContact.getName());
        } else {
            System.out.println("Contact not found.");
        }

       
        boolean deleted = phonebook.deleteContact("Jane Smith");
        if (deleted) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
