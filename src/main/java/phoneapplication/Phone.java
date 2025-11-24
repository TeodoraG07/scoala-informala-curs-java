//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package phoneapplication;

import java.util.ArrayList;
import java.util.List;

public class Phone implements phoneapplication.HandleCalls, phoneapplication.HandleContacts, phoneapplication.HandleMessages {
    protected String manufacturer;
    protected String model;
    protected String color;
    protected String material;
    protected String imei;
    protected int baterryLive;
    protected List<phoneapplication.Call> calllist;
    protected List<phoneapplication.Message> messageslist;
    protected List<phoneapplication.Contact> contactlist;
    protected int remainingBaterry;

    public void call(String phoneNumber) {
        phoneapplication.Call call = new phoneapplication.Call(phoneNumber);
        this.calllist.add(call);
        System.out.println("Calling " + phoneNumber);
        this.remainingBaterry -= 2;
    }

    public void viewHistory() {
        for(phoneapplication.Call call : this.calllist) {
            System.out.println("Call View History: " + call.callerFirtName + " " + call.callerLastName + " " + call.callerPhone);
        }

    }

    public void addContact(int id, String phoneNumber, String firstName, String lastName) {
        phoneapplication.Contact newContact = new phoneapplication.Contact(id, phoneNumber, firstName, lastName);
        this.contactlist.add(newContact);
    }

    public void viewContact(String firstName) {
        for(phoneapplication.Contact contact : this.contactlist) {
            if (contact.firstName.equals(firstName)) {
                System.out.println("Contact Details: First Name: " + contact.firstName + " Last Name:  " + contact.lastName + " Phone: " + contact.phoneNumber);
            }
        }

    }

    public void getFirstContact() {
        if (this.contactlist != null && !this.contactlist.isEmpty()) {
            phoneapplication.Contact first = (phoneapplication.Contact)this.contactlist.get(0);
            System.out.println("First Name: " + first.firstName + " Last Name:  " + first.lastName);
        } else {
            System.out.println("No contacts available.");
        }

    }

    public void getLastContact() {
        if (this.contactlist != null && !this.contactlist.isEmpty()) {
            phoneapplication.Contact last = (phoneapplication.Contact)this.contactlist.get(this.contactlist.size() - 1);
            System.out.println("Last contact: First Name:" + last.firstName + " Last Name:" + last.lastName);
        } else {
            System.out.println("No contacts available.");
        }

    }

    public void sendMessage(String phoneNumber, String messageBody) {
        phoneapplication.Message message = new phoneapplication.Message(phoneNumber, messageBody);
        this.messageslist.add(message);
        --this.remainingBaterry;
    }

    public void seeMessage() {
    }

    public void getFirstMessage(String phoneNumber) {
        List<phoneapplication.Message> messagesfiltered = new ArrayList();

        for(phoneapplication.Message message : this.messageslist) {
            if (phoneNumber.equals(phoneNumber)) {
                messagesfiltered.add(message);
                phoneapplication.Message first = (phoneapplication.Message)messagesfiltered.get(0);
                System.out.println("First message for " + first.phoneNumber + " : " + first.messageBody);
                return;
            }
        }

    }

    public void getLastMessage(String phoneNumber) {
        List<phoneapplication.Message> messagesFiltered = new ArrayList();

        for(phoneapplication.Message message : this.messageslist) {
            if (phoneNumber.equals(phoneNumber)) {
                messagesFiltered.add(message);
                phoneapplication.Message last = (phoneapplication.Message)messagesFiltered.get(messagesFiltered.size() - 1);
                System.out.println("Last message for " + last.phoneNumber + " : " + last.messageBody);
                return;
            }
        }

    }

    public void getSecondMessage(String phoneNumber) {
        List<phoneapplication.Message> messagesfiltered = new ArrayList();

        for(phoneapplication.Message message : this.messageslist) {
            if (phoneNumber.equals(phoneNumber)) {
                if (messagesfiltered.size() < 2) {
                    System.out.println("Less than two messages found.");
                    return;
                }

                phoneapplication.Message second = (phoneapplication.Message)messagesfiltered.get(1);
                System.out.println("Second message: " + second.messageBody);
            }
        }

    }
}

