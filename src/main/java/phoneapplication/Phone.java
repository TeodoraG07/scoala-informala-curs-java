package phoneapplication;

import java.util.ArrayList;
import java.util.List;

public class Phone implements HandleCalls, HandleContacts, HandleMessages {
    protected String manufacturer;
    protected String model;
    protected String color;
    protected String material;
    protected String imei;
    protected int baterryLive;
    protected List<Call> calllist;
    protected List<Message> messageslist;
    protected List<Contact> contactlist;
    protected int remainingBaterry;


    @Override
    public void call(String phoneNumber) {
        Call call = new Call(phoneNumber);
        this.calllist.add(call);
        System.out.println("Calling " + phoneNumber);
        this.remainingBaterry = remainingBaterry - 2;
    }

    @Override
    public void viewHistory() {
        for (Call call : calllist) {
            System.out.println("Call View History: " + call.callerFirtName + " " + call.callerLastName + " " + call.callerPhone);

        }
    }

    @Override
    public void addContact(int id, String phoneNumber, String firstName, String lastName) {
        Contact newContact = new Contact(id, phoneNumber, firstName, lastName);
        contactlist.add(newContact);
    }

    @Override
    public void viewContact(String firstName) {
        for (Contact contact : contactlist) {
            if (contact.firstName.equals(firstName)) {
                System.out.println("Contact Details: " + "First Name: " + contact.firstName + " Last Name:  " + contact.lastName + " Phone: " + contact.phoneNumber);
            }
        }
    }

    @Override
    public void getFirstContact() {
        if (contactlist != null && !contactlist.isEmpty()) {
            Contact first = contactlist.get(0);
            System.out.println("First Name: " + first.firstName + " Last Name:  " + first.lastName);
        } else {
            System.out.println("No contacts available.");

        }
    }

    @Override
    public void getLastContact() {
        if (contactlist != null && !contactlist.isEmpty()) {
            Contact last = contactlist.get(contactlist.size() - 1);
            System.out.println("Last contact: " + "First Name:" + last.firstName + " Last Name:" + last.lastName);
        } else {
            System.out.println("No contacts available.");

        }
    }

    @Override
    public void sendMessage(String phoneNumber, String messageBody) {
        Message message = new Message(phoneNumber, messageBody);
        messageslist.add(message);
        this.remainingBaterry = remainingBaterry - 1;
    }

    @Override
    public void seeMessage() {

    }

    @Override
    public void getFirstMessage(String phoneNumber) {
        List<Message> messagesfiltered = new ArrayList<>();
        for (Message message : messageslist) {
            if (phoneNumber.equals(phoneNumber)) {
                messagesfiltered.add(message);
                Message first = messagesfiltered.get(0);
                {
                    System.out.println("First message for " + first.phoneNumber + " : " + first.messageBody);
                    return;
                }
            }
        }
    }

    @Override
    public void getLastMessage(String phoneNumber) {
        List<Message> messagesFiltered = new ArrayList<>();
        for (Message message : messageslist) {
            if (phoneNumber.equals(phoneNumber)) {
                messagesFiltered.add(message);
                Message last = messagesFiltered.get(messagesFiltered.size() - 1);
                {
                    System.out.println("Last message for " + last.phoneNumber + " : " + last.messageBody);
                    return;
                }

            }
        }
    }

    @Override
    public void getSecondMessage(String phoneNumber) {
        List<Message> messagesfiltered = new ArrayList<>();

        for (Message message : messageslist) {
            if (phoneNumber.equals(phoneNumber)) {
                if (messagesfiltered.size() >= 2) {
                    Message second = messagesfiltered.get(1);
                    System.out.println("Second message: " + second.messageBody);
                } else {
                    System.out.println("Less than two messages found.");
                    return;
                }
            }

        }

    }
}
