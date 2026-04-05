package SS1.BT.B3.repository.impl;

import SS1.BT.B3.repository.InventoryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {
    // Giả lập kho bằng HashMap: tên món -> số lượng
    private final Map<String, Integer> stock = new HashMap<>();
    public InventoryRepositoryImpl() {
        // Khởi tạo dữ liệu giả lập
        stock.put("Mì xào bò", 5);
        stock.put("Mì tôm", 10);
    }
    @Override
    public boolean isAvailable(String foodName, int quantity) {
        // Kiểm tra số lượng trong kho có đủ không
        return stock.getOrDefault(foodName, 0) >= quantity;
    }

    @Override
    public void reduceStock(String foodName, int quantity) {
        // Giảm số lượng món trong kho
        stock.put(foodName, stock.get(foodName) - quantity);
    }
}
