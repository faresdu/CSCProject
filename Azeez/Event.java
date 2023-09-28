
public class Event {
	private String eventTitle;
	private String dateAndTime;
	private String location;
	private Contact Con;
	
	public Event() {
		this.eventTitle = null;
		this.dateAndTime = null;
		this.location = null;
		Con = null;
	}
	public Event(String eventTitle, String dateAndTime, String location, Contact con) {
		this.eventTitle = eventTitle;
		this.dateAndTime = dateAndTime;
		this.location = location;
		Con = con;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Contact getCon() {
		return Con;
	}
	public void setCon(Contact con) {
		Con = con;
	}
	
	}
	
