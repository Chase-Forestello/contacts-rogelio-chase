package ContactManager;


import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class ContactsListMain {
    public static final int INVALID_CHOICE = -1;
    public static final int EXIT_CHOICE = 5;

    public static void main(String[] args) {
        Input input = new Input();

        ContactsList contactList = new ContactsList();

        String test = """
                John|210-123-3333
                Chase|210-8879341
                    
                """;
        Contact.createFromString(test);
        System.out.println(test.lines().count());
        for (int i = 1; i < test.lines().count() ; i++) {
            System.out.println(Contact.createFromString(test));
        }


        Contact Chase = new Contact("Chase", "210-887-9341");
        Contact John = new Contact("John", "210-123-4567");
//        System.out.println(Contact.createFromString("Chase"));
        contactList.addContact(Chase);
        contactList.addContact(John);
//        contact.printContacts();
//        contact.removeContact("John");
//        System.out.println(contactList.getContactByName("Chase"));

        int choice = INVALID_CHOICE;
        while (!Objects.equals(choice, EXIT_CHOICE)) {
            printMenu();
            choice = input.getInt("What would you like to do?");
            switch (choice) {
                case 1 -> {
                    contactList.printContacts();
                }
                case 2 -> {
                    String oName = input.getString("Enter contact name: ");
                    String contactNumber = input.getString("Enter contact number: ");
                    Contact newContact = new Contact(oName, contactNumber);
                    contactList.addContact(newContact);
                }
                case 3 -> {
                    String name = input.getString("What contact would you like to search? ");
                    System.out.println(contactList.getContactByName(name));

                }
                case 4 -> {
                    String name = input.getString("What contact would you like to delete? ");
                    contactList.removeContact(name);
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
}
