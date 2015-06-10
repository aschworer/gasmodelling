/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.model;

import java.io.Serializable;

/**
 * Created: 30.10.2007 || 17:28:42
 *
 *
 */
public class EducationPlace implements Serializable {
    public static final String TABLE = "places";
    private int id;
    private String name;


    public EducationPlace() {
    }


    public EducationPlace(String name) {
        this.name = name;
    }

    public EducationPlace(int id) {
        this.id = id;
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
