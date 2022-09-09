package com.igauk.foodbook.models;

import com.igauk.foodbook.Location;

import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Food {

    public static final int DESCRIPTION_CHARACTER_LENGTH = 30;

    private final ObjectId id = new ObjectId();
    private String description;
    private LocalDate bestBeforeDate;
    private Location location;
    private int count;
    private BigDecimal unitCost;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return id.equals(food.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public Food(String description, LocalDate bestBeforeDate, Location location, int count, BigDecimal unitCost) {
        this.setDescription(description);
        this.setBestBeforeDate(bestBeforeDate);
        this.setLocation(location);
        this.setCount(count);
        this.setUnitCost(unitCost);
    }

    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for the food item. Must be less than {@link #DESCRIPTION_CHARACTER_LENGTH} characters
     */
    public void setDescription(String description) {
        if (description.length() > DESCRIPTION_CHARACTER_LENGTH) {
            // TODO: exception handling
        }
        this.description = description;
    }

    /**
     * Returns the best before date of the item, formatted in {@link DateTimeFormatter#ISO_DATE_TIME} format
     */
    public String getBestBeforeDate() {
        return bestBeforeDate.toString();
//         return bestBeforeDate.format(DateTimeFormatter.ISO_DATE);
    }

    public void setBestBeforeDate(LocalDate bestBeforeDate) {
        this.bestBeforeDate = bestBeforeDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getCount() {
        return count;
    }

    /**
     * Sets the count of the item, this count must be positive
     */
    public void setCount(int count) {
        if (count < 0) {
            // TODO: throw some error
        }
        this.count = count;
    }

    /**
     * Adds one to the item count
     * TODO: extract set scale to a helper
     */
    public void incrementCount() {
        this.count++;
    }

    public BigDecimal getUnitCost() {
        return unitCost.setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * Returns the total cost of the item, ie. the unit cost times the count
     */
    public BigDecimal getTotalCost() {
        return unitCost.multiply(BigDecimal.valueOf(count)).setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setUnitCost(BigDecimal unitCost) {
        if (BigDecimal.ZERO.compareTo(unitCost) > 0) {
            // TODO: throw some error
        }
        this.unitCost = unitCost;
    }
}
