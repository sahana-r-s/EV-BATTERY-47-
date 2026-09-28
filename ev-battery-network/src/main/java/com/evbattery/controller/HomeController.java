package com.evbattery.controller;

import com.evbattery.service.BatteryService;
import com.evbattery.service.FleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private BatteryService batteryService;

    @Autowired
    private FleetService fleetService;

    @GetMapping("/")
    public String home(Model model) {

        int totalBatteries = batteryService.getAllBatteries().size();

        int availableBatteries = 0;
        for (var battery : batteryService.getAllBatteries()) {
            if ("AVAILABLE".equals(battery.getStatus())) {
                availableBatteries++;
            }
        }

        int totalFleets = fleetService.getAllFleets().size();
        int recyclingBatteries = batteryService.getRecyclingBatteries().size();

        model.addAttribute("totalBatteries", totalBatteries);
        model.addAttribute("availableBatteries", availableBatteries);
        model.addAttribute("totalFleets", totalFleets);
        model.addAttribute("recyclingBatteries", recyclingBatteries);

        return "index";
    }
}
