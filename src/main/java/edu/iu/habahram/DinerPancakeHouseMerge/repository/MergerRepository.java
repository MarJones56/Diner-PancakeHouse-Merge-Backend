package edu.iu.habahram.DinerPancakeHouseMerge.repository;
import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MergerRepository {
    public List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return records;
    }

    public List<MenuItemRecord> getVegetarianMenu() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .filter(MenuItem::isVegetarian)
                .map(x -> new MenuItemRecord(x.getName(), x.getDescription(), x.isVegetarian(), x.getPrice())).toList();

        return records;
    }

    public List<MenuItemRecord> getBreakfastMenu() {
        MenuComponent breakfastMenu = new Menu("BREAKFAST MENU", "Breakfast");
        breakfastMenu.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        MenuItem[] menuItems = breakfastMenu.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return records;
    }

    public List<MenuItemRecord> getLunchMenu() {
        MenuComponent lunchMenu = new Menu("LUNCH MENU", "Lunch");
        lunchMenu.add(new DinerMenu("DINER MENU", "Lunch"));
        MenuItem[] menuItems = lunchMenu.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return records;
    }

    public List<MenuItemRecord> getSupperMenu() {
        MenuComponent dinnerMenu = new Menu("DINNER MENU", "Dinner");
        dinnerMenu.add(new CafeMenu("CAFE MENU", "Dinner"));
        MenuItem[] menuItems = dinnerMenu.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return records;
    }
}
