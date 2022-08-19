package ContactManager;

import java.util.ArrayList;
import java.util.List;

public class ContactsList {
    private ArrayList<Contact> contacts;

    public ContactsList() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void printContacts() {
        System.out.print("""
                  _____            _             _       \s
                 / ____|          | |           | |      \s
                | |     ___  _ __ | |_ __ _  ___| |_ ___ \s
                | |    / _ \\| '_ \\| __/ _` |/ __| __/ __|\s
                | |___| (_) | | | | || (_| | (__| |_\\__ \\\s
                 \\_____\\___/|_| |_|\\__\\__,_|\\___|\\__|___/\s
                """);
        System.out.println("-----------------------------------");
        String name = "Name";
        String Number = "Number";
        System.out.printf("|  " + "%-12s" + "|" + "  %-14s  " + "|%n", name, Number);
        System.out.println("-----------------------------------");
        for (Contact contact : contacts) {
            System.out.println("|" + contact);
        }
        System.out.println("-----------------------------------");
    }

    public Contact removeContact(String contactName) {
        //find index of contact with contactName
        int index = getIndexByContactName(contactName);
        if (index > -1) {
            return contacts.remove(index);
        } else {
            return null;
        }
    }

    public int getIndexByContactName(String contactName) {
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            String contactNameInList = contact.getName();
            if (contactNameInList.equalsIgnoreCase(contactName)) {
                index = i;
            }
        }
        return index;
    }

    public List<String> toStringList() {
        List<String> contactsString = new ArrayList<>();
        for (Contact contact : contacts) {
            contactsString.add(contact.toString());
        }
        return contactsString;
    }

    public Contact getContactByName(String contactName) {
        int index = getIndexByContactName(contactName);

        if (index > -1) {
            return contacts.get(index);
        }
        return null;
    }
}
