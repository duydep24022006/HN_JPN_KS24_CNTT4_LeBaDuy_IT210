package SS1.BT.B4.repository.impl;

import SS1.BT.B4.repository.SmsRipository;
import org.springframework.stereotype.Component;

@Component
public class SmsRipositoryImpl implements SmsRipository {
    @Override
    public void send(String userId, String message) {
        if (Math.random() < 0.5) {
            throw new RuntimeException("SMS service connection failed!");
        }
        System.out.println("Sms sent to " + userId + ": " + message);
    }
}
