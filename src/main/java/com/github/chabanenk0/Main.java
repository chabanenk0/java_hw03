package com.github.chabanenk0;

import com.github.chabanenk0.Inventory.TreeMapInventory;
import com.github.chabanenk0.Product.ProductsBatch;

/**
 * Created by dchabanenko on 10.11.16.
 */
public class Main
{
    public static void main(String[] args)
    {
        //LinkedListInventory inventory = new LinkedListInventory();
        //HashMapInventory inventory = new HashMapInventory();
        TreeMapInventory inventory = new TreeMapInventory();
        try {
            ProductsBatch productBatch1 = new ProductsBatch();
            productBatch1.setId(1);
            productBatch1.setItemPrice(15);
            productBatch1.setName("Makarony");
            productBatch1.setTypeCode(1);
            productBatch1.setQuantity(10);

            inventory.add(productBatch1);

            ProductsBatch productBatch2 = new ProductsBatch();
            productBatch2.setId(2);
            productBatch2.setItemPrice(20);
            productBatch2.setName("Grechka");
            productBatch2.setTypeCode(1);
            productBatch2.setQuantity(8);

            inventory.add(productBatch2);

            ProductsBatch productBatch3 = new ProductsBatch();
            productBatch3.setId(3);
            productBatch3.setItemPrice(25);
            productBatch3.setName("Pelmeni");
            productBatch3.setTypeCode(1);
            productBatch3.setQuantity(5);
            inventory.add(productBatch3);

            ProductsBatch productBatch4 = new ProductsBatch();
            productBatch4.setId(4);
            productBatch4.setItemPrice(10);
            productBatch4.setName("Lamopchka");
            productBatch4.setTypeCode(2);
            productBatch4.setQuantity(5);
            inventory.add(productBatch4);

            ProductsBatch productBatch5 = new ProductsBatch();
            productBatch5.setId(5);
            productBatch5.setItemPrice(23);
            productBatch5.setName("Zubna pasta");
            productBatch5.setTypeCode(3);
            productBatch5.setQuantity(7);
            inventory.add(productBatch5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Total products count:" + inventory.getTotalCount());
        System.out.println("Total products price:" + inventory.getTotalPrice());

        System.out.println("Total products count for type1:" + inventory.countProductsByTypeCode(1));
        System.out.println("Total products pricefor type1:" + inventory.getTotalPriceOfProductsByTypeCode(1));

        System.out.println("Total products count for type2:" + inventory.countProductsByTypeCode(2));
        System.out.println("Total products pricefor type2:" + inventory.getTotalPriceOfProductsByTypeCode(2));

        System.out.println("Total products count for type3:" + inventory.countProductsByTypeCode(3));
        System.out.println("Total products pricefor type3:" + inventory.getTotalPriceOfProductsByTypeCode(3));

    }
}
