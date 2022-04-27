/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.orderfulfillment.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "T_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "order_date", nullable = false)
    private Date orderDate;
    
    @Column(name = "person_id", nullable = false)
    private Integer personId;
    
    @Column(name = "status", nullable = false, length =  50)
    private String Status;
    
    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;
    
    @Column(name = "cart_id", nullable = false)
    private Integer cartId;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personid) {
        this.personId = personid;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }
    
    
}
