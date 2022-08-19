package ContactManager;


import java.lang.reflect.Array;
import java.util.List;
import java.util.Objects;

import static ContactManager.ContactsListMain.addAContact;

public class ContactsListMain {
    public static final int INVALID_CHOICE = -1;
    public static final int EXIT_CHOICE = 5;
    private static ContactsList contactList = ContactsGateway.readFromFile();

    public static void main(String[] args) {
        Input input = new Input();

//        ContactsList contactList = ContactsGateway.readFromFile();

// Messing with reading data from file...
//        String test = """
//                Jim|210-123-3333
//                Steve|210-8879341
//                """;
//        Contact.createFromString(test);
//        System.out.println(test.lines().count());
//        List<String> testing = test.lines().toList();
//        for (int i = 0; i <testing.size() ; i++) {
//            contactList.addContact(Contact.createFromString(testing.get(i)));
//        }
//        contactList.addContact(Chase);
//        contactList.addContact(John);
//        contactList.printContacts();
        int choice = INVALID_CHOICE;
        while (!Objects.equals(choice, EXIT_CHOICE)) {
            printMenu();
            choice = input.getInt("What would you like to do?");
            switch (choice) {
                case 1 -> {
                    contactList.printContacts();
                }
                case 2 -> {
                    contactList.addContact(addAContact());
//                    String name = input.getString("Enter contact name: ");
//                    String contactNumber = input.getString("Enter contact number: ");
//                    // Add conditional to check size of number, 10 or 7 digits, and format accordingly...
//                    String number = contactNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
//                    Contact newContact = new Contact(name, number);
//                    if (contactList.toStringList().toString().contains(name)) {
//                        System.out.println("Contact already exists!");
//                        String overwrite = input.getString("Overwrite contact: " + name + "? [ y , n ]");
//                    // If the answer is No allow the user to enter the information again.
//                        if (overwrite.equalsIgnoreCase("y")){
//                            contactList.removeContact(name);
//                            contactList.addContact(newContact);
//                        } else {
//                            addAContact();
//                        }
//                    } else {
//                        contactList.addContact(newContact);
//                    }
                }
                case 3 -> {
                    String name = input.getString("What contact would you like to search? ");
                    if (contactList.getContactByName(name) == null) {
                        System.out.println("That contact does not exist!");
                    } else {
                        System.out.println(contactList.getContactByName(name));
                    }

                }
                case 4 -> {
                    String name = input.getString("What contact would you like to delete? ");
                    if (contactList.removeContact(name) == null) {
                        System.out.println("That contact does not exist!");
                    } else {
                        contactList.removeContact(name);
                    }
                }
            }
            ContactsGateway.writeToFile(contactList);
        }
    }


    private static void printMenu() {
        System.out.print("""
                What would you like to do?
                                
                1. View contacts.
                2. Add a new contact.
                3. Search a contact by name.
                4. Delete an existing contact.
                5. Exit.
                Enter an option (1, 2, 3, 4 or 5):
                            
                """);
    }

    public static Contact addAContact() {
        Input input = new Input();
        String name = input.getString("Enter contact name: ");
        String contactNumber = input.getString("Enter contact number: ");
        // Add conditional to check size of number, 10 or 7 digits, and format accordingly...
        String number = contactNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        Contact newContact = new Contact(name, number);
        if (ContactsListMain.contactList.toStringList().toString().contains(name)) {
            System.out.println("Contact already exists!");
            String overwrite = input.getString("Overwrite contact: " + name + "? [ y , n ]");
            // If the answer is No allow the user to enter the information again.
            if (overwrite.equalsIgnoreCase("y")){
                contactList.removeContact(name);
                System.out.println("Removed " + name);
            } else {
                return addAContact();
            }
        }
        return newContact;
    }
}
