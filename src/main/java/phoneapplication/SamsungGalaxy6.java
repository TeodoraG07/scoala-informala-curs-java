package phoneapplication;

public class SamsungGalaxy6 extends Samsung {
    protected Message messages;
    protected Contact contacts;
    protected Call calls;

    public SamsungGalaxy6(int batteryLive, String manufacturer, String model, String color, String material, String imei, Message messages, Contact contacts, Call calls) {
        super(batteryLive, manufacturer, model, color, material, imei);
        this.messages = messages;
        this.contacts = contacts;
        this.calls = calls;
        this.calllist = calllist;
        this.contactlist = contactlist;
        this.messageslist = messageslist;
    }
    public SamsungGalaxy6 (){
        super (10,"Samsung", "S6", "blue", "glass", "private");
        this.messages = messages;
        this.contacts = contacts;
        this.calls = calls;
    }
}
