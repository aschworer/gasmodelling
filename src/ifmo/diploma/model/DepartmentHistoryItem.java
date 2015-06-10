/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created: 18.10.2007 || 18:40:37
 *
 *
 */
public class DepartmentHistoryItem implements Serializable {
    public static final String TABLE = "departments_history";

    private int id;
    private Department changedTo;
    private Date changedWhenDateFormat;
    private String changedWhen;
    private Employee employee;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Department getChangedTo() {
        return changedTo;
    }

    public void setChangedTo(Department changedTo) {
        this.changedTo = changedTo;
    }


    public Date getChangedWhenDateFormat() {
        return changedWhenDateFormat;
    }

    public void setChangedWhenDateFormat(Date changedWhenDateFormat) {
        this.changedWhenDateFormat = changedWhenDateFormat;
        this.setChangedWhen(changedWhenDateFormat.toString());
    }

    public String getChangedWhen() {
        return changedWhen;
    }

    public void setChangedWhen(String changedWhen) {
        this.changedWhen = changedWhen;
//        if (changedWhen == null) {
//            changedWhenDateFormat = new java.sql.Date(System.currentTimeMillis());
//        } else if ("".equals(changedWhen)) {
//            changedWhenDateFormat = new java.sql.Date(System.currentTimeMillis());
//        } else {
//            try{
//            this.changedWhenDateFormat = java.sql.Date.valueOf(changedWhen);
//            }catch(Exception e){
//
//            }
//        }
    }

    public void initDate() {
        if (changedWhen == null) {
            changedWhenDateFormat = new java.sql.Date(System.currentTimeMillis());
        } else if ("".equals(changedWhen)) {
            changedWhenDateFormat = new java.sql.Date(System.currentTimeMillis());
        } else {
            try {
                this.changedWhenDateFormat = java.sql.Date.valueOf(changedWhen);
            } catch (Exception e) {
            }
        }

    }
}
