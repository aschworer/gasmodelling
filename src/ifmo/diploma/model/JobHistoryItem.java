/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created: 18.10.2007 || 18:41:25
 *
 *
 */
public class JobHistoryItem implements Serializable {
    public static final String TABLE = "employee_job_history";

    private int id;
    private String company;
    private String position;
    private Date fromDateFormat;
    private String from;
    private Date tillDateFormat;
    private String till;
    private String note;
    private Employee employee;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getFromDateFormat() {
        return fromDateFormat;
    }

    public void setFromDateFormat(Date fromDateFormat) {
        this.fromDateFormat = fromDateFormat;
        if (fromDateFormat != null) {
            this.from = fromDateFormat.toString();
        }
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
//        if (from != null) {
//            fromDateFormat = java.sql.Date.valueOf(this.from);
//        }
    }

    public Date getTillDateFormat() {
        return tillDateFormat;
    }

    public void setTillDateFormat(Date tillDateFormat) {
        this.tillDateFormat = tillDateFormat;
        if (tillDateFormat != null) {
            this.till = tillDateFormat.toString();
        }
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public String getTill() {
        return till;
    }

    public void setTill(String till) {
        this.till = till;
//        if (till != null) {
//            try{
//            tillDateFormat = java.sql.Date.valueOf(this.till);
//            }catch(Exception e){
//
//            }
//        }
    }

    public void initDates() {
        if (till == null) {
            tillDateFormat = new java.sql.Date(System.currentTimeMillis());
        } else if ("".equals(till)) {
            tillDateFormat = new java.sql.Date(System.currentTimeMillis());
        } else {
            try {
                this.tillDateFormat = java.sql.Date.valueOf(till);
            } catch (Exception e) {
            }
        }

        if (from == null) {
            fromDateFormat = new java.sql.Date(System.currentTimeMillis());
        } else if ("".equals(from)) {
            fromDateFormat = new java.sql.Date(System.currentTimeMillis());
        } else {
            try {
                this.fromDateFormat = java.sql.Date.valueOf(from);
            } catch (Exception e) {
            }
        }

    }
}
