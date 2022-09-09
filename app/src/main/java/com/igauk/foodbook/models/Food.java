package com.igauk.foodbook.models;

import com.igauk.foodbook.Location;

import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class Food {

    public static final int DESCRIPTION_CHARACTER_LENGTH = 30;

    private ObjectId id;
    private String description;
    private LocalDate bestBeforeDate;
    private Location location;
    private int count;
    private BigDecimal unitCost;

    // TODO: constructor without id

    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for the food item. Must be less than
     * {@link #DESCRIPTION_CHARACTER_LENGTH} characters
     */
    public void setDescription(String description) {
        if (description.length() > DESCRIPTION_CHARACTER_LENGTH) {
            // TODO: exception handling
        }
        this.description = description;
    }

    /**
     * Returns the best before date of the item, formatted in
     * {@link DateTimeFormatter#ISO_DATE_TIME} format
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
     */
    public void incrementCount() {
        this.count++;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    // TODO: must be larger than 0
    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }
}
