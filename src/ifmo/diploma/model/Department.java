/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.model;

import java.io.Serializable;

/**
 * Created: 18.10.2007 || 15:59:06
 *
 *
 */
public class Department implements Serializable {
    public static final String TABLE = "departments";

    private int id;


    private String name;


    public Department() {
    }

    public Department(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
