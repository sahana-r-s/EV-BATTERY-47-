package com.evbattery.entity;

public class FleetCustomer {

    private int id;
    private String fleetName;
    private String driverName;
    private String phone;

    public FleetCustomer() {
    }

    public FleetCustomer(int id, String fleetName, String driverName, String phone) {
        this.id = id;
        this.fleetName = fleetName;
        this.driverName = driverName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
