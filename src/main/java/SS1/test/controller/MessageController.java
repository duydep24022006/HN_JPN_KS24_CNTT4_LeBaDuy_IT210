package SS1.test.controller;

import SS1.test.service.EmailService;
import SS1.test.service.FacebookService;
import SS1.test.service.MessageService;

public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }
    public void sendMessage(){
        messageService.sendMessage();
    }

}
