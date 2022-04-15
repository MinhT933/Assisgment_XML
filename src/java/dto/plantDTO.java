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
    int ID;
    String name;
    float price;
    String CateID;
    Date createDate;

    public plantDTO(int ID, String name, float price, String CateID, Date createDate) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.CateID = CateID;
        this.createDate = createDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
        return CateID;
    }

    public void setCateID(String CateID) {
        this.CateID = CateID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "plantDTO{" + "ID=" + ID + ", name=" + name + ", price=" + price + ", CateID=" + CateID + ", createDate=" + createDate + '}';
    }
    
    
}
