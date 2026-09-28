package com.evbattery;

import com.evbattery.entity.BatteryPack;
import com.evbattery.entity.FleetCustomer;
import com.evbattery.service.BatteryService;
import com.evbattery.service.FleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// This class runs once when the application starts.
// It loads a few sample records into memory so the site is not empty.
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private BatteryService batteryService;

    @Autowired
    private FleetService fleetService;

    @Override
    public void run(String... args) {

        batteryService.addBattery(new BatteryPack(0, "BAT001", 50, 90, "AVAILABLE"));
        batteryService.addBattery(new BatteryPack(0, "BAT002", 45, 75, "AVAILABLE"));
        batteryService.addBattery(new BatteryPack(0, "BAT003", 50, 65, "RECYCLING"));

        fleetService.addFleet(new FleetCustomer(0, "Green Taxi Fleet", "Arun", "9876543210"));
        fleetService.addFleet(new FleetCustomer(0, "City EV Fleet", "Kumar", "9876543211"));
    }
}
