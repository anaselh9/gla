package gla.delivery.deliveryback.controller;

import gla.delivery.deliveryback.exception.ResourceNotFoundException;
import gla.delivery.deliveryback.models.Order;
import gla.delivery.deliveryback.repositrory.OrderRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    //get orders
    @GetMapping("orders")
    public List<Order> getAllOrder(){
        return this.orderRepository.findAll();
    }
    //get order by id
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value="id") Long orderId)
    throws ResourceNotFoundException {
        Order order= orderRepository.findById(orderId)
                .orElseThrow(()->new ResourceNotFoundException("Order not found for this id ::"+orderId));
        return ResponseEntity.ok().body(order);
    }


    //save order
    @PostMapping("orders")
    public Order createOrder(@RequestBody Order order){
        return this.orderRepository.save(order);
    }
    //update order
    @PutMapping("orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long orderId, @Validated @RequestBody Order orderDetails) throws ResourceNotFoundException{
        Order order =orderRepository.findById(orderId)
                .orElseThrow(()->new ResourceNotFoundException("Order not found for this id ::"+orderId));
        order.setName(orderDetails.getName());
        order.setCountry(orderDetails.getCountry());
        order.setAddressline1(orderDetails.getAddressline1());
        order.setAddressline2(orderDetails.getAddressline1());
        order.setCity(orderDetails.getCity());
        order.setPostal_code(orderDetails.getPostal_code());
        order.setPhone(orderDetails.getPhone());
        order.setAdditionnalnotes(orderDetails.getAdditionnalnotes());
        order.setGate_code(orderDetails.getGate_code());
        return ResponseEntity.ok(this.orderRepository.save(order));
    }
    //delete order
    @DeleteMapping("orders/{id}")
    public Map<String,Boolean> deleteOrder(@PathVariable(value="id") Long orderId) throws  ResourceNotFoundException{
        Order order =orderRepository.findById(orderId)
                .orElseThrow(()->new ResourceNotFoundException("Order not found for this id ::"+orderId));
        this.orderRepository.delete(order);
         Map<String,Boolean> response= new HashMap<>();
         response.put("deleted",Boolean.TRUE);
         return response;
    }
}
