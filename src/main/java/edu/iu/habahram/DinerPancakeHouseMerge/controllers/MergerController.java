package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Customer;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CustomerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    MergerRepository mergerRepository;
    CustomerRepository customerRepository;

    public MergerController(MergerRepository mergerRepository, CustomerRepository customerRepository) {
        this.mergerRepository = mergerRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        return items;
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarian() {
        List<MenuItemRecord> items = mergerRepository.getVegetarianMenu();
        return items;
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfast() {
        List<MenuItemRecord> items = mergerRepository.getBreakfastMenu();
        return items;
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunch() {
        List<MenuItemRecord> items = mergerRepository.getLunchMenu();
        return items;
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> getSupper() {
        List<MenuItemRecord> items = mergerRepository.getSupperMenu();
        return items;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}