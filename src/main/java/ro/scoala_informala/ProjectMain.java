//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ro.scoala_informala;

public class ProjectMain {
    public static void main(String[] args) {
        phoneapplication.Phone phone = new phoneapplication.SamsungGalaxy6();
        phone.addContact(1, "phone number", "first name", "last name");
        phone.addContact(2, "second phone number", "second first name", "second last name");
        phone.getFirstContact();
        phone.getLastContact();
        phone.sendMessage("phone number", "message content");
        phone.getFirstMessage("phone number");
        phone.getSecondMessage("phone number");
        phone.call("second phone number");
        phone.viewHistory();
    }
}
