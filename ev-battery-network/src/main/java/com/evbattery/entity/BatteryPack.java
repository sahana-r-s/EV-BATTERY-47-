package com.evbattery.entity;

public class BatteryPack {

    private int id;
    private String batteryCode;
    private double capacity;
    private double stateOfHealth;
    private String status; // AVAILABLE, CHARGING, IN_USE, RECYCLING, RECYCLED

    public BatteryPack() {
    }

    public BatteryPack(int id, String batteryCode, double capacity, double stateOfHealth, String status) {
        this.id = id;
        this.batteryCode = batteryCode;
        this.capacity = capacity;
        this.stateOfHealth = stateOfHealth;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatteryCode() {
        return batteryCode;
    }

    public void setBatteryCode(String batteryCode) {
        this.batteryCode = batteryCode;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getStateOfHealth() {
        return stateOfHealth;
    }

    public void setStateOfHealth(double stateOfHealth) {
        this.stateOfHealth = stateOfHealth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
