import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private PhoneBook phoneBook = new PhoneBook();
    private JTextArea outputTextArea;

    public MainGUI() {
        setTitle("Phone Book Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create output text area
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Add Contact button
        JButton addContactButton = new JButton("Add a contact");
        addContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });
        buttonPanel.add(addContactButton);

        // Search Contact button
        JButton searchContactButton = new JButton("Search for a contact");
        searchContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchContact();
            }
        });
        buttonPanel.add(searchContactButton);

        // Delete Contact button
        JButton deleteContactButton = new JButton("Delete a contact");
        deleteContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });
        buttonPanel.add(deleteContactButton);

        // Schedule Event button
        JButton scheduleEventButton = new JButton("Schedule an event");
        scheduleEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleEvent();
            }
        });
        buttonPanel.add(scheduleEventButton);

        // Print Event Details button
        JButton printEventDetailsButton = new JButton("Print event details");
        printEventDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printEventDetails();
            }
        });
        buttonPanel.add(printEventDetailsButton);

        // Print Contacts by First Name button
        JButton printContactsByFirstNameButton = new JButton("Print contacts by first name");
        printContactsByFirstNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printContactsByFirstName();
            }
        });
        buttonPanel.add(printContactsByFirstNameButton);

        // Print All Events Alphabetically button
        JButton printAllEventsButton = new JButton("Print all events alphabetically");
        printAllEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printAllEventsAlphabetically();
            }
        });
        buttonPanel.add(printAllEventsButton);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void addContact() {
        String name = JOptionPane.showInputDialog(this, "Enter contact name:");
        String phoneNumber = JOptionPane.showInputDialog(this, "Enter contact phone number:");
        String email = JOptionPane.showInputDialog(this, "Enter contact email:");
        String address = JOptionPane.showInputDialog(this, "Enter contact address:");
        String birthday = JOptionPane.showInputDialog(this, "Enter contact birthday:");
        String notes = JOptionPane.showInputDialog(this, "Enter contact notes:");

        Contact contact = new Contact(name, phoneNumber, email, address, birthday, notes );
        phoneBook.addContact(contact);

        outputTextArea.append("Contact added successfully.\n");
    }

    private void searchContact() {
        String name = JOptionPane.showInputDialog(this, "Enter contact name to search:");

        Contact contact = phoneBook.searchContactByName(name);
        if (contact != null) {
            String contactDetails = "Contact details:\n" +
                    "Name: " + contact.getName() + "\n" +
                    "Phone Number: " + contact.getPhoneNumber() + "\n" +
                    "Email: " + contact.getEmailAddress() + "\n";
            outputTextArea.append(contactDetails);
        } else {
            outputTextArea.append("Contact not found.\n");
        }
    }

    private void deleteContact() {
        String name = JOptionPane.showInputDialog(this, "Enter contact name to delete:");

        Contact contact = phoneBook.searchContactByName(name);
        if (contact != null) {
            phoneBook.deleteContact(contact);
            outputTextArea.append("Contact deleted successfully.\n");
        } else {
            outputTextArea.append("Contact not found.\n");
        }
    }

    private void scheduleEvent() {
        String title = JOptionPane.showInputDialog(this, "Enter event title:");
        String startTime = JOptionPane.showInputDialog(this, "Enter event start time:");
        String endTime = JOptionPane.showInputDialog(this, "Enter event end time:");
        String location =JOptionPane.showInputDialog(this, "Enter event end location:");
        Event event = new Event(title,startTime,endTime, location);
        phoneBook.addEvent(event);

        outputTextArea.append("Event scheduled successfully.\n");
    }

    private void printEventDetails() {
        String title = JOptionPane.showInputDialog(this, "Enter event title:");

        
        if (!phoneBook.EisEmpty()) {
            outputTextArea.append(phoneBook.eventByTitle(title));
        } else {
            outputTextArea.append("Event not found.\n");
        }
    }

    private void printContactsByFirstName() {
        String firstName = JOptionPane.showInputDialog(this, "Enter first name:");

        Contact contacts = phoneBook.searchContactByName(firstName);
        if (!phoneBook.CisEmpty()) {
            outputTextArea.append("Contacts with first name " + firstName + ":\n" + contacts);
        } else {
            outputTextArea.append("No contacts found with first name " + firstName + ".\n");
        }
    }

    private void printAllEventsAlphabetically() {
        LinkedList<Event> events = phoneBook.getAllEventsOrderedAlphabetically();
        if (!events.empty()) {
            outputTextArea.append("All events (sorted alphabetically):\n" + events);
        } else {
            outputTextArea.append("No events found.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainGUI mainGUI = new MainGUI();
                mainGUI.setVisible(true);
            }
        });
    }
}