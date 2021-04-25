/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangdh.dtos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC
 */
public class CartDTO {
    private Map<String, OrderDetailDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, OrderDetailDTO> cart) {
        this.cart = cart;
    }

    public Map<String, OrderDetailDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, OrderDetailDTO> cart) {
        this.cart = cart;
    }
    public void add(OrderDetailDTO o){
        if (this.cart == null){
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(o.getProductID())){
            int quantity = this.cart.get(o.getProductID()).getQuantity();
            o.setQuantity(quantity + o.getQuantity());
        }
        this.cart.put(o.getProductID(), o);
    }
    
    public void delete(String id){
        if (this.cart == null){
            return;
        }
        if (this.cart.containsKey(id)){
            this.cart.remove(id);
        }
    }
    
    public void update(String id, OrderDetailDTO o){
        if (this.cart == null){
            return;
        }
        if (this.cart.containsKey(id)){
            this.cart.replace(id, o);
        }
    }
}
