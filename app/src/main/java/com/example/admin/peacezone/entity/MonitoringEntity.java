package com.example.admin.peacezone.entity;



/**
 * Created by admin on 2016/8/25.
 */
public class MonitoringEntity {
    private String location;

    public MonitoringEntity(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "MonitoringEntity{" +
                "location='" + location + '\'' +
                '}';
    }
}
