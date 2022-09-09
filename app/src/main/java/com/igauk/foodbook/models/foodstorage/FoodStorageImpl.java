package com.igauk.foodbook.models.foodstorage;

import com.igauk.foodbook.models.Food;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FoodStorageImpl implements FoodStorage {

    private Set<Food> storage = new HashSet<>();

    public Collection<Food> getAll() {
        return null;
    }

    public boolean addFood(Food food) {
        return storage.add(food);
    }

    public boolean removeFood(Food food) {
        return storage.remove(food);
    }

    // TODO: decide wether this should be multiple methods
    public boolean modifyFood(Food food) {
        if (!storage.contains(food)) {
            // TODO: throw error
        }
        storage.remove(food);
        return storage.add(food);
    }

    public BigDecimal getTotalCost() {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (Food item : storage) {
            totalCost = totalCost.add(item.getTotalCost());
        }
        return totalCost;
    }
}
