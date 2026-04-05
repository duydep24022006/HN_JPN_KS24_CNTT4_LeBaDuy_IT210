package SS1.BT.B3.service;

import SS1.BT.B3.repository.InventoryRepository;
import SS1.BT.B3.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // Đánh dấu là Service để Spring quản lý
public class OrderFoodService {
    private final InventoryRepository inventoryRepo;
    private final UserAccountRepository accountRepo;

    // Constructor Injection: Spring sẽ tự động tiêm các Repository vào đây
    @Autowired
    public OrderFoodService(InventoryRepository inventoryRepo, UserAccountRepository accountRepo) {
        this.inventoryRepo = inventoryRepo;
        this.accountRepo = accountRepo;
    }
    // Logic đặt món ăn
    public String orderFood(String userId, String foodName, int quantity, double pricePerItem) {
        // 1. Kiểm tra kho
        if (!inventoryRepo.isAvailable(foodName, quantity)) {
            return "Xin lỗi, món " + foodName + " đã hết.";
        }

        // 2. Kiểm tra số dư
        double totalPrice = pricePerItem * quantity;
        if (!accountRepo.hasEnoughBalance(userId, totalPrice)) {
            return "Số dư không đủ để đặt món.";
        }

        // 3. Thực hiện giao dịch
        inventoryRepo.reduceStock(foodName, quantity);
        accountRepo.deductBalance(userId, totalPrice);

        // 4. Trả về kết quả
        return "Đặt món thành công: " + foodName + " x" + quantity;
    }
}
