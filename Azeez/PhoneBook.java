import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
	private LinkedList<Contact> contactLinkedList;
	private LinkedList<Event> EventLinkedList;
	public PhoneBook( int maxsize) {
		this.contactLinkedList = new LinkedList<>();
		this.EventLinkedList = new LinkedList<>();
		
	}
	
	public void addContact3(Contact contact) {
			if (contactLinkedList.empty()) {
				contactLinkedList.insert(contact);
			} else {
				if (checkUnique(contact)) {
					if (contactLinkedList.retrieve().compareTo(contact) <= 0) {
						contactLinkedList.insert(contact);
						contactLinkedList.findfirst();
						Contact tmp1 = new Contact(contactLinkedList.retrieve());
						contactLinkedList.remove();
						contactLinkedList.insert(tmp1);
					} else {
						contactLinkedList.findfirst();
						while (!contactLinkedList.last() && contactLinkedList.retrieve().compareTo(contact) < 0) {
							contactLinkedList.findnext();
						}
						if (contactLinkedList.retrieve() != null) {
							Contact tmp2 = contactLinkedList.retrieve();
							contactLinkedList.findfirst();
							while (contactLinkedList.retrieve() != null && contactLinkedList.retrieve().compareTo(contact) < 0) {
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
				} else {
					System.out.println("The contact already exists!");
				}
			}
		}
	
	public void deleteContact1(String c) {
		if (contactLinkedList.empty()) {
			System.out.println("The List is empty!");
			return;
		}
		
		contactLinkedList.findfirst();
		boolean found = false;
		while (contactLinkedList.retrieve() != null) {
			if (contactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(c)) {
				if (!EventLinkedList.empty()) {
					EventLinkedList.findfirst();
					boolean btmp = true;
					while (btmp) {
						if (EventLinkedList.retrieve().getCon() == contactLinkedList.retrieve()) {
							EventLinkedList.remove();
						}

						if(EventLinkedList.empty()||EventLinkedList.last()){
							btmp=false;
						}
						else{
						EventLinkedList.findnext();}
					}
	
					if (!(EventLinkedList.empty()) && EventLinkedList.last() && EventLinkedList.retrieve().getCon() == contactLinkedList.retrieve()) {
						EventLinkedList.remove();
					}
				}
				contactLinkedList.remove();
				System.out.println("THE CONTACT HAS BEEN DELETED!");
				found = true;
				break;
			} else {
				if (contactLinkedList.last()) {
					System.out.println("Contact not found!");
					return;
				}
				contactLinkedList.findnext();
			}
		}
	
		if (!found) {
			System.out.println("Contact not found!");
		}
	}
	public void deleteContact(String c) {
		if (contactLinkedList.empty()) {
			System.out.println("The List is empty!");
			return;
		}
	
		contactLinkedList.findfirst();
		boolean found = false;
	
		while (contactLinkedList.retrieve() != null) {
			if (contactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(c)) {
				Contact contactToDelete = contactLinkedList.retrieve();
	
				if (!EventLinkedList.empty()) {
					EventLinkedList.findfirst();
					while (EventLinkedList.retrieve() != null) {
						if (EventLinkedList.retrieve().getCon() == contactToDelete) {
							EventLinkedList.remove();
						}
						EventLinkedList.findnext();
					}
				}
	
				contactLinkedList.remove();
				System.out.println("THE CONTACT HAS BEEN DELETED!");
	
				found = true;
				break;
			}
	
			contactLinkedList.findnext();
		}
	
		if (!found) {
			System.out.println("Contact not found!");
		}
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
			contactLinkedList.findnext();
		} while (!contactLinkedList.last());
	
		return null;
	}
	 

	 
		
	 public void scheduleEvent(Event event) {
	        if (event.getCon()==null) {
	            System.out.println("Contact does not exist in the phonebook.");
	            return;
	        }
	        else {
	        	
	        }
	        if (conflictDate(event.getCon(), event.getDateAndTime())) {
	            System.out.println("There's a scheduling conflict for this contact.");
	            return;
	        }
			else{
	        Event newEvent = new Event(event.getEventTitle(), event.getDateAndTime(), event.getLocation(),event.getCon());
	        EventLinkedList.insert(newEvent);
			System.out.println("The event has been schudlede!");}
	    }
	 
	 public boolean conflictDate(Contact contact, String DateAndTime) {
	        if(EventLinkedList.empty()){
				return false;
			}else{
			EventLinkedList.findfirst();
	        while(!EventLinkedList.last()){
	            if (EventLinkedList.retrieve().getCon()==contact &&  EventLinkedList.retrieve().getDateAndTime().equalsIgnoreCase(DateAndTime)) {
	                return true;
	            }
	            EventLinkedList.findnext();
	        }
	        if(EventLinkedList.last()) {
	        	
	            if (EventLinkedList.retrieve().getCon()==contact &&  EventLinkedList.retrieve().getDateAndTime().equalsIgnoreCase(DateAndTime)) {
	                return true;
	            }
	        }}
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
		
		
		public void tes1() {
			if(!EventLinkedList.empty()){
			EventLinkedList.findfirst();
			while (!EventLinkedList.last() && !EventLinkedList.empty()) {
				System.out.println(EventLinkedList.retrieve().getEventTitle());
				EventLinkedList.findnext();
			}
			if (EventLinkedList.last()) {
				System.out.println(EventLinkedList.retrieve().getEventTitle());
			}
		}}
	}

