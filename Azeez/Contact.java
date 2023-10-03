
public class Contact implements Comparable<Contact>{
	private String contactName;
	private String phoneNumber;
	private String emailAddress;
	private String address;
	private String birthday;
	private String notes;
	public Contact() {
		contactName =null;
		phoneNumber=null;
		emailAddress=null;
		address=null;
		birthday=null;
		notes=null;
	}
	
	
	  public Contact(Contact c) {
		super();
		this.contactName = c.contactName;
		this.phoneNumber = c.phoneNumber;
		this.emailAddress = c.emailAddress;
		this.address = c.address;
		this.birthday = c.birthday;
		this.notes = c.notes;
	}


	public Contact(String contactName, String phoneNumber, String emailAddress, String address, String birthday,
			String notes) {
		super();
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
	}

	public int compareTo(Contact other) {
	        return this.contactName.compareToIgnoreCase(other.getContactName());
	    }
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getType(String Type){
		if(Type.equalsIgnoreCase("Name")){
			return getContactName();
		}
		else if(Type.equalsIgnoreCase("Email")){
			return getEmailAddress();
		}
		else if(Type.equalsIgnoreCase("Address")){
			return getAddress();
		}
		else if(Type.equalsIgnoreCase("PhoneNumber")){
			return getPhoneNumber();
		}
		else if(Type.equalsIgnoreCase("Birthday")){
			
			return getBirthday();
		}
		return null;
		
	}

}
