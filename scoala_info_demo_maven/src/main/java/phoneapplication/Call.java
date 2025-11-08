package phoneapplication;

public class Call {
    protected int callId;
    protected String callerFirtName;
    protected String callerLastName;
    protected String callerPhone;

    public Call(int callId, String callerFirtName, String callerLastName, String callerPhone) {
        this.callId = callId;
        this.callerFirtName = callerFirtName;
        this.callerLastName = callerLastName;
        this.callerPhone = callerPhone;
    }

    public Call(String callerPhone) {
        this.callerPhone = callerPhone;
        this.callerFirtName = "Unknown";
        this.callerLastName = "Unknown";
    }
}
