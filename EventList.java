public class EventList {
    private EventNode head;
    private EventNode current;

    public void addEvent(Event event) {
        EventNode newNode = new EventNode(event);

        if (head == null) {
            head = newNode;
        } else {
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean conflictDate(Contact contact, String DateAndTime) {
        current = head;
        while (current != null) {
            Event event = current.event;
            if (event.getContact().equals(contact) && event.getDateAndTime().equalsIgnoreCase(DateAndTime)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Event[] orderEvents() {
        int count = 0;
        current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        Event[] events = new Event[count];
        current = head;
        for (int i = 0; i < count; i++) {
            events[i] = current.event;
            current = current.next;
        }

        sortEvents(events);

        return events;
    }
    public EventNode findEvent(String eventName){
        current = head;
        while(current != null){
            if(current.getEvent().getEventTitle().equalsIgnoreCase(eventName)){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    private void sortEvents(Event[] events) {
        int n = events.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (events[j].getDateAndTime().compareToIgnoreCase(events[j + 1].getDateAndTime()) > 0) {
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
    }
}