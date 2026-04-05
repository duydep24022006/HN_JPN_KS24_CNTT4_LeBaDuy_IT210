package SS1.test.service;

public class EmailService implements MessageService {
    @Override
    public void sendMessage(){
        System.out.println("tin nhắn Email");
    }
}
