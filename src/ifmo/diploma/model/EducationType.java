/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.model;

import java.io.Serializable;

/**
 * Created: 30.10.2007 || 17:28:36
 *
 *
 */
public class EducationType implements Serializable {
    public static final String TABLE = "education_types";

    private int id;
    private String name;


    public EducationType(int id) {
        this.id = id;
    }


    public EducationType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
