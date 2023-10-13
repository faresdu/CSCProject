import java.util.Scanner;
public class mainBeta {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		PhoneBook pb = new PhoneBook();

		/* sample tests*/
		Contact a1 = new Contact("Faris-Aldhelan","0534335052","f@.com","RIYADH","A","2003");
		Contact a2 = new Contact("A","0534335050","o@.com","RIYADH","A","2003");
		Contact a3 = new Contact("Abdulaziz-Alkhinifer","0534331010","a@.com","RIYADH","A","2003");
		Contact a4 = new Contact("Abdullah-Alhassan","051201012","a2@.com","RIYADH","A","2003");
		Contact a5 = new Contact("B","0534332020","a3@.com","RIYADH","A","2003");
		pb.addContact(a1);
		pb.addContact(a2);

		pb.addContact(a3);
		pb.addContact(a4);
		pb.addContact(a5);
		
		System.out.println("Welcome to the Linked Tree Phonebook!");
		System.out.println("Please choose an option:");
		System.out.println("1. Add a contact");
		System.out.println("2. Search for a contact");
		System.out.println("3. Delete a contact\n4. Schedule an event\n5. Print event details\n6. Print contacts by first name");
		System.out.println("7. Print all events alphabetically");
		System.out.println("8.Exit");
		System.out.println();
		System.out.print("Enter your choice:");
		int c = a.nextInt();
		while(c!=8){
			
			if(c==1) {
			Contact tmp = new Contact();
			System.out.print("Enter the contact's name: ");
			tmp.setContactName(a.next());
			
			System.out.print("Enter the contact's phone number: ");
			tmp.setPhoneNumber(a.next());
			
			System.out.print("Enter the contact's Email address: ");
			tmp.setEmailAddress(a.next());
			
			System.out.print("Enter the contact's birthday: ");
			tmp.setBirthday(a.next());
			
			System.out.print("Enter the contact's address: ");
			tmp.setAddress(a.next());
			
			System.out.print("Enter any notes for the contact: ");
			tmp.setNotes(a.next());
			
			pb.addContact(tmp);
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
				if(scan2==1) {
				System.out.print("Enter the contact's name: ");
				pb.searchContact(a.nextLine(), "Name");
				
				}
				else if(scan2==2) {
				System.out.print("Enter the contact's Phone Number: ");
				pb.searchContact(a.next(), "PhoneNumber");	
				}
				else if(scan2==3) {
				System.out.print("Enter the contact's Email Adress: ");
				pb.searchContact(a.next(), "Email");
				}
				else if(scan2==4) {
				System.out.print("Enter the contact's Address: ");
				pb.searchContact(a.next(), "Address");
				
				}
				else if(scan2==5){
				System.out.print("Enter the contact's Birtday: ");
				pb.searchContact(a.next(), "Birthday");	
				
				}
				
			} 
			else if(c==3) {
				System.out.print("Enter the contact's phone number: ");
				pb.deleteContact(a.next());
			}
			else if(c==4) {
				Event e1 = new Event();
				System.out.print("Enter event title: ");
				e1.setEventTitle(a.next());
				
				System.out.print("Enter contact name: ");
				Contact tmp = pb.findContact(a.next(), "Name");
				
				System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
				e1.setDateAndTime(a.next());
				System.out.print("Enter event location: ");
				e1.setLocation(a.next());
				
				pb.scheduleEvent(e1,tmp);
			}
			else if(c==5) {
				System.out.println("Enter search criteria: ");
				System.out.println("1.contact name.");
				System.out.println("2.Event title.\n");
				System.out.print("Enter your choice: ");
				int a51=a.nextInt();
			   if(a51==1){
					System.out.print("Enter the contact name: ");
					pb.SearchEvent(a.next(), "Name");
					
				}
			   else if(a51==2){
					System.out.print("Enter the event title: ");
					pb.SearchEvent(a.next(), "Title");
					
				}
				
			}
			else if(c==6) {
				System.out.print("Enter the first name: ");
				pb.searchByFirstName(a.next());
				
			}
			else if(c==7) {
				pb.PrintEvent();
			}
			System.out.println("\n-------------------------");
			System.out.println("Please choose an option:");
			System.out.println("1. Add a contact");
			System.out.println("2. Search for a contact");
			System.out.println("3. Delete a contact\n4. Schedule an event\n5. Print event details\n6. Print contacts by first name ");
			System.out.println("7. Print all events alphabetically");
			System.out.println("8. Exit");
			System.out.println();
			System.out.print("Enter your choice:");
			c = a.nextInt();
			}
		System.out.println("THANK YOU");
		
	}

}
