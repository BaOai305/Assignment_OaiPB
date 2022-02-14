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

    private String proName, proSeller, proImage;
    private int proPrice;

    public Product() {
    }

    public Product(String proName, String proSeller, String proImage, int proPrice) {
        this.proName = proName;
        this.proSeller = proSeller;
        this.proImage = proImage;
        this.proPrice = proPrice;
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

    public int getProPrice() {
        return proPrice;
    }

    public void setProPrice(int proPrice) {
        this.proPrice = proPrice;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

}
