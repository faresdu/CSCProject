public class PhoneBook {
	private LinkedList<Contact> contactLinkedList;
	private LinkedList<Event> EventLinkedList;
	public PhoneBook() {
		this.contactLinkedList = new LinkedList<>();
		this.EventLinkedList = new LinkedList<>();
		
	}
	
	public void addContact(Contact contact) {
			if (contactLinkedList.empty()) {
				contactLinkedList.insert(contact);
				System.out.println("the CONTACT has been Added successfully!");
			} else {
				if (checkUnique(contact)) {
					contactLinkedList.insert(contact);
					System.out.println("the CONTACT has been Added successfully!");
				}}
			/*Big o n */
		}
	private boolean checkUnique(Contact n) {
		contactLinkedList.findfirst();
		while (!contactLinkedList.last()){
			if (contactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(n.getPhoneNumber()) || contactLinkedList.retrieve().getContactName().equalsIgnoreCase(n.getContactName())) {
				return false;
			}
			contactLinkedList.findnext();
			if (contactLinkedList.last() && (contactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(n.getPhoneNumber()) || contactLinkedList.retrieve().getContactName().equalsIgnoreCase(n.getContactName()))) {
				return false;
			}}
		
	return true;
	}
	
	public void deleteContact1(String c) {
		if (contactLinkedList.empty()) {
			System.out.println("The List is empty!");
			return;
		}
		Contact tmp=findContact(c, "PhoneNumber");
		if(tmp==null) {
			System.out.println("The contact not exist!");
		}
		if(!EventLinkedList.empty()){
		EventLinkedList.findfirst();
		while(!EventLinkedList.last()) {
			
			if(EventLinkedList.retrieve().findContact(c, "PhoneNumber")!=null) {
				EventLinkedList.retrieve().removeContact();
			}
			if(EventLinkedList.retrieve().isEmptyContact()) {
				EventLinkedList.remove();
			}
			EventLinkedList.findnext();
			}
		if(EventLinkedList.last()) {
			if(EventLinkedList.retrieve().findContact(c, "PhoneNumber")!=null) {
				EventLinkedList.retrieve().removeContact();
			}
			if(EventLinkedList.retrieve().isEmptyContact()) {
				EventLinkedList.remove();
		}
	
		}
		}
		
		contactLinkedList.remove();
		System.out.println("THE CONTACT HAS BEEN DELETED");
		
		
		
		}
		
	public void searchContact(String data, String type) {
		int nb = 1;
		Contact tmp = findContact(data, type);
		if(tmp!=null){
		if (type.equalsIgnoreCase("Email") || type.equalsIgnoreCase("birthday") || type.equalsIgnoreCase("Address")) {
			contactLinkedList.findfirst();
			while (!contactLinkedList.last()) {
				if (tmp!=null&&tmp.getType(type).equalsIgnoreCase(contactLinkedList.retrieve().getType(type))) {
					System.out.println("\nContact " + nb + " found!");
					System.out.println("Name: " + contactLinkedList.retrieve().getContactName());
					System.out.println("Phone Number: " + contactLinkedList.retrieve().getPhoneNumber());
					System.out.println("Email Address: " + contactLinkedList.retrieve().getEmailAddress());
					System.out.println("Address: " + contactLinkedList.retrieve().getAddress());
					System.out.println("Birthday " + contactLinkedList.retrieve().getBirthday());
					System.out.println("Notes: " + contactLinkedList.retrieve().getNotes());
					System.out.println("----------------------------------------------");
					nb++;
				}
				contactLinkedList.findnext();
			}
	
			if (tmp.getType(type).equalsIgnoreCase(contactLinkedList.retrieve().getType(type))&&contactLinkedList.last()) {
				System.out.println("\nContact " + nb + " found!");
				System.out.println("Name: " + contactLinkedList.retrieve().getContactName());
				System.out.println("Phone Number: " + contactLinkedList.retrieve().getPhoneNumber());
				System.out.println("Email Address: " + contactLinkedList.retrieve().getEmailAddress());
				System.out.println("Address: " + contactLinkedList.retrieve().getAddress());
				System.out.println("Birthday " + contactLinkedList.retrieve().getBirthday());
				System.out.println("Notes: " + contactLinkedList.retrieve().getNotes());
				System.out.println("----------------------------------------------");
			}
		} else{
			System.out.println("\nContact found!");
			System.out.println("Name: " + tmp.getContactName());
			System.out.println("Phone Number: " + tmp.getPhoneNumber());
			System.out.println("Email Address: " + tmp.getEmailAddress());
			System.out.println("Address: " + tmp.getAddress());
			System.out.println("Birthday " + tmp.getBirthday());
			System.out.println("Notes: " + tmp.getNotes());
		} }else {
			System.out.println("CONTACT NOT FOUND!");
		}
	}
    
	 public Contact findContact(String data, String type) {
		contactLinkedList.findfirst();
		if (contactLinkedList.empty()) {
			return null;
		}
		boolean last=false;
		
		do{
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
				} else if (type.equalsIgnoreCase("birthday") && currentContact.getBirthday().equalsIgnoreCase(data)) {
					return currentContact;
				}
			}
			if(last==true) {
				return null;
			}
			contactLinkedList.findnext();
			if(contactLinkedList.last()) {
				last=true;
			}
		}while(!contactLinkedList.last()||last==true);
	
		return null;
	}
	 

	 
		
	 public void scheduleEvent(Event event,Contact a) {
			if (a == null) {
				System.out.println("Contact does not exist in the phonebook.");
				return;
			} else {

			}
			if (conflictDate(a, event.getDateAndTime())) {
				System.out.println("There's a scheduling conflict for this contact.");
				return;
			} else {
				
				if(findEvent(event)) {
					EventLinkedList.retrieve().addContact(a);
				System.out.println("The event has been schudlede!");
				return;
				}else {
				event.addContact(a);
				EventLinkedList.insert(event);
				System.out.println("The event has been schudlede!");}
				
					
				}
		}
		

		private boolean conflictDate(Contact contact, String DateAndTime) {
			String stmp = contact.getPhoneNumber();
			if (EventLinkedList.empty()) {
				return false;
			} else {
				EventLinkedList.findfirst();
				while (!EventLinkedList.last()) {
					if (EventLinkedList.retrieve().findContact(stmp,"PhoneNumber")!=null&&EventLinkedList.retrieve().getDateAndTime().equalsIgnoreCase(DateAndTime)) {
						return true;
					}
					EventLinkedList.findnext();
				}
				if (EventLinkedList.last()) {

					if (EventLinkedList.retrieve().findContact(stmp,"PhoneNumber")!=null&& EventLinkedList.retrieve().getDateAndTime().equalsIgnoreCase(DateAndTime)) {
						return true;
					}
				}
			}
			return false;
		}
	 private boolean findEvent(Event a){
		
		 if(EventLinkedList.empty())
			 return false;
		 EventLinkedList.findfirst();
		 while(!EventLinkedList.last()){
			 Event tmp = EventLinkedList.retrieve();
			if(tmp.getEventTitle().equalsIgnoreCase(a.getEventTitle())&&tmp.getDateAndTime().equalsIgnoreCase(a.getDateAndTime()))
				return true;
			
			 EventLinkedList.findnext();
			 }
		 if(EventLinkedList.last()&&EventLinkedList.retrieve().getEventTitle().equalsIgnoreCase(a.getEventTitle()) && EventLinkedList.retrieve().getDateAndTime().equalsIgnoreCase(a.getDateAndTime()))
			 return true;
		 
		 return false;
	 }
	 


	
		
		
		public void PrintEvent() {
			if(!EventLinkedList.empty()){
			EventLinkedList.findfirst();
			while (!EventLinkedList.last()) {
				System.out.println(EventLinkedList.retrieve().getEventTitle());
				EventLinkedList.findnext();
			}
			if (EventLinkedList.last()) {
				System.out.println(EventLinkedList.retrieve().getEventTitle());
				return;
			}
		}
			System.out.println("The List is empty");}
		public void SearchEvent(String data, String Type) {
			if (EventLinkedList.empty()) {
				System.out.println("The event list is empty! ");
				return;
			}
			boolean Signal = true;
			EventLinkedList.findfirst();
			do{
				Event tmp = EventLinkedList.retrieve();
				if (tmp.getEventTitle().equalsIgnoreCase(data) && Type.equalsIgnoreCase("Title")) {
					
					System.out.println("Event found!\n");
					System.out.println("Event title: " + tmp.getEventTitle());
					tmp.contactsNames();
					System.out.println("Event date and time: " + tmp.getDateAndTime());
					System.out.println("Event Location: " + tmp.getLocation());
					return;
	
				}else if (EventLinkedList.retrieve().findContact(data, "Name")!=null&& Type.equalsIgnoreCase("Name")) {
					System.out.println("\nEvent found!\n");
					System.out.println("Event title: " + tmp.getEventTitle());
					tmp.contactsNames();
					System.out.println("Event date and time: " + tmp.getDateAndTime());
					System.out.println("Event Location: " + tmp.getLocation());
				}
				
				if(EventLinkedList.last()) {
					Signal = false;
					return;}
					EventLinkedList.findnext();
	
					}while(Signal);
					System.out.println("Event not founded! ");
	
		}
		


		public void deleteContact(String c) {
		    if (contactLinkedList.empty()) {
		        System.out.println("The List is empty!");
		        return;
		    }

		    // Remove the contact from events
		    if (!EventLinkedList.empty()) {
		        EventLinkedList.findfirst();
		        while (!EventLinkedList.last()) {
		            Event event = EventLinkedList.retrieve();
		            if (event.findContact(c, "PhoneNumber") != null) {
		                event.removeContact();
		                if (event.isEmptyContact()) {
		                    EventLinkedList.remove();
		                }
		            }
		            EventLinkedList.findnext();
		        }

		        if (EventLinkedList.last()) {
		            Event event = EventLinkedList.retrieve();
		            if (event.findContact(c, "PhoneNumber") != null) {
		                event.removeContact();
		                if (event.isEmptyContact()) {
		                    EventLinkedList.remove();
		                }
		            }
		        }
		    }

		    // Remove the contact from the contact list
		    contactLinkedList.findfirst();
		    while (!contactLinkedList.last()) {
		        Contact contact = contactLinkedList.retrieve();
		        if (contact.getPhoneNumber().equalsIgnoreCase(c)) {
		            contactLinkedList.remove();
		            System.out.println("THE CONTACT HAS BEEN DELETED");
		            return;
		        }
		        contactLinkedList.findnext();
		    }

		    if (contactLinkedList.last()) {
		        Contact contact = contactLinkedList.retrieve();
		        if (contact.getPhoneNumber().equalsIgnoreCase(c)) {
		            contactLinkedList.remove();
		            System.out.println("THE CONTACT HAS BEEN DELETED");
		        }
		    } else {
		        System.out.println("The contact not exist!");
		    }
		}
		
		public void searchByFirstName(String name) {
		    if (EventLinkedList.empty()) {
		        return;
		    }

		    EventLinkedList.findfirst();

		    while (!EventLinkedList.last()){
		        Event currentEvent = EventLinkedList.retrieve();
		        currentEvent.printFirstName(name);
		        EventLinkedList.findnext();
		    }

		    Event lastEvent = EventLinkedList.retrieve();
		    lastEvent.printFirstName(name);
		}
		
		
			
	

	}
		
	


