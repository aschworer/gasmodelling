/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.model;

import java.io.Serializable;

/**
 * Created: 18.10.2007 || 18:35:20
 *
 *
 */
public class Shedule implements Serializable {
    //    private Employee employee;
    private boolean mondayFlag;
    private boolean tuesdayFlag;
    private boolean wednesdayFlag;
    private boolean thursdayFlag;
    private boolean fridayFlag;
    private boolean saturdayFlag;
    private boolean sundayFlag;

    private int id;


    public Shedule() {
    }

    public Shedule(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean getMondayFlag() {
        return mondayFlag;
    }

    public void setMondayFlag(boolean mondayFlag) {
        this.mondayFlag = mondayFlag;
    }

    public boolean getTuesdayFlag() {
        return tuesdayFlag;
    }

    public void setTuesdayFlag(boolean tuesdayFlag) {
        this.tuesdayFlag = tuesdayFlag;
    }

    public boolean getWednesdayFlag() {
        return wednesdayFlag;
    }

    public void setWednesdayFlag(boolean wednesdayFlag) {
        this.wednesdayFlag = wednesdayFlag;
    }

    public boolean getThursdayFlag() {
        return thursdayFlag;
    }

    public void setThursdayFlag(boolean thursdayFlag) {
        this.thursdayFlag = thursdayFlag;
    }

    public boolean getFridayFlag() {
        return fridayFlag;
    }

    public void setFridayFlag(boolean fridayFlag) {
        this.fridayFlag = fridayFlag;
    }

    public boolean getSaturdayFlag() {
        return saturdayFlag;
    }

    public void setSaturdayFlag(boolean saturdayFlag) {
        this.saturdayFlag = saturdayFlag;
    }

    public boolean getSundayFlag() {
        return sundayFlag;
    }

    public void setSundayFlag(boolean sundayFlag) {
        this.sundayFlag = sundayFlag;
    }
}
