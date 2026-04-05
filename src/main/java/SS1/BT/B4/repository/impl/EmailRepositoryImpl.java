package SS1.BT.B4.repository.impl;

import SS1.BT.B4.repository.EmailRepository;
import org.springframework.stereotype.Component;

@Component
public class EmailRepositoryImpl implements EmailRepository {
    @Override
    public void send(String userId, String message) {
        System.out.println("Email sent to " + userId + ": " + message);
    }
}
