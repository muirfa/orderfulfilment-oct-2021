/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.orderfulfillment.kafka;


import co.g2academy.bootcamp.storefront.model.OrderStatus;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 *
 * @author Asus
 */
public class KafkaListenerCallback implements ListenableFutureCallback<SendResult<String, OrderStatus>>{
    

    @Override
    public void onSuccess(SendResult<String, OrderStatus> result){
        System.out.println("Message sent with result offset: " + result.getRecordMetadata().offset());
    }
    @Override
    public void onFailure(Throwable ex){
        System.out.println("Unable to send message with cause: " + ex.getMessage());
    }
    
}
