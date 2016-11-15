package com.github.chabanenk0.Inventory;

import com.github.chabanenk0.Exception.KeyDuplicateException;
import com.github.chabanenk0.Exception.KeyNotFoundException;
import com.github.chabanenk0.Product.ProductsBatch;

import java.util.*;

/**
 * Created by dmitry on 15.11.16.
 */
public class HashMapInventory implements InventoryInterface {
    // hash map for searching product batches by id
    protected Map<Long, ProductsBatch> productBatchesMapById;

    protected Map<Long, LinkedList<ProductsBatch>> productBatchListsMapByType;

    public HashMapInventory()
    {
        productBatchesMapById = new HashMap<Long, ProductsBatch>();
        productBatchListsMapByType = new HashMap<Long, LinkedList<ProductsBatch>>();
    }

    public void add(ProductsBatch product) throws KeyDuplicateException {
        this.addProductToIdsHashMap(product);
        this.addProductToTypesHashMap(product);
    }

    protected void addProductToIdsHashMap(ProductsBatch product) throws KeyDuplicateException {
        long productId = product.getId();
        if (this.productBatchesMapById.containsKey(productId)) {
            throw new KeyDuplicateException("Cannot add item! Key " + productId + "already exists in the collection");
        }

        productBatchesMapById.put(product.getId(), product);
    }

    protected void addProductToTypesHashMap(ProductsBatch product)
    {
        long typeCode = product.getTypeCode();
        LinkedList<ProductsBatch> productBatchList = null;
        if (this.productBatchListsMapByType.containsKey(typeCode)) {
            productBatchList = productBatchListsMapByType.get(typeCode);
        } else {
            // new type - create new linked list and add it to the hash map
            productBatchList = new LinkedList<ProductsBatch>();
            this.productBatchListsMapByType.put(typeCode, productBatchList);
        }
        productBatchList.add(product);
    }

    public void remove(long batchId) throws Exception
    {
        this.removeProductFromTypesHashMap(batchId);
        this.removeProductItemFromIdsHashMap(batchId);
    }

    protected void removeProductItemFromIdsHashMap(long batchId) throws KeyNotFoundException {
        if (!this.productBatchesMapById.containsKey(batchId)) {
            throw new KeyNotFoundException("Cannot remove item! Key " + batchId + "is not present in the hashmap");
        }
        productBatchesMapById.remove(batchId);
    }
    protected void removeProductFromTypesHashMap(long batchId) throws KeyNotFoundException {
        if (!this.productBatchesMapById.containsKey(batchId)) {
            throw new KeyNotFoundException("Cannot remove item! Key " + batchId + "is not present in the hashmap");
        }
        ProductsBatch product = productBatchesMapById.get(batchId);

        long productTypeCode = product.getTypeCode();
        LinkedList<ProductsBatch> listForSpecifiedType = this.productBatchListsMapByType.get(productTypeCode);
        listForSpecifiedType.remove(product);
    }

    /**
     * Returns the total price of all products in the warehouse
     * @return double
     */
    public double getTotalPrice() {
        double totalPrice = 0;
        for(long key: this.productBatchesMapById.keySet()) {
            ProductsBatch productsBatch = this.productBatchesMapById.get(key);
            totalPrice += productsBatch.getItemPrice() * productsBatch.getQuantity();
        }

        return totalPrice;
    }

    /**
     * Returns the total count of all products in the warehouse
     * @return long
     */
    public long getTotalCount() {
        long totalCount = 0;
        for(long key: this.productBatchesMapById.keySet()) {
            ProductsBatch productsBatch = this.productBatchesMapById.get(key);
            totalCount += productsBatch.getQuantity();
        }

        return totalCount;
    }

    /**
     *
     * @param batchId
     * @return ProductsBatch
     * @throws KeyNotFoundException
     */
    public ProductsBatch findOneById(long batchId) throws KeyNotFoundException {
        if (!this.productBatchesMapById.containsKey(batchId)) {
            throw new KeyNotFoundException("Cannot find item! Key " + batchId + "is not present in the hashmap");
        }

        return productBatchesMapById.get(batchId);
    }

    public Collection<ProductsBatch> findAllByName(String name) {
        LinkedList<ProductsBatch> foundItems = new LinkedList<ProductsBatch>();
        for(long key: this.productBatchesMapById.keySet()) {
            ProductsBatch productsBatch = this.productBatchesMapById.get(key);
            if (productsBatch.getName().indexOf(name) > 0) {
                foundItems.add(productsBatch);
            }
        }

        return foundItems;
    }

    public long countProductsByName(String name) {
        long count = 0;
        for(long key: this.productBatchesMapById.keySet()) {
            ProductsBatch productsBatch = this.productBatchesMapById.get(key);
            if (productsBatch.getName().indexOf(name) > 0) {
                count++;
            }
        }

        return count;
    }

    public double getTotalPriceOfProductsByName(String name) {
        double totalPrice = 0;
        for(long key: this.productBatchesMapById.keySet()) {
            ProductsBatch productsBatch = this.productBatchesMapById.get(key);
            if (productsBatch.getName().indexOf(name) > 0) {
                totalPrice += productsBatch.getItemPrice() * productsBatch.getQuantity();
            }
        }

        return totalPrice;
    }

    public Collection<ProductsBatch> findAllByTypeCode(long typeCode) {
        return null;
    }

    public long countProductsByTypeCode(long typeCode) {
        if (!this.productBatchListsMapByType.containsKey(typeCode)) {
            return 0;
        }

        return this.productBatchListsMapByType.get(typeCode).size();
    }

    public double getTotalPriceOfProductsByTypeCode(long typeCode) {
        if (!this.productBatchListsMapByType.containsKey(typeCode)) {
            return 0;
        }

        LinkedList<ProductsBatch> productsList = this.productBatchListsMapByType.get(typeCode);
        double totalPrice = 0;
        for(ProductsBatch productsBatch: productsList) {
            totalPrice += productsBatch.getItemPrice() * productsBatch.getQuantity();
        }

        return totalPrice;
    }
}
