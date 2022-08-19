package ContactManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContactsGateway {
    public static void writeToFile(ContactsList contactsList) {
//        Made path object
        Path filePath = getFilePath();
        if(filePath == null) {
            System.out.println("Filepath was not able to be created. Can not save.");
            return;
        }
//        Temporary list of strings that are the contacts
//        Then write those to the file
        List<String> contactsStrings =  contactsList.toStringList();
        // 3. use Files.write to send the data to the file
        writeItemStringsToFilePath(filePath, contactsStrings);

    }
    private static void writeItemStringsToFilePath(Path filePath, List<String> contactsStrings) {
        try {
            Files.write(filePath, contactsStrings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ContactsList readFromFile() {
        ContactsList list = new ContactsList();

        // 1. make a path object
        Path filePath = getFilePath();
        if(filePath == null) {
            System.out.println("Filepath could not be created. Cannot load.");
            return list;
        }

        // 2. read item strings from file
        List<String> contactStrings = readItemStringsFromFilePath(filePath);

        // 3. make items from the items strings and put them in the groceryList
        for(String contactsString : contactStrings) {
            Contact contacts = Contact.createFromString(contactsString);
            list.addContact(contacts);
        }
        return list;
    }

    private static List<String> readItemStringsFromFilePath(Path filePath) {
        try {
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Path getFilePath () {
        try {
            Path folder = Paths.get("contacts_list");
            Path file = Paths.get("contacts_list", "data.txt");
            if (!Files.exists(folder)) {
                Files.createDirectories(folder);
            }
            if (!Files.exists(file)) {
                Files.createFile(file);
            }
            return file;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

