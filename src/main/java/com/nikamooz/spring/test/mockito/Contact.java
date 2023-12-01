package com.nikamooz.spring.test.mockito;

public class Contact {
    String city;
    String address;
    String telephone;
    String mobile;

    public Contact(String city, String address, String telephone, String mobile) {
        this.city = city;
        this.address = address;
        this.telephone = telephone;
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
