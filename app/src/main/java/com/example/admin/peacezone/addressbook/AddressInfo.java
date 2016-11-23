package com.example.admin.peacezone.addressbook;

/**
 * Created by admin on 2016/8/30.
 */
public class AddressInfo {

    public  static String [] linkman = new String[]{"攻了"} ;
    private String namePinyin;
    private String name;
    private String firstPinyin;

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstPinyin(){
        firstPinyin = namePinyin.substring(0,1);
        return  firstPinyin;
    }
}
