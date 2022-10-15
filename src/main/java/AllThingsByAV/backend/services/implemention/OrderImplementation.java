package AllThingsByAV.backend.services.implemention;

import AllThingsByAV.backend.models.Order;
import AllThingsByAV.backend.repositories.OrderRepository;
import AllThingsByAV.backend.services.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderImplementation implements OrderService {
    private final OrderRepository orderRepository;

    public OrderImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Object[] getAll() {
        return orderRepository.findAll().toArray();
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order get(Long id) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
