package com.evbattery.repository;

import com.evbattery.entity.FleetCustomer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FleetRepository {

    private final List<FleetCustomer> fleets = new ArrayList<>();
    private int nextId = 1;

    public FleetCustomer save(FleetCustomer fleet) {
        if (fleet.getId() == 0) {
            fleet.setId(nextId++);
            fleets.add(fleet);
        }
        return fleet;
    }

    public List<FleetCustomer> findAll() {
        return fleets;
    }

    public FleetCustomer findById(int id) {
        for (FleetCustomer fleet : fleets) {
            if (fleet.getId() == id) {
                return fleet;
            }
        }
        return null;
    }
}
