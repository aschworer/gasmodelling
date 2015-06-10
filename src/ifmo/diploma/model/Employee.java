/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created: 18.10.2007 || 15:49:14
 *
 *
 */

public class Employee implements Serializable {
    public static final String TABLE = "employees";

    private String systemLogin;
    private String systemPass;

    private Long groupId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getSystemLogin() {
        return systemLogin;
    }

    public void setSystemLogin(String systemLogin) {
        this.systemLogin = systemLogin;
    }

    public String getSystemPass() {
        return systemPass;
    }

    public void setSystemPass(String systemPass) {
        this.systemPass = systemPass;
    }

    private int id;
    private String lastname;
    private String firstname;
    private String middlename;
    private String characteristics;

    private String photoCopyFilename;
    private String resumeCopyFilename;

    private Position currentPosition;
    private Department currentDepartment;
    private Passport passport;

    private Shedule shedule;

    private java.sql.Date heiringDate;


    public Date getHeiringDate() {
        return heiringDate;
    }

    public void setHeiringDate(Date heiringDate) {
        this.heiringDate = heiringDate;
    }

    public Shedule getShedule() {
        return shedule;
    }

    public void setShedule(Shedule shedule) {
        this.shedule = shedule;
    }

    public Employee() {
    }

    public Employee(int employeeID) {
        this.id = employeeID;
    }


    public String getPhotoCopyFilename() {
        return photoCopyFilename;
    }

    public void setPhotoCopyFilename(String photoCopyFilename) {
        this.photoCopyFilename = photoCopyFilename;
    }

    public String getResumeCopyFilename() {
        return resumeCopyFilename;
    }

    public void setResumeCopyFilename(String resumeCopyFilename) {
        this.resumeCopyFilename = resumeCopyFilename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Department getCurrentDepartment() {
        return currentDepartment;
    }

    public void setCurrentDepartment(Department currentDepartment) {
        this.currentDepartment = currentDepartment;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String toString() {
        if (getLastname() != null && getFirstname() != null) {
            return lastname + " " + firstname + " " + middlename;
        }
        return "--";
    }

    public String getFullName() {
        return toString();
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;

        return true;
    }

    public int hashCode() {
        return id;
    }
}
