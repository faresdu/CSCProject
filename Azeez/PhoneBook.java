public class PhoneBook {
    private LinkedList<Contact> contacts;
    private LinkedList<Event> events;

    public PhoneBook() {
        contacts = new LinkedList<>();
        events = new LinkedList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
	public boolean CisEmpty(){
		if (contacts.getHead() == null){
			return true;
		}
		return false;
	}
	public boolean EisEmpty(){
		if (events.getHead() == null){
			return true;
		}
		return false;
	}
	public String eventByTitle(String title){
		if(events.getHead() == null){
			return "There's no current events.";
		}
		else{
while(events.getCurrent().getNext() != null){
			if(events.getCurrent().getData().getTitle().equalsIgnoreCase(title)){
				return "Event Title: "+ title
				+ "\nEvent Start time: " + events.getCurrent().getData().getStartTime()
				+ "\nEvent End Time: " + events.getCurrent().getData().getEndTime()
				+ "\nEvent attendees: " + events.getCurrent().getData().getAttendees();

			}
		}
		return "";
		}
		
	}

    public void deleteContact(Contact contact) {
        contacts.delete(contact);
        deleteContactEvents(contact);
    }

    public Contact searchContactByName(String name) {
        return contacts.search(name, "name");
    }

    public boolean isContactExist(Contact contact) {
        return contacts.search(contact.getName(), "name") != null;
    }

    private void deleteContactEvents(Contact contact) {
		Node<Event> current = events.getHead();
		while (current != null) {
			Event event = current.getData();
			event.getAttendees().remove(contact);
			current = current.getNext();
		}
	}

    public void addEvent(Event event) {
        events.add(event);
    }

    public void deleteEvent(Event event) {
        events.delete(event);
    }

    public boolean hasEventConflict(Event event) {
        Node<Event> current = events.getHead();
        while (current != null) {
            Event existingEvent = current.getData();
            if (doEventsOverlap(existingEvent, event)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    private boolean doEventsOverlap(Event event1, Event event2) {
		// Check if event1 ends before event2 starts or if event1 starts after event2 ends
		if (event1.getEndTime().compareTo(event2.getStartTime()) <= 0 ||
			event1.getStartTime().compareTo(event2.getEndTime()) >= 0) {
			return false; // No overlap
		}
		
		return true; // Overlap detected
	}

    public LinkedList<Event> getAllEventsOrderedAlphabetically() {
        LinkedList<Event> sortedEvents = new LinkedList<>();
        // Copy all events to a new list
        Node<Event> current = events.getHead();
        while (current != null) {
            sortedEvents.add(current.getData());
            current = current.getNext();
        }
        // Sort the new list alphabetically by event title
        sortedEvents.sortAlphabetically();
        return sortedEvents;
    }

    public String getFieldValue(Object data, String field) {
        if (data instanceof Contact) {
            Contact contact = (Contact) data;
            switch (field) {
                case "name":
                    return contact.getName();
                case "phoneNumber":
                    return contact.getPhoneNumber();
                case "email":
                    return contact.getEmailAddress();
                default:
                    throw new IllegalArgumentException("Invalid field: " + field);
            }
        } else if (data instanceof Event) {
            Event event = (Event) data;
            switch (field) {
                case "title":
                    return event.getTitle();
                case "startTime":
                    return event.getStartTime();
                case "endTime":
                    return event.getEndTime();
                default:
                    throw new IllegalArgumentException("Invalid field: " + field);
            }
        } else {
            throw new IllegalArgumentException("Invalid data type: " + data.getClass().getName());
        }
    }
}