/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.model;

import org.apache.struts.upload.FormFile;

/**
 * Created: 19.11.2007 || 13:34:53
 *
 *
 */
public class ExtraItem {
    private int id;
    public static final String TABLE = "extra_information";
    private String description;
    private String name;
    private Employee employee;
    private String documentCopyFilename;
    private FormFile documentCopy;
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

    public String getDocumentCopyFilename() {
        return documentCopyFilename;
    }

    public void setDocumentCopyFilename(String documentCopyFilename) {
        this.documentCopyFilename = documentCopyFilename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
