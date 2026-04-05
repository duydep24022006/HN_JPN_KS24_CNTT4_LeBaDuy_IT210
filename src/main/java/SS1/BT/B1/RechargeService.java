package SS1.BT.B1;

public class RechargeService
{
    private final PaymentGateway gateway;//dependency đc khai báo là final để đảm bảo bất biến
    // Constructor Injection: dependency được truyền từ bên ngoài
    public RechargeService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void processRecharge(String username, double amount) {
        gateway.pay(amount);
        System.out.println("Nạp " + amount + " cho " + username);
    }
}
