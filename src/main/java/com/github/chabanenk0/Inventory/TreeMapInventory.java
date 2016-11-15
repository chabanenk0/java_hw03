package com.github.chabanenk0.Inventory;

import com.github.chabanenk0.Product.ProductsBatch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Created by dmitry on 16.11.16.
 */
public class TreeMapInventory extends HashMapInventory
{
    public TreeMapInventory()
    {
        this.productBatchesMapById = new TreeMap<Long, ProductsBatch>();
        productBatchListsMapByType = new HashMap<Long, LinkedList<ProductsBatch>>();
    }

}
