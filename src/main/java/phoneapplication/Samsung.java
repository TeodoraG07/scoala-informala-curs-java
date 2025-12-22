package phoneapplication;

import java.util.ArrayList;

public class Samsung extends Phone {

    private final int batteryLive;
    protected Message messages;
    protected Contact contacts;
    protected Call calls;


    public Samsung(int batteryLive, String manufacturer, String model, String color, String material, String imei) {
        this.batteryLive = this.baterryLive;
        this.manufacturer = this.manufacturer;
        this.model = this.model;
        this.color = this.color;
        this.material = this.material;
        this.imei = this.imei;
        this.calllist = new ArrayList<>();
        this.contactlist = new ArrayList<>();
        this.messageslist = new ArrayList<>();
        this.messages = messages;
        this.contacts = contacts;
        this.calls = calls;
        this.remainingBaterry = batteryLive;
    }


}




