/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangdh.dtos;

/**
 *
 * @author PC
 */
public class ProductDTO {
    String productID;
    String name;
    float price;
    int quantity;
    String description;
    String categoryID;
    String img;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String name, float price, int quantity, String description, String categoryID, String img) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.categoryID = categoryID;
        this.img = img;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
