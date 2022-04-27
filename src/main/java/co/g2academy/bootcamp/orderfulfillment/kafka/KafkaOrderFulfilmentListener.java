/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.orderfulfillment.kafka;

import co.g2academy.bootcamp.orderfulfillment.entity.Order;
import co.g2academy.bootcamp.orderfulfillment.entity.OrderItem;
import co.g2academy.bootcamp.storefront.model.OrderItemModel;
import co.g2academy.bootcamp.storefront.model.OrderModel;
import co.g2academy.bootcamp.orderfulfillment.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */
@Component
public class KafkaOrderFulfilmentListener {
    @Autowired
    private OrderRepository orderRepository;
    
    @KafkaListener(topics = "order-fulfillment", groupId = "foo", containerFactory = "kafkaListenerFactory")
    public void listenerOrderFulfillmentTopic(@Payload OrderModel orderModel){
        orderRepository.save(convertOrderModelToOrder(orderModel));
                
    }
    
    public Order convertOrderModelToOrder(OrderModel orderModel){
        Order order = new Order();
        order.setCartId(orderModel.getCartId());
        order.setOrderDate(orderModel.getOrderDate());
        order.setPersonId(orderModel.getPersonId());
        order.setStatus(orderModel.getStatus());
        order.setTotalPrice(orderModel.getTotalPrice());
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemModel orderItemModel : orderModel.getOrderItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setPrice(orderItemModel.getPrice());
            orderItem.setProductId(orderItemModel.getProductId());
            orderItem.setProductName(orderItemModel.getProductName());
            orderItem.setQuantity(orderItemModel.getQuantity());
            orderItems.add(orderItem);
        }
        order.setOrderItem(orderItems);
        return order;
    }
}
