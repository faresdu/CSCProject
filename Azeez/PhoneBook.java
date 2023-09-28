
public class PhoneBook {
	private LinkedList<Contact> contactLinkedList;
	private LinkedList<Event> EventLinkedList;
	private Event [] eventsList;
	private int nbevents;
	public PhoneBook( int maxsize) {
		this.contactLinkedList = new LinkedList<>();
		this.EventLinkedList = new LinkedList<>();
		this.eventsList = new Event[maxsize];
		this.nbevents=0;
	}
	public void addContact(Contact contact) {

        if (contactLinkedList.empty()) {
            contactLinkedList.insert(contact);;
        
        contactLinkedList.findfirst();

        } else if (contactLinkedList.retrieve().compareTo(contact) <= 0
                && contactLinkedList.retrieve().getPhoneNumber() != contact.getPhoneNumber()) {
            contactLinkedList.insert(contact);
            contactLinkedList.findfirst();
            Contact tmp1 = new Contact(contactLinkedList.retrieve());
            contactLinkedList.remove();
            contactLinkedList.insert(tmp1);

        } else {
        	contactLinkedList.findnext();
        	Contact tmp2 = new Contact(contactLinkedList.retrieve());
        	contactLinkedList.findfirst();
        	
            while (!contactLinkedList.empty() && tmp2.compareTo(contact) < 0
                    && contactLinkedList.retrieve().getPhoneNumber() != contact.getPhoneNumber()) {
            	contactLinkedList.findnext();
            }
           /* current.setNext(current.getNext());
            current.setNext(contactN); */

        }

    }
	
	
	public void deleteContact(String c) {
		
		if(contactLinkedList.empty()) {
			System.out.println("The List is empty! ");
			return;
		}
		contactLinkedList.findfirst();
		boolean ac=true;
		while(ac!=false){
			if(contactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(c)) {
				if(!EventLinkedList.empty()){
					EventLinkedList.findfirst();
					while(!EventLinkedList.last()) {
						if(EventLinkedList.retrieve().getCon()==contactLinkedList.retrieve()) {
							EventLinkedList.remove();
						}
						EventLinkedList.findnext();
						
						}
						if(EventLinkedList.last() && EventLinkedList.retrieve().getCon()==contactLinkedList.retrieve()) {
							EventLinkedList.remove();
						}}
				contactLinkedList.remove();
				System.out.println("THE CONTACT HAS DELETED! ");
			ac=false;
			}
			else{
				if(contactLinkedList.last()) {
				System.out.println("not founded!");
					return;}
				contactLinkedList.findnext();
				}
			}}

		
	 public Contact findContact(String data, String type){
		 contactLinkedList.findfirst();
		    if (contactLinkedList.empty()) {
		        return null;
		    }
		    if(type.equalsIgnoreCase("Name")) {
		    	  do {
		  	        if (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().getContactName().equalsIgnoreCase(data)) {
		  	            return contactLinkedList.retrieve();
		  	        }
		  	        contactLinkedList.findnext();
		  	      if (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().getContactName().equalsIgnoreCase(data)&&contactLinkedList.last()) {
		  	            return contactLinkedList.retrieve();}
		  	    }while(!contactLinkedList.last());}
		    else if(type.equalsIgnoreCase("email")) {
		    	do {
			        if (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().getEmailAddress().equalsIgnoreCase(data)) {
			            return contactLinkedList.retrieve();
			        }
			        contactLinkedList.findnext();
			        if (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().getEmailAddress().equalsIgnoreCase(data)&&contactLinkedList.last()) {
		  	            return contactLinkedList.retrieve();}
			    }while (!contactLinkedList.last()); }
		    else if(type.equalsIgnoreCase("PhoneNumber")) {
		    	  do {
				        if (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(data)) {
				            return contactLinkedList.retrieve();
				        }
				        contactLinkedList.findnext();
				        if (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().getEmailAddress().equalsIgnoreCase(data)&&contactLinkedList.last()) {
			  	            return contactLinkedList.retrieve();}
				    }while (!contactLinkedList.last());}
		    
		    else if(type.equalsIgnoreCase("Address")) {
		    	do {
			        if (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().getAddress().equalsIgnoreCase(data)) {
			            return contactLinkedList.retrieve();
			        }
			        contactLinkedList.findnext();
			        if (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().getAddress().equalsIgnoreCase(data)&&contactLinkedList.last()) {
		  	            return contactLinkedList.retrieve();}
			    } while (!contactLinkedList.last());}
		    else if(type.equalsIgnoreCase("Birthday")) {
		    	do {
			        if (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().getBirthday().equalsIgnoreCase(data)) {
			            return contactLinkedList.retrieve();
			        }
			        contactLinkedList.findnext();
			        if (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().getBirthday().equalsIgnoreCase(data)&&contactLinkedList.last()) {
		  	            return contactLinkedList.retrieve();}
			    }while (!contactLinkedList.last());
		    }
		    return null;
	 }
	 

