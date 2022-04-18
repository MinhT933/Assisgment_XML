/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author pc
 */
public class plantDTO {
    int id;
    String name;
    float price;
    String cateID;
    String createDate;
    

    public plantDTO(int id, String name, float price, String cateID, String createDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cateID = cateID;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "plantDTO{" + "id=" + id + ", name=" + name + ", price=" + price + ", cateID=" + cateID + ", createDate=" + createDate + '}';
    }

   
    

}
