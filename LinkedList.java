public class LinkedList {
    private ContactNode head;
    private ContactNode current;

    public void addContact(Contact contact) {
        ContactNode<Contact> contactN = new ContactNode<Contact>(contact);

        if (head == null) {
            head = contactN;
        } else if (head.getContact().compareTo(contact) <= 0 && head.getContact().getPhoneNumber() != contact.getPhoneNumber()) {
            contactN.setNext(head);
            head = contactN;
        } else {
            while (current.getNext() != null && current.getNext().getContact().compareTo(contact) < 0 && current.getContact().getPhoneNumber() != contact.getPhoneNumber() ) {
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

    public Contact findContactByName(String name) {
        current = head;
        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(name)) {
                return current.contact;
            }
            current = current.getNext();
        }
        return null;
    }
    public Contact findContactByEmail(String email) {
        current = head;
        while (current != null) {
            if (current.contact.getEmailAddress().equalsIgnoreCase(email)) {
                return current.contact;
            }
            current = current.getNext();
        }
        return null;
    }
    public Contact findContactByAddress(String address) {
        current = head;
        while (current != null) {
            if (current.contact.getAddress().equalsIgnoreCase(address)) {
                return current.contact;
            }
            current = current.getNext();
        }
        return null;
    }
    public Contact findContactByBirthday(String birthday) {
        current = head;
        while (current != null) {
            if (current.contact.getBirthday().equalsIgnoreCase(birthday)) {
                return current.contact;
            }
            current = current.getNext();
        }
        return null;
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
