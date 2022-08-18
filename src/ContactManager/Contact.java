package ContactManager;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }
    public static Contact createFromString(String contactString) {
        String [] parts = contactString.split("|");
        return new Contact(parts[0].trim(), parts[1].trim());
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

    @Override
    public String toString() {
        return name + "|" + phoneNumber;
    }
}
