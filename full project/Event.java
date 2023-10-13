public class Event implements Comparable<Event>{
	private String eventTitle;
	private String dateAndTime;
	private String location;
	private LinkedList<Contact> contactLinkedList;
	
	
	public Event() {
		this.contactLinkedList = new LinkedList<Contact>();
		this.eventTitle = null;
		this.dateAndTime = null;
		this.location = null;
		
	}
	public Event(String eventTitle, String dateAndTime, String location) {
		this.eventTitle = eventTitle;
		this.dateAndTime = dateAndTime;
		this.location = location;
		
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
	 public Contact findContact(String data, String type) {
		contactLinkedList.findfirst();
		if (contactLinkedList.empty()) {
			return null;
		}
		boolean last=true;
	
		do {
			Contact currentContact = contactLinkedList.retrieve();
			if (currentContact != null) {
				if (type.equalsIgnoreCase("Name") && currentContact.getContactName().equalsIgnoreCase(data)) {
					return currentContact;
				} else if (type.equalsIgnoreCase("Email") && currentContact.getEmailAddress().equalsIgnoreCase(data)) {
					return currentContact;
				} else if (type.equalsIgnoreCase("PhoneNumber") && currentContact.getPhoneNumber().equalsIgnoreCase(data)) {
					return currentContact;
				} else if (type.equalsIgnoreCase("Address") && currentContact.getAddress().equalsIgnoreCase(data)) {
					return currentContact;
				} else if (type.equalsIgnoreCase("Birthday") && currentContact.getBirthday().equalsIgnoreCase(data)) {
					return currentContact;
				}
			}
			if(last==false) {
				return null;
			}
			
			if(contactLinkedList.last()) {
				last=false;
				return null;
			}
			contactLinkedList.findnext();
			
		} while (!contactLinkedList.last()||last==true);
	
		return null;
	}
	public void addContact(Contact a) {
		contactLinkedList.insert(a);
	}
	public void removeContact() {
		contactLinkedList.remove();
	}
	
	public void contactsNames() {
	    System.out.println("Contact List: ");
	    int c = 1;

	    if (contactLinkedList.empty()) {
	        System.out.println("THERE IS NO CONTACTS");
	        return;
	    }

	    contactLinkedList.findfirst();

	    while(!contactLinkedList.last()){
	        
	    	System.out.println(c++ + " : " + contactLinkedList.retrieve().getContactName());

	        

	        contactLinkedList.findnext(); }
	    if(contactLinkedList.last())
        	System.out.println(c++ + " : " + contactLinkedList.retrieve().getContactName());
            
	    
	}
	public boolean isEmptyContact() {
		return contactLinkedList.empty();
	}
	
	
	public void printFirstName(String name) {
		if(contactLinkedList.empty()) {
			return;
		}
		boolean printname = true;
		int c = 1;
		contactLinkedList.findfirst();
		while(!contactLinkedList.last()) {
			Contact tmp = contactLinkedList.retrieve();
			if(tmp.getContactName().substring(0, name.length()).equalsIgnoreCase(name)) {
				if(printname==true) {
					System.out.println("\nEvent Name: "+getEventTitle());
					System.out.println("------------------------------\n");
					printname=false;
				}
				System.out.println(c+++" : "+tmp.getContactName());
				
			}
			contactLinkedList.findnext();
		}
		if(contactLinkedList.last()) {
			Contact tmp = contactLinkedList.retrieve();
			if(tmp.getContactName().substring(0, name.length()).equalsIgnoreCase(name)) {
				if(printname==true) {
					System.out.println("Event name: "+getEventTitle());
					System.out.println("------------------------------\n");
					printname=false;
				}
				System.out.println(c+++" : "+tmp.getContactName());
				
			}
		}
		System.out.println();
	}
	public int compareTo(Event o) {  
        try {  
            return (this.eventTitle.compareTo(o.getEventTitle()));   
                                                    
        }  
        catch (Exception e)  
        {  
            throw new UnsupportedOperationException();  
        }  
    }  
	
	
	
	}