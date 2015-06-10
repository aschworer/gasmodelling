/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created: 18.10.2007 || 18:40:44
 *
 *
 */
public class PositionHistoryItem implements Serializable {
    public static final String TABLE = "positions_history";

    private int id;
    private Position changedTo;
    private String changedWhen;
    private Date changedWhenDateFormat;
    private Employee employee;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position getChangedTo() {
        return changedTo;
    }

    public void setChangedTo(Position changedTo) {
        this.changedTo = changedTo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
