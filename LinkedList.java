public class LinkedList {
    private ContactNode head;
    private ContactNode current;

    public void addContact(Contact contact) {
        ContactNode<Contact> contactN = new ContactNode<Contact>(contact);

        if (head == null) {
            head = contactN;

        } else if (head.getContact().compareTo(contact) <= 0
                && head.getContact().getPhoneNumber() != contact.getPhoneNumber()) {
            contactN.setNext(head);
            head = contactN;

        } else {
            while (current.getNext() != null && current.getNext().getContact().compareTo(contact) < 0
                    && current.getContact().getPhoneNumber() != contact.getPhoneNumber()) {
                current = current.getNext();
            }
            current.setNext(current.getNext());
            current.setNext(contactN);

        }

    }

    public boolean existsContact(Contact contact) {
        current = head;
        while (current != null) {
            if (current.contact.equals(contact)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void findContactByName(String name) {
        current = head;
        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact name: " + current.contact.getName()
                        + "\n Phone number: " + current.contact.getPhoneNumber()
                        + "\n Address: " + current.contact.getAddress()
                        + "\n Email address: " + current.contact.getEmailAddress()
                        + "\n Birthday: " + current.contact.getBirthday()
                        + "\n Notes: " + current.contact.getNotes());
            }
            current = current.getNext();
        }
        System.out.println("Contact not found!");
    }

    public void findContactByEmail(String email) {
        current = head;
        while (current != null) {
            if (current.contact.getEmailAddress().equalsIgnoreCase(email)) {
                System.out.println("Contact name: " +current.contact.getName()
                        + "\n Phone number: " + current.contact.getPhoneNumber()
                        + "\n Address: " + current.contact.getAddress()
                        + "\n Email address: " + current.contact.getEmailAddress()
                        + "\n Birthday: " + current.contact.getBirthday()
                        + "\n Notes: " + current.contact.getNotes());
            }
            current = current.getNext();
        }
        System.out.println("Contact not found!");
    }

    public void findContactByAddress(String address) {
        current = head;
        while (current != null) {
            if (current.contact.getAddress().equalsIgnoreCase(address)) {
                System.out.println("Contact name: " +current.contact.getName() + "\n Phone number: " + current.contact.getPhoneNumber() + "\n Address: "
                        + current.contact.getAddress() + "\n Email address: " + current.contact.getEmailAddress() + "\n Birthday: "
                        + current.contact.getBirthday() + "\n Notes: " + current.contact.getNotes());
            }
            current = current.getNext();
        }
        System.out.println("Contact not found!");
    }

    public void findContactByPhone(String phone) {
        current = head;
        while (current != null) {
            if (current.contact.getPhoneNumber().equalsIgnoreCase(phone)) {
                System.out.println("Contact name: " +current.contact.getName() + "\n Phone number: " + current.contact.getPhoneNumber() + "\n Address: "
                        + current.contact.getAddress() + "\n Email address: " + current.contact.getEmailAddress() + "\n Birthday: "
                        + current.contact.getBirthday() + "\n Notes: " + current.contact.getNotes());
            }
            current = current.getNext();
        }
        System.out.println("Contact not found!");
    }

    public boolean deleteContact(String name) {
        if (head == null) {
            return false;
        }

        if (head.contact.getName().equalsIgnoreCase(name)) {
            head = head.getNext();
            return true;
        }

        ContactNode previous = head;
        current = head.getNext();
        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(name)) {
                previous.next = current.getNext();
                return true;
            }
            previous = current;
            current = current.getNext();
        }

        return false;
    }
}
