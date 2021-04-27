package com.trajour.journey;

import com.trajour.model.User;
import javafx.scene.image.Image;
import com.trajour.db.DatabaseQuery;

import java.time.LocalDate;

import static com.trajour.db.DatabaseQuery.insertNewJourney;

/**
 * A simple Java class!
*/
public class Journey implements Comparable<Journey>, Postable {
    // Properties
    private int journeyID;
    private String location;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    // Constructors
    public Journey( int journeyID, String location, String description, LocalDate startDate, LocalDate endDate) {
        this.journeyID = journeyID;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addNewJourney(User user) {
        insertNewJourney(this, user);
    }

    public boolean removeJourney() {
        return DatabaseQuery.removeJourney(this);
    }
    
    // Methods
    public Post post(String comments, Image image) {
        return new Post(this, comments, image);
    }
    /**
     * This method returns the journey id.
     * @return journeyID 
    */
    public int getJourneyID() {
        return journeyID;
    }
    
    /**
     * This method returns the location.
     * @return location 
    */
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * This method returns the startDate.
     * @return startDate
    */
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    /**
     * This method returns the endDate.
     * @return endDate
    */
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * This method returns the description.
     * @return description
    */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Location: " + getLocation() + ", Start-End Date: " + startDate + " - " + endDate;
    }
	@Override
	public int compareTo(Journey o) {
        return startDate.compareTo(endDate);
	}
}