package SS1.BT.B3;
import SS1.BT.B3.service.OrderFoodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "SS1.BT.B3")
// Cho phép Spring quét toàn bộ package để tìm @Component, @Service, @Repository
public class Main {
    public static void main(String[] args) {
        // Khởi tạo IoC Container dựa trên cấu hình quét package
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        // Lấy Bean OrderFoodService từ Container
        OrderFoodService orderService = context.getBean(OrderFoodService.class);

        // Thử đặt món ăn
        String result1 = orderService.orderFood("user01", "Mì xào bò", 2, 15.0);
        System.out.println(result1);

        String result2 = orderService.orderFood("user02", "Mì xào bò", 5, 15.0);
        System.out.println(result2);

        // Đóng context
        context.close();
    }
}
