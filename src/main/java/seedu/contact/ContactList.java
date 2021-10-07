package seedu.contact;

import java.util.ArrayList;

public class ContactList {
    public static final int NAME_INDEX = 0;
    public static final int GITHUB_INDEX = 1;

    private ArrayList<Contact> contacts;

    public ContactList() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void editContact(String[] contactDetails, int contactIndex) {
        for (int i = 0; i < contactDetails.length; i++) {
            if (contactDetails[i] != null) {
                switch (i) {
                case NAME_INDEX:
                    contacts.get(contactIndex).setName(contactDetails[i]);
                    break;
                case GITHUB_INDEX:
                    contacts.get(contactIndex).setGithub(contactDetails[i]);
                    break;
                default:
                    System.out.println("Index error has occurred.");
                    break;
                }
            }
        }
    }

    public void deleteContact(int deletedIndex) {
        contacts.remove(deletedIndex);
    }

    public int getIndexOfContact(Contact contact) {
        return contacts.indexOf(contact);
    }

    public Contact getContactAtIndex(int index) {
        return contacts.get(index);
    }

    public int getListSize() {
        return contacts.size();
    }
}