import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    Contact next;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }
}

class Phonebook {
    Contact head;

    public Phonebook() {
        this.head = null;
    }

    public void addContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        if (head == null) {
            head = newContact;
        } else {
            Contact current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newContact;
        }
    }

    public void displayContacts() {
        Contact current = head;
        if (current == null) {
            System.out.println("No contacts found.");
        } else {
            while (current != null) {
                System.out.println("Name: " + current.name);
                System.out.println("Phone Number: " + current.phoneNumber);
                System.out.println("------------------------");
                current = current.next;
            }
        }
    }

    public void searchContact(String name) {
        Contact current = head;
        boolean found = false;
        if (current == null) {
            System.out.println("No contacts found.");
        } else {
            while (current != null) {
                if (current.name.equalsIgnoreCase(name)) {
                    System.out.println("Name: " + current.name);
                    System.out.println("Phone Number: " + current.phoneNumber);
                    found = true;
                    break;
                }
                current = current.next;
            }
            if (!found) {
                System.out.println("Contact not found.");
            }
        }
    }
}

public class PhonebookApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Phonebook phonebook = new Phonebook();
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = sc.next();
                    phonebook.addContact(name, phoneNumber);
                    break;
                case 2:
                    phonebook.displayContacts();
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.next();
                    phonebook.searchContact(searchName);
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
