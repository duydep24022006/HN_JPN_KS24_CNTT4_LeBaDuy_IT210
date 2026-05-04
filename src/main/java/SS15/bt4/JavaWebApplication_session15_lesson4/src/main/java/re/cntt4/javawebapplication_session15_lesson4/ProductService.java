package re.cntt4.javawebapplication_session15_lesson4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public String applyDiscount(String categoryName, double discountPercentage) {
        // Bẫy 1: kiểm tra discountPercentage
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Phần trăm giảm giá không hợp lệ");
        }

        // Thực thi cập nhật
        int updatedCount = productRepository.applyDiscountToCategory(categoryName, discountPercentage);

        // Bẫy 2: kiểm tra số lượng cập nhật
        if (updatedCount == 0) {
            return "Không tìm thấy sản phẩm nào để cập nhật";
        }

        return "Đã cập nhật giá cho " + updatedCount + " sản phẩm";
    }
}
