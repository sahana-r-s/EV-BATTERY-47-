package com.evbattery.repository;

import com.evbattery.entity.BatterySwap;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SwapRepository {

    private final List<BatterySwap> swaps = new ArrayList<>();
    private int nextId = 1;

    public BatterySwap save(BatterySwap swap) {
        swap.setId(nextId++);
        swaps.add(swap);
        return swap;
    }

    public List<BatterySwap> findAll() {
        return swaps;
    }
}
