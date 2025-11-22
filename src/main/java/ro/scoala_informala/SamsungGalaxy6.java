//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package phoneapplication;

public class SamsungGalaxy6 extends phoneapplication.Samsung {
    protected phoneapplication.Message messages;
    protected phoneapplication.Contact contacts;
    protected phoneapplication.Call calls;

    public SamsungGalaxy6(int batteryLive, String manufacturer, String model, String color, String material, String imei, phoneapplication.Message messages, phoneapplication.Contact contacts, phoneapplication.Call calls) {
        super(batteryLive, manufacturer, model, color, material, imei);
        this.messages = messages;
        this.contacts = contacts;
        this.calls = calls;
        this.calllist = this.calllist;
        this.contactlist = this.contactlist;
        this.messageslist = this.messageslist;
    }

    public SamsungGalaxy6() {
        super(10, "Samsung", "S6", "blue", "glass", "private");
        this.messages = this.messages;
        this.contacts = this.contacts;
        this.calls = this.calls;
    }
}
