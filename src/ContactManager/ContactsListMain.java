package ContactManager;


public class ContactsListMain {
    public static void main(String[] args) {
        Input input = new Input();

        ContactsList contact = new ContactsList();

        Contact Chase = new Contact("Chase", "210-887-9341");
        Contact John = new Contact("John", "210-123-4567");
        System.out.println(Contact.createFromString("Chase"));
        contact.addContact(Chase);
        contact.addContact(John);
        contact.printContacts();
        contact.removeContact("John");
        contact.printContacts();
        System.out.println(contact.getIndexByContactName("John"));
        System.out.println(contact.getContactByName("Chase"));
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
