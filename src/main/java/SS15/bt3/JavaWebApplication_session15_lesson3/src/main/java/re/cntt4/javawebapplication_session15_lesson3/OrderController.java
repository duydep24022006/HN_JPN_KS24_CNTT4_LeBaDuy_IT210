package re.cntt4.javawebapplication_session15_lesson3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String listOrders(@RequestParam Long userId,
                             @RequestParam(required = false, defaultValue = "ALL") String status,
                             @RequestParam(required = false, defaultValue = "0") int page,
                             @RequestParam(required = false, defaultValue = "10") int size,
                             @RequestParam(required = false, defaultValue = "createdDate") String sortBy,
                             @RequestParam(required = false, defaultValue = "DESC") String direction,
                             Model model) {

        Page<Order> orderPage = orderService.getOrders(userId, status, page, size, sortBy, direction);

        // Bẫy 1: nếu page vượt quá tổng số trang
        if (page >= orderPage.getTotalPages() && orderPage.getTotalPages() > 0) {
            page = orderPage.getTotalPages() - 1;
            orderPage = orderService.getOrders(userId, status, page, size, sortBy, direction);
        }

        model.addAttribute("orders", orderPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", orderPage.getTotalPages());
        model.addAttribute("statusFilter", status);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("direction", direction);

        return "order-list";
    }
}
