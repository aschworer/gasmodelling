/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.model;

import java.io.Serializable;

/**
 * Created: 18.10.2007 || 15:58:58
 *
 *
 */
public class Position implements Serializable {
    public static final String TABLE = "positions";

    private int id;
    private String name;
    private String requirements;
    private String conditions;


    public Position() {
    }

    public Position(int id) {
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

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (id != position.id) return false;

        return true;
    }

    public int hashCode() {
        return id;
    }
}
