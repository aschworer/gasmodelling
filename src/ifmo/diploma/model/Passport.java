/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created: 18.10.2007 || 15:59:48
 *
 *
 */
public class Passport implements Serializable {
    private int no;
    private int ser;
    private java.sql.Date receivedWhenDateFormat;
    private String receivedWhen;
    private String receivedWhere;
    private String receivedFrom;
    private String passportCopyFilename;

    public String getPassportCopyFilename() {
        return passportCopyFilename;
    }

    public void setPassportCopyFilename(String passportCopyFilename) {
        this.passportCopyFilename = passportCopyFilename;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getSer() {
        return ser;
    }

    public void setSer(int ser) {
        this.ser = ser;
    }


    public String getReceivedWhen() {
        return receivedWhen;
    }

    public void setReceivedWhen(String receivedWhen) {
        this.receivedWhen = receivedWhen;
//        receivedWhenDateFormat = java.sql.Date.valueOf(this.receivedWhen);
    }

    public String getReceivedWhere() {
        return receivedWhere;
    }

    public void setReceivedWhere(String receivedWhere) {
        this.receivedWhere = receivedWhere;
    }

    public String getReceivedFrom() {
        return receivedFrom;
    }

    public void setReceivedFrom(String receivedFrom) {
        this.receivedFrom = receivedFrom;
    }


    public Date getReceivedWhenDateFormat() {
        return receivedWhenDateFormat;
    }


    public void setReceivedWhenDateFormat(Date receivedWhenDateFormat) {
        this.receivedWhenDateFormat = receivedWhenDateFormat;
        this.receivedWhen = receivedWhenDateFormat.toString();
    }

    public void initDates() {
        if (receivedWhen == null) {
            receivedWhenDateFormat = new java.sql.Date(System.currentTimeMillis());
        } else if ("".equals(receivedWhen)) {
            receivedWhenDateFormat = new java.sql.Date(System.currentTimeMillis());
        } else {
            try {
                this.receivedWhenDateFormat = java.sql.Date.valueOf(receivedWhen);
            } catch (Exception e) {
            }
        }
    }
}
