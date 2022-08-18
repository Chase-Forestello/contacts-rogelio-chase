import java.util.ArrayList;
import java.util.List;

public class ContactsList {
    private ArrayList<Contacts> contacts;

    public ContactsList () {
        contacts = new ArrayList<>();
    }

    public void addContact(Contacts contact) {
        contacts.add(contact);
    }

    public void printContacts() {
        System.out.println("Contacts:");
        for (Contacts contact : contacts) {
            System.out.println(contact);
        }
    }

    public void removeContact (String contactName) {
        //find index of contact with contactName
        int index = getIndexByContactName(contactName);
    }

    public int getIndexByContactName (String contactName) {
        int index = -1;
        for (int i = 0; i < contacts.size() ; i++) {
            Contacts contact = contacts.get(i);
            String contactNameInList = contact.getName();
            if (contactNameInList.equalsIgnoreCase(contactName)){
                index = i;
            }
        }
        return index;
    }

    public List<String> toStringList() {
        List<String> contactsString = new ArrayList<>();
        for (Contacts contact : contacts) {
            contactsString.add(contact.toString());
        }
        return contactsString;
    }

    public Contacts getContactByName (String contactName){
        int index = getIndexByContactName(contactName);

        if (index > -1) {
            return contacts.get(index);
        }
        return null;
    }
}
