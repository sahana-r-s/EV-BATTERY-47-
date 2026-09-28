package com.evbattery.service;

import com.evbattery.entity.BatteryPack;
import com.evbattery.repository.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatteryService {

    @Autowired
    private BatteryRepository batteryRepository;

    public BatteryPack addBattery(BatteryPack battery) {
        return batteryRepository.save(battery);
    }

    public List<BatteryPack> getAllBatteries() {
        return batteryRepository.findAll();
    }

    public BatteryPack getBatteryById(int id) {
        return batteryRepository.findById(id);
    }

    // Business rule: any battery below 70% State of Health needs recycling
    public List<BatteryPack> getRecyclingBatteries() {
        List<BatteryPack> recyclingList = new ArrayList<>();
        for (BatteryPack battery : batteryRepository.findAll()) {
            if (battery.getStateOfHealth() < 70) {
                recyclingList.add(battery);
            }
        }
        return recyclingList;
    }
}
