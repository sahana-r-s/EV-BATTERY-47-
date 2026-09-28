package com.evbattery.controller;

import com.evbattery.entity.BatterySwap;
import com.evbattery.service.BatteryService;
import com.evbattery.service.FleetService;
import com.evbattery.service.SwapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SwapController {

    @Autowired
    private SwapService swapService;

    @Autowired
    private FleetService fleetService;

    @Autowired
    private BatteryService batteryService;

    @GetMapping("/swaps")
    public String listSwaps(Model model) {
        model.addAttribute("swaps", swapService.getAllSwaps());
        return "swaps";
    }

    @GetMapping("/swaps/add")
    public String showSwapForm(Model model) {
        model.addAttribute("fleets", fleetService.getAllFleets());
        model.addAttribute("batteries", batteryService.getAllBatteries());
        return "battery-swap";
    }

    @PostMapping("/swaps/add")
    public String performSwap(@RequestParam int fleetId,
                               @RequestParam int batteryId,
                               @RequestParam double stateOfHealth,
                               @RequestParam double swapCharge,
                               Model model) {

        BatterySwap result = swapService.performSwap(fleetId, batteryId, stateOfHealth, swapCharge);
        boolean recyclingRequired = swapService.checkBatteryHealth(stateOfHealth);

        model.addAttribute("swapResult", result);
        model.addAttribute("recyclingRequired", recyclingRequired);
        model.addAttribute("fleets", fleetService.getAllFleets());
        model.addAttribute("batteries", batteryService.getAllBatteries());

        return "battery-swap";
    }
}
