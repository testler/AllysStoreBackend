package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.models.CartItem;
import AllThingsByAV.backend.repositories.OrderRepository;
import AllThingsByAV.backend.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/guest/checkout")
    public List<CartItem> checkoutCart(){
        List<CartItem> arr = new ArrayList<>();

        return null;
    }
}
