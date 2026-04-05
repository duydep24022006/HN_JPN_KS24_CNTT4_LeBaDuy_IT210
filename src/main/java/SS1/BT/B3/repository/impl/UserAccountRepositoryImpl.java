package SS1.BT.B3.repository.impl;

import SS1.BT.B3.repository.UserAccountRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {
    // Giả lập dữ liệu tài khoản: userId -> số dư
    private final Map<String, Double> accounts = new HashMap<>();
    public UserAccountRepositoryImpl() {
        accounts.put("user01", 100.0);
        accounts.put("user02", 20.0);
    }

    @Override
    public boolean hasEnoughBalance(String userId, double price) {
        // Kiểm tra số dư >= giá món
        return accounts.getOrDefault(userId, 0.0) >= price;
    }

    @Override
    public void deductBalance(String userId, double price) {
        // Trừ tiền từ tài khoản
        accounts.put(userId, accounts.get(userId) - price);
    }
}
