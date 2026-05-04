package re.cntt4.javawebapplication_session15_lesson3;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Page<Order> getOrders(Long userId, String status, int page, int size, String sortBy, String direction) {
        // Bẫy 1: kiểm tra tham số page
        if (page < 0) page = 0;

        // Bẫy 2: kiểm tra sortBy hợp lệ
        List<String> validSortColumns = Arrays.asList("createdDate", "totalAmount");
        if (!validSortColumns.contains(sortBy)) {
            sortBy = "createdDate"; // mặc định
        }

        Sort sort = direction.equalsIgnoreCase("ASC") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        return orderRepository.findByUserIdAndStatus(userId, status, pageable);
    }
}
