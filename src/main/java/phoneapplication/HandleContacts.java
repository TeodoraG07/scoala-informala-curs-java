package phoneapplication;

public interface HandleContacts {
    void addContact(int id, String phoneNumber, String firstName, String lastName);

    void viewContact(String firstName);

    void getFirstContact();

    void getLastContact();
}

