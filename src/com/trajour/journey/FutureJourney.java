package com.trajour.journey;

import java.time.LocalDate;

/**
 * A subclass of journey for future journeys of the user.
 */
public class FutureJourney extends Journey {
    
    // Constructor
    public FutureJourney(String location, String description, LocalDate startDate, LocalDate endDate) {
        super(location, description, startDate, endDate);
    }

    /**
     * Converts future journey to a current one.
     */
    public CurrentJourney convertToCurrentJourney() {
        return new CurrentJourney(getLocation(), getDescription(), getStartDate(), getEndDate());
    }
}
