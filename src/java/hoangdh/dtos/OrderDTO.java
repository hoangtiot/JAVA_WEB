/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangdh.dtos;

import java.sql.Timestamp;

/**
 *
 * @author PC
 */
public class OrderDTO {
    String orderID;
    Timestamp orderDate;
    float orderTotal;
    String userID;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, Timestamp orderDate, float orderTotal, String userID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.userID = userID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
}
