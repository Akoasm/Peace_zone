package com.example.admin.peacezone.addressbook;

/**
 * Created by admin on 2016/8/25.
 */
public class AddressItemEntity {
    private String name;
    private String phone;
    private String location;

    public AddressItemEntity(String name, String phone, String location) {
        this.name = name;
        this.phone = phone;
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



}
