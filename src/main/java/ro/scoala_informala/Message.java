//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package phoneapplication;

public class Message {
    protected String messageBody;
    protected String messageFrom;
    protected String messageTo;
    protected int messageID;
    protected String phoneNumber;

    public Message(String messageBody, String messageFrom, String messageTo, int messageID, String phoneNumber) {
        this.messageBody = messageBody;
        if (messageBody.length() >= 500) {
            this.messageBody = messageBody.substring(0, 500);
        }

        this.messageFrom = messageFrom;
        this.messageTo = messageTo;
        this.messageID = messageID;
        this.phoneNumber = phoneNumber;
    }

    public Message(String phoneNumber, String messageBody) {
        this.messageBody = messageBody;
        this.phoneNumber = phoneNumber;
        if (messageBody.length() >= 500) {
            this.messageBody = messageBody.substring(0, 500);
        }

    }
}
