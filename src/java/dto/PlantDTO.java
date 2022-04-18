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
public class PlantDTO {
    int ID;
    String name;
    float price;
    String description;
    Date createDate;
    String cateID;

    public PlantDTO() {
    }

    public PlantDTO(int ID, String name, float price, String description, Date createDate, String cateID) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.createDate = createDate;
        this.cateID = cateID;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    @Override
    public String toString() {
        return "plantDTO{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", cateID='" + cateID + '\'' +
                '}';
    }
}
