package sums.smartbar.service;

import groovy.util.logging.Slf4j;
import sums.smartbar.model.Order;
import sums.smartbar.model.OrderProduct;
import sums.smartbar.model.Product;
import sums.smartbar.repository.OrderProductRepository;
import sums.smartbar.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class OrderService {

    @Autowired
    ProductService productService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderProductRepository orderProductRepository;


    public List getAll() {
        return orderRepository.findAll();
    }


    public boolean addOrder(HashMap<Integer,Integer> orderMap) {
        try {

            Order order  = new Order(new Date());
            orderRepository.save(order);
            Iterator it = orderMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                for (int i = 0; i < Integer.valueOf(pair.getValue().toString()) ; i++) {
                    orderProductRepository.save(new OrderProduct(order.getId(), Integer.valueOf(pair.getKey().toString())));
                }
            }
            return true;
        } catch (Exception ex) {
            return false;
        }

        //orderRepository.save(new Order(orderMapWithDrink));
    }
}
