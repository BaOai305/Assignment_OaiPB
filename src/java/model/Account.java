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
public class Account {

    private String password, name, address1, address2, phoneNumber;
    private boolean typeOfUser;

    public Account() {
    }

    public Account(String password, String name, String address1, String address2, String phoneNumber, boolean typeOfUser) {
        this.password = password;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.phoneNumber = phoneNumber;
        this.typeOfUser = typeOfUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(boolean typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

}
