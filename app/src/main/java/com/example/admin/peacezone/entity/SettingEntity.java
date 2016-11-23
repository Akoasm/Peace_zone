package com.example.admin.peacezone.entity;

/**
 * Created by admin on 2016/9/19.
 */
public class SettingEntity {
    private String update;

    public SettingEntity(String update) {
        this.update = update;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "SettingEntity{" +
                "update='" + update + '\'' +
                '}';
    }
}
