package com.evbattery.service;

import com.evbattery.entity.FleetCustomer;
import com.evbattery.repository.FleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FleetService {

    @Autowired
    private FleetRepository fleetRepository;

    public FleetCustomer addFleet(FleetCustomer fleet) {
        return fleetRepository.save(fleet);
    }

    public List<FleetCustomer> getAllFleets() {
        return fleetRepository.findAll();
    }

    public FleetCustomer getFleetById(int id) {
        return fleetRepository.findById(id);
    }
}