	 public void addContact1(Contact contact) {
		    if (contactLinkedList.empty()) {
		        contactLinkedList.insert(contact);
		        contactLinkedList.findfirst();
		    } else if (contactLinkedList.retrieve().compareTo(contact) <= 0
		            && !contactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber())) {
		        contactLinkedList.insert(contact);
		        contactLinkedList.findfirst();
		        Contact tmp1 = new Contact(contactLinkedList.retrieve());
		        contactLinkedList.remove();
		        contactLinkedList.insert(tmp1);
		    } else {
		        contactLinkedList.findnext();
		        Contact tmp2 = new Contact(contactLinkedList.retrieve());
		        contactLinkedList.findfirst();

		        while (!contactLinkedList.empty() && tmp2.compareTo(contact) < 0
		                && !contactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber())) {
		            contactLinkedList.findnext();
		        }
		        contactLinkedList.findfirst();
		        while (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().compareTo(contact) < 0
		                && !contactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber())) {
		            contactLinkedList.findnext();
		        }
		        Node<Contact> current = contactLinkedList.getCurrent();
		        Node<Contact> contactNode = new Node<>(contact);
		        contactNode.setNext(current.getNext());
		        current.setNext(contactNode);
		    }
		}
	 public void scheduleEvent(Event event, String cname) {
	        if (findContact(cname, "Name")==null) {
	            System.out.println("Contact does not exist in the phonebook.");
	            return;
	        }
	        else {
	        	event.setCon(findContact(cname, "Name"));
	        	
	        }
	        if (conflictDate(event.getCon(), event.getDateAndTime())) {
	            System.out.println("There's a scheduling conflict for this contact.");
	            return;
	        }
	        Event newEvent = new Event(event.getEventTitle(), event.getDateAndTime(), event.getLocation(),event.getCon());
	        EventLinkedList.insert(newEvent);
	    }
	 
	 public boolean conflictDate(Contact contact, String DateAndTime) {
	        EventLinkedList.findfirst();
	        while(!EventLinkedList.last()){
	            Event event = EventLinkedList.retrieve();
	            if (event.getCon().equals(contact) && event.getDateAndTime().equalsIgnoreCase(DateAndTime)) {
	                return true;
	            }
	            EventLinkedList.findnext();;
	        }
	        if(EventLinkedList.last()) {
	        	Event event = EventLinkedList.retrieve();
	            if (event.getCon().equals(contact) && event.getDateAndTime().equalsIgnoreCase(DateAndTime)) {
	                return true;
	            }
	        }
	        return false;
	    }
	 public void test() {
		 contactLinkedList.findfirst();
		 while(!contactLinkedList.last()) {
			 System.out.println(contactLinkedList.retrieve().getContactName());
			 contactLinkedList.findnext();
		 }
		 if(contactLinkedList.last()) {
			 System.out.println(contactLinkedList.retrieve().getContactName());
		 }
	 }
	 public void addContact2(Contact contact) {
		    if (contactLinkedList.empty()) {
		        contactLinkedList.insert(contact);
		    } else if (contactLinkedList.retrieve().compareTo(contact) <= 0
		            && !contactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber())) {
		        contactLinkedList.insert(contact);
		        contactLinkedList.findfirst();
		        Contact tmp1 = new Contact(contactLinkedList.retrieve());
		        contactLinkedList.remove();
		        contactLinkedList.insert(tmp1);
		    } else {
		        contactLinkedList.findfirst();
		        while (!contactLinkedList.last() && contactLinkedList.retrieve().compareTo(contact) < 0
		                && !contactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber())) {
		            contactLinkedList.findnext();
		        }
		        if (contactLinkedList.retrieve() != null) {
		            Contact tmp2 = new Contact(contactLinkedList.retrieve());
		            contactLinkedList.findfirst();
		            while (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().compareTo(contact) < 0
		                    && !contactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber())) {
		                contactLinkedList.findnext();
		            }
		            Contact tmp3 = new Contact(contactLinkedList.retrieve());
		            contactLinkedList.insert(contact);
		            contactLinkedList.findfirst();
		            while (contactLinkedList.retrieve() != null && !contactLinkedList.retrieve().equals(tmp3)) {
		                contactLinkedList.findnext();
		            }
		            contactLinkedList.remove();
		            contactLinkedList.insert(tmp3);
		            contactLinkedList.findfirst();
		            while (contactLinkedList.retrieve() != null && !contactLinkedList.retrieve().equals(tmp2)) {
		                contactLinkedList.findnext();
		            }
		            contactLinkedList.remove();
		            contactLinkedList.insert(tmp2);
		        } else {
		            contactLinkedList.insert(contact);
		        }
		    }
		}
	 public void addContact3(Contact contact) {
		    if (contactLinkedList.empty()) {
		        contactLinkedList.insert(contact);
		    } else if (contactLinkedList.retrieve().compareTo(contact) <= 0
		            && !contactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber())) {
		        contactLinkedList.insert(contact);
		        contactLinkedList.findfirst();
		        Contact tmp1 = new Contact(contactLinkedList.retrieve());
		        contactLinkedList.remove();
		        contactLinkedList.insert(tmp1);
		    } else {
		        contactLinkedList.findfirst();
		        while (!contactLinkedList.last() && contactLinkedList.retrieve().compareTo(contact) < 0
		                && !contactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber())) {
		            contactLinkedList.findnext();
		        }
		        if (contactLinkedList.retrieve() != null) {
		            Contact tmp2 = contactLinkedList.retrieve();
		            contactLinkedList.findfirst();
		            while (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().compareTo(contact) < 0
		                    && !contactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber())) {
		                contactLinkedList.findnext();
		            }
		            Contact tmp3 = contactLinkedList.retrieve();
		            contactLinkedList.insert(contact);
		            contactLinkedList.findfirst();
		            while (contactLinkedList.retrieve() != null && !tmp3.equals(contactLinkedList.retrieve())) {
		                contactLinkedList.findnext();
		            }
		            contactLinkedList.remove();
		            contactLinkedList.insert(tmp3);
		            contactLinkedList.findfirst();
		            while (contactLinkedList.retrieve() != null && !tmp2.equals(contactLinkedList.retrieve())) {
		                contactLinkedList.findnext();
		            }
		            contactLinkedList.remove();
		            contactLinkedList.insert(tmp2);
		        } else {
		            contactLinkedList.insert(contact);
		        }
		    }
		}
}
