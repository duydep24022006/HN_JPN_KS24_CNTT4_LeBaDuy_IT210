package SS1.BT.B3.repository;

public interface UserAccountRepository {
    // Kiểm tra số dư có đủ để thanh toán không
    boolean hasEnoughBalance(String userId, double price);

    // Trừ tiền từ tài khoản
    void deductBalance(String userId, double price);
}
