package edu.iu.habahram.DinerPancakeHouseMerge.iterators;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position;
    Calendar date = Calendar.getInstance();
    int day_of_week = date.get (Calendar.DAY_OF_WEEK);

    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        position = 0;
    }
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
}