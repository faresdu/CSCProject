public class EventList<T> {
    private EventNode<T> head;
    private EventNode<T> current;

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
    public boolean empty () {
		return head == null;
	}

	public boolean last () {
		return current.next == null;
	}
	public boolean full () {
		return false;
	}
	public void findfirst () {
		current = head;
	}
	public void findnext () {
		current = current.next;
	}
	public T retrieve () {
		return current.data;
	}
	public EventNode<T> getCurrent() {
		return current;
	}

	public void update (T val) {
		current.data = val;
	}
	public void insert (T val) {
		EventNode<T> tmp;
		if (empty()) {
			current = head = new EventNode<T> (val);
		}
		else {
			tmp = current.next;
			current.next = new EventNode<T> (val);
			current = current.next;
			current.next = tmp;
		}
	}
	public void remove () {
		if (current == head) {
			head = head.next;
		}
		else {
			EventNode<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;
	}
	
    public boolean conflictDate(Contact contact, String DateAndTime) {
        current = head;
        while (current != null) {
            Event event = (Event)current.getData();
            if (event.getCon().equals(contact) && event.getDateAndTime().equalsIgnoreCase(DateAndTime)) {
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
            events[i] = (Event) current.data;
            current = current.next;
        }

        sortEvents(events);

        return events;
    }

    public void findEvent(String eventName) {
        current = head;
        while (current != null) {
            if (((Event) current.getData()).getEventTitle().equalsIgnoreCase(eventName)) {
                System.out.println("Event title: " + ((Event) current.getData()).getEventTitle()
                        + "\n Contact name: " + ((Event) current.getData()).getCon().getContactName()
                        + "\n Event date and time: " + ((Event) current.getData()).getDateAndTime()
                        + "\n Event location: " + ((Event) current.getData()).getLocation());
            }
            current = current.getNext();
        }
        return;
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
    public void listEventsAlphabetically1() {
        EventNode current = head;

        if (current == null) {
            System.out.println("No events found.");
        } else {
            System.out.println("Events (ordered alphabetically by event name):");
            EventNode sortedHead = null;
            EventNode sortedTail = null;

            while (current != null) {
                EventNode next = current.getNext();
                if (sortedHead == null || ((Event) current.getData()).getEventTitle().compareToIgnoreCase(((Event) sortedHead.getData()).getEventTitle()) < 0) {
                    current.setNext(sortedHead);
                    sortedHead = current;
                } else {
                    EventNode temp = sortedHead;
                    while (temp.getNext() != null && ((Event) current.getData()).getEventTitle().compareToIgnoreCase(((Event) temp.getNext().getData()).getEventTitle()) >= 0) {
                        temp = temp.getNext();
                    }
                    current.setNext(temp.getNext());
                    temp.setNext(current);
                }
                current = next;
            }

            current = sortedHead;
            while (current != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }
        }
    }
}