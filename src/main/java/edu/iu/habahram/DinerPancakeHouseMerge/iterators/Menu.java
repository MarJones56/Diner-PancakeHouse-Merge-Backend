package edu.iu.habahram.DinerPancakeHouseMerge.iterators;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;

import java.util.Iterator;

public interface Menu {
    public Iterator<MenuItem> createIterator();
}
