/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sportsclub.duminda.model;

/**
 *
 * @author Duminda
 */
public class Athlete {
 
    private int atheleteId;
    private String firstName;
    private String contactNumber;
    private String emailAddress;
    private String sports[];

    /**
     * @return the atheleteId
     */
    public int getAtheleteId() {
        return atheleteId;
    }

    /**
     * @param atheleteId the atheleteId to set
     */
    public void setAtheleteId(int atheleteId) {
        this.atheleteId = atheleteId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the sportss
     */
    public String[] getSports() {
        return sports;
    }

    /**
     * @param sportss the sportss to set
     */
    public void setSports(String[] sports) {
        this.sports = sports;
    }
    
    
    
}
