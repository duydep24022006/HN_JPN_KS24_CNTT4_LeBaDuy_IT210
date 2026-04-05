package SS1.BT.B4;

import SS1.BT.B4.service.NotificationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "SS1.BT.B4")
// Cho phép Spring quét toàn bộ package để tìm @Component, @Service
public class Main {
    public static void main(String[] args) {
        // Khởi tạo IoC Container
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        // Lấy Bean NotificationService
        NotificationService notificationService = context.getBean(NotificationService.class);

        // Thử gửi thông báo
        notificationService.sendNotification("user01", "Bạn có khuyến mãi mới!");
        notificationService.sendNotification("user02", "Trò chơi của bạn đã kết thúc!");

        // Đóng context
        context.close();
    }
}
