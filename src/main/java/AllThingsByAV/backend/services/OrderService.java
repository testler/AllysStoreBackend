package AllThingsByAV.backend.services;

import AllThingsByAV.backend.models.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    Object[] getAll();
    Order create(Order order);
    Order get(Long id);
    Order update(Order order);
    Boolean delete(Long id);
}
