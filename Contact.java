public class Contact implements Comparable<Contact> {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthday;
    private String notes;
    

    public Contact() {
        name=null;
        phoneNumber=null;
        emailAddress=null;
        address=null;
        birthday=null;
        notes=null;
        events = null;
    }

    public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday,
            String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        events = null;
    }

    @Override
    public int compareTo(Contact other) {
        return this.name.compareToIgnoreCase(other.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    

}