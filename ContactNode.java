public class ContactNode<T> {
    public Contact contact;
    public ContactNode<T> next;

    public ContactNode(Contact contact) {
        this.contact = contact;
        this.next = null;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public ContactNode<T> getNext() {
        return next;
    }

    public void setNext(ContactNode<T> next) {
        this.next = next;
    }

}