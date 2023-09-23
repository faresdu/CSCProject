public class EventList {
    private EventNode head;

    private class EventNode {
        private Event event;
        private EventNode next;

        public EventNode(Event event) {
            this.event = event;
            this.next = null;
        }
    }

    public void addEvent(Event event) {
        EventNode newNode = new EventNode(event);

        if (head == null) {
            head = newNode;
        } else {
            EventNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean hasConflict(Contact contact, String newDateAndTime) {
        EventNode current = head;
        while (current != null) {
            Event event = current.event;
            if (event.getContact().equals(contact) && event.getDateAndTime().equalsIgnoreCase(newDateAndTime)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Event[] getAllEventsOrdered() {
        int count = 0;
        EventNode current = head;
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