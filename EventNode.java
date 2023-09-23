public class EventNode<T> {
    public Event event;
    public EventNode<T> next;

    public EventNode(Event event) {
        this.event = event;
        this.next = null;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public EventNode getNext() {
        return next;
    }

    public void setNext(EventNode next) {
        this.next = next;
    }
}