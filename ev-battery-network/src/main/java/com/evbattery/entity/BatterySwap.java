package com.evbattery.entity;

public class BatterySwap {

    private int id;
    private int fleetId;
    private int batteryId;
    private String fleetName;
    private String batteryCode;
    private double stateOfHealth;
    private double swapCharge;
    private String status;

    public BatterySwap() {
    }

    public BatterySwap(int id, int fleetId, int batteryId, String fleetName, String batteryCode,
                        double stateOfHealth, double swapCharge, String status) {
        this.id = id;
        this.fleetId = fleetId;
        this.batteryId = batteryId;
        this.fleetName = fleetName;
        this.batteryCode = batteryCode;
        this.stateOfHealth = stateOfHealth;
        this.swapCharge = swapCharge;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFleetId() {
        return fleetId;
    }

    public void setFleetId(int fleetId) {
        this.fleetId = fleetId;
    }

    public int getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(int batteryId) {
        this.batteryId = batteryId;
    }

    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

    public String getBatteryCode() {
        return batteryCode;
    }

    public void setBatteryCode(String batteryCode) {
        this.batteryCode = batteryCode;
    }

    public double getStateOfHealth() {
        return stateOfHealth;
    }

    public void setStateOfHealth(double stateOfHealth) {
        this.stateOfHealth = stateOfHealth;
    }

    public double getSwapCharge() {
        return swapCharge;
    }

    public void setSwapCharge(double swapCharge) {
        this.swapCharge = swapCharge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
