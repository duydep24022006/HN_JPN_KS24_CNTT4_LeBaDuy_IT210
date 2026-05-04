package re.cntt4.javawebapplication_session15_lesson3;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByUserIdAndStatus(Long userId, String status, Pageable pageable);
}
