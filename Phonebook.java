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

    public Contact findContactByName(String name) {
        return contactList.findContactByName(name);
    }

    public void scheduleEvent(Contact contact, String eventTitle, String dateAndTime, String location) {
        if (!contactList.existsContact(contact)) {
            System.out.println("Contact does not exist in the phonebook.");
            return;
        }

        if (eventList.conflictDate(contact, dateAndTime)) {
            System.out.println("There's a scheduling conflict for this contact.");
            return;
        }

        Event event = new Event(eventTitle, dateAndTime, location, contact);
        eventList.addEvent(event);
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