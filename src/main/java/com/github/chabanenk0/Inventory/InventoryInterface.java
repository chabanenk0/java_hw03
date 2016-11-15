package com.github.chabanenk0.Inventory;

import com.github.chabanenk0.Exception.KeyNotFoundException;
import com.github.chabanenk0.Product.ProductsBatch;

import java.util.Collection;

/**
 * Interface for inventory objects
 * Created by dchabanenko on 10.11.16.
 */
interface InventoryInterface
{
    /**
     * Add a new product batch
     * @param product
     */
    public void add(ProductsBatch product) throws Exception;

    /**
     * Remove product batch by id
     * @param batchId
     */
    public void remove(long batchId) throws Exception;

    /**
     * Calculates the total price of all products in the warehouse
     * @return
     */
    public double getTotalPrice();

    /**
     * get count of all products in the warehouse
     * @return int
     */

    public long getTotalCount();
    /**
     * find one product batch by id
     * @param batchId
     * @return
     */
    public ProductsBatch findOneById(long batchId) throws Exception;

    /**
     * find all product batches by name (part of the name)
     * @param name
     * @return
     */
    public Collection<ProductsBatch> findAllByName(String name);

    /**
     * Count the number of products with name (part of the name) matched
     * @param name
     * @return
     */
    public long countProductsByName(String name);

    /**
     * Calculate the total price of products with name (part of the name) matched
     * @param name
     * @return
     */
    public double getTotalPriceOfProductsByName(String name);

    /**
     * Return the collection of products with certain typeCode
     * @param typeCode
     * @return
     */
    public Collection<ProductsBatch> findAllByTypeCode(long typeCode);

    /**
     * Count the number of products with certain typeCode
     * @param typeCode
     * @return
     */
    public long countProductsByTypeCode(long typeCode) throws KeyNotFoundException;
    /**
     * Calculate the total price of products with certain typeCode
     * @param typeCode
     * @return
     */
    public double getTotalPriceOfProductsByTypeCode(long typeCode);
}
