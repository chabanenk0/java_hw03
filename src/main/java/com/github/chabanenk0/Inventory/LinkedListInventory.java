package com.github.chabanenk0.Inventory;

import com.github.chabanenk0.Product.ProductsBatch;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by dchabanenko on 10.11.16.
 */
public class LinkedListInventory implements InventoryInterface
{
    private LinkedList<ProductsBatch> productBatchesCollection;

    public LinkedListInventory()
    {
        this.productBatchesCollection = new LinkedList<ProductsBatch>();
    }

    public void add(ProductsBatch product)
    {
        this.productBatchesCollection.addLast(product);
    }

    public void remove(long batchId) throws Exception {
        ProductsBatch productsBatchFound = this.findOneById(batchId);
        this.productBatchesCollection.remove(productsBatchFound);
    }

    /**
     * Returns the total price of all products
     */
    public double getTotalPrice() {
        double totalPrice = 0;
        for (ProductsBatch productsBatch: this.productBatchesCollection) {
            totalPrice += productsBatch.getItemPrice() * productsBatch.getQuantity();
        }

        return totalPrice;
    }

    /**
     * get count of all products in the warehouse
     * @return
     */
    public long getTotalCount()
    {
        long totalCount = 0;
        for (ProductsBatch productsBatch: this.productBatchesCollection) {
            totalCount += productsBatch.getQuantity();
        }

        return totalCount;
    }

    public ProductsBatch findOneById(long batchId) throws Exception {
        ProductsBatch productsBatchFound = null;
        for (ProductsBatch productsBatch: this.productBatchesCollection) {
            if (batchId == productsBatch.getId()) {
                productsBatchFound = productsBatch;
                break;
            }
        }
        if (null == productsBatchFound) {
            throw new Exception("Product batch not found!");
        }

        return productsBatchFound;
    }

    public Collection<ProductsBatch> findAllByName(String name) {
        LinkedList<ProductsBatch> productsBatchesFound = new LinkedList<ProductsBatch>();
        for (ProductsBatch productsBatch: this.productBatchesCollection) {
            if (productsBatch.getName().indexOf(name) > 0) {
                productsBatchesFound.addLast(productsBatch);
            }
        }
        return productsBatchesFound;
    }

    public long countProductsByName(String name) {
        LinkedList<ProductsBatch> productsBatchesFound = (LinkedList<ProductsBatch>) this.findAllByName(name);

        return productsBatchesFound.size();
    }

    public double getTotalPriceOfProductsByName(String name) {
        double totalPrice = 0;
        for (ProductsBatch productsBatch: this.productBatchesCollection) {
            if (productsBatch.getName().indexOf(name) > 0) {
                totalPrice += productsBatch.getItemPrice() * productsBatch.getQuantity();
            }
        }

        return totalPrice;
    }

    public Collection<ProductsBatch> findAllByTypeCode(long typeCode) {
        LinkedList<ProductsBatch> productsBatchesFound = new LinkedList<ProductsBatch>();
        for (ProductsBatch productsBatch: this.productBatchesCollection) {
            if (productsBatch.getTypeCode() == typeCode) {
                productsBatchesFound.addLast(productsBatch);
            }
        }
        return productsBatchesFound;
    }

    public long countProductsByTypeCode(long typeCode) {
        LinkedList<ProductsBatch> productsBatchesFound = (LinkedList<ProductsBatch>) this.findAllByTypeCode(typeCode);

        return productsBatchesFound.size();
    }

    public double getTotalPriceOfProductsByTypeCode(long typeCode) {
        double totalPrice = 0;
        for (ProductsBatch productsBatch: this.productBatchesCollection) {
            if (productsBatch.getTypeCode() == typeCode) {
                totalPrice += productsBatch.getItemPrice() * productsBatch.getQuantity();
            }
        }

        return totalPrice;
    }
}
