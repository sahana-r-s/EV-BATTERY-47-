package com.evbattery.controller;

import com.evbattery.entity.BatteryPack;
import com.evbattery.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BatteryController {

    @Autowired
    private BatteryService batteryService;

    @GetMapping("/batteries")
    public String listBatteries(Model model) {
        model.addAttribute("batteries", batteryService.getAllBatteries());
        return "batteries";
    }

    @GetMapping("/batteries/add")
    public String showAddBatteryForm(Model model) {
        model.addAttribute("batteryPack", new BatteryPack());
        return "add-battery";
    }

    @PostMapping("/batteries/add")
    public String addBattery(@ModelAttribute BatteryPack batteryPack) {
        batteryPack.setId(0);
        batteryPack.setStatus("AVAILABLE");
        batteryService.addBattery(batteryPack);
        return "redirect:/batteries";
    }

    @GetMapping("/recycling")
    public String recyclingList(Model model) {
        model.addAttribute("recyclingBatteries", batteryService.getRecyclingBatteries());
        return "recycling";
    }

    @GetMapping("/recycling/process/{id}")
    public String processRecycling(@PathVariable int id) {
        BatteryPack battery = batteryService.getBatteryById(id);
        if (battery != null) {
            battery.setStatus("RECYCLED");
        }
        return "redirect:/recycling";
    }
}
