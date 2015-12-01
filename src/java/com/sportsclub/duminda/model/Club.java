/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sportsclub.duminda.model;

/**
 *
 * @author ESOFT
 */
public class Club {

    private int clubId;
    private String clubName;
    private String emailAddress;
    private String telephoneNumber;

    /**
     * @return the clubId
     */
    public int getClubId() {
        return clubId;
    }

    /**
     * @param clubId the clubId to set
     */
    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    /**
     * @return the clubName
     */
    public String getClubName() {
        return clubName;
    }

    /**
     * @param clubName the clubName to set
     */
    public void setClubName(String clubName) {
        this.clubName = clubName;
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
     * @return the telephoneNumber
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * @param telephoneNumber the telephoneNumber to set
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    
    
}
