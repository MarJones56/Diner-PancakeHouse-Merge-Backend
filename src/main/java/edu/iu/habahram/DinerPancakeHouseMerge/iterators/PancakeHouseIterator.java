package edu.iu.habahram.DinerPancakeHouseMerge.iterators;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import java.util.List;

public class PancakeHouseIterator implements Iterator{
    List<MenuItem> items;
    int position = 0;
    public PancakeHouseIterator (List<MenuItem> items){
        this.items = items;
    }
    public boolean hasNext() {
        if (position >= items.size()){
            return false;
        } else {
            return true;
        }
    }
    public MenuItem next() {
        MenuItem menuItem = items.get(position);
        position++;
        return menuItem;
    }
}
