/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Phamb
 */
public class Product {

    private int proId;
    private String proName, proSeller, proImage, proType;
    private int proPrice;

    public Product() {
    }

    public Product(int proId, String proName, String proSeller, String proImage, String proType, int proPrice) {
        this.proId = proId;
        this.proName = proName;
        this.proSeller = proSeller;
        this.proImage = proImage;
        this.proType = proType;
        this.proPrice = proPrice;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProSeller() {
        return proSeller;
    }

    public void setProSeller(String proSeller) {
        this.proSeller = proSeller;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public int getProPrice() {
        return proPrice;
    }

    public void setProPrice(int proPrice) {
        this.proPrice = proPrice;
    }

}
