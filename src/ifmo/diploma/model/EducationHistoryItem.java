/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.model;

import org.apache.struts.upload.FormFile;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created: 18.10.2007 || 18:41:38
 *
 *
 */
public class EducationHistoryItem implements Serializable {
    public static final String TABLE = "employee_education";
    private int id;

    private Employee employee;
    private EducationPlace place;
    private EducationType type;
    private String documentCopyFilename;

    private FormFile documentCopy;

    private Date fromDateFormat;
    private String from;
    private Date tillDateFormat;
    private String till;
    private String documentNO;


    public String getDocumentNO() {
        return documentNO;
    }

    public void setDocumentNO(String documentNO) {
        this.documentNO = documentNO;
    }

    public FormFile getDocumentCopy() {
        return documentCopy;
    }

    public void setDocumentCopy(FormFile documentCopy) {
        this.documentCopy = documentCopy;
    }

    public EducationHistoryItem() {
    }

    public EducationHistoryItem(int id) {
        this.id = id;
    }

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

    public EducationPlace getPlace() {
        return place;
    }

    public void setPlace(EducationPlace place) {
        this.place = place;
    }

    public EducationType getType() {
        return type;
    }

    public void setType(EducationType type) {
        this.type = type;
    }


    public String getDocumentCopyFilename() {
        return documentCopyFilename;
    }

    public void setDocumentCopyFilename(String documentCopyFilename) {
        this.documentCopyFilename = documentCopyFilename;
    }

    public Date getFromDateFormat() {
        return fromDateFormat;
    }

    public void setFromDateFormat(Date fromDateFormat) {
        this.fromDateFormat = fromDateFormat;
        this.from = fromDateFormat.toString();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
//        fromDateFormat = java.sql.Date.valueOf(this.from);
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

    public String getTill() {
        return till;
    }

    public void setTill(String till) {
        this.till = till;
//        try{
//        tillDateFormat = java.sql.Date.valueOf(this.till);
//        }catch(Exception e){
//
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
