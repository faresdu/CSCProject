public class LinkedList {
    private Node head;

    private class Node {
        private Contact contact;
        private Node next;

        public Node(Contact contact) {
            this.contact = contact;
            this.next = null;
        }
    }

    public void addContact(Contact contact) {
        Node newNode = new Node(contact);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean existsContact(Contact contact) {
        Node current = head;
        while (current != null) {
            if (current.contact.equals(contact)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Contact findContactByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(name)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }

    public boolean deleteContact(String name) {
        if (head == null) {
            return false;
        }

        if (head.contact.getName().equalsIgnoreCase(name)) {
            head = head.next;
            return true;
        }

        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(name)) {
                prev.next = current.next;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }
}