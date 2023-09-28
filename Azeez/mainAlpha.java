import java.util.*;
public class mainAlpha {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		PhoneBook pb = new PhoneBook(10);

		/* sample tests*/
		Contact a1 = new Contact("Faris Aldhelan","0534335050","f@.com","RIYADH","A","2003");
		Contact a2 = new Contact("Omar Almayof","0534331000","o@.com","RIYADH","A","2003");
		Contact a3 = new Contact("Abdulaziz Alkhinifer","0534331010","a@.com","RIYADH","A","2003");
		Contact a4 = new Contact("Abdullah Alhassan","051201012","a2@.com","RIYADH","A","2003");
		Contact a5 = new Contact("Abdulrahman Alruhmah","0534332020","a3@.com","RIYADH","A","2003");
		pb.addContact3(a1);
		pb.addContact3(a2);
		pb.addContact3(a3);
		pb.addContact3(a4);
		pb.addContact3(a5);
		
		System.out.println("Welcome to the Linked Tree Phonebook!");
		System.out.println("Please choose an option:");
		System.out.println("1. Add a contact");
		System.out.println("2. Search for a contact");
		System.out.println("3. Delete a contact\n4. Schedule an event");
		System.out.println("8.Exit");
		System.out.println();
		System.out.print("Enter your choice:");
		int c = a.nextInt();
		while(c!=8){
			
			if(c==1) {
			Contact zb = new Contact();
			System.out.print("Enter the contact's name: ");
			String fname = a.next();
			String lname = a.next();
			String fullName = fname+" "+lname;
			zb.setContactName(fullName);
			System.out.print("Enter the contact's phone number: ");
			zb.setPhoneNumber(a.next());
			System.out.print("Enter the contact's Email address: ");
			zb.setEmailAddress(a.next());
			System.out.print("Enter the contact's birthday: ");
			zb.setBirthday(a.next());
			System.out.print("Enter the contact's address: ");
			zb.setAddress(a.next());
			System.out.print("Enter any notes for the contact: ");
			zb.setNotes(a.next());
			pb.addContact3(zb);
			}
			else if(c==2) {
				System.out.println("Enter search criteria:");
				System.out.println("1. Name\r\n"
						+ "2. Phone Number\r\n"
						+ "3. Email Address\r\n"
						+ "4. Address\r\n"
						+ "5. Birthday\r\n");
				System.out.print("Enter your choice:");
				int scan2 = a.nextInt();
				Contact tmp = null;
				if(scan2==1) {
				System.out.print("Enter the contact's name: ");
				tmp=pb.findContact(a.next(), "Name");
				
				}
				else if(scan2==2) {
				System.out.print("Enter the contact's Phone Number: ");
				tmp=pb.findContact(a.next(), "PhoneNumber");	
				}
				else if(scan2==3) {
				System.out.print("Enter the contact's Email Adress: ");
				tmp=pb.findContact(a.next(), "Email");
				}
				else if(scan2==4) {
				System.out.print("Enter the contact's Address: ");
				tmp=pb.findContact(a.next(), "Address");
				}
				else if(scan2==5) {
				System.out.print("Enter the contact's Birtday: ");
				tmp=pb.findContact(a.next(), "Birthday");	
				}
				if(tmp==null) {
					System.out.println("CONTACT NOT FOUNDED! ");
				}
				else if(tmp!=null) {
					System.out.println("\nContact found!");
					System.out.println("Name: "+tmp.getContactName());
					System.out.println("Phone Number: "+tmp.getPhoneNumber());
					System.out.println("Email Address: "+tmp.getEmailAddress());
					System.out.println("Address: "+tmp.getAddress());
					System.out.println("Birthday "+tmp.getBirthday());
					System.out.println("Notes: "+tmp.getNotes());
				}
				
				
				
				
			} 
			else if(c==3) {
				System.out.print("Enter the contact's phone number");
				String k = a.next();
				pb.deleteContact(k);
			}
			else if(c==4) {
				Event e1 = new Event();
				System.out.print("Enter event title: ");
				e1.setEventTitle(a.next());
				System.out.print("Enter contact name: ");
				String fname = a.next();
				String lname = a.next();
				String ac = fname+" "+lname;
				System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
				e1.setDateAndTime(a.next());
				System.out.print("Enter event location: ");
				e1.setLocation(a.next());
				pb.scheduleEvent(e1,ac);
			}
			else if(c==5) {
				pb.test();
			}
			 
			System.out.println("\nWelcome to the Linked Tree Phonebook!");
			System.out.println("Please choose an option:");
			System.out.println("1. Add a contact");
			System.out.println("2. Search for a contact");
			System.out.println("3. Delete a contact");
			System.out.println("8.Exit");
			System.out.println();
			System.out.print("Enter your choice:");
			c = a.nextInt();
			}
		
		
	}

}
