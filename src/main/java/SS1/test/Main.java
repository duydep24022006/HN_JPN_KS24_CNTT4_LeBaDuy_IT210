package SS1.test;

import SS1.test.controller.MessageController;
import SS1.test.service.EmailService;
import SS1.test.service.FacebookService;
import SS1.test.service.MessageService;
import SS1.test.service.ZaloService;

public class Main {

    public static void main(String[] args) {
        MessageService diEmailService=new EmailService();
        MessageService diFacebookService=new FacebookService();
        MessageService diZaloService=new ZaloService();
        MessageController msgControlle=new MessageController(diZaloService);
        msgControlle.sendMessage();
    }
}
