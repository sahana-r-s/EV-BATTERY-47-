package com.evbattery.controller;

import com.evbattery.entity.FleetCustomer;
import com.evbattery.service.FleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FleetController {

    @Autowired
    private FleetService fleetService;

    @GetMapping("/fleets")
    public String listFleets(Model model) {
        model.addAttribute("fleets", fleetService.getAllFleets());
        return "fleets";
    }

    @GetMapping("/fleets/add")
    public String showAddFleetForm(Model model) {
        model.addAttribute("fleetCustomer", new FleetCustomer());
        return "add-fleet";
    }

    @PostMapping("/fleets/add")
    public String addFleet(@ModelAttribute FleetCustomer fleetCustomer) {
        fleetCustomer.setId(0);
        fleetService.addFleet(fleetCustomer);
        return "redirect:/fleets";
    }
}
