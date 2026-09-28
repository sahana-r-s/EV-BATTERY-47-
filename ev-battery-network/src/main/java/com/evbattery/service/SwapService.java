package com.evbattery.service;

import com.evbattery.entity.BatteryPack;
import com.evbattery.entity.BatterySwap;
import com.evbattery.entity.FleetCustomer;
import com.evbattery.repository.BatteryRepository;
import com.evbattery.repository.FleetRepository;
import com.evbattery.repository.SwapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwapService {

    @Autowired
    private SwapRepository swapRepository;

    @Autowired
    private BatteryRepository batteryRepository;

    @Autowired
    private FleetRepository fleetRepository;

    // Business rule: if State of Health is below 70%, the battery must be sent for recycling
    public boolean checkBatteryHealth(double stateOfHealth) {
        return stateOfHealth < 70;
    }

    public BatterySwap performSwap(int fleetId, int batteryId, double stateOfHealth, double swapCharge) {

        FleetCustomer fleet = fleetRepository.findById(fleetId);
        BatteryPack battery = batteryRepository.findById(batteryId);

        boolean recyclingRequired = checkBatteryHealth(stateOfHealth);
        String newStatus = recyclingRequired ? "RECYCLING" : "CHARGING";

        // update the battery with the latest health reading and new status
        battery.setStateOfHealth(stateOfHealth);
        battery.setStatus(newStatus);
        batteryRepository.save(battery);

        BatterySwap swap = new BatterySwap(
                0,
                fleetId,
                batteryId,
                fleet.getFleetName(),
                battery.getBatteryCode(),
                stateOfHealth,
                swapCharge,
                newStatus
        );

        return swapRepository.save(swap);
    }

    public List<BatterySwap> getAllSwaps() {
        return swapRepository.findAll();
    }
}
