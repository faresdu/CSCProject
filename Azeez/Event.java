public class Event {
    private String title;
    private Contact contact;
    private String startTime;
    private String endTime;
	private String location;
	private LinkedList<Contact> attendees;

    public Event(String title, String startTime, String endTime, String location) {
        this.title = title;
        this.attendees = new LinkedList<>();
        this.startTime = startTime;
        this.endTime = endTime;
		this.location = location;
    }
	public LinkedList<Contact> getAttendees() {
		return attendees;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

    
}