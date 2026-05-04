package re.cntt4.javawebapplication_session15_lesson1.thucthi;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Tìm kiếm sản phẩm theo danh mục, giá <= maxPrice và còn hàng
    List<Product> findByCategoryAndPriceLessThanEqualAndStockQuantityGreaterThan(
            String category, Double maxPrice, Integer stockQuantityThreshold
    );
}
