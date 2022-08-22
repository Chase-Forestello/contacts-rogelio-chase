// Main program class
package ContactManager;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static ContactManager.ContactsListMain.addAContact;

public class ContactsListMain {
    public static final int INVALID_CHOICE = -1;
    public static final int EXIT_CHOICE = 6;
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
        String contactsTxt = """
                 _____             _             _      \s
                /  __ \\           | |           | |     \s
                | /  \\/ ___  _ __ | |_ __ _  ___| |_ ___\s
                | |    / _ \\| '_ \\| __/ _` |/ __| __/ __|
                | \\__/ (_) | | | | || (_| | (__| |_\\__ \\
                 \\____/\\___/|_| |_|\\__\\__,_|\\___|\\__|___/
                                                        \s
                """;
        int choice = INVALID_CHOICE;
        System.out.println(contactsTxt);
        // Begin program with menu prompt connected to switch to handle each input
        while (!Objects.equals(choice, EXIT_CHOICE)) {
            printMenu();
            choice = input.getInt("Enter an option (1, 2, 3, 4, 5 or 6): ");
            switch (choice) {
                case 1 -> {
                    // Prints all contacts
                    Toolkit.getDefaultToolkit().beep();
                    contactList.printContacts();
                }
                case 2 -> {
                    // Adds contact if format is correct
                    Toolkit.getDefaultToolkit().beep();
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
                // May be better to use .contains (requires strings...toStringList?)
                // so the program does not rely on an EXACT match but rather just a containing
                // string match. ie "Matthew" returns "Matthew" and "Matthew B"
                // need list of strings of names (and numbers for number search functionality
                case 3 -> {
                    // Allows for partial search inputs that are not case sensitive
                    Toolkit.getDefaultToolkit().beep();
                    String name = input.getString("What contact would you like to search for?: ");
                    for (int i = 0; i < contactList.toStringList().toArray().length; i++) {
                        if (contactList.toStringList().toArray()[i].toString().toLowerCase().contains(name.toLowerCase())) {
                            System.out.println("-------------------------------------");
                            System.out.println(contactList.toStringList().toArray()[i]);
                            System.out.println("-------------------------------------");
                        }
                    }
                    if (!Arrays.toString(contactList.toStringList().toArray()).toLowerCase().contains(name.toLowerCase())) {
                        System.out.println("*---------That contact does not exist---------*");
                    }
                }
                case 4 -> {
                    // Deletes specified contact
                    Toolkit.getDefaultToolkit().beep();
                    String name = input.getString("What contact would you like to delete?: ");
                    if (contactList.removeContact(name) == null) {
                        System.out.println("*---------That contact does not exist---------*");
                    } else {
                        contactList.removeContact(name);
                        System.out.println("-------------------------------------");
                        System.out.println("Removed " + name);
                        System.out.println("-------------------------------------");
                    }
                }
                case 5 -> {
                    // Deletes all contacts by initiating a new ContactList
                    Toolkit.getDefaultToolkit().beep();
                    String deleteAll = input.getString("Are you sure you want to delete all contacts? [ y , n ]: ");
                    if (deleteAll.equalsIgnoreCase("y")) {
                        for (int i = 0; i < contactList.toStringList().size(); i++) {
                            contactList = new ContactsList();
                            System.out.println("-------------------------------------");
                            System.out.println("All contacts removed");
                            System.out.println("-------------------------------------");
                        }
                    }
                }
                default -> {
                    ContactsGateway.writeToFile(contactList);
                    System.out.println("File written");
                }
            }
        }
    }


    private static void printMenu() {
        System.out.print("""
                ********************************
                1. View contacts.
                2. Add a new contact.
                3. Search a contact by name.
                4. Delete an existing contact.
                5. Delete all contacts
                6. Exit.
                ********************************
                """);
    }

    public static Contact addAContact() {
        Input input = new Input();
        String name = input.getString("Enter contact name: ");
        String contactNumber = input.getString("Enter contact number: ");
        System.out.println("-------------------------------------");
        String number = null;
        // Add conditional to check size of number, 10 or 7 digits, and format accordingly...
        if (contactNumber.toCharArray().length == 10) {
            number = contactNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        } else if (contactNumber.toCharArray().length == 7) {
            number = contactNumber.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
        } else {
            System.out.println("*---------Incorrect number format---------*");
            return addAContact();
        }
        Contact newContact = new Contact(name, number);
        if (ContactsListMain.contactList.toStringList().toString().contains(name)) {
            System.out.println("*---------Contact already exists---------*");
            String overwrite = input.getString("Overwrite contact: " + name + "? [ y , n ]");
            // If the answer is No allow the user to enter the information again.
            if (overwrite.equalsIgnoreCase("y")) {
                contactList.removeContact(name);
                System.out.println("Overwriting " + name);
            } else {
                return addAContact();
            }
        }
        System.out.println("Added " + name + " to contacts");
        System.out.println("-------------------------------------");
        return newContact;
    }
}
