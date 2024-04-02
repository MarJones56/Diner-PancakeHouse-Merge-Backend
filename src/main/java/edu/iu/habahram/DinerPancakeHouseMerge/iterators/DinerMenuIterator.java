package edu.iu.habahram.DinerPancakeHouseMerge.iterators;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;

public class DinerMenuIterator implements Iterator{
    MenuItem[] items;
    int position = 0;
    public DinerMenuIterator (MenuItem[] items){
        this.items = items;
    }
    public boolean hasNext() {
        if (position >= items.length){
            return false;
        } else {
            return true;
        }
    }
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }
}
