package com.igauk.foodbook.models.foodstorage;

import com.igauk.foodbook.models.Food;

import java.math.BigDecimal;
import java.util.Collection;

public interface FoodStorage {

    /**
     * Returns all of the food in the storage
     */
    Collection<Food> getAll();

    /**
     * Adds a food item to the storage
     * @param food to add
     */
    boolean addFood(Food food);

    /**
     * Removes a food item from the storage
     * @param food to remove
     */
    boolean removeFood(Food food);

    /**
     * Changes the information about a given food
     */
    boolean modifyFood(Food food);

    /**
     * Returns the total cost of the food in the storage
     */
    BigDecimal getTotalCost();



}
