package SS1.BT.B4.service;

import SS1.BT.B4.repository.EmailRepository;
import SS1.BT.B4.repository.SmsRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final EmailRepository emailRepository;  // dependency gửi email
    private final SmsRipository smsRipository;      // dependency gửi SMS

    // Constructor Injection: Spring sẽ tự động tiêm EmailSender và SmsSender vào đây
    @Autowired
    public NotificationService(EmailRepository emailRepository, SmsRipository smsRipository) {
        this.emailRepository = emailRepository;
        this.smsRipository = smsRipository;
    }

    public void sendNotification(String userId, String message) {
        // Gửi email luôn thành công
        emailRepository.send(userId, message);

        try {
            // Gửi SMS, có thể bị lỗi mạng
            smsRipository.send(userId, message);
        } catch (Exception e) {
            // Xử lý fallback: nếu SMS fail thì log lỗi, vẫn coi như thông báo đã gửi qua email
            System.out.println("SMS service unavailable, fallback to email only.");
        }
    }
}
