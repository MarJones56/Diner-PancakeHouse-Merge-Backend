package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    PancakeHouseRepository pancakeHouseRepository;
    DinerRepository dinerRepository;
    public MergerController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
    }

    @GetMapping
    public List<MenuItem> get(){
        MenuItem[] dinerMenu = dinerRepository.getTheMenu();
        List<MenuItem> pancakeMenu = pancakeHouseRepository.getTheMenu();
        pancakeMenu.addAll(List.of(dinerMenu));
        Collections.sort(pancakeMenu, Comparator.comparing(MenuItem::getName));
        return pancakeMenu;
    }
}
