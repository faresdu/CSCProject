public class Phonebook {
    private LinkedList contactList;
    private EventList eventList;

    public Phonebook() {
        contactList = new LinkedList();
        eventList = new EventList();
    }

    public void addContact(Contact contact) {
        contactList.addContact(contact);
    }

    public boolean deleteContact(String name) {
        return contactList.deleteContact(name);
    }

    public void findContactByName(String name) {
        contactList.findContactByName(name);
    }
    public void findContactByEmail(String email) {
        contactList.findContactByEmail(email);
    }
    public void findContactByPhone(String phone) {
        contactList.findContactByPhone(phone);
    }
    public void findContactByAddress(String address) {
        contactList.findContactByAddress(address);
    }
    public boolean existsContact(Contact contact) {
        if(contactList.existsContact(contact)){
            return true;
        }
        else{
            return false;
        }
    }
    public void findEvent(String eventName){
        eventList.findEvent(eventName);
    }

    public void scheduleEvent(Event event) {
        if (!contactList.existsContact(event.getContact())) {
            System.out.println("Contact does not exist in the phonebook.");
            return;
        }

        if (eventList.conflictDate(event.getContact(), event.getDateAndTime())) {
            System.out.println("There's a scheduling conflict for this contact.");
            return;
        }

        Event newEvent = new Event(event.getEventTitle(), event.getDateAndTime(), event.getLocation(),event.getContact());
        eventList.addEvent(newEvent);
    }

    public void printAllEventsOrdered() {
        Event[] events = eventList.orderEvents();
        for (Event event : events) {
            System.out.println("Event Title: " + event.getEventTitle());
            System.out.println("Date and Time: " + event.getDateAndTime());
            System.out.println("Location: " + event.getLocation());
            System.out.println("Contact Name: " + event.getContact().getName());
            System.out.println();
        }
    }
    // public void sharedEventAndName(String eventName){
    //     EventNode event = eventList.findEvent(eventName);
       
    //     if(eventList == null){
    //         return;
    //     }
    //     else{
    //         while( != null){
                
    //         }
    //     }
    // }
}