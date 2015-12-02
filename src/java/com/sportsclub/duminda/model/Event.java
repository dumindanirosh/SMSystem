/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sportsclub.duminda.model;

import java.util.Date;

/**
 *
 * @author Duminda
 */
public class Event {
    
    private int eventId;
    private String eventName;
    private String eventDescription;
    private Date eventDate;
    private double eventFee;
    private boolean approvalStatus;

    /**
     * @return the eventId
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * @param eventId the eventId to set
     */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the eventDescription
     */
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * @param eventDescription the eventDescription to set
     */
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    /**
     * @return the eventDate
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * @param eventDate the eventDate to set
     */
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * @return the eventFee
     */
    public double getEventFee() {
        return eventFee;
    }

    /**
     * @param eventFee the eventFee to set
     */
    public void setEventFee(double eventFee) {
        this.eventFee = eventFee;
    }

    /**
     * @return the approvalStatus
     */
    public boolean isApprovalStatus() {
        return approvalStatus;
    }

    /**
     * @param approvalStatus the approvalStatus to set
     */
    public void setApprovalStatus(boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
