package re.cntt4.javawebapplication_session15_lesson4;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.price = p.price - (p.price * :discountPercentage / 100) " +
            "WHERE p.category = :categoryName AND p.status = 'ACTIVE'")
    int applyDiscountToCategory(@Param("categoryName") String categoryName,
                                @Param("discountPercentage") double discountPercentage);
}
