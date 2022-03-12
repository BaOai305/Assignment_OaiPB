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
public class Seller {

    private int sellerId;
    private String sellerName, sellerAddress, sellerPhone;

    public Seller() {
    }

    public Seller(int sellerId, String sellerName, String sellerAddress, String sellerPhone) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerAddress = sellerAddress;
        this.sellerPhone = sellerPhone;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

}
