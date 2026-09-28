package com.evbattery.repository;

import com.evbattery.entity.BatteryPack;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BatteryRepository {

    private final List<BatteryPack> batteries = new ArrayList<>();
    private int nextId = 1;

    public BatteryPack save(BatteryPack battery) {
        if (battery.getId() == 0) {
            battery.setId(nextId++);
            batteries.add(battery);
        }
        return battery;
    }

    public List<BatteryPack> findAll() {
        return batteries;
    }

    public BatteryPack findById(int id) {
        for (BatteryPack battery : batteries) {
            if (battery.getId() == id) {
                return battery;
            }
        }
        return null;
    }
}
