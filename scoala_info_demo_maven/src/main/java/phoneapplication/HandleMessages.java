package phoneapplication;

public interface HandleMessages {
    void sendMessage(String phoneNumber, String messageBody);

    void seeMessage();

    void getFirstMessage(String phoneNumber);

    void getLastMessage(String phoneNumber);

    void getSecondMessage(String phoneNumber);

}
